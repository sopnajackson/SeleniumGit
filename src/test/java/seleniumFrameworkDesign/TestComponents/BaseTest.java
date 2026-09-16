package seleniumFrameworkDesign.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumFrameworkDesign.pageobjects.LandingPage;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage lp;
	
	public WebDriver initializeDriver() throws IOException {
		
		Properties pro=new Properties();
		FileInputStream finput=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/seleniumFrameworkDesign/Resources/GlobalData.properities");
		pro.load(finput);
		
		//if browser property is passed from mvn terminal then use that value instead of reading from GlobalData.properities file
		//to pass from terminal use cmd: mvn test -Dbrowser=Firefox
		
		String browserName=System.getProperty("browser")!=null ? System.getProperty("browser") : pro.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("Chrome");
		}
		
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
			
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
		
	}
	
	@BeforeMethod(alwaysRun=true)
	public void launchApplication() throws IOException {
		WebDriver driver=initializeDriver();
		lp=new LandingPage(driver);
		lp.goTo();
		
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeDriver() {
		driver.close();
		
	}
	
	public List<HashMap<String, String>> jsonToMap() throws IOException {
		String jsonString=FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\seleniumFrameworkDesign\\data\\PurchaseOrder.json"),StandardCharsets.UTF_8);
		ObjectMapper mapper=new ObjectMapper();
		return mapper.readValue(jsonString, new TypeReference<List<HashMap<String,String>>>(){});

}
	public String screenShot(String fname) throws IOException {
		TakesScreenshot tss=(TakesScreenshot)driver;
		File f=tss.getScreenshotAs(OutputType.FILE);
		File dest=new File(System.getProperty("user.dir")+"\\screenshots\\"+fname+".png");
		FileUtils.copyFile(f, dest);
		return System.getProperty("user.dir")+"\\screenshots\\"+fname+".png";
		
	}
}
