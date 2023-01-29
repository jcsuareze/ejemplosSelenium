package ejemplosPruebas.javascript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorInteraccion {

	public static void main(String[] args) {
		/*
		 * JavascriptExecutor es interface metodo executeScript() con el cual podemos
		 * ejecutar scripts de javascript
		 * 
		 * En ocasiones algunos elementos no funcionan como deberian en la pagina Y
		 * obtendremos un "elementInterceptedException" causado por que otro elemento
		 * toma la accion
		 * 
		 * Ejemplo: Exception in thread "main"
		 * org.openqa.selenium.ElementClickInterceptedException: element click
		 * intercepted: Element <input value="Google Search" aria-label="Google Search"
		 * name="btnK" type="submit"> is not clickable at point (596, 368). ther element
		 * would receive the click: <span>...</span>
		 * 
		 * 
		 */

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://testautomationpractice.blogspot.com");
		driver.manage().window().maximize();

		driver.switchTo().frame(0);

		// Usando Interface JavascriptExecutor, como driver es un objeto de Webdriver
		// hay que usar mascara (cast) para ejecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// usando la funcion executeScript() en texto
		WebElement inputTxt = driver.findElement(By.id("RESULT_TextField-1"));
		// el primer argument ejecuta javascript. El segundo parametro es el elemento
		js.executeScript("arguments[0].setAttribute('value','Juan Carlos')", inputTxt);

		// usando la funcion executeScript() en radiobutton
		// WebElement radioBtn =
		// driver.findElement(By.xpath("//label[contains(text(),'male')]"));
		WebElement radioBtn = driver.findElement(By.id("RESULT_RadioButton-7_0"));
		js.executeScript("arguments[0].click()", radioBtn);

		// usando la funcion executeScript() en checkboxes
		WebElement checkBoxBtn = driver.findElement(By.id("RESULT_CheckBox-8_0"));
		js.executeScript("arguments[0].click()", checkBoxBtn);

		// usando la funcion executeScript() en boton
		WebElement submitBtn = driver.findElement(By.id("FSsubmit"));
		js.executeScript("arguments[0].click()", submitBtn);

	}

}
