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

public class ObjetoEnviaEmail {

	private String userName = "d4n.formacaojava@gmail.com";
	private String senha = "yopaexqxnyrndmtu";
	
	private String listaDestinatarios = "";
	private String nomeRemetente = "";
	private String assuntoEmail = "";
	private String textoEmail = "";
	
	public ObjetoEnviaEmail(String listaDestinatario, String nomeRemetente, String assuntoEmail, String textoEmail) {
		this.listaDestinatarios = listaDestinatario;
		this.nomeRemetente = nomeRemetente;
		this.assuntoEmail = assuntoEmail;
		this.textoEmail = textoEmail;
	}
	

	public void enviarEmail() throws Exception{
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
		properties.put("mail.smtp.socketFactory.port", "465");

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
		Address[] toUser = InternetAddress.parse(listaDestinatarios);

		// Habilitar a mensagem para o envio
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(userName, nomeRemetente)); // Quem está enviando
		message.setRecipients(Message.RecipientType.TO, toUser); // Email de destino
		message.setSubject(assuntoEmail); // assunto do email
		message.setText(textoEmail); // campo de texto do email

		Transport.send(message);
	}

}
