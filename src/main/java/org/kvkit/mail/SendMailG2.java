/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kvkit.mail;

/**
 *
 * @author dell
 */

    
/*
 * Created on Feb 21, 2005
 * 
 */

import java.security.Security;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailG2 {

    private static final String SMTP_HOST_NAME = "smtp.gmail.com";
    private static final String SMTP_PORT = "465";
    private static final String emailMsgTxt ="Dear <b>"+"Karthi"+"<b>,<br/>"
                    + "<br/>You have scores <b>"+"10"+"<b> from our online test application.<br/>"
                    + "<br/>Thank you for showing interest with us. Please visit again.<br/>"
                    + "<br/>Regards,<br/>Karthikeyan.K<br/>Admin.";;
    private static final String emailSubjectTxt = "A test from gmail";
    private static final String emailFromAddress = "1990.karthi@gmail.com";
    private static final String password = "kavinkarthi1";
    private static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
    private static final String[] sendTo = { "karthiitkv@gmail.com"};
    
    
    public static void main(String args[]) throws Exception {

        

        new SendMailG2().sendSSLMessage(sendTo, emailSubjectTxt,
                emailMsgTxt);
        System.out.println("Sucessfully Sent mail to All Users");
    }

    public void sendSSLMessage(String recipients[], String subject,
            String message) throws MessagingException {
        boolean debug = false;
        //Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        Properties props = new Properties();
        props.put("mail.smtp.host", SMTP_HOST_NAME);
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        props.put("mail.smtp.port", SMTP_PORT);
        props.put("mail.smtp.socketFactory.port", SMTP_PORT);
        props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.put("mail.smtp.ssl.trust", "smtpserver");
        props.put("mail.smtp.ssl.enable", false);
        props.put("mail.smtp.starttls.enable", false);
        System.out.println("done");
        
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {

                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(emailFromAddress, password);
                    }
                });

        session.setDebug(debug);

        Message msg = new MimeMessage(session);
        InternetAddress addressFrom = new InternetAddress(emailFromAddress);
        msg.setFrom(addressFrom);

        InternetAddress[] addressTo = new InternetAddress[recipients.length];
        for (int i = 0; i < recipients.length; i++) {
            addressTo[i] = new InternetAddress(recipients[i]);

}

msg.setRecipients(Message.RecipientType.TO, addressTo);



// Setting the Subject and Content Type

msg.setSubject(subject);

msg.setContent(message, "text/html");

Transport.send(msg);

System.out.println("Mail Sent");

}

}

