package rosana.test.automated;

import static org.junit.Assert.assertTrue;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Authenticate {

	private WebDriver driver = null; 
	private Util page;

	/**
	 * criando o Driver
	 */
	@Before
	public void Inicializa(){
		System.setProperty("webdriver.chrome.driver", "C:/ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		this.page = new Util(driver);
	}
	
	
	/**
	 * testes  serem realizados - Módulo Login
	 */
	@Test
		public void TestLogin() throws InterruptedException, IOException {
		page.Login("avaliacao_qa_samba@sambatech.com.br", "12345678",false);		
		assertTrue("Não logou", page.ValidationLogin());
	}
	
	@Test
	public void TestUserInexistente() throws InterruptedException, IOException {
		page.Login("samba@sambatech.com.br", "12345678",false);		
		assertTrue("Não foi para tela de erro", page.ValidationErroUser());
	}
	
	@Test
	public void TestSenhaFalsa() throws InterruptedException, IOException {
		page.Login("avaliacao_qa_samba@sambatech.com.br", "1234",false);		
		assertTrue("Não foi para tela de erro", page.ValidationErrorPsw());
	}
	
	@Test
	public void TestLoginSemEmail() throws InterruptedException, IOException {
		page.Login("", "12345678",false);		
		assertTrue("Não foi para tela de erro", page.TestLoginCpOb());
	}
	
	@Test
	public void TestLoginSemSenha() throws InterruptedException, IOException {
		page.Login("", "12345678",false);		
		assertTrue("Não foi para tela de erro", page.TestLoginCpOb());
	}
	
	@Ignore("Verificando como o driver salva sessão")
	public void TestRememberMe() throws InterruptedException, IOException {
		page.Login("avaliacao_qa_samba@sambatech.com.br", "12345678",true);
		assertTrue("Não manteve logado", page.RememberMe());
	}
	
	/**
	 * Finaliza o Driver e fecha o browser
	 */
	@After
	public void Finaliza() {
		driver.quit();
	}

}