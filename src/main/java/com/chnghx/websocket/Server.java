package com.chnghx.websocket;

public class Server {

	public static void main(String[] args) {
		String txt = "ae8be155-31d7-47cb-a4b7-356cadd0c3c4:阿达";
		String userName=txt.substring(0, txt.indexOf(":"));//用户名
		System.out.println(userName);
	}

}
