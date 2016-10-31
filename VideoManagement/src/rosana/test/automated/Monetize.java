package rosana.test.automated;

import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Monetize {
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
	 * testes  serem realizados - Módulo Estatisticas
	 */
	@Ignore
	public void Create() throws  InterruptedException, IOException{
		page.Login("avaliacao_qa_samba@sambatech.com.br", "12345678",false);
		page.CreateCampaign();
	}

	
	
	/**
	 * Finaliza o Driver e fecha o browser
	 */
	@After
	public void Finaliza() {
		driver.quit();
	}
}
