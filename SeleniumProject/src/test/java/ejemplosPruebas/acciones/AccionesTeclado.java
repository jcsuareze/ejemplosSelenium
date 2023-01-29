package ejemplosPruebas.acciones;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AccionesTeclado {

	public static void main(String[] args) {
		
		//Escribir texto,  seleccionar todo,  copiarlo,  hacer TAB, pegar texto
		//Es necesario la clase Actions

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//textarea[@id='inputText1']")).sendKeys("Hola Mundo");
		
		Actions acciones = new Actions(driver);
		
	 
		//CTRL+A 
		acciones.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		
		//CTRL+C   
		acciones.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
		
		//TAB
		
		acciones.keyDown(Keys.TAB).perform(); // Como se usa una sola tecla, no es necesario KeyUP
		
		//CTRL+V
		
		acciones.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();

	}

}
