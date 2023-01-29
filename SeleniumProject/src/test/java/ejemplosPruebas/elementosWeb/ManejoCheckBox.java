package ejemplosPruebas.elementosWeb;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ManejoCheckBox {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		driver.manage().window().maximize();

		// Seleccion de checboxes //input[@id='monday']

		/*********************************SELECCION DE SOLO UN ELEMENTO*********************/
		// Seleccion de solo un elemento CheckBox
		// driver.findElement(By.cssSelector("input#monday")).click();

		
		/*********************************SELECCION DE VARIOS ELEMENTOS*********************/
		// Cuando son varios es recomendable guardarlos en colecciones **Refer2Udemy**
		// 1) capturar un Xpath comun que contenga todos los elementos
		// 2) Guardarlos en una lista
		List<WebElement> checkBoxesEle = driver
				.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));

		// Mostrar el numero de elementos
		System.out.println("Tamaño de la lista: " + checkBoxesEle.size());

		
		/*********************************SELECCION DE VARIOS ELEMENTOS FOR TRADICIONAL*********************/
		// Seleccionar o hacer click en todos los checkboxes
		// Se muestra la forma tradicional para comprencion 
		for (int i = 0; i < checkBoxesEle.size(); i++) {

			checkBoxesEle.get(i).click();
		}
		
		/*********************************SELECCION DE VARIOS ELEMENTOS FOR MEJORADO*********************/
		
		for(WebElement chekBox: checkBoxesEle) {
			chekBox.click();
		}
		/*********************************SELECCION DE ULTIMOS ELEMENTOS *********************/
		for (int i = checkBoxesEle.size()-1; i > 4; i--) {

			checkBoxesEle.get(i).click();
		}
		
		
		driver.quit();
	}
	
	

}
