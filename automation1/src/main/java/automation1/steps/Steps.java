package automation1.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {

	WebDriver driver;

	@SuppressWarnings("deprecation")
	@Given("With the browser open")
	public void withTheBrowserOpen() throws Throwable {
		// configure webDriver
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);

	}

	@When("I enter the google page")
	public void IEnterTheGooglePage() throws Throwable {
		
		// enter in www.google.com.br
		driver.get("https://www.google.com.br/");
	}

	@Then("So I search for Houses")
	public void SoISearchForHouses() throws Throwable {
		
		// write in search box
		WebElement searchBOX = driver.findElement(By.name("q"));
		searchBOX.sendKeys("Houses");

		// click in button search
		WebElement buttonSearch = driver.findElement(By.name("btnK"));
		buttonSearch.click();
		
		String resultSearch = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[4]/div/div/div[1]/a/h3")).getText();
		
		if(resultSearch.contains("Houses")) {
			assert true ;
		} else {
			assert false;
		}
		
	}

	@After
	public void finish() {
		driver.quit();
	}

}
