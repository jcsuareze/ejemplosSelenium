package ejemplosPruebas.acciones;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SliderMouse {

	// Para mover el slider hay que tomar en cuenta el sistema cartesiano (x,y)
	//No es posible mover la ventana del browser con esto

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://jqueryscript.net/demo/Price-Range-Slider-jQuery-UI");
		driver.manage().window().maximize();

		Actions acciones = new Actions(driver);

		//Min Slider
		WebElement minSlider =  driver.findElement(By.xpath("//span[1]"));
		
		//GetLocation() proporcionara el lugar en que se encuentra el elemento
		System.out.println("La ubicacion del elemento  min antes de accion es: " + minSlider.getLocation());
		
		//dragAndDropBy() mueve el elemento usando coordenadas cartesianas
		//Ubicacion actual (59,250)
		acciones.dragAndDropBy(minSlider, 100, 250).perform();
		
		System.out.println("La ubicacion del elemento min despues de accion es: " + minSlider.getLocation());
		
		//Max Slider
		WebElement maxSlider =  driver.findElement(By.xpath("//span[2]"));
		
		System.out.println("La ubicacion del elemento max antes de accion es: " + maxSlider.getLocation());
		acciones.dragAndDropBy(maxSlider, -200, 250).perform();
		System.out.println("La ubicacion del elemento max despues de accion es: " + maxSlider.getLocation());
	}

}
