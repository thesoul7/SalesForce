package com.test;

import java.util.stream.StreamSupport;

import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;

public  class Twilio {

	/*
	 * public static java.util.stream.Stream<Message> getMessages() { String
	 * ACCOUNT_SID="ACbba82eaa6c801de9dd7ccab1e0ded639"; String
	 * AUTH_TOKEN="f4770c1f964c2bf77465d43635899b53"; ResourceSet<Message> messages
	 * = Message.reader(ACCOUNT_SID).read(); return
	 * StreamSupport.stream(messages.spliterator(), false); }
	 */
	
	public  String getMsg(String accountSID,  String phNumber) {
		ResourceSet<Message> messages = Message.reader(accountSID).read();
		return StreamSupport.stream(messages.spliterator(), false).filter(m -> m.getDirection().compareTo(Message.Direction.INBOUND)==0).filter(m -> m.getTo().equals(phNumber)).map(Message::getBody).findFirst().orElseThrow(IllegalStateException::new);
	}
	
	public static  void init(String accountSID, String authToken) {
		Twilio.init(accountSID, authToken); 
	}
	
	public String fetchOTP(String name) {
		String digits =name.replaceAll("[^-?0-9]+", "");
		return digits.substring(0, 6);
	}
}
