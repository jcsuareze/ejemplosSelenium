package ejemplosPruebas.popUps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ManejoAlertaAutenticacion {

	public static void main(String[] args) {

		// En este caso hay que enviar el usuario y password en la URL
		// No se puede usar SwitchTo
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// http://admin:admin@URL   se inyectan las credenciales en la URL, No se ven al final
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		driver.manage().window().maximize();

		String getText = driver.findElement(By.xpath("//div[@class='example']//child::p")).getText();
		String actText = "Congratulations! You must have the proper credentials.";

		if (getText.contentEquals(actText)) {
			System.out.print("Prueba pasa");
		} else {
			System.out.println("Prueba falla");
		}

		driver.quit();

	}

}
