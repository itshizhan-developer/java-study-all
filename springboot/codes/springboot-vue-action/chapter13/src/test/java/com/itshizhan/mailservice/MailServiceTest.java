package com.itshizhan.mailservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

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

	@Test
	public void sendAttachFileMail() {
		mailService.sendAttachFileMail("370424110@qq.com","itshizhan@163.com",
						"springboot测试附件","springboot附件邮件内容",
						new File("/Users/leeson8888/Desktop/file/attachfile.zip"));
	}

	@Test
	public void sendMailWithImg() {

		mailService.sendMailWithImg("370424110@qq.com","itshizhan@163.com",
						"springboot测试图片邮件",

						"<h2>这是一封待图片的邮件</h2>" +
						"这是图片1:<div><img src='cid:p1'/></div>"+
						"这是图片2:<div><img src='cid:p2'/></div>",

						new String [] {"/Users/leeson8888/Desktop/file/lb1.png","/Users/leeson8888/Desktop/file/lb2.png"},
						new String[]{"p1","p2"});
	}
}