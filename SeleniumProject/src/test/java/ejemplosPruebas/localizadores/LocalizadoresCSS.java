package ejemplosPruebas.localizadores;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocalizadoresCSS {

	public static void main(String[] args) throws InterruptedException {
		
		/*
		 * Diferentes formas de usar los CSS Selectors
		 * 
		 * tag  Id				simbolo ( # )              Ex. input#small-sarchterms
		 * 
		 * tag class			simbolo ( . )            
		 * 
		 * tag attribute		simbolo ( [] )
		 * 
		 * tag class attribute	simbolo ( . [] )
		 * 
		 * 
		 * Al usar class si existen espacios, solo usar la primera parte de class
		 * */
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		/********       EL PRIMER ELEMENTO ES OPCIONAL en este caso INPUT      ************/
		//CSS con tag e id
		//driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("MacBook");
		//driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("MacBook");
		
		//class
		//driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("MacBook");
		//driver.findElement(By.cssSelector(".search-box-text")).sendKeys("MacBook");
		
		// attribute
		//driver.findElement(By.cssSelector("input[type='text']")).sendKeys("MacBook");
		
		driver.findElement(By.cssSelector("input.search-box-text[type='text']")).sendKeys("MacBook");
		
		Thread.sleep(1000);
		driver.quit();

	}

}
