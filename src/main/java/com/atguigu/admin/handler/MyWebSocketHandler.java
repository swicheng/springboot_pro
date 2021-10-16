package com.atguigu.admin.handler;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.websocket.Session;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 孙
 * @data 2021-10-5
 * 
 */

@Slf4j
public class MyWebSocketHandler extends TextWebSocketHandler{

	
	private static AtomicInteger onlineCount = new AtomicInteger(0);
	
	private static ConcurrentHashMap<String, WebSocketSession> userMap = new ConcurrentHashMap<String, WebSocketSession>();
	
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// TODO Auto-generated method stub
		
		userMap.put(session.getId(), session);
		log.info("连接建立 sessionId: {} , 在线人数 {}", session.getId() , onlineCount.incrementAndGet());
	}

	
	
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// TODO Auto-generated method stub
		log.info("服务端收到客户端的信息   {}" , message.getPayload());
	    
	    SendMessage(session, "Hello World");
		
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		// TODO Auto-generated method stub
		log.info("异常 {} ");
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		// TODO Auto-generated method stub
		
		userMap.remove(session.getId());
		log.info("连接关闭 sessionId: {}  closeStatus: {}  剩余连接 :{} ", session.getId() , closeStatus.getCode(), onlineCount.decrementAndGet());
	    session.close(closeStatus);
	}

	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	}

	private void SendMessage(WebSocketSession session, String message) throws Exception{
		
		Set<Entry<String , WebSocketSession>> set  = userMap.entrySet();
		
		Iterator<Entry<String , WebSocketSession>>  iter =  set.iterator();
		
		while (iter.hasNext()) {
			Entry<String , WebSocketSession> entry =   iter.next();
			if (entry.getValue() != session) {
				
				WebSocketSession socketSession =  entry.getValue();
				socketSession.sendMessage(new TextMessage(entry.getKey() + " : "+ message));
				
			}
		}
		
	}
	
}
