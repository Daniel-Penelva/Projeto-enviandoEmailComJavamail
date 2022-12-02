package enviando.email;

import org.junit.Test;

public class ObjetoEnviarEmailTest {

	@Test
	public void testeEmail() throws Exception {

		ObjetoEnviaEmail objEnviarEmail = new ObjetoEnviaEmail("d4n.formacaojava@gmail.com", 
				"Daniel - Treinando javamail",
				"Testando email com java", 
				"Testando o corpo de email");

		objEnviarEmail.enviarEmail();
		
	}

}
