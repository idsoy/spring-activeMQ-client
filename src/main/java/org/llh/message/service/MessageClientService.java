package org.llh.message.service;

import java.util.ArrayList;

public interface MessageClientService {
	
	public void sendTipMsg(String sender);
	
	public void sendTipMsgList(ArrayList<String> senders);
	
}
