package org.kvkit.mail;

public final class MailProperties {

	/*GMail Setting*/
	public static final String SMTP_HOST_NAME = "smtp.gmail.com";
    public static final String SMTP_SSL_PORT = "465";
    public static final String SMTP_TLS_PORT = "587";
    public static final String emailFromAddress = "kvkappsacc@gmail.com";
    public static final String password = "kavinkarthi@1";
    
    /*Yahoo settings*///Not Working
    /*public static final String SMTP_HOST_NAME = "smtp.mail.yahoo.com";
    public static final String SMTP_SSL_PORT = "465";
    public static final String SMTP_TLS_PORT = "587";
    public static final String emailFromAddress = "kk0071990@yahoo.co.in";
    public static final String password = "kavinkarthi@1";*/
    
    
    public static final String SMTP_AUTH = "true";
    public static final String SMTP_STARTTLS_ENABLE = "true";
    public static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
    
    
    public static final String emailMsgTxt ="Dear <b>"+"Karthi"+"</b>,<br/>"
                    + "<br/>You have scores <b>"+"10"+"</b> from our online test application.<br/>"
                    + "<br/>Thank you for showing interest with us. Please visit again.<br/>"
                    + "<br/>Regards,<br/>Karthikeyan.K<br/>Admin.";;
    public static final String emailSubjectTxt = "A test from gmail";
    public static final String[] sendTo = { "karthiitkv@gmail.com"};
	
}
