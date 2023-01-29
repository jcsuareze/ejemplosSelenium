package ejemplosPruebas.localizadores;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Localizadores1 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://automationpractice.com/index.php");
		
		
		//search textbox
		driver.findElement(By.id("search_query_top")).sendKeys("T-shirts");
		
		//boton search  on Name
		driver.findElement(By.name("submit_search")).click();
		
		//link text - se usa el texto completo que identifica el link
		//driver.findElement(By.linkText("Printed Chiffon Dress")).click();
		
		//partial link text - se usa el texto parcial que identifica el link
		// se usa de preferencia texto completo
		driver.findElement(By.partialLinkText("Printed Chiffon")).click();
		
		
		
		
		
		
		
		
		
		
		driver.quit();

	}

}
