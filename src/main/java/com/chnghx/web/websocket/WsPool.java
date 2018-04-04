package com.chnghx.web.websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;


public class WsPool {

	private static final Map<WebSocketSession, String> wsUserMap = new HashMap<WebSocketSession, String>();
	
	public static final Map<WebSocketSession, String> getWsUserMap(){
		return wsUserMap;
	}
	
	/**
	 * 通过websocket连接获取其对应的用户
	 * @param conn
	 * @return
	 */
	public static String getUserByWs(WebSocketSession conn) {
		return wsUserMap.get(conn);
	}
	
	/**
	 * 获取连接
	 * @param userName
	 * @return
	 */
	public synchronized static WebSocketSession getWsByUser(String userName) {
		Set<WebSocketSession> keySet = wsUserMap.keySet();
		synchronized (keySet) {
			for (WebSocketSession conn : keySet) {
                String cuser = wsUserMap.get(conn);
                if (cuser.equals(userName)) {
                    return conn;
                }
            }
		}
		return null;
//		wsUserMap.forEach((k, v) ->{
//			if(userName.equals(v)) {
//				return k;
//			}
//		});
	}
	
	/**
	 *  向连接池中添加连接
	 * @param userName
	 * @param conn
	 */
	public static void addUser(String userName, WebSocketSession conn) {
		wsUserMap.put(conn, userName);
	}
	
	/**
	 * 获取所有连接池中的用户，所以可以得到无重复的user数组
	 * @return
	 */
	public static Collection<String> getOnlineUser() {
		List<String> setUsers = new ArrayList<String>();
		Collection<String> setUser = wsUserMap.values();
        for (String u : setUser) {
            setUsers.add(u);
        }
        return setUsers;
	}
	
	/**
	 * 移除连接池中的连接
	 * @param conn
	 * @return
	 */
	public static boolean removeUser(WebSocketSession conn) {
		if (wsUserMap.containsKey(conn)) {
            wsUserMap.remove(conn); // 移除连接
            return true;
        } else {
            return false;
        }
	}
	
	/**
	 * 向特定的用户发送数据
	 * @param conn
	 * @param message
	 * @throws IOException 
	 */
	public static void sendMessageToUser(WebSocketSession conn, TextMessage message) throws IOException {
		if (null != conn && null != wsUserMap.get(conn)) {
            conn.sendMessage(message);
        }
	}
	
	/**
     * 向所有的用户发送消息
     * 
     * @param message
	 * @throws IOException 
     */
    public static void sendMessageToAll(TextMessage message) throws IOException {
        Set<WebSocketSession> keySet = wsUserMap.keySet();
        synchronized (keySet) {
            for (WebSocketSession conn : keySet) {
                String user = wsUserMap.get(conn);
                if (user != null) {
                    conn.sendMessage(message);
                }
            }
        }
    }
	
}
