package org.llh.message.service.impl;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.llh.message.service.MessageClientService;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class MessageClientServiceImpl implements MessageClientService{
	
	//站内信队列
	private static final String MESSAGE_TIP_QUEUE= "org.llh.message.tip.queue";
	//批量发送站内信队列
	private static final String MESSAGE_TIP_QUEUE_LIST= "org.llh.message.tip.queue.list";
	
	@Resource
	private JmsTemplate jmsTemplate;
	
	public void sendTipMsg(final String sender) {
			jmsTemplate.send(MESSAGE_TIP_QUEUE, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createObjectMessage(sender);
			}
		});
	}
	
	public void sendTipMsgList(final ArrayList<String> senders) {
			jmsTemplate.send(MESSAGE_TIP_QUEUE_LIST, new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createObjectMessage(senders);
			}
		});
	}
	
}
