package ejemplosPruebas.navegadores;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MetodosCodicionales {
	
	/*******Son iniciados desde un WebElement*********/
	/*
	 * isDisplayed()
	 * isEnabled()
	 * isSelected() 
	 * 
	 * */

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("http://demo.nopcommerce.com/register");
		driver.manage().window().maximize();	
		
		/*Busqueda del logo de la pagina*/
		
		Thread.sleep(2000);
		WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		System.out.println(logo.isDisplayed());
		
		
		//Busqueda de searchBox de la pagina
		//Thread.sleep(1000);
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		System.out.println(searchBox.isEnabled());
		System.out.println(searchBox.isDisplayed());
		
		WebElement male_rd = driver.findElement(By.xpath("//input[@id='gender-male']"));
		WebElement female_rd = driver.findElement(By.xpath("//input[@id='gender-female']"));
		
		//Antes de la seleccion
		System.out.println("Antes de la seleccion masculino: " + male_rd.isSelected());
		System.out.println("Antes de la seleccion femenino: " + female_rd.isSelected());
		
		male_rd.click();
				
		//Despues de la seleccion
		System.out.println("Despues de la seleccion masculino: " + male_rd.isSelected());
		System.out.println("Despues de la seleccion masculino: " + female_rd.isSelected());
				
				
		driver.quit();
	}

}
