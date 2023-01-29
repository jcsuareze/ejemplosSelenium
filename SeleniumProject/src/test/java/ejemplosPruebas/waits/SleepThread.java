package ejemplosPruebas.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SleepThread {

	public static void main(String[] args) throws InterruptedException {
		
		/* Proporcionado por Java y no por Selenium
		 * 
		 * Desventajas
		 * 
		 * Posiblemente el tiempo asignado es insuficiente, no encontrara el elemento
		 * Si encuentra el elemento rapidamente el tiempo restante es perdido
		 * Es probable que se use el mismo comando multiples veces 
		 * 
		 * */

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("http://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		

		driver.quit();

	}

}
