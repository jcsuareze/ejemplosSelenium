package ejemplosPruebas.acciones;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HoverMouse {  
	
	/***** moveToElement(WebElement)*********/

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
		WebElement desktopsEle = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
		WebElement macEle = driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));
		
		
		//El constructor necesita una instancia de WebDriver
		Actions accion = new Actions(driver);
		
		//Mouse Hover
		//Es necesario poner el metodo build().perform() que permitirar crear una accion despues de CLICK()
		// build() crea la accion  (puede ser omitido, ya que perform crea su propio build
		//perform() ejecuta la accion		
		accion.moveToElement(desktopsEle).moveToElement(macEle).click().build().perform();
			

	}

}
