package automation1.steps;

import java.util.ArrayList;
import java.util.List;
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

	@When("I enter the Correios page")
	public void IEnterTheGooglePage() throws Throwable {
		
		// enter in www.google.com.br
		driver.get("https://www.correios.com.br/");
	}

	@Then("So I search for CEP")
	public void SoISearchForHouses() throws Throwable {
		
		// write in search box
		WebElement searchBOX = driver.findElement(By.id("acesso-busca"));
			searchBOX.sendKeys("30775330");

		// click in button search
		WebElement buttonSearch = driver.findElement(By.xpath("//*[@id=\"conteudo-inicial\"]/div/div[2]/div/form[2]/div[2]/button/i"));
		buttonSearch.click();

		// switch to window
		List<String> abas = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(abas.get(1));
		
		String resultSearch = driver.findElement(By.xpath("//*[@id=\"resultado-DNEC\"]/tbody/tr/td[1]")).getText();
		
		if(resultSearch.contains("Alabandina")) {
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
