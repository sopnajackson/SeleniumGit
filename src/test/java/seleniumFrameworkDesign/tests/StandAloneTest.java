package seleniumFrameworkDesign.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Sopna@gmail.com and Sopna@2730
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("sopna@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Sopna@2730");
		driver.findElement(By.id("login")).click();
		
		List<WebElement> productName=driver.findElements(By.xpath("//div[@class='card-body']"));
		
		
		WebElement prod=productName.stream().filter(product->product.findElement(By.xpath(".//b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		prod.findElement(By.xpath(".//button[text()=' Add To Cart']")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@routerlink='/dashboard/cart']")));
		
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		
		//List<WebElement> cart=driver.findElements(By.cssSelector(".cart"));
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='cartSection']/h3")).getText(), "ZARA COAT 3");
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ta-results"))));
		List<WebElement> countryNames=driver.findElements(By.xpath("//section[@class='ta-results list-group ng-star-inserted']//span"));
		
		WebElement c=countryNames.stream().filter(country->country.getText().equals("India")).findFirst().orElse(null);
		c.click();
	
		WebElement placeOrder=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".action__submit")));	
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", placeOrder);
		//placeOrder.click();
		//driver.findElement(By.cssSelector(".action__submit")).click();
		
		
		Assert.assertEquals(driver.findElement(By.cssSelector(".hero-primary")).getText(),"THANKYOU FOR THE ORDER.");

	}

}
