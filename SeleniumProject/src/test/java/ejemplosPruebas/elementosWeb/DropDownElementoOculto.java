package ejemplosPruebas.elementosWeb;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownElementoOculto {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();

		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

		// driver.switchTo().frame((WebElement)
		// By.xpath("//div[@class='oxd-sidepanel-body']"));

		driver.findElement(By.xpath("//a[@href='/web/index.php/pim/viewPimModule']")).click();

		// Abre el dropdown que hasta hacer click tenia elementos ocultos
		driver.findElement(By.xpath("//div[6]//div[1]//div[2]//div[1]//div[1]//div[2]")).click();

		// Manualmente hay que hacer click para mostrar lista de opciones (en este caso)
		// div role="listbox" class="oxd-select-dropdown --position-botton" loading
		// ="false"
		// capturar este Xpath dentro del tag span

		List<WebElement> opcionesEmpleado = driver.findElements(By.xpath("//div[@role='listbox']//span"));

		for (WebElement opcEmpleado : opcionesEmpleado) {

			// Se obtiene la lista de elementos ocultos
			System.out.println(opcEmpleado.getText());

			if (opcEmpleado.getText().equals("QA Engineer")) {
				opcEmpleado.click();
				break;
			}
		}

	}

}
