package com.example.HousieProjectSpring;

import java.util.Random;
import java.util.stream.IntStream;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class ChatController 
{
	int[] arr = new int[] { 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,
		    41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,
		      83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99};
	
	
	@MessageMapping("/chat.sendMessage")
	@SendTo("/topic/public")
	public String sendMessage(String chatmessage)
	{
		int index = new Random().nextInt(arr.length);
		String output = String.valueOf(arr[index]);
		arr = IntStream.range(0, arr.length)
        .filter(i -> i != index)
        .map(i -> arr[i])
        .toArray();
		
		System.out.println(arr.length);
		System.out.println(arr.toString());
		
		return output;
	}

	/*
	 * @MessageMapping("/chat.addUser")
	 * 
	 * @SendTo("/topic/public") public ChatBean addUser(@Payload ChatBean
	 * chatmessage,SimpMessageHeaderAccessor messageHeaderAccessor) {
	 * messageHeaderAccessor.getSessionAttributes().put("username",
	 * chatmessage.getSender()); return chatmessage; }
	 */
	
}
