package rosana.test.automated;

import static org.junit.Assert.*;

import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Estatistics {

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
	@Test
	public void TestEstatistic() throws  InterruptedException, IOException{
		page.Login("avaliacao_qa_samba@sambatech.com.br", "12345678",false);
		page.Estatistic("custom","30/10/2016","29/11/2016");
		assertTrue("Tela de erro no grafíco em vez do grafico", page.ValidationGraphic());
	}
	
	@Test
	public void TestEstatisticFail() throws  InterruptedException, IOException{
		page.Login("avaliacao_qa_samba@sambatech.com.br", "12345678",false);
		page.Estatistic("custom","30/10/2015","29/11/2016");
		assertFalse("Apresentou o grafico em vez do erro", page.ValidationGraphic());
	}
	
	
	/**
	 * Finaliza o Driver e fecha o browser
	 */
	@After
	public void Finaliza() {
		driver.quit();
	}

}