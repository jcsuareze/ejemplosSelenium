package ejemplosPruebas.acciones;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickDerechoMouse {

	
	
	/*****  contextClick(WebElement)  ****************/
	public static void main(String[] args) {		
		
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		
		WebElement buttonEle = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));

		Actions acciones = new Actions(driver);
		
		//Click derecho
		acciones.contextClick(buttonEle).perform();
		
		//Click regular en la funcion copy
		driver.findElement(By.xpath("//span[normalize-space()='Copy']")).click(); 
		
		driver.switchTo().alert().accept();// cerrar la ventana de alerta
		
		driver.quit();
		
	}

}
