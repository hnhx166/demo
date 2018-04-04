package com.chnghx.websocket;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.java_websocket.WebSocket;

public class WsPool {

	private static final Map<WebSocket, String> wsUserMap = new HashMap<WebSocket, String>();
	
	public static final Map<WebSocket, String> getWsUserMap(){
		return wsUserMap;
	}
	
	/**
	 * 通过websocket连接获取其对应的用户
	 * @param conn
	 * @return
	 */
	public static String getUserByWs(WebSocket conn) {
		return wsUserMap.get(conn);
	}
	
	/**
	 * 获取连接
	 * @param userName
	 * @return
	 */
	public synchronized static WebSocket getWsByUser(String userName) {
		Set<WebSocket> keySet = wsUserMap.keySet();
		synchronized (keySet) {
			for (WebSocket conn : keySet) {
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
	public static void addUser(String userName, WebSocket conn) {
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
	public static boolean removeUser(WebSocket conn) {
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
	 */
	public static void sendMessageToUser(WebSocket conn, String message) {
		if (null != conn && null != wsUserMap.get(conn)) {
            conn.send(message);
        }
	}
	
	/**
     * 向所有的用户发送消息
     * 
     * @param message
     */
    public static void sendMessageToAll(String message) {
        Set<WebSocket> keySet = wsUserMap.keySet();
        synchronized (keySet) {
            for (WebSocket conn : keySet) {
                String user = wsUserMap.get(conn);
                if (user != null) {
                    conn.send(message);
                }
            }
        }
    }
	
}
