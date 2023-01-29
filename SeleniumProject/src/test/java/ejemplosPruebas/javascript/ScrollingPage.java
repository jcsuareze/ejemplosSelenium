package ejemplosPruebas.javascript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollingPage {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//Scroll down la pagina  por pixeles y muestra su posicion 
		js.executeScript("window.scrollBy(0,3000)");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		Thread.sleep(1000);
		
		//Scroll down la pagina hasta que el elemento este presente 
		WebElement flag=driver.findElement(By.xpath("//img[@alt='Flag of Mexico']"));
		js.executeScript("arguments[0].scrollIntoView();", flag);
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		Thread.sleep(1000);
		
		//Scroll down hasta el final del documento
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		Thread.sleep(1000);
		// regresa a su posicion inicial 
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		
	}

}
