package ejemplosPruebas.screenshots;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CapturaScreenshot {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		/*
		 * // Usando Interface TakesScreenshot, como driver es un objeto de Webdriver //
		 * hay que usar mascara (cast) para ejecutor TakesScreenshot ts =
		 * (TakesScreenshot) driver; //getscreenthot(OutputType<T>) //OutputType.FILE
		 * Captura el screnshot pero no guarda, se debe de guardar en archivo File src =
		 * ts.getScreenshotAs(OutputType.FILE); //Se debe especificar donde se guarda la
		 * copia del screenshot File trg = new File(
		 * "C:\\Users\\suare\\git\\repository2\\SeleniumProject\\screenshots\\paginaEntera.png"
		 * );
		 * 
		 * FileUtils.copyFile(src, trg);
		 */

		// Tomar screenshot de elemento en especifico
		WebElement productos = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));

		productos.getScreenshotAs(OutputType.FILE);
		File src = productos.getScreenshotAs(OutputType.FILE);
		File trg = new File("C:\\Users\\suare\\git\\repository2\\SeleniumProject\\screenshots\\productos.png");
		FileUtils.copyFile(src, trg);
		
		driver.quit();

	}

}
