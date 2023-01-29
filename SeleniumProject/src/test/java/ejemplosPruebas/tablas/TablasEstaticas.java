package ejemplosPruebas.tablas;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TablasEstaticas {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://testautomationpractice.blogspot.com");
		driver.manage().window().maximize();

		// Averiguar el numero de filas hay en la tabla
		// 1)Con Xpaths, definir y limitar la tabla
		// Y buscar por los tags <tr>

		List<WebElement> filas = driver.findElements(By.xpath("//table[@name='BookTable']//tr"));

		System.out.println("Numero de filas: " + filas.size());

		// Averiguar el numero de columnas en la tabla
		List<WebElement> cols = driver.findElements(By.xpath("//table[@name='BookTable']//th"));

		System.out.println("Numero de columnas: " + cols.size());

		// Capturar datos de una celda especifica
		WebElement dato = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]"));
		System.out.println(dato.getText());

		// Capturar todos los datos en la tabla

		for (int f = 2; f <= filas.size(); f++) {// La primera fila contiene headers
			for (int c = 1; c <= cols.size(); c++) {

				String valores = driver
						.findElement(By.xpath("//table[@name='BookTable']//tr[" + f + "]//td[" + c + "]")).getText();
				System.out.print(valores + "\t\t\t");
			} // fin de for Col

			System.out.println();

		} // fin de for Fila

		// Imprimir solo los libros del autor Amit
		for (int f = 2; f <= filas.size(); f++) {

			String autor = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + f + "]//td[2]")).getText(); // obtiene
																														// solo
																														// autores

			if (autor.equals("Amit")) {
				String libro = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + f + "]//td[1]"))
						.getText(); // Obtiene solo los libros
				System.out.println(autor + "-" + libro);

			}
		} // fin de for

		// Encontrar la suma de los precios de todos los libros

		int suma = 0;
		for (int f = 2; f <= filas.size(); f++) {

			String precios = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + f + "]//td[4]")).getText(); // Obtiene
			
			suma += Integer.parseInt(precios); // Convierte los String a enteros
		}
		System.out.println("La suma de los precios de los libros es: "+suma);

		driver.quit();
	}
	

}
