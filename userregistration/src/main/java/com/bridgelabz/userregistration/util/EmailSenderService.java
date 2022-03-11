package com.bridgelabz.userregistration.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class EmailSenderService {
	
	
	@Autowired
	private JavaMailSender mailsender;
	private String universalkey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9";
	
	public void sendEmail(String toEmail, String subject, String body ) {
	SimpleMailMessage message=new SimpleMailMessage();
	message.setFrom("piyushbarde1@gmail.com");
	message.setTo(toEmail);
	message.setText(body);
	message.setSubject(subject);
	mailsender.send(message);
	System.out.println("Mail sent to the User...!");	
	}
}
