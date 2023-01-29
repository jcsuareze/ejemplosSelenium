package ejemplosPruebas.localizadores;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocalizadoresXpathAxes {

	public static void main(String[] args) {

		/** Texto visible* ***/
		/*
		 * //a[text() ='String'] //a[contains(text(),'Str')] //*[contains(text(),'Str')]
		 * //*[stars-with(text(),'Str')]
		 *
		 */

		/****** Localizando elementos cuando parte del texto visible es estatico ***/
		/*
		 * //tagName[]contains
		 * 
		 */

		/******* Multples atributos Xpath ********/
		/*
		 * //input[@name='username'][@placeholder='Username'] //input[@name='username'
		 * and @placeholder='Username'] //input[@name='xyz' or @placeholder='Username']
		 * 
		 */

		/******* Funciones para Xpath *******/
		/*
		 * last() text() starts-with() contains() and or
		 */

		/************ SYNTAXIS XPATH AXES *******************/

		/*
		 * //xpathConocido[@atrib='valor']/AXES::NodoBuscado
		 * 
		 * //input[@id='txtUser']/parent::form //input[@id='txtUser']/child::*
		 * //button[@type='text']/img
		 * 
		 * Ancestor:: Parent:: Following-sibling:: preceding-sibling:: child::
		 * descendant:
		 * 
		 */

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
		driver.manage().window().maximize();

		// Self - Selecciona el nodo actual
		String text = driver.findElement(By.xpath("//a[contains(text(),'NIIT Ltd')]/self::a")).getText();
		System.out.println("Self : " + text); // NIIT Ltd

		// Parent - Selecciona el PARENT del elemento actual (Siempre uno)
		text = driver.findElement(By.xpath("//a[contains(text(),'NIIT Ltd')]/parent::td")).getText();

		System.out.println("Parent : " + text); // NIIT Ltd

		// Child - Selecciona el CHILD del elemento actual (Uno o varios)
		List<WebElement> childs = driver
				.findElements(By.xpath("//a[contains(text(),'NIIT Ltd')]/ancestor::tr/child::td"));
		System.out.println("Numero de child nodos:" + childs.size());// 5

		// Ancestor - Selecciona todos los ANCESTOR (parent, grandparent, etc.)
		text = driver.findElement(By.xpath("//a[contains(text(),'NIIT Ltd')]/ancestor::tr")).getText();
		System.out.println("Ancestor : " + text);

		// Descendant - Selecciona todos los DESCENDANT del elemento actual
		// (children, grandchildren, etc.) 
		List<WebElement> descendants = driver
				.findElements(By.xpath("//a[contains(text(),'NIIT Ltd')]/ancestor::tr/descendant::*"));
		System.out.println("Numero de descendant nodos:" + descendants.size());

		// Following -Selecciona todo en el documento despues del tag de cierre
		List<WebElement> followingnodes = driver
				.findElements(By.xpath("//a[contains(text(),'NIIT Ltd')]/ancestor::tr/following::tr"));
		System.out.println("Numero de following nodos:" + followingnodes.size());

		// Following-sibling : SSelecciona todos los SIBLING del elemento actual
		List<WebElement> followingsiblings = driver
				.findElements(By.xpath("//a[contains(text(),'NIIT Ltd')]/ancestor::tr/following-sibling::tr"));
		System.out.println("Numero de Following-Siblings nodos:" + followingsiblings.size());

		// Preceding - Selecciona todos los nodos que preceding al nodo actual
		List<WebElement> precedings = driver
				.findElements(By.xpath("//a[contains(text(),'NIIT Ltd')]/ancestor::tr/preceding::tr"));
		System.out.println("Numero de preceding nodos:" + precedings.size());

		// preceding-sibling - SSelecciona todos los siblings
		List<WebElement> precedingsiblings = driver
				.findElements(By.xpath("//a[contains(text(),'NIIT Ltd')]/ancestor::tr/preceding-sibling::tr"));
		System.out.println("Numero de preceding-sibling nodos:" + precedingsiblings.size());

		driver.quit();

	}

}
