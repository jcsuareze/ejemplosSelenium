package ejemplosPruebas.navegadores;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UbicacionDeElementos {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		WebElement logo = driver.findElement(By.xpath("//img[@alt='company-branding']"));

		System.out.println("Ubicacion del logo antes de maximizar la ventana:" + logo.getLocation());

		driver.manage().window().maximize();

		System.out.println("Ubicacion del logo despues de maximizar la ventana:" + logo.getLocation());

		driver.manage().window().minimize();

		System.out.println("Ubicacion del logo despues de minimizar la ventana:" + logo.getLocation());

		driver.manage().window().fullscreen();

		System.out.println("Ubicacion del logo despues ampliar la ventana:" + logo.getLocation());

		driver.quit();

	}

}
