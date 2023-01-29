package ejemplosPruebas.navegadores;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ManejoFrames1 {

	public static void main(String[] args) {
		
		/*
		 * Buscar los tags <iframe>
		 * 
		 * Los argumentos que se acepta
		 * driver.switchTo().frame(name/id)
		 * driver.switchTo().frame(WebElement)
		 * driver.switchTo().frame(index <--- Evitar si se tiene mas de 2 framess
		 * driver.switchTo().defaultContent()
		 * 
		 * */

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		driver.manage().window().maximize();
		
		/* Actualmente en el frame default*/
		
		
		//Cambia a Frame izquierda/arriba
		driver.switchTo().frame("packageListFrame");		
		driver.findElement(By.linkText("org.openqa.selenium")).click();
		
		/*******Al hacer el cambio de frame, el foto debe de regresar al principal (default)
		 * para poder hacer cambio a otro frame */
		
		driver.switchTo().defaultContent();
		
		//cambia a Frame izquierda/abajo
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.linkText("WebDriver")).click();
		
		
		driver.switchTo().defaultContent();		
		
		//cambia a Frame izquierda/abajo
		driver.switchTo().frame("classFrame");
		driver.findElement(By.xpath("//div[@class='topNav']//a[normalize-space()='Overview']")).click();
		
		driver.quit();
	}

}
