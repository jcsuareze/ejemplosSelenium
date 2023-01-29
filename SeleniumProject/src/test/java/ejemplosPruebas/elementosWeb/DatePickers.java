package ejemplosPruebas.elementosWeb;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickers {

	public static void main(String[] args) {

		/*
		 * Los DatePickers regularmente son personalizados, por lo tanto seran
		 * diferentes Y la logica no siempre sera la misma
		 * 
		 * Existen elementos standard como: 1)Tabla que muestra fechas 2)Botones de
		 * navegacion 3)Etiqueta de mes y año
		 */

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();

		// el datepicker esta dentro de un frame ( verificar uso de frames)
		driver.switchTo().frame(0);

		// Approach 1
		// Dentro del Textbox vacio del datepicker, enviar la fecha como texto
		//driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("11/04/2019");

		// Approach 2

		String anio = "2027";
		String mes = "November";
		String dia = "15";
		// Hacer click en el date picker abrira la tabla con las fechas
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		
		
		//Para recorrer los meses y año
		String getMes = null;
		String getAnio = null;
		
		
		/****Ciclo while que se puede mejorar****/
		while(true) {
			
			 getMes = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			 getAnio = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			//Hace click en el boton ADELANTE hasta que encuentre el mes y año
			 
			 if(mes.equals(getMes)&&anio.equals(getAnio)) {
				 break;
			 }
			 //Boton NEXT para fechas futuras
			 driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			 //Boton BEFORE para fechas pasadas
			// driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
		}// fin de While
				

		// Seleccionar la fecha iniciando con la fila, despues columna ( checar manejo
		// tablas)
		// Al seleccionar, buscar por la tabla
		List<WebElement> fechasAll = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));

		for (WebElement fecha : fechasAll) {

			if(fecha.getText().equals(dia)) {
				fecha.click();
			}
		}// fin de for

		
	}

}
