package com.vows.test.websocket;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;



/**
 * @project:webasic
 * @description:websocket server
 * @authur:nis36
 * 2017年1月26日-下午5:29:40
 * 2017  PD.Sp Center   -版权所有
 */
@ServerEndpoint("/websocket/chat")
public class WebsocketServer {
	SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
	@OnOpen
	public void onopen(Session session){
		
	}
	@OnClose
	public void onclose() {
		
	}
	@OnMessage
	public void onmsg(Session session,String msg)throws IOException{
		msg = msg +"__"+ sdf.format(new Date());
		session.getBasicRemote().sendText(msg);
		
	}
	@OnError
	public void onerr(Throwable t){
		
	}
}
