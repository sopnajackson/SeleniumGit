package seleniumFrameworkDesign.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumFrameworkDesign.AbstractComponents.AbstractComponents;

public class PaymentPage extends AbstractComponents{
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement selectCountry;
	
	@FindBy(css=".ta-results")
	WebElement results;
	
	@FindBy(xpath="//section[@class='ta-results list-group ng-star-inserted']//span")
	List<WebElement> resultCountryNames;
	
	@FindBy(css=".action__submit")
	WebElement submitbuttonelement;
	
	By submitbutton=By.cssSelector(".action__submit");
	
	public PaymentPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void EnterCountry(String cName) {
		selectCountry.sendKeys(cName);
		visibilityofone(results);
	}
	
	public void SelectCountry(String cName) {
		WebElement c=resultCountryNames.stream().filter(country->country.getText().equals(cName)).findFirst().orElse(null);
		c.click();
	}
	
	public OrderPlacedPage submit() {
		clickable(submitbutton);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", submitbuttonelement);
		OrderPlacedPage opp=new OrderPlacedPage(driver);
		return opp;
	}
	

}
