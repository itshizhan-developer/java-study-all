package com.itshizhan.mailservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

	@Autowired
	MailService mailService;

	@Test
	public void sendSimpleMail() {
		mailService.sendSimpleMail("22222@qq.com",
						"2222@163.com",
						"2222@qq.com",
						"springboot测试邮件主题",
						"springboot测试邮件内容");
	}
}