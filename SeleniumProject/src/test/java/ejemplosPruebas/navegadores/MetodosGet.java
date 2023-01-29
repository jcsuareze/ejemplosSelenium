package ejemplosPruebas.navegadores;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MetodosGet {

	/*
	 * 			get(url)
	 * getTitle() 
	 * getCurrentURL() 
	 * getPageSource() 
	 * getWindowHandle()
	 * getWindowHandles()
	 * Se puede accesar a estos mediante una instancia de la Clase WebDriverManager
	 * 
	 */

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("http://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();

		System.out.println("Titulo de la pagina: " + driver.getTitle());
		
		System.out.println("URL de la pagina: " + driver.getCurrentUrl());
		
		String ps =  driver.getPageSource();
		
		System.out.println(ps.contains("html"));	
		
		/* Comentado para que no muestre todo el codigo fuente
		 * 
		System.out.println("Codigo fuente de la pagina: " +ps);
		*/
		
		
		//EL ID de la pagina no es constante cada vez que se ejecuta
		//System.out.println(driver.getWindowHandle());
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Orange')]")).click();
		Thread.sleep(1000);
		
		
		Set<String> windowsIds = driver.getWindowHandles();  //Multiples instancias de browsers
		
		for(String winID:windowsIds)
			System.out.println(winID);

		
		driver.quit();
	}

}
