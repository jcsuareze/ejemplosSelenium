package ejemplosPruebas.navegadores;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MetodosBrowser {

	public static void main(String[] args) throws InterruptedException {

		
		WebDriverManager.chromedriver();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		driver.findElement(By.partialLinkText("Orange")).click();
		
		//cierra solo una instancia del browser que contiene el foco
		//si abrimos otra instancia, debemos pasar el foco a esa instancia
		driver.close();
		
		//cierra la instancia de driver, por lo tanto cerrara todas las ventanas abiertas
		driver.quit();
		

	}

}
