package com.chnghx.core.shiro.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

import com.chnghx.core.shiro.session.ShiroSessionRepository;

public class CustomSessionListener implements SessionListener {

	private ShiroSessionRepository shiroSessionRepository;
	public ShiroSessionRepository getShiroSessionRepository() {
        return shiroSessionRepository;
    }

    public void setShiroSessionRepository(ShiroSessionRepository shiroSessionRepository) {
        this.shiroSessionRepository = shiroSessionRepository;
    }
	
	@Override
	public void onStart(Session session) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStop(Session session) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onExpiration(Session session) {
		shiroSessionRepository.deleteSession(session.getId());
	}

}
