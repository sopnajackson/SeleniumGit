package seleniumFrameworkDesign.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumFrameworkDesign.AbstractComponents.AbstractComponents;

public class OrderPlacedPage extends AbstractComponents {
	
	WebDriver driver;
	
	@FindBy(css=".hero-primary")
	WebElement msg;
	
	public OrderPlacedPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String checkmsg() {
		String actual=msg.getText();
		return actual;
		
	}

}
