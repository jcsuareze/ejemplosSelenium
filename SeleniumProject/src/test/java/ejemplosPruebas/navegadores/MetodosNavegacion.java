package ejemplosPruebas.navegadores;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MetodosNavegacion {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Abre paginas dentro del mismo navegador
		driver.get("http://amazon.mx");
		System.out.println(driver.getCurrentUrl());

		//Funciona igual que Get  ( pasa como argumento URL que a su vez llama al metodo get)
		driver.navigate().to("http://demo.nopcommerce.com/register");
		System.out.println(driver.getCurrentUrl());

		// Regresa a la primera pagina
		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());

		// Avanza a la pagina posterior
		driver.navigate().forward();
		System.out.println(driver.getCurrentUrl());

		// Refresca la pagina
		driver.navigate().refresh();

		driver.quit();

	}

}
