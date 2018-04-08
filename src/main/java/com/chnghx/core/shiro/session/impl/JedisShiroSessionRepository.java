package com.chnghx.core.shiro.session.impl;

import java.io.Serializable;
import java.util.Collection;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SimpleSession;

import com.chnghx.core.shiro.session.ShiroSessionRepository;
import com.chnghx.core.shiro.session.cache.JedisManager;
import com.chnghx.web.common.config.Config;
import com.chnghx.web.common.utils.LoggerUtils;
import com.chnghx.web.common.utils.SerializeUtil;

public class JedisShiroSessionRepository implements ShiroSessionRepository {

	static final String REDIS_SHIRO_SESSION = Config.getProperty("shiro.session.prefix");
    static final Integer SESSION_VAL_TIME_SPAN = Integer.parseInt(Config.getProperty("shiro.session.timeout"));
    static final Integer DB_INDEX =  Integer.parseInt(Config.getProperty("shiro.session.index"));

    private JedisManager jedisManager;
    
	public JedisManager getJedisManager() {
		return jedisManager;
	}

	public void setJedisManager(JedisManager jedisManager) {
		this.jedisManager = jedisManager;
	}

	@Override
	public void saveSession(Session session) {
		if (null == session || null == session.getId())
            throw new NullPointerException("session is empty");
		try {
            byte[] key = SerializeUtil.serialize(buildRedisSessionKey(session.getId()));
            byte[] value = SerializeUtil.serialize(session);
            long sessionTimeOut = session.getTimeout() / 1000;
            Long expireTime = sessionTimeOut + SESSION_VAL_TIME_SPAN + (5 * 60);
            jedisManager.saveValueByKey(DB_INDEX, key, value, expireTime.intValue());
        } catch (Exception e) {
        	LoggerUtils.error(getClass(), "save session error",e);
        }

	}

	@Override
	public void deleteSession(Serializable sessionId) {
		if (null == sessionId) {
            throw new NullPointerException("session id is empty");
        }
        try {
        	jedisManager.deleteByKey(DB_INDEX, SerializeUtil.serialize(buildRedisSessionKey(sessionId)));
        } catch (Exception e) {
        	LoggerUtils.error(getClass(), "delete session error",e);
        }

	}

	@Override
	public Session getSession(Serializable sessionId) {
		if (null == sessionId)
            throw new NullPointerException("session id is empty");
        Session session = null;
        try {
            byte[] value = jedisManager.getValueByKey(DB_INDEX, SerializeUtil
                    .serialize(buildRedisSessionKey(sessionId)));
            session = SerializeUtil.deserialize(value, SimpleSession.class);
        } catch (Exception e) {
        	LoggerUtils.error(getClass(), "get session error",e);
        }
		return session;
	}

	@Override
	public Collection<Session> getAllSessions() {
		Collection<Session> sessions = null;
		try {
			sessions = jedisManager.AllSession(DB_INDEX, REDIS_SHIRO_SESSION);
		} catch (Exception e) {
			LoggerUtils.error(getClass(), "get all session error",e);
		}
		return sessions;
	}
	
	private String buildRedisSessionKey(Serializable sessionId) {
        return REDIS_SHIRO_SESSION + sessionId;
    }

}
