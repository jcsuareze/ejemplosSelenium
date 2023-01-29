package ejemplosPruebas.waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait {

	public static void main(String[] args) {

		/**** Para iniciar un Explicit wait se necesita la instancia de driver ***/
		/*
		 * Primero trabaja en la condicion y despues sobre el tiempo No trabaja para
		 * todos y cada uno de los elementos, se debe especificar cada uno
		 *
		 */

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		// Declarecion de Explicit wait con la clase WebDriverWait y Duration
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("http://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();

		// Se declara con el metodo UNTIL( CLASE EXPECTED CONDITIONS **condicion***)
		WebElement userName = myWait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));

		WebElement passTxt = myWait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));

		userName.sendKeys("Admin");
		passTxt.sendKeys("admin123");

		System.out.println(driver.getTitle());

		driver.quit();

	}
}
