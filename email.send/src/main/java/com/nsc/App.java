package com.nsc;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       
    	
    	System.out.println("preparing to send message ...");
		String message = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris leo risus, malesuada pretium enim at, mollis fermentum est. Aliquam magna diam, fermentum eget consequat varius, accumsan non lacus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam eget nisi pellentesque, mollis lectus gravida, egestas leo. Suspendisse rutrum nunc eget purus eleifend, ut cursus turpis consequat. Mauris vulputate ultrices ante, non tempus mi efficitur ut. Aenean a ante scelerisque, fringilla sapien vitae, dictum leo. Nam vel ullamcorper purus. Curabitur vestibulum felis id urna euismod volutpat. Cras iaculis bibendum lorem, hendrerit gravida enim fermentum ornare. Nullam est tortor, ultrices non malesuada vel, cursus sed tortor. Praesent id purus elementum, rhoncus enim sed, luctus mauris. \r\n" + 
				"\r\n" + 
				"  \r\n" + 
				"\r\n" + 
				"Curabitur quis semper dolor, vel mattis lorem. Aenean elit dolor, egestas at malesuada ac, pulvinar sit amet arcu. Nam finibus urna ac turpis convallis, vitae sodales nisi cursus. Donec eleifend ullamcorper est, eget efficitur sapien eleifend nec. Mauris auctor erat at tellus aliquam gravida tempor fermentum sapien. Etiam non congue lacus. Vestibulum hendrerit justo at libero ultricies, quis laoreet turpis accumsan. Praesent ut sem vel erat posuere ultricies. Vestibulum lacinia malesuada nisi, ut dapibus justo eleifend quis. Aliquam erat volutpat. \r\n" + 
				"\r\n" + 
				"  \r\n" + 
				"\r\n" + 
				"Nunc vel volutpat magna, at venenatis ligula. In malesuada non arcu efficitur gravida. Etiam malesuada mauris id consectetur dapibus. Nam molestie leo eget libero sodales, non ullamcorper dolor condimentum. Donec sed turpis dui. Suspendisse a dapibus purus. Nunc metus nunc, convallis quis gravida et, pellentesque sit amet orci. Maecenas gravida hendrerit tincidunt. Ut scelerisque et orci ut commodo. Fusce vitae mollis nibh. Donec a mauris sagittis eros imperdiet euismod. Duis et lacus urna. Sed lacinia scelerisque ullamcorper. \r\n" + 
				"\r\n" + 
				"  \r\n" + 
				"\r\n" + 
				"Vestibulum nec nunc urna. Integer egestas est ac aliquam fermentum. Morbi egestas nisi eu quam viverra, vitae fermentum mauris mattis. Integer et sapien urna. Proin et leo scelerisque, venenatis est non, hendrerit urna. Maecenas ut sodales ipsum. Suspendisse vehicula odio at ligula interdum, ut sodales lacus vulputate. Mauris egestas metus sed pellentesque eleifend. Morbi lacinia mauris sed aliquam efficitur. Nulla sed finibus ligula. Aliquam id massa nisl. Fusce a orci vehicula, imperdiet mauris nec, cursus metus. Proin rhoncus tincidunt dui et viverra. Nulla facilisi. \r\n" + 
				"\r\n" + 
				"  \r\n" + 
				"\r\n" + 
				"Morbi magna diam, aliquam a luctus quis, interdum vitae ipsum. Ut eget tortor risus. Vivamus eu nibh sagittis, consectetur diam et, euismod mi. Suspendisse ultrices lorem et massa ornare, vitae laoreet odio condimentum. Duis et felis vel arcu lacinia sollicitudin. Aenean vel odio felis. Etiam blandit velit eros, et dapibus ante ultrices ac. Integer posuere eu urna cursus sagittis. Quisque mattis feugiat ligula ultricies facilisis. Ut nec quam nec dui commodo pretium rhoncus a magna. Pellentesque mauris augue, cursus ac augue id, efficitur vestibulum erat. Vestibulum nec lacus eu orci elementum ullamcorper. Donec et eros at lorem egestas laoreet et eget justo. Proin volutpat, tellus eu imperdiet luctus, ex nibh laoreet leo, at tincidunt lorem risus accumsan urna.  ";
		String subject = "NSCIT_TEST : 5 JOHN DOE 5 ";
		String to = "testing20201015@gmail.com";
		String from = "testing20201015@yahoo.com";
		
//		sendEmail(message,subject,to,from);
		sendAttach(message,subject,to,from);
	}

	//this is responsible to send the message with attachment
	private static void sendAttach(String message, String subject, String to, String from) {
		
		//Variable for gmail
				String host="smtp.gmail.com";
				
				//get the system properties
				Properties properties = System.getProperties();
				System.out.println("PROPERTIES "+properties);
				
				//host set
				properties.put("mail.smtp.host", host);
				properties.put("mail.smtp.port","465");
				properties.put("mail.smtp.ssl.enable","true");
				properties.put("mail.smtp.auth","true");
				
				
				//Step 1: to get the session object..
				Session session=Session.getInstance(properties, new Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {				
						return new PasswordAuthentication("kawarhemant350@gmail.com", "hemant@0006");
					}
					
					
					
				});
				
				session.setDebug(true);
  
				//Step 2 : compose the message [text,multi media]
				MimeMessage m = new MimeMessage(session);
				
				try {
				
				//from email
				m.setFrom(from);
				
				//adding recipient to message
				m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				
				//adding subject to message
				m.setSubject(subject);
			
				
				//adding text to message
				m.setText(message);
				
				//send 
				
				//Step 3 : send the message using Transport class
				Transport.send(m);
				
				System.out.println("Sent success...................");
				
				
				}catch (Exception e) {
					e.printStackTrace();
				}
	
	}
}
