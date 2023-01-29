package ejemplosPruebas.tablas;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TablasPaginadas {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/admin/");
		driver.manage().window().maximize();

		WebElement userNametxt = driver.findElement(By.id("input-username"));
		userNametxt.clear();
		userNametxt.sendKeys("demo");

		WebElement passwordTxt = driver.findElement(By.id("input-password"));
		passwordTxt.clear();
		passwordTxt.sendKeys("demo");

		driver.findElement(By.xpath("//button[text()=' Login']")).click();

		WebElement btnClose= driver.findElement(By.xpath("//button[@class='btn-close']"));
		if (btnClose.isDisplayed()) {
			btnClose.click();
		}

		// entrando a la seccion Customers
		driver.findElement(By.xpath("//a[@class='parent collapsed'][normalize-space()='Customers']")).click();
		driver.findElement(By.xpath("//ul[@class='collapse show']//a[contains(text(),'Customers')]")).click();

		// Captura el total de paginas
		String text = driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
		// Convierte el texto a entero
		int totalPaginas = Integer.parseInt(text.substring(text.indexOf("(") + 1, text.indexOf("Pages") - 1));
		// Muestra el total de paginas
		System.out.println("Numero total de paginas:" + totalPaginas);

		for (int p = 1; p <= 10; p++) {

			if (totalPaginas > 2) {
				WebElement pagina_activa = driver
						.findElement(By.xpath("//ul[@class='pagination']//li//*[text()=" + p + "]"));
				System.out.println(" Pagina Activa : " + pagina_activa.getText());
				pagina_activa.click();
				// Thread.sleep(2000);
				if (totalPaginas > 1) {
				}
			} // fin de if
		} // fin de for

	}
}
