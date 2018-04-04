package com.chnghx.websocket;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.Set;

import org.java_websocket.WebSocket;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

public class WsServer extends WebSocketServer {
	
	public static void main(String[] args) {
		WebSocketImpl.DEBUG = true;
		int port = 8888; // 端口
        WsServer s = new WsServer(port);
        s.start();

	}
	
	public WsServer(int port) {
        super(new InetSocketAddress(port));
    }
	
	public WsServer(InetSocketAddress address) {
        super(address);
    }

	/**
	 * 连接关闭时触发
	 */
	@Override
	public void onClose(WebSocket conn, int code, String reason, boolean remote) {
		//移除用户和连接
		userLeave(conn);
	}

	@Override
	public void onError(WebSocket conn, Exception e) {
		System.out.println("on error");
        e.printStackTrace();
	}

	@Override
	public void onMessage(WebSocket conn, String message) {
		System.out.println("收到消息：" + message);
		if(null != message &&message.indexOf(":") > -1){
            String userName=message.substring(0, message.indexOf(":"));//用户名
            
//            conn.send(message);
            userJoin(conn,userName);//用户加入
            this.sendAll(message);
            
        }else if(null != message && message.startsWith("offline")){
            userLeave(conn);
        }
	}

	/**
	 * WebSocket连接的时候触发
	 */
	@Override
	public void onOpen(WebSocket conn, ClientHandshake handshake) {
		System.out.println("打开连接...............");
	}

	@Override
	public void onStart() {
		System.out.println("启动中..............");
	}

	/**
	 * 连接池移除用户和连接
	 * @param conn
	 */
	private void userLeave(WebSocket conn){
        WsPool.removeUser(conn);
    }
	
	/**
	 * 用户和连接加入连接池
	 * @param conn
	 * @param userName
	 */
	private void userJoin(WebSocket conn,String userName){
        WsPool.addUser(userName, conn);
    }
	
	
	private void sendAll(String message){
		Map<WebSocket, String> wsUserMap = WsPool.getWsUserMap();
		Set<WebSocket> keySet = wsUserMap.keySet();
		for (WebSocket conn : keySet) {
//            String cuser = wsUserMap.get(conn);
            conn.send(message);
        }
    }
	
}
