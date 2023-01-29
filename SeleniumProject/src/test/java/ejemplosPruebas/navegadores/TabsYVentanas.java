package ejemplosPruebas.navegadores;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TabsYVentanas {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		
		driver.manage().window().maximize();
		
		//Para abrir dos instancias de Chrome		
		driver.get("http://www.opencart.com/");
		// Antes se debe de abrir un un nuevo explorador,
		// usar el metodo newWindow ()  enviar un TAB
		driver.switchTo().newWindow(WindowType.TAB);
		//driver.switchTo().newWindow(WindowType.WINDOW); // Abre en una nueva ventana
		
		driver.get("http://opensource-demo.orangehrmlive.com/");

		
	}

}
