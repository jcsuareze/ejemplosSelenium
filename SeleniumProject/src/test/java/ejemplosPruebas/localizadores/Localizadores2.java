package ejemplosPruebas.localizadores;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Localizadores2 {
	
	
	/*  Conocer el tamaño de diferentes colecciones con multiples elementos
	 * 
	 * lenght  -  Para Arreglos   i.e.    a.length
	 * 
	 * lenght()  -  Para Strings   i.e.     s.length()
	 * 
	 * size()   -  Para List, Set, Hashmaps   i.e.  l.size();
	 * */

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		
		//Cuando son multiples webelements,findElements devuelve una  Lista de WebElements
		List<WebElement> sliders = driver.findElements(By.className("homeslider-container"));		
		System.out.println("Numero de Sliders: "+ sliders.size());
		
		//Encontrar el total de imagenes  que en el DOM empiezan con img		
		 List<WebElement> imagenes = driver.findElements(By.tagName("img"));
		 System.out.println("Numero de imagenes: "+ imagenes.size());
		 
		//Encontrar el total de links  que en el DOM empiezan con a		
		 List<WebElement> links = driver.findElements(By.tagName("a"));
		 System.out.println("Numero de links: "+ links.size());
		 
		 
		 driver.quit();
		
		
		
		
	}

}
