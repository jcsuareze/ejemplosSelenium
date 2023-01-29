package ejemplosPruebas.waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWait {

	public static void main(String[] args) {

		/**** Para iniciar in Implicit wait se necesita la instancia de driver ***/
		/*
		 * Se declara solo una vez Aplica para todos y cada uno de los elementos en el
		 * script. Si encuentra el elemento antes del tiempo especificado, pasa al
		 * siguiente elemento Espera la cantidad Maxima especificada
		 * 
		 * 
		 * Desventajas:
		 * Si el tiempo no es suficiente, lanzara una excepcion
		 */

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		// No se usan Milisegundos, Se usa la clase DURATION
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();

		WebElement usertxt = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		WebElement passtxt = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		usertxt.sendKeys("Admin");
		passtxt.sendKeys("admin123");

		System.out.println(driver.getTitle());

		driver.quit();

	}
}
