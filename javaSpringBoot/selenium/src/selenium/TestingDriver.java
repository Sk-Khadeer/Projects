package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestingDriver {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "");
		WebDriver driver=new ChromeDriver();  
	      
		// Launch website  
		    driver.navigate().to("http://www.google.com/");
	}

}
