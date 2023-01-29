package ejemplosPruebas.popUps;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ManejoAlertaTexto {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();

		Alert ventanaAlerta = driver.switchTo().alert();

		System.out.println(ventanaAlerta.getText());
		ventanaAlerta.sendKeys("Bienvenido");
		ventanaAlerta.accept();

		// validacion
		String getText = driver.findElement(By.xpath("//p[@id='result']")).getText();
		String expText = "You entered: Bienvenido";
		
		if(getText.contentEquals(expText)) {
			
			System.out.println("Prueba pasa");
		}else
			System.out.println("Prueba falla");
		
		driver.quit();

	}

}
