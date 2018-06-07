var url = "ws://192.168.0.125:8888";
// //第一个参数 url, 指定连接的 URL。第二个参数 protocol 是可选的，指定了可接受的子协议。
// //var Socket = new WebSocket(url, [protocol] );
// //var Socket = new WebSocket(url);
// (function (){
// var ws;
// var connect_url = url;
// window.JsSocket = {
// init : function (){
// var support = "MozWebSocket" in window ? "MozWebSocket" : ('WebSocket' in
// window ? 'WebSocket' : null);
// if(support){
// alert("您的浏览器支持 WebSocket!");
// this.connect();
//					
// }else{
// alert("您的浏览器不支持 WebSocket!");
// console.log("您的浏览器不支持 WebSocket!");
// }
// },
// connect : function(){
// try{
// ws = new WebSocket(connect_url);
// if(ws.readyState == SWebSocket.CONNECTING){
// console.log("正在连接WebSocket服务器...");
// }
// ws.onopen = this.onopen;
// ws.onmessage = this.onmessage;
// ws.onclose = this.onclose;
// ws.onerror = this.onerror;
// } catch (e) {
// console.log("Error：" + e);
// }
// },
// disconnect : function(){
// if (ws != null && ws.readyState === WebSocket.OPEN) {
// ws.close(); //关闭TCP连接
// }
// },
// onopen : function(e){
// console.log("open");
// if (ws.readyState === WebSocket.OPEN) {
// console.log("已连接到WebSocket服务器");
// alert("已连接到WebSocket服务器");
// }
//				
// },
// onmessage : function(){
// console.log("message");
// },
// onclose : function(){
// var result = JsSocket.getWebSocketState(ws);
//				
// },
// onerror : function(e){
// console.log("error:" + e);
// alert(e);
// },
// sendMessage : function(msg){
// if (ws != null && ws.readyState === WebSocket.OPEN) {
// if (msg == "" || msg == null || msg == "undefined") {
// return false;
// }
// ws.send(msg);
// console.log(msg);
// }
// },
// getWebSocketState : function(ws){
// var result = "";
// switch (ws.readyState) {
// case 0:
// result = "连接正在进行中，但还未建立";
// break;
// case 1:
// result = "连接已经建立。消息可以在客户端和服务器之间传递";
// break;
// case 2:
// result = "连接正在进行关闭握手";
// break;
// case 3:
// result = "连接已经关闭，不能打开";
// break;
// }
// return result;
// },
// log : function(log){
// if (document.readyState !== "complete") {
//					
// }else{
//					
// }
// },
// jsonToString : function(json){
// return JSON.stringify(json);
// },
// stringToJson : function(str){
// try{
// str = str.replace(/\'/g, "\"");
// return JSON.parse(str);
// }catch(error){
// console.log(error);
// }
// }
// }
// })(jQuery);
//
// JsSocket.init();

var websocket;
var ajaxPageNum = 1;
var last_health;
var health_timeout = 10;
var tDates = [], tData = [];
var rightIndex;

var userName = $("#userName").val();

if ('WebSocket' in window || 'MozWebSocket' in window) {//浏览器支持
	websocket = new WebSocket(encodeURI("ws://" + document.location.host
			+ "/socket/wechat"));
} else {//浏览器不支持
	alert("不支持");
	websocket = new SockJS(encodeURI("ws://" + document.location.host
			+ "/socket/wechat"));
}

websocket.onopen = function() {
	console.log('已连接');
//	heartbeat_timer = setInterval(function() {
//		keepalive(websocket)
//	}, 60000);
};
websocket.onerror = function() {
	console.log('连接发生错误');
};
websocket.onclose = function() {
	console.log('已经断开连接');
};
// 消息接收
websocket.onmessage = function(message) {
	console.log(message)
	var received_msg = message.data;
	$("#show_messages").append('<div>' + received_msg + '</div>')
};


//// 心跳包
//function keepalive(ws) {
//	var time = new Date();
//	if (last_health != -1 && (time.getTime() - last_health > health_timeout)) {
//
//		// ws.close();
//	} else {
//		if (ws.bufferedAmount == 0) {
//			ws.send('~HC~');
//		}
//	}
//}

document.onkeydown = function(event) {
	var e = event || window.event || arguments.callee.caller.arguments[0];
	if (e && e.keyCode == 13) { // enter 键
		var user = $("#userName").val();

		var txt = $("#msg").val();
		if ($.trim(txt) == "") {
			return;
		}
		$("#msg").val("");
		var msg = (user + ":" + txt);
		websocket.send(msg);
	}
};