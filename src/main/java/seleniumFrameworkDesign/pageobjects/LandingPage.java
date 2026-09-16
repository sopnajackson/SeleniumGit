package seleniumFrameworkDesign.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumFrameworkDesign.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {
	
	WebDriver driver;
	
	@FindBy(id="userEmail")
	WebElement username;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement incorrect;
	
	public LandingPage(WebDriver drivers){
		super(drivers);
		this.driver=drivers;
		PageFactory.initElements(driver, this);
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public ProductCatalogue login(String uname,String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		submit.click();
		ProductCatalogue pc=new ProductCatalogue(driver);
		return pc;
	}
	
	public String errorMessage() {
		visibilityofone(incorrect);
		String msg=incorrect.getText();
		return msg;
	}
	
	
}
