package com.example.HousieProjectSpring;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class WebSocketGameHandler extends TextWebSocketHandler 
{
	
	public List<WebSocketSession> sessionData = new ArrayList<WebSocketSession>();
	int[] arr = new int[] { 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,
			41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,
			  83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99};
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception
	{
		sessionData.add(session);
	}
	
	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("triggered message");
		System.out.println(message);
		int randomNumber = arr[new Random().nextInt(arr.length)];
		TextMessage newMessage = new TextMessage("hello");
		
		  for(WebSocketSession singleSession : sessionData) {
		  singleSession.sendMessage(message); }
		 
		//session.sendMessage(newMessage);
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessionData.remove(session);
	}
	
}
