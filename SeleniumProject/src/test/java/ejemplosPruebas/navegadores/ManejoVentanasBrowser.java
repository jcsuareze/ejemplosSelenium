package ejemplosPruebas.navegadores;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ManejoVentanasBrowser {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();

		driver.findElement(By.linkText("OrangeHRM, Inc")).click();

		Set<String> windowsId = driver.getWindowHandles();// guarda los id's de 2 ventanas

		/****** Approach 1 usando colecciones LIST******NO RECOMENDABLE *************/
		// Capturando los Id de los navegadores web

		/*
		 * 
		 * 
		 * List<String> windowsList = new ArrayList(windowsId);// Se convierte Set a
		 * list para poder obtener valores // individuales
		 * 
		 * String parentWindowsId = windowsList.get(0); String childWindowId =
		 * windowsList.get(1);
		 * 
		 * // cambia a window child driver.switchTo().window(childWindowId);
		 * driver.findElement(By.
		 * xpath("//div[@class='d-flex web-menu-btn']//li[1]//a[1]")).click();
		 * 
		 * // cambia a window parent driver.switchTo().window(parentWindowsId);
		 * driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(
		 * "admin");
		 */
		/****** Approach 2 *******************/

		for (String winId : windowsId) {

			String title = driver.switchTo().window(winId).getTitle();

			if (title.equals("OrangeHRM HR Software | Free & Open Source HR Software | HRMS | HRIS | OrangeHRM")) {
				driver.findElement(By.xpath("//div[@class='d-flex web-menu-btn']//li[1]//a[1]")).click();
				driver.close();
			}
		}

	}

}
