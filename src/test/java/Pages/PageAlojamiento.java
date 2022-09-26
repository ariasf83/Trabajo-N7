package Pages;

import org.testng.annotations.Test;

import testsHotel.HotelBase;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;

public class PageAlojamiento extends HotelBase {
	
	private WebDriver driver = null;
	
	By imputCerrarCoquiesLoc = By.xpath("//*[@id=\"lgpd-banner\"]/div/a[2]/em"); //--> locator para cerrar ventana de cooquies
	By imputCerrarFaceLoc = By.xpath("/html/body/nav/div[4]/div[1]/i"); //--> locator para cerrar ventana de facebook
	By imputDestLocator = By.xpath("//div[@class='sbox5-box-container']/div[3]/div[1]/div/div/div/input"); //--> locator destino	
	By imputCalenEntradaLoc2 = By.xpath("//*[@id=\"searchbox-sbox-box-hotels\"]/div/div/div/div/div[3]/div[2]/div/div[1]/div/div/div/div/input");
	By imputFechaEntradaLoc = By.xpath("//*[@id=\"component-modals\"]/div[1]/div[1]/div[2]/div[1]/div[3]/div[29]/div");
    By imputFechaSaliLoc = By.xpath("//*[@id=\"component-modals\"]/div[1]/div[1]/div[2]/div[1]/div[3]/div[30]/div");	  
    By imputAplicarCaleLoc = By.xpath("//*[@id=\"component-modals\"]/div[1]/div[2]/div[1]/button/em");
    By imputHabitacionesLoc = By.xpath("//*[@id=\"searchbox-sbox-box-hotels\"]/div/div/div/div/div[3]/div[3]/div/div");	 
 	By imputSumaAdultoLoc = By.xpath("//*[@id=\"component-modals\"]/div[2]/div/div/div[1]/div[2]/div[1]/div[2]/div/button[2]");
 	By imputSumaMenorLoc = By.xpath("//*[@id=\"component-modals\"]/div[2]/div/div/div[1]/div[2]/div[2]/div[2]/div/button[2]"); 
 	By imputSelectEdadMenorLoc = By.xpath("//*[@id=\"component-modals\"]/div[2]/div/div/div[1]/div[2]/div[3]/div[2]/div/div/select");
 	By imputSelectOchoAñosLoc = By.xpath("//*[@id=\"component-modals\"]/div[2]/div/div/div[1]/div[2]/div[3]/div[2]/div/div/select/option[10]");  	
 	By imputSlectAplicarHabitacion = By.xpath("//*[@id=\"component-modals\"]/div[2]/div/div/div[2]/a[1]/em"); 	
 	By imputSelectBuscarLoc = By.xpath("//*[@id=\"searchbox-sbox-box-hotels\"]/div/div/div/div/div[3]/button"); //--> buscar
 	By ValidaTituloLoc = By.xpath("/html/body/aloha-app-root/aloha-detail/div/aloha-re-search-container/aloha-re-search/div/div[1]/div/ul/li[2]/span/span"); //--> valida ttitulo
 	By imputSelectHotelLoc = By.xpath("/html/body/aloha-app-root/aloha-results/div/div/div/div[2]/div[2]/aloha-list-view-container/div[3]/div[1]/aloha-cluster-container/div/div/div[1]/div/div[2]/div[1]");
	
 	
 	
 
  @BeforeMethod 
  public void beforeMethod(ITestContext context)  {
	  
	 /* System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers/chromedriver.exe");  // ubicacion del webdriver
	  driver = new ChromeDriver(); // creo objeto webdriver
	  driver.manage().window().maximize(); // maximiza la ventana
	  driver.get("http://www.despegar.com.ar/hoteles"); */
	  
	  String navegadorSuite = context.getCurrentXmlTest().getParameter("Browser");
	  String Navegador = navegadorSuite != null ? navegadorSuite: "CHROME";
	  String url = "http://www.despegar.com.ar/hoteles"; 
	  
	  driver = HotelBase.DriverConection(Navegador,url);
	 
  } 
  
  
  @Test
  public void f() {
	  
 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //--> instancio el wait
	  
	  
	  
	  WebElement cooquies = driver.findElement(imputCerrarCoquiesLoc);
	  wait.until(ExpectedConditions.visibilityOf(cooquies));
	  cooquies.click(); //--> cierra emergente cooquies
	 	  
	  WebElement face =  driver.findElement(imputCerrarFaceLoc);
	  wait.until(ExpectedConditions.visibilityOf(face));
	  face.click(); //-->  cierra emergente face
	
	  driver.findElement(imputDestLocator).click(); // clickeamos para ingresar el destino
	  	 
	  try {
		Thread.sleep(2000);
	} catch (InterruptedException e5) {
		// TODO Auto-generated catch block
		e5.printStackTrace();
	}
	  
	  //WebElement ingDestino = driver.findElement(imputDestLocator);  
	  //ingDestino.sendKeys("Mendoza mendoza argentina"); // sendkeys envia texto con el destino 
	  driver.findElement(imputDestLocator).sendKeys("Mendoza mendoza argentina"); // sendkeys envia texto con el destino	
	  
	  try {
			Thread.sleep(2000);
		} catch (InterruptedException e5) {
			// TODO Auto-generated catch block
			e5.printStackTrace();
		}
	  
	  driver.findElement(imputDestLocator).sendKeys(Keys.ENTER); // hacemos click enter
	  	 
	  try {
		Thread.sleep(2000);
	} catch (InterruptedException e4) {
		// TODO Auto-generated catch block
		e4.printStackTrace();
	}
	  driver.findElement(imputCalenEntradaLoc2).click(); // hace click en la entrada del calendario
	  
	  
	  WebElement fechaEntrada = driver.findElement(imputFechaEntradaLoc);
	  wait.until(ExpectedConditions.visibilityOf(fechaEntrada));
	  fechaEntrada.click(); ///---> click en la fecha de entrada
	  
	  
	  WebElement fechaSalida = driver.findElement(imputFechaSaliLoc);
	  wait.until(ExpectedConditions.visibilityOf(fechaSalida));
	  fechaSalida.click(); //--> fecha de salida 
	  
	  
	  WebElement aplicar = driver.findElement(imputAplicarCaleLoc);
	  wait.until(ExpectedConditions.visibilityOf(aplicar));
	  aplicar.click();  //--> click en aplicar al calendario
	 
	  
	  WebElement habitaciones = driver.findElement(imputHabitacionesLoc);
	  wait.until(ExpectedConditions.visibilityOf(habitaciones));
	  habitaciones.click();  //---> click para abrir habitaciones
	  
	
	  
	  WebElement sumaAdulto = driver.findElement(imputSumaAdultoLoc);
	  wait.until(ExpectedConditions.visibilityOf(sumaAdulto));
	  sumaAdulto.click(); //--> suma 1 adulto
	
	  WebElement sumaNiño = driver.findElement(imputSumaMenorLoc);
	  wait.until(ExpectedConditions.visibilityOf(sumaNiño));
	  sumaNiño.click(); //--> suma 1 niño 
	  
	 
	  driver.findElement(imputSelectEdadMenorLoc).click(); //--> despliga combo ellecion de edad del menor
	
	  driver.findElement(imputSelectOchoAñosLoc).click(); //--> selecciono 8 años
	  
	
	  driver.findElement(imputSlectAplicarHabitacion).click(); //--> click en aplicar habitacion
	
	  
	  WebElement buscar = driver.findElement(imputSelectBuscarLoc);
	  wait.until(ExpectedConditions.visibilityOf(buscar));
	  driver.findElement(imputSelectBuscarLoc).click(); //--> click buscar
	  
     
	  WebElement hotelSelect = driver.findElement(imputSelectHotelLoc);
	  wait.until(ExpectedConditions.visibilityOf(hotelSelect));
	  hotelSelect.click(); //--> selecciono la primera opcion de la busqueda
	  
	  try {
		Thread.sleep(5000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	  
	// Assert.assertTrue(driver.findElement(ValidaTituloLoc).isDisplayed()); //--> validacion de titulo pag 3
      
   
   
  //--- cambio de foco ---//
	  
	  Set <String> handles = driver.getWindowHandles();
		for (String actual : handles) {
			if(!actual.equalsIgnoreCase(driver.getWindowHandle())) {
				driver.switchTo().window(actual);
			
			}
		}
		
		
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
