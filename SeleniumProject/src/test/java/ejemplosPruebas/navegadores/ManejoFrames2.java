package ejemplosPruebas.navegadores;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ManejoFrames2 {
	
	/**********el tag frameset contiene varios frames dentro*/

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		// tip; usar los tags frame para localizarlo y cambiar a frame
		WebElement frm1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(frm1);
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("11111");
		
		driver.switchTo().defaultContent();
		
		//cambiando a frame 3
		WebElement frm3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frm3);
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("33333");
		
		/*******     ENTRANDO A LOS FRAMES INTERIORES    ******/
			
		//frame interior
		driver.switchTo().frame(0);
		
		driver.findElement(By.cssSelector("div.AB7Lab")).click();
		
		driver.switchTo().defaultContent();
		

	}

}
