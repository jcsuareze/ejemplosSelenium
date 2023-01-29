package ejemplosPruebas.elementosWeb;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownAutosugerencia {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		
		//Datos para la sugerencia 
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Selenium");
		
		List<WebElement> listaElem = driver.findElements(By.xpath("//div[contains(@class,'wM6W7d')]//span"));
		
		System.out.println(listaElem.size());
		for(WebElement ele: listaElem) {
			System.out.println(ele.getText());
			ele.click();
			
		}
		
		driver.close();
	}

}
