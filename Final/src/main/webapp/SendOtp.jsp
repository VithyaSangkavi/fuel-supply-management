<%@ page import = "java.util.*" %>
<%@ page import = "javax.mail.*" %>
<%@ page import = "javax.mail.internet.*" %>
<%@page import= "java.sql.Connection" %>
<%@page import= "java.sql.DriverManager" %>
<%@page import= "java.sql.PreparedStatement" %>
<%@page import= "java.sql.ResultSet" %>
<%@page import= "java.sql.Statement" %>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>  



<body>

	<%
	String N  = "hello";
	
	String to = request.getParameter("Key");
    // Sender's email ID needs to be mentioned
    String from = "projectfuelsupply@gmail.com";

    final String username = "Temp Project";
    final String password1 = "frkgjqmhxitmkije";
    // Assuming you are sending email from through gmails smtp
    String host = "smtp.gmail.com";

  
    // Setup mail server
    Properties properties = new Properties();
    properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.starttls.enable", "true");
    properties.put("mail.smtp.host", host);
    properties.put("mail.smtp.port", "587");
   
    

    // Get the Session object.// and pass username and password
    Session session1 = Session.getInstance(properties, new javax.mail.Authenticator() {

        protected PasswordAuthentication getPasswordAuthentication() {

            return new PasswordAuthentication("projectfuelsupply@gmail.com", "frkgjqmhxitmkije");
        }
    });

    try {
    	
    	Random rand = new Random();
		int n = rand.nextInt(10000,99000);
    	
		 N = String.valueOf(n);
		
    	
        // Create a default MimeMessage object.
        MimeMessage message = new MimeMessage(session1);

        // Set From: header field of the header.
        message.setFrom(new InternetAddress(from));

        // Set To: header field of the header.
        message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));

        // Set Subject: header field
        message.setSubject("This is the Subject Line!");
        
        // Now set the actual message
        message.setText("OTP : "+n);

        System.out.println("sending...");
        // Send message
        Transport.send(message);
        System.out.println("Sent message successfully....");
    } catch (MessagingException mex) {
        mex.printStackTrace();
    }
	
	%>
	
	<script>
		let temp = <%= N %>;
		sessionStorage.setItem("otp",temp);
		alert("Email sent successfully");
		history.back();
	</script>
</body>
</html>