package com.chnghx.core.shiro.realms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;

import com.chnghx.core.shiro.token.ShiroToken;
import com.chnghx.core.shiro.token.TokenManager;
import com.chnghx.web.common.config.Config;
import com.chnghx.web.common.utils.StringUtils;

public class SampleRealm extends AuthorizingRealm {
	
	private final static String[] permissionAdmin = Config.getProperty("sso.permission.admin").split(",");
	private final static List<String> permissionAdminList = new ArrayList<String>();
	static{
		Collections.addAll(permissionAdminList, permissionAdmin);
	}

	
	public SampleRealm() {
		super();
	}
	/**
	 *  认证信息，主要针对用户登录， 
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		
		ShiroToken token = (ShiroToken) authcToken;
		/**
		 * 通过帐号获取用户对象
		 */
		if(null == token )//|| token.checkSelf()
			throw new AccountException("'token' is null or 'token' contains null value");
		
		//TODO 如果自己管理用户信息的，需要自主实现登录校验，如有问题咨询@周柏成
		
		String userId = new String(token.getUserId());
		token = token.getSelf();
		TokenManager.seToken(token);
		return new SimpleAuthenticationInfo(token,userId, getName());
		
    }

	 /** 
     * 授权 
     */  
    @Override  
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    	/**
    	 * 在这可以给予当前用户的权限
    	 */
    	//用户名  
    	ShiroToken token = (ShiroToken) principals.getPrimaryPrincipal();
    	String username = token.getLoginName();
         
        /*这些代码应该是动态从数据库中取出的，此处写死*/  
        if(StringUtils.isNotBlank(username) && permissionAdminList.contains(username)){
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            info.addRole("admin");//添加一个角色，不是配置意义上的添加，而是证明该用户拥有admin角色  
            info.addStringPermission("admin:manage");//添加管理权限  
            return info;
        }
    	return null;
    }  
	
    /** 
     * 异常转换 
     * @param e 
     * @return 
     */  
    private AuthenticationException translateAuthenticationException(Exception e) {  
        if (e instanceof AuthenticationException) {  
            return (AuthenticationException) e;  
        }  
        if(e instanceof DisabledAccountException){  
            return (DisabledAccountException)e;  
        }  
        if(e instanceof UnknownAccountException){  
            return (UnknownAccountException)e;  
        }  
        return new AuthenticationException(e);  
    } 
    
	public void clearCachedAuthorizationInfo(String principal) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(
				principal, getName());
		clearCachedAuthorizationInfo(principals);
	}
}
