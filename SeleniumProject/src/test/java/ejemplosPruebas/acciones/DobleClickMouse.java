package ejemplosPruebas.acciones;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DobleClickMouse {

	/************ doubleclick(WebElement) ***************/

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.manage().window().maximize();

		// Cambia el frame para obtener foco en frame derecho (checar Manejo de frames)
		driver.switchTo().frame("iframeResult");

		WebElement field1 = driver.findElement(By.xpath("//input[@id='field1']"));
		field1.clear();
		field1.sendKeys("Hola");

		// boton que ejecutara doble clicl
		WebElement buttonEle = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));

		Actions acciones = new Actions(driver);

		// Ejecucion del doble click
		acciones.doubleClick(buttonEle).perform();

		WebElement field2 = driver.findElement(By.xpath("//input[@id='field2']"));
		// String campo2 = field2.getText();
		// Se usa getAttribute porque el texto esta dentro
		// del TAG <input id='abc' value='texto'> como valor
		//
		String campo2 = field2.getAttribute("value");

		System.out.println("Texto copiado es: " + campo2);

		if (campo2.equals("Hola")) {
			System.out.println("Prueba pasa");
		} else {
			System.out.println("Prueba Falla");
		}

		driver.quit();
	}

}
