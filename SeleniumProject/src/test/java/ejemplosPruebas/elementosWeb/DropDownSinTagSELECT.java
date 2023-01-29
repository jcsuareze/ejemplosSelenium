package ejemplosPruebas.elementosWeb;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownSinTagSELECT {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();

		// hacer click primero en el dropdown para mostrar multiples opciones
		driver.findElement(By.xpath("//button[contains(@class,'multiselect') and @type='button']")).click();

		// Para capturar los datos de todos los elementos del dropdown, UL es comun y
		// label contiene el texto
		List<WebElement> drpdown = driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//label"));

		System.out.println("Numero total de elementos: " + drpdown.size());

		// mostrar todas las opciones del dropdown

		/* 
		for (int i = 0; i < drpdown.size(); i++) {

			 if(drpdown.get(i).getText().equals("Java") || drpdown.get(i).getText().equals("Python")){
				 drpdown.get(i).click();
				
			 }
			//System.out.println(opt.getText());
		
		}// end of for
		*/
		for(WebElement opt: drpdown){
			
			String text = opt.getText();
			if(text.equals("Java")|| text.equals("Python")) {
				opt.click();
			}
		}
		
		driver.quit();

	}

}
