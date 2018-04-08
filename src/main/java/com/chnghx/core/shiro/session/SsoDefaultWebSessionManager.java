package com.chnghx.core.shiro.session;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.servlet.ShiroHttpSession;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Default {@link Cookie Cookie} implementation.  'HttpOnly' is supported out of the box, even on
 * Servlet {@code 2.4} and {@code 2.5} container implementations, using raw header writing logic and not
 * {@link javax.servlet.http.Cookie javax.servlet.http.Cookie} objects (which only has 'HttpOnly' support in Servlet
 * {@code 2.6} specifications and above).
 *
 * @since 1.0
 * 
 * 重新 生成session cookie方法
 * 
 * @author guohaixiang
 * 
 */
public class SsoDefaultWebSessionManager extends DefaultWebSessionManager{
	private static final Logger log = LoggerFactory.getLogger(SsoDefaultWebSessionManager.class);
	
    
	public SsoDefaultWebSessionManager() {
        Cookie cookie = new SessionIdCookie(ShiroHttpSession.DEFAULT_SESSION_ID_NAME);
        cookie.setHttpOnly(true); //more secure, protects against XSS attacks
        setSessionIdCookie(cookie);
        setSessionIdCookieEnabled(true);
    }
	
	/**
     * Stores the Session's ID, usually as a Cookie, to associate with future requests.
     *
     * @param session the session that was just {@link #createSession created}.
     */
	 @Override
	 protected void onStart(Session session, SessionContext context) {
	        if (!WebUtils.isHttp(context)) {
	            log.debug("SessionContext argument is not HTTP compatible or does not have an HTTP request/response " +
	                    "pair. No session ID cookie will be set.");
	            return;

	        }
	        HttpServletRequest request = WebUtils.getHttpRequest(context);
	        HttpServletResponse response = WebUtils.getHttpResponse(context);

	        if (isSessionIdCookieEnabled()) {
	            Serializable sessionId = session.getId();
	            storeSessionId(sessionId, request, response);
	        } else {
	            log.debug("Session ID cookie is disabled.  No cookie has been set for new session with id {}", session.getId());
	        }

	        request.removeAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE);
	        request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_IS_NEW, Boolean.TRUE);
		 
	 }
	
	 /**
	  * 设置session Cookie
	  * @param currentId
	  * @param request
	  * @param response
	  */
	private void storeSessionId(Serializable currentId, HttpServletRequest request, HttpServletResponse response) {
        if (currentId == null) {
            String msg = "sessionId cannot be null when persisting for subsequent requests.";
            throw new IllegalArgumentException(msg);
        }
        Cookie template = getSessionIdCookie();
        Cookie cookie = new SessionIdCookie(template);
        String idString = currentId.toString();
        cookie.setValue(idString);
        cookie.saveTo(request, response);
        log.trace("Set session ID cookie for session with id {}", idString);
    }
}
