package seleniumFrameworkDesign.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import seleniumFrameworkDesign.pageobjects.AllOrdersPage;
import seleniumFrameworkDesign.pageobjects.ConfirmationPage;

public class AbstractComponents {
	
	WebDriver driver;
	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement gotocart;
	
	@FindBy(css="button[routerlink='/dashboard/myorders']")
	WebElement orders;
	
	By cart=By.xpath("//button[@routerlink='/dashboard/cart']");
	
	
	public AbstractComponents(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	
	public void visibilityAllElements(By loc) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(loc));
	}
	
	public void invisibilityof(WebElement wloc) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(wloc));
	}
	
	public void clickable(By loc) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(loc));
	}
	
	public void visibilityofone(WebElement wloc) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(wloc));
	}
	
	public ConfirmationPage goToCart() {
		clickable(cart);
		gotocart.click();
		ConfirmationPage cp=new ConfirmationPage(driver);
		return cp;
	}
	
	public AllOrdersPage goToOrders() {
		orders.click();
		AllOrdersPage aop=new AllOrdersPage(driver);
		return aop;
	}
}
