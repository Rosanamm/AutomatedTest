package rosana.test.automated;

import java.io.IOException;

import org.openqa.selenium.By;
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
			
		driver = new ChromeDriver(); //ver como funciona
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
	    	period.selectByValue(periodo);// sendKeys("last_30_days");
	    			
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
		//WebElement achou = driver.findElement(By.className("progress progress-large progress-striped progress-info active"));
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
	
	public boolean ValidationUpload() throws IOException, InterruptedException {
		
		Thread.sleep(4000);		
		//WebElement achou = driver.findElement(By.className("progress progress-large progress-striped progress-info active"));
		WebElement enviou = driver.findElement(By.className("edit-media"));
		
		if(enviou.equals("Editar informações"))
			return true;		
		return false;
		
	}
	
	
}