package rosana.automated.login;

import java.io.IOException;

import org.openqa.selenium.By;
//import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Authenticate {
	private WebDriver driver;
	 
	public Authenticate(WebDriver driver) {
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
	
}
