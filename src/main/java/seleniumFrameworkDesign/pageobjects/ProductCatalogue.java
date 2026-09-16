package seleniumFrameworkDesign.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumFrameworkDesign.AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents{
	
	WebDriver driver;
	
	
	public ProductCatalogue(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='card-body']")
	List<WebElement> productList;
	
	@FindBy(css=".ng-animating")
	WebElement animate;
	
	
	By toastContainer=By.cssSelector("#toast-container");
	
	
	public WebElement getProductByName(String prodName) {
		WebElement prodElement=productList.stream().filter(product->product.findElement(By.xpath(".//b")).getText().equals(prodName)).findFirst().orElse(null);
		return prodElement;
	}
	
		
	public void addToCart(String pname) {
		getProductByName(pname).findElement(By.xpath(".//button[text()=' Add To Cart']")).click();
		visibilityAllElements(toastContainer);
		invisibilityof(animate);
	}	
	
}
	
	
