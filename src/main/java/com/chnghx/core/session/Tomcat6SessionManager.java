package com.chnghx.core.session;

/**
 * 
 * 
 * tomcat session 禁用
 * <Loader delegate="true"/>
						<Manager className="com.vinux.api.center.core.session.SessionManager" />				
 */
//import java.io.IOException;
//
//import org.apache.catalina.Lifecycle;
//import org.apache.catalina.LifecycleException;
//import org.apache.catalina.LifecycleListener;
//import org.apache.catalina.Session;
//import org.apache.catalina.session.ManagerBase;
//import org.apache.catalina.util.LifecycleSupport;
//
//public class Tomcat6SessionManager extends ManagerBase implements Lifecycle {
//
//	protected LifecycleSupport lifecycle = new LifecycleSupport(this);
//
//	public void addLifecycleListener(LifecycleListener listener) {
//		lifecycle.addLifecycleListener(listener);
//	}
//
//	public LifecycleListener[] findLifecycleListeners() {
//		return lifecycle.findLifecycleListeners();
//	}
//
//	public void removeLifecycleListener(LifecycleListener listener) {
//		lifecycle.removeLifecycleListener(listener);
//	}
//
//	protected synchronized void startInternal() throws LifecycleException {
////		super.startInternal();
////		setState(LifecycleState.STARTING);
//		setDistributable(true);
//	}
//
//	protected synchronized void stopInternal() throws LifecycleException {
////		setState(LifecycleState.STOPPING);
//	}
//
//	public int getRejectedSessions() {
//		return 0;
//	}
//
//	public void setRejectedSessions1(int i) {
//	}
//
//	public void load() throws ClassNotFoundException, IOException {
//	}
//
//	public void setRejectedSessions(int arg0) {
//
//	}
//
//	public void unload() throws IOException {
//
//	}
//
//	@Override
//	public Session createSession(String sessionId) {
//		// TODO 关键位置
//		return null;
//	}
//
//	public Session createSession() {
//		// TODO 关键位置
//		return null;
//	}
//
//	@Override
//	public Session createEmptySession() {
//		// TODO 关键位置
//		return null;
//	}
//
//	@Override
//	public void add(Session session) {
//
//	}
//
//	@Override
//	public Session findSession(String id) {
//		return null;
//	}
//
//	public void remove(Session session) {
//		remove(session, false);
//	}
//
//	public void remove(Session session, boolean update) {
//
//	}
//
//	@Override
//	public void processExpires() {
//	}
//
//	public void start() throws LifecycleException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void stop() throws LifecycleException {
//		// TODO Auto-generated method stub
//		
//	}
//
//}
