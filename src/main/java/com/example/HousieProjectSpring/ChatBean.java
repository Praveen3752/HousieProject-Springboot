package com.example.HousieProjectSpring;

public class ChatBean 
{
	private MessageType messagetype;
	private String content;
	private String sender;
	
	public enum MessageType
	{
		Joined,
		Left,
		Chat
	}

	public MessageType getMessagetype() {
		return messagetype;
	}

	public void setMessagetype(MessageType messagetype) {
		this.messagetype = messagetype;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}
	
	
}
