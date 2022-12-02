package enviando.email;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;

public class TesteEnviarEmail {

	
	public void enviarEmail(final String senha, final String remetente, String destinatario, String msg, String assunto) throws AddressException, MessagingException {
		Properties properties = new Properties();
		properties.put("mail.smtp.user", remetente);
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "25");
		properties.put("mail.debug", "true");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.EnableSSL.enable", "true");
		
		properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.setProperty("mail.smtp.socketFactory.fallback", "false");
		properties.setProperty("mail.smtp.port", "465");
		properties.setProperty("mail.smtp.socketFactory.port", "465");
		
		Session session = Session.getInstance(properties, new javax.mail.Authenticator(){
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication(remetente, senha);
			}
		});
		
		session.setDebug(true);
		
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(remetente));
		
		Address[] toUser = InternetAddress.parse(destinatario);
		message.setRecipients(Message.RecipientType.TO, toUser);
		message.setSubject(assunto);
		message.setText(msg);
		
		Transport.send(message);
	}
	
	@Test
	public void enviarEmail() throws AddressException, MessagingException {
		TesteEnviarEmail teste = new TesteEnviarEmail();
		teste.enviarEmail("yopaexqxnyrndmtu",
				"d4n.formacaojava@gmail.com",
				"d4n.penelva@gmail.com",
				"Testando o corpo de email",
				"Testando email com java");
	}
}
