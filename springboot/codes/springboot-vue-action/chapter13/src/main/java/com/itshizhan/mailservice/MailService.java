package com.itshizhan.mailservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class MailService {

	@Autowired
	JavaMailSender javaMailSender;

	public void sendSimpleMail(String from,String to,String cc,String subject,String content){
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(from);
		simpleMailMessage.setBcc(cc);
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(content);
		javaMailSender.send(simpleMailMessage);
	}


	public void sendAttachFileMail(String from, String to, String subject, String content, File file){
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(content);
			helper.addAttachment(file.getName(),file);
			javaMailSender.send(mimeMessage);

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public void sendMailWithImg(String from,
															String to,
															String subject,
															String content,
															String[] srcPath,
															String[] resIds) {
		if (srcPath.length != resIds.length) {
			System.out.println("发送失败");
			return;
		}
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper =
							new MimeMessageHelper(message,true);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(content,true);
			for (int i = 0; i < srcPath.length; i++) {
				FileSystemResource res =
								new FileSystemResource(new File(srcPath[i]));
				helper.addInline(resIds[i], res);
			}
			javaMailSender.send(message);
		} catch (MessagingException e) {
			System.out.println("发送失败");
		}
	}


}
