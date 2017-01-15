package org.kvkit.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailG3 {


	 
	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
 
	public static void main(String args[]) throws AddressException, MessagingException {
		sendSSLMessage(MailProperties.sendTo, MailProperties.emailSubjectTxt, MailProperties.emailMsgTxt);
		System.out.println("\n\n ===> Your Java Program has just sent an Email successfully. Check your email..");
	}
 
	public static void sendSSLMessage(String recipients[], String subject,
            String message) throws AddressException, MessagingException {
 
		// Step1
		System.out.println("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", MailProperties.SMTP_TLS_PORT);
		mailServerProperties.put("mail.smtp.auth", MailProperties.SMTP_AUTH);
		mailServerProperties.put("mail.smtp.starttls.enable", MailProperties.SMTP_STARTTLS_ENABLE);
		mailServerProperties.put("mail.smtp.ssl.trust", MailProperties.SMTP_HOST_NAME);
		System.out.println("Mail Server Properties have been setup successfully..");
 
		// Step2
		System.out.println("\n\n 2nd ===> get Mail Session..");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		InternetAddress[] addressTo = new InternetAddress[recipients.length];
        for (int i = 0; i < recipients.length; i++) {
            addressTo[i] = new InternetAddress(recipients[i]);
        }
        generateMailMessage.setRecipients(Message.RecipientType.TO, addressTo);
		generateMailMessage.setSubject(subject);
		generateMailMessage.setContent(message, "text/html");
		System.out.println("Mail Session has been created successfully..");
 
		// Step3
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");
 
		// Enter your correct gmail UserID and Password
		// if you have 2FA enabled then provide App Specific Password
		transport.connect(MailProperties.SMTP_HOST_NAME, MailProperties.emailFromAddress, MailProperties.password);
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}

}
