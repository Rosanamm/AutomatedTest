package rosana.automated.login;

import static org.junit.Assert.assertTrue;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

	private WebDriver driver = null; 
	private Authenticate page;
 
	/**
	 * criando o Driver e definindo a página a ser testada
	 */
	@Before
	public void Inicializa(){
		System.setProperty("webdriver.chrome.driver", "C:/ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		this.page = new Authenticate(driver);
	}
	
	
	
	@Test
	public void TestLogin() throws InterruptedException, IOException {
		page.Login("avaliacao_qa_samba@sambatech.com.br", "12345678",false);		
		assertTrue("Não logou", page.ValidationLogin());
	}
	
	@Test
	public void TestUser() throws InterruptedException, IOException {
		page.Login("samba@sambatech.com.br", "12345678",false);		
		assertTrue("Não foi para tela de erro", page.ValidationErroUser());
	}
	
	@Test
	public void TestPsw() throws InterruptedException, IOException {
		page.Login("avaliacao_qa_samba@sambatech.com.br", "1234",false);		
		assertTrue("Não foi para tela de erro", page.ValidationErrorPsw());
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
