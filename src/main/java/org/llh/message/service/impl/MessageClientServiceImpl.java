package org.llh.message.service.impl;

import java.util.ArrayList;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.llh.message.service.MessageClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class MessageClientServiceImpl implements MessageClientService{
	
	//站内信队列
	private String messageTipQueue;
	//批量发送站内信队列
	private String messageTipQueueList;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Override
	public void sendTipMsg(final String sender) {
			jmsTemplate.send(messageTipQueue, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createObjectMessage(sender);
			}
		});
	}
	
	@Override
	public void sendTipMsgList(final ArrayList<String> senders) {
			jmsTemplate.send(messageTipQueueList, new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createObjectMessage(senders);
			}
		});
	}

	public void setMessageTipQueue(String messageTipQueue) {
		this.messageTipQueue = messageTipQueue;
	}

	public void setMessageTipQueueList(String messageTipQueueList) {
		this.messageTipQueueList = messageTipQueueList;
	}
	
}
