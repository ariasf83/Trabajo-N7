package Test;

import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.HotelResultadoPage;
import Pages.HotelesPage;
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
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;

public class PageAlojamiento extends HotelBase {
	
	private WebDriver driver = null;
	HomePage pageHome ;
	
	
	/*//By imputCerrarCoquiesLoc = By.xpath("//*[@id=\"lgpd-banner\"]/div/a[2]/em"); //--> locator para cerrar ventana de cooquies
	 * 
	 */
	By imputCerrarFaceLoc = By.xpath("/html/body/nav/div[4]/div[1]/i"); //--> locator para cerrar ventana de facebook
	By imputDestLocator = By.xpath("//div[@class='sbox5-box-container']/div[3]/div[1]/div/div/div/input"); //--> locator destino	
	By imputCalenEntradaLoc2 = By.xpath("//*[@id=\"searchbox-sbox-box-hotels\"]/div/div/div/div/div[3]/div[2]/div/div[1]/div/div/div/div/input");
	By imputFechaEntradaLoc = By.xpath("//*[@id=\"component-modals\"]/div[1]/div[1]/div[2]/div[1]/div[3]/div[29]/div");
    By imputFechaSaliLoc = By.xpath("//*[@id=\"component-modals\"]/div[1]/div[1]/div[2]/div[1]/div[3]/div[30]/div");	  
  //  By imputAplicarCaleLoc = By.xpath("//*[@id=\"component-modals\"]/div[1]/div[2]/div[1]/button/em");
   // By imputHabitacionesLoc = By.xpath("//*[@id=\"searchbox-sbox-box-hotels\"]/div/div/div/div/div[3]/div[3]/div/div");	 
 //	By imputSumaAdultoLoc = By.xpath("//*[@id=\"component-modals\"]/div[2]/div/div/div[1]/div[2]/div[1]/div[2]/div/button[2]");
 //	By imputSumaMenorLoc = By.xpath("//*[@id=\"component-modals\"]/div[2]/div/div/div[1]/div[2]/div[2]/div[2]/div/button[2]"); 
 //	By imputSelectEdadMenorLoc = By.xpath("//*[@id=\"component-modals\"]/div[2]/div/div/div[1]/div[2]/div[3]/div[2]/div/div/select");
 //	By imputSelectOchoAñosLoc = By.xpath("//*[@id=\"component-modals\"]/div[2]/div/div/div[1]/div[2]/div[3]/div[2]/div/div/select/option[10]");  	
 //	By imputSlectAplicarHabitacion = By.xpath("//*[@id=\"component-modals\"]/div[2]/div/div/div[2]/a[1]/em"); 	
 //	By imputSelectBuscarLoc = By.xpath("//*[@id=\"searchbox-sbox-box-hotels\"]/div/div/div/div/div[3]/button"); //--> buscar  */
 	By ValidaTituloLoc = By.xpath("/html/body/aloha-app-root/aloha-detail/div/aloha-re-search-container/aloha-re-search/div/div[1]/div/ul/li[2]/span/span"); //--> valida ttitulo
 	By imputSelectHotelLoc = By.xpath("/html/body/aloha-app-root/aloha-results/div/div/div/div[2]/div[2]/aloha-list-view-container/div[3]/div[1]/aloha-cluster-container/div/div/div[1]/div/div[2]/div[1]");
	
 	
 	
 
  @BeforeMethod 
  public void beforeMethod(ITestContext context)  {
	  
	 
	  String navegadorSuite = context.getCurrentXmlTest().getParameter("Browser");
	  String Navegador = navegadorSuite != null ? navegadorSuite: "CHROME";
	  String url = "http://www.despegar.com.ar/hoteles"; 
	  
	  driver = HotelBase.DriverConection(Navegador,url);
	  
	  pageHome = new HomePage(driver); //---> instancia de la clse
	 
  } 
  
  
  @Test
  public void f() {
	  
	  pageHome.cerrarCooquies(); //--> llama al metodo de la clase HomePage
	  
	  pageHome.cerraFace();
	  
	  pageHome.ingresarDestino();
	  
	  pageHome.ingresarFecha();
	  
	  pageHome.ingresarHabitacion();
	  
	   HotelesPage paginaHoteles = pageHome.buscar(); //--> creo variable de tipo hotelesPages
	   
	   Assert.assertTrue(paginaHoteles.returnTitulo().isDisplayed(),"El titulo no esta disponible "); //--> assert del titulo
	   
	  // paginaHoteles.selecioHotel();
	   
	   HotelResultadoPage resultaPages = paginaHoteles.selecioHotel();
	   
	   Set <String> handles = driver.getWindowHandles();
		for (String actual : handles) {
			if(!actual.equalsIgnoreCase(driver.getWindowHandle())) {
				driver.switchTo().window(actual);
			
			}
		}
	   
	   Assert.assertTrue(resultaPages.retornoResultado().isDisplayed(),"La imagen no esta disponible ");
	/*
	  
// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //--> instancio el wait
	  
	  
	  
	
	 	  
	
	
	

	 
	 
	  
		
	  
	
	  
     
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
	  
	  */
  }
 
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
