package enviando.email;

import org.junit.Test;

public class ObjetoEnviarEmailTest {

	@Test
	public void testeEmail() throws Exception {

		StringBuilder sbTextEmail = new StringBuilder();
		sbTextEmail.append("<h2> Olá, <br/><br/> Testando Javamail! </h2><br/><br/>");
		sbTextEmail.append("Estou aprendendo sobre o javamail <br/><br/>");
		sbTextEmail.append("Fazendo um botão <br/><br/>");
		sbTextEmail.append("<a target =\"_blank\" href=\"https://github.com/Daniel-Penelva\" style=\"color:#2F4F4F; padding: 14px 25px; text-align:center; text-decoration:none; display:inline-block; border-radius:30px; font-size:20px; font-family: courier; border: 3px solid green; background-color:#8FBC8F;\"> Acessar GitHub Daniel Penelva</a>");
		
		
		ObjetoEnviaEmail objEnviarEmail = new ObjetoEnviaEmail("d4n.formacaojava@gmail.com", 
				"Daniel - Treinando javamail",
				"Testando email com java", 
				sbTextEmail.toString());

		objEnviarEmail.enviarEmail(true);
		
	}

}
