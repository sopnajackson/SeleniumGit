package seleniumFrameworkDesign.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//div[@class='cartSection']/h3")
	WebElement cartProduct;
	
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkout;
	
	public ConfirmationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String CheckCart() {
		String actual=cartProduct.getText();
		return actual;
	}
	
	public PaymentPage checkoutprod() {
		checkout.click();
		PaymentPage pp=new PaymentPage(driver);
		return pp;
	}
	

}
