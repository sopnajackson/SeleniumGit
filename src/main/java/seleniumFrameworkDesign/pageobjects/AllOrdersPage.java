package seleniumFrameworkDesign.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumFrameworkDesign.AbstractComponents.AbstractComponents;

public class AllOrdersPage extends AbstractComponents {
	
	WebDriver driver;
	
	@FindBy(xpath="//table[contains(class,table)]/tbody/tr/td[2]")
	List<WebElement> pNames;
	
	public AllOrdersPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public Boolean OrderInOrders(String pname) {
		Boolean match=pNames.stream().anyMatch(product->product.getText().equalsIgnoreCase(pname));
		return match;
	}

}
