package ejemplosPruebas.links;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinksRotos {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();

		List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println("Numero total de links " + links.size());

		int numeroLinksRotos = 0;

		// Si un link esta roto, no entra contenido dentro del atributo href
		for (WebElement allLinks : links) {

			String valorAtribHref = allLinks.getAttribute("href");
			
			System.out.println(valorAtribHref);
			if (valorAtribHref==null || valorAtribHref.isEmpty() ) {

				System.out.println("Vacio");
			}

		}
	}
}
