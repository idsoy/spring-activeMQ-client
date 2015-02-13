package org.llh.message.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 描    述:
 * 作    者:lilianghui
 * 日    期:2015年2月12日下午5:13:17
 * 版权所有:深圳市鼎丰在线金融服务有限公司
 * 版    本:V1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:mvc-servlet.xml")
public class MessageClientServiceTest {

	@Autowired
	private MessageClientService messageClientService;
	
	@Test
	public void sendTipMsg() {
		
		messageClientService.sendTipMsg("idsoy");
	}

}


