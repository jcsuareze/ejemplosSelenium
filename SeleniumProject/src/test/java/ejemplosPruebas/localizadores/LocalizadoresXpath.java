package ejemplosPruebas.localizadores;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocalizadoresXpath {

	public static void main(String[] args) {

		/**** Existen 2 tipos de Xpaths****/
		/*
		 * Xpath Absoluto (xpath completo) **********
		 * 
		 * comienza con un /
		 * /html/body/header/div/div/div[1]/div/a/img
		 * 
		 * Xpath Relativo  (xpath parcial)************
		 *  //nombreTag[@atributo = "valor del atributo"]
		 * comienza con doble //
		 *  
		 *  
		 *  //div[@id="logo"]/a/img
		 * 
		 * */
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
		
		//Normalize-space  selecciona un texto largo elimina espacios en blanco
		String nombreProducto = driver.findElement(By.xpath("//a[normalize-space()='MacBook']")).getText();
		
		//String nombreProducto = driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[2]/div[1]/h4[1]/a[1]")).getText();
		
		System.out.print(nombreProducto);

		//driver.quit();
	}

}
