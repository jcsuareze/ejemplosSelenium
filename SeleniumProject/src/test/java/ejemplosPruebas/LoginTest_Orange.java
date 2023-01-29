package ejemplosPruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LoginTest_Orange {

	public static void main(String[] args) throws InterruptedException {

		// 1) Abrir el web browser
		// System.setProperty("webdriver.chrome.driver",
		// "C://DriversVarios//chromedriver_win32//chromedriver.exe");
		// WebDriverManager.chromedriver().setup();
		// Metodos que ya no se usan en las ultimas versiones siempre y cuando se use
		// Maven y el POM.xml

		// Unicamente es necesario instanciar un objeto driver de ChromeDriver
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		// 2)Abrir la URL
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(1000);
		// 3) Interactuar
		/*
		 * WebElement userNameTxt = driver.findElement(By.name("username"));
		 * userNameTxt.sendKeys("Admin");
		 */

		driver.findElement(By.name("username")).sendKeys("Admin"); // Interactua con el webElement y envia texto

		driver.findElement(By.name("password")).sendKeys("admin123");

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		/*
		 * Verificacion de titulo ( funciona pero manda falso positivo ) String String
		 * title = "OrangeHRM"; getPageTitle = driver.getTitle();// Captura el titulo de
		 * la pagina
		 * 
		 * if (getPageTitle.equals(title)) {
		 * 
		 * System.out.println("Test pasa"); } else { System.out.println("Test Falla"); }
		 */

		// Validacion por Label despues de un login exitoso
		// //*[@id="app"]/div[1]/div[1]/header/div[1]/div[1]/span/h6

		Thread.sleep(2000);

		String labelTxt = "";
		try {
			labelTxt = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6"))
					.getText();

		} catch (NoSuchElementException e) {

			// e.printStackTrace();
		}

		String labelExp = "Dashboard";

		if (labelTxt.equals(labelExp)) {

			System.out.println("Test pasa");
		} else {
			System.out.println("Test Falla");
		}

		// driver.close(); // Cierra el navegador
		driver.quit(); // Cierra sesion

	}
}