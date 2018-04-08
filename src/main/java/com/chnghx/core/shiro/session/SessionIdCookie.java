package com.chnghx.core.shiro.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 支持session cookie跨域写入
 * 
 * @author
 *
 */
public class SessionIdCookie extends SimpleCookie {

    private static final transient Logger log = LoggerFactory.getLogger(SessionIdCookie.class);

    
    public SessionIdCookie() {
       super();
    }

    public SessionIdCookie(String name) {
        super(name);
    }

    public SessionIdCookie(Cookie cookie) {
        super(cookie);
    }

   
    /**
     * Returns the Cookie's calculated path setting.  If the {@link javax.servlet.http.Cookie#getPath() path} is {@code null}, then the
     * {@code request}'s {@link javax.servlet.http.HttpServletRequest#getContextPath() context path}
     * will be returned. If getContextPath() is the empty string or null then the ROOT_PATH constant is returned.
     *
     * @param request the incoming HttpServletRequest
     * @return the path to be used as the path when the cookie is created or removed
     */
    private String calculatePath(HttpServletRequest request) {
        String path = StringUtils.clean(getPath());
        if (!StringUtils.hasText(path)) {
            path = StringUtils.clean(request.getContextPath());
        }

        //fix for http://issues.apache.org/jira/browse/SHIRO-9:
        if (path == null) {
            path = ROOT_PATH;
        }
        log.trace("calculated path: {}", path);
        return path;
    }

    /**
     * sessionCookie
     */
    public void saveTo(HttpServletRequest request, HttpServletResponse response) {
        String name = getName();
        String value = getValue();
        String comment = getComment();
        String domain = getDomain();
        String path = calculatePath(request);
        int maxAge = getMaxAge();
        int version = getVersion();
        boolean secure = isSecure();
        boolean httpOnly = isHttpOnly();
        //支持P3P跨域写cookie
        response.setHeader("P3P", "CP=CAO PSA OUR");
        addCookieHeader(response, name, value, comment, domain, path, maxAge, version, secure, httpOnly);
    }
    
    private void addCookieHeader(HttpServletResponse response, String name, String value, String comment,
            String domain, String path, int maxAge, int version,
            boolean secure, boolean httpOnly) {
		String headerValue = buildHeaderValue(name, value, comment, domain, path, maxAge, version, secure, httpOnly);
		response.addHeader(COOKIE_HEADER_NAME, headerValue);
		if (log.isDebugEnabled()) {
			log.debug("Added HttpServletResponse Cookie [{}]", headerValue);
		}
	}

}
