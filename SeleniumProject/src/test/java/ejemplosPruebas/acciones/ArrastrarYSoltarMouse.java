package ejemplosPruebas.acciones;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ArrastrarYSoltarMouse {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		driver.manage().window().maximize();

		Actions acciones = new Actions(driver);

		WebElement roma = driver.findElement(By.id("box6"));
		WebElement italia = driver.findElement(By.id("box106"));

		//Realiza la accion de arrastrar y soltar con los dos elementos capturados
		acciones.dragAndDrop(roma, italia).perform();
		
		WebElement washington = driver.findElement(By.id("box3"));
		WebElement eeuu = driver.findElement(By.id("box103"));
		
		acciones.dragAndDrop(washington,eeuu).perform();

	}

}
