package enviando.email;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;

public class AppTesteEmail {

	private String userName = "d4n.formacaojava@gmail.com";
	private String senha = "9767D@ni4l";

	@Test
	public void testeEmail() {

		try {

			// Configurando propriedades do JavaMail
			Properties properties = new Properties();
			properties.put("mail.smtp.ssl.trust", "*"); /* autenticação de segurança */
			properties.put("mail.smtp.auth", "true"); /* autorização */
			properties.put("mail.smtp.starttls", "true"); /* autenticação */
			properties.put("mail.smtp.host", "smtp.gmail.com"); /* servidor gmail */
			properties.put("mail.smtp.port", "465"); /* porta do servidor */

			/*
			 * Definir o fluxo da comunicação - Especifica a porta a ser conectada pelo
			 * socket
			 */
			properties.put("mail.smtp.socketFactory", "465");

			/* classe Socket de conexão ao SMTP */
			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

			/* Sessão de requisitação para conexão do servidor com o email gmail */
			Session session = Session.getInstance(properties, new Authenticator() {

				@Override
				protected PasswordAuthentication getPasswordAuthentication() {

					return new PasswordAuthentication(userName, senha);
				}
			});

			// Para enviar para mais de um destinatario - vai ser utilizado um array
			Address[] toUser = InternetAddress.parse("d4n.formacaojava@gmail.com, d4n.penelva@gmail.com");
			
			// Habilitar a mensagem para o envio
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(userName, "Daniel - Treinando JavaMail")); // Quem está enviando
			message.setRecipients(Message.RecipientType.TO, toUser); // Email de destino
			message.setSubject("Chegou o email enviado com o java"); // assunto do email
			message.setText("Testando o corpo de email"); // campo de texto do email
			
			Transport.send(message);
			
			/*
			 * Caso o email não esteja sendo enviado então coloque um tempo de espera mais
			 * isso só pode ser usado para os testes.
			 * 
			 * Thread.sleep(5000);
			 */
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
