package rosana.test.automated;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Util {
	private WebDriver driver;
	 
	public Util(WebDriver driver) {
		this.driver = driver;
	}
 
	public void Login(String user, String password, Boolean rmb) throws IOException {
		
		try{
			
			driver.get("http://52.2.166.124:8085/auth/login");
			
			WebElement userName = driver.findElement(By.name("j_username"));
	    	userName.sendKeys(user);
	    	
	    		    	
	    	WebElement pw = driver.findElement(By.id("inputPassword"));
	    	pw.sendKeys(password);
	    	
	    	if(rmb){
	    		WebElement button = driver.findElement(By.id("rememeberMe"));
	    		button.click();
	    	}
	    				
	    	WebElement button = driver.findElement(By.id("login"));
	    	button.click();
			
		}
		catch (Exception e){
			System.out.println("\n>>>ERRO DE LOGIN<<<\n\n"+e);
		}	
		
	}
	
	public boolean ValidationLogin() throws InterruptedException {
		
		Thread.sleep(4000);		
		String url = driver.getCurrentUrl();				
		
		if(url.equals("http://52.2.166.124:8085/ui#dashboard"))
			return true;
			
		return false;
	}
	
	public boolean ValidationErroUser() throws InterruptedException {
		
		Thread.sleep(4000);		
		//WebElement msg = driver.findElement(By.id("password_incorrect"));	//não está achando o elemento de spam			
		//if(msg.equals("password_incorrect")) 
		
		String url = driver.getCurrentUrl();		
		if(url.equals("http://52.2.166.124:8085/auth/login?authentication_error=true"))
			return true;
			
		return false;
	}

	public boolean ValidationErrorPsw() throws InterruptedException {
		
		Thread.sleep(4000);		
		String url = driver.getCurrentUrl();	
		
		if(url.equals("http://52.2.166.124:8085/auth/login?authentication_error=true"))
			return true;
			
		return false;
	}
	
	public boolean TestLoginCpOb() throws InterruptedException {
		
		Thread.sleep(4000);		
		String url = driver.getCurrentUrl();	
		
		if(url.equals("http://52.2.166.124:8085/auth/login?authentication_error=true"))
			return true;
			
		return false;
	}
	
	public boolean RememberMe() throws InterruptedException, IOException {
		driver.close();
		Thread.sleep(2000);		
			
		driver = new ChromeDriver(); //ver como funciona melhor
		Thread.sleep(2000);
		
		driver.get("http://52.2.166.124:8085");
		Thread.sleep(2000);

		String url = driver.getCurrentUrl();
		if(url.equals("http://52.2.166.124:8085/#dashboard"))
			return true;
			
		return false;
		
	}
	
	public void Estatistic(String periodo, String inicio, String fim) throws IOException, InterruptedException {
		
			driver.get("http://52.2.166.124:8085/ui#statistics/period");
			Thread.sleep(4000);		

			final Select period = new Select(driver.findElement(By.id("select-period")));
	    	period.selectByValue(periodo);
	    			
	    	WebElement dataIni = driver.findElement(By.id("input-dataIni"));
			dataIni.sendKeys(inicio);
			
			WebElement dataFim = driver.findElement(By.id("input-dataFim"));
			dataFim.sendKeys(fim);
			
	    	WebElement button = driver.findElement(By.className("span1"));
	    	button.click();
	    	
	    	Thread.sleep(4000);

	}
	
	public boolean ValidationGraphic() throws InterruptedException {
		try{
		
		WebElement ErroPeriodo = driver.findElement(By.id("graph-holder"));
		
		if(ErroPeriodo.isEnabled())
			return true;
			
		return false;
		
		
	}
	catch (Exception e){
		System.out.println("\n>>>ERRO DE GRÁFICO<<<\n\n"+e);
	}	
		return false;

	}
	
	public boolean CreateCampaign() throws IOException, InterruptedException {
		try{
		driver.get("http://52.2.166.124:8085/ui#monetization");
		Thread.sleep(4000);		

		driver.findElement(By.id("create-campaign")).click();
		driver.findElement(By.name("name")).sendKeys("nova campanha");
		driver.findElement(By.name("urlClickThrough")).sendKeys("sambatech.com");
		driver.findElement(By.name("target")).sendKeys("100");
		driver.findElement(By.name("grossValue")).sendKeys("0.5");
		driver.findElement(By.className("btn btn-primary")).click(); //não achou o botão salvar

		}
		catch (Exception e){
			System.out.println("\n>>>NÃO ACHOU BOTÃO DE SALVAR<<<\n\n"+e);
		}	
			return false;
}
		
	public boolean Upload(String caminho) throws IOException, InterruptedException {
		try{
		driver.get("http://52.2.166.124:8085/ui#monetization");
		Thread.sleep(4000);		

		WebElement buttonUp = driver.findElement(By.id("upload-large"));
		buttonUp.sendKeys(caminho);
//		driver.findElement(By.id("upload-large")).sendKeys(caminho);

		}
		catch (Exception e){
			System.out.println("\n>>>NÃO ACHOU BOTÃO DE UPLOAD<<<\n\n"+e);
		}	
			return false;
}
	
	public boolean ValidationUpload() throws IOException, InterruptedException {
			try{
				Thread.sleep(4000);		
				WebElement enviou = driver.findElement(By.className("edit-media"));
				
				if(enviou.equals("Editar informações"))
					return true;		
				return false;
			}
			catch (Exception e){
				System.out.println("\n>>>ERRO DE UPLOAD<<<\n\n"+e);
			}	
				return false;
	}
	
}