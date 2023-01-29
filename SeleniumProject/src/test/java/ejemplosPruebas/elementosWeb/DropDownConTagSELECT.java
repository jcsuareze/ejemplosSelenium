package ejemplosPruebas.elementosWeb;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownConTagSELECT {

	public static void main(String[] args) {

		/******** Con la clase SELECT se usa para SELECT tags **************/

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://www.opencart.com/index.php");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[@class='btn btn-black navbar-btn']")).click();

		// Seleccionar el xpath sobre select
		WebElement dropdwnEle = driver.findElement(By.xpath("//select[@id='input-country']"));

		// Se pasa el WebElement que contiene el elemento del dropdown
		Select drpDownCtry = new Select(dropdwnEle);
		
		// drpDownCtry.selectByVisibleText("Bahamas");
		// drpDownCtry.selectByValue("3"); ///User solo si el atributo valor es
		// disponible en el tag opcion
		drpDownCtry.selectByIndex(53);

		// Para saber el numero hay una funcion directa
		List<WebElement> opciones = drpDownCtry.getOptions();
		
		System.out.println("Numero total de opciones: " + opciones.size());
		
		//for(WebElement opt: opciones){
		for(int i =0; i<opciones.size(); i++) {
			
			System.out.println(opciones.get(i).getText());
		}

	}
}
