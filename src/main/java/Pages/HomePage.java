package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	WebDriver driver;
	WebDriverWait wait ;
			
			
	
	//By imputCerrarCoquiesLoc = By.xpath("//*[@id=\"lgpd-banner\"]/div/a[2]/em"); //--> locator para cerrar ventana de cooquies
	@FindBy(xpath = "//*[@id=\"lgpd-banner\"]/div/a[2]/em") ///---> cerrar cooquies
	WebElement imputCerrarCoquiesLoc;
	
	@FindBy(xpath = "/html/body/nav/div[4]/div[1]/i") ///---> cerrar face
	WebElement imputCerrarFaceLoc;
	
	@FindBy(xpath = "//div[@class='sbox5-box-container']/div[3]/div[1]/div/div/div/input") ///---> locator destino , se esta pasando a webelement
	WebElement imputDestLocator;
		
	@FindBy(xpath = "//*[@id=\"searchbox-sbox-box-hotels\"]/div/div/div/div/div[3]/div[2]/div/div[1]/div/div/div/div/input") ///---> cerrar face
	WebElement imputCalenEntradaLoc2; //--> calendario entrada
	
	
	@FindBy(xpath = "//*[@id=\"component-modals\"]/div[1]/div[1]/div[2]/div[1]/div[3]/div[29]/div")
	WebElement imputFechaEntradaLoc; //--> select fecha entrada
	
	 
	 @FindBy(xpath = "//*[@id=\"component-modals\"]/div[1]/div[1]/div[2]/div[1]/div[3]/div[30]/div") 
	 WebElement imputFechaSaliLoc; //--> fecha salida
	 
	 
	 @FindBy(xpath = "//*[@id=\"component-modals\"]/div[1]/div[2]/div[1]/button/em") 
	 WebElement imputAplicarCaleLoc; //--> aplicar calendario
	 
	
	 @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-hotels\"]/div/div/div/div/div[3]/div[3]/div/div") ///---> cerrar cooquies
	 WebElement imputHabitacionesLoc;  //-->habitaciones
	 
	 
	 
	 @FindBy(xpath = "//*[@id=\"component-modals\"]/div[2]/div/div/div[1]/div[2]/div[1]/div[2]/div/button[2]") 
	 WebElement imputSumaAdultoLoc; //--> suma adulto
	 
	
	 @FindBy(xpath = "//*[@id=\"component-modals\"]/div[2]/div/div/div[1]/div[2]/div[2]/div[2]/div/button[2]")
	 WebElement imputSumaMenorLoc; //--> suma menor
	 
	 
	
	 @FindBy(xpath = "//*[@id=\"component-modals\"]/div[2]/div/div/div[1]/div[2]/div[3]/div[2]/div/div/select")
	 WebElement imputSelectEdadMenorLoc; //--> selecciono edad menor
	 
	
	 @FindBy(xpath = "//*[@id=\"component-modals\"]/div[2]/div/div/div[1]/div[2]/div[3]/div[2]/div/div/select/option[10]") 
		WebElement imputSelectOchoAñosLoc; //--> select 8 años
	 
	 
	
	 @FindBy(xpath = "//*[@id=\"component-modals\"]/div[2]/div/div/div[2]/a[1]/em") 
	 WebElement imputSlectAplicarHabitacion;
	 
	
	 @FindBy(xpath = "//*[@id=\"searchbox-sbox-box-hotels\"]/div/div/div/div/div[3]/button") 
	 WebElement imputSelectBuscarLoc;
	 
	 
	public HomePage(WebDriver driver) //--> constructor
	{
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.driver= driver;
		PageFactory.initElements(driver , this);
	}
	
	
	public void cerrarCooquies()
	{
		
		//  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  wait.until(ExpectedConditions.visibilityOf(imputCerrarCoquiesLoc));
		  imputCerrarCoquiesLoc.click(); //--> cierra emergente cooquies
	}
	
	public void cerraFace()
	{
		 
		  wait.until(ExpectedConditions.visibilityOf(imputCerrarFaceLoc));
		  imputCerrarFaceLoc.click(); //-->  cierra emergente face
	}
	
	public void ingresarDestino()
	{
		imputDestLocator.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		imputDestLocator.sendKeys("Mendoza mendoza argentina");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e5) {
			// TODO Auto-generated catch block
			e5.printStackTrace();
		}
		
		imputDestLocator.sendKeys(Keys.ENTER);
		
		 try {
				Thread.sleep(1000);
			} catch (InterruptedException e4) {
				// TODO Auto-generated catch block
				e4.printStackTrace();
			}
	}
	
	public void ingresarFecha()
	{
		imputCalenEntradaLoc2.click(); // hace click en la entrada del calendario
		  
		  
		//  WebElement fechaEntrada = driver.findElement(imputFechaEntradaLoc);
		  wait.until(ExpectedConditions.visibilityOf(imputFechaEntradaLoc));
		  imputFechaEntradaLoc.click(); ///---> click en la fecha de entrada
		  
		  
		 // WebElement fechaSalida = driver.findElement(imputFechaSaliLoc);
		  wait.until(ExpectedConditions.visibilityOf(imputFechaSaliLoc));
		  imputFechaSaliLoc.click(); //--> fecha de salida 
		  
		  
		//  WebElement aplicar = driver.findElement(imputAplicarCaleLoc);
		  wait.until(ExpectedConditions.visibilityOf(imputAplicarCaleLoc));
		  imputAplicarCaleLoc.click();  //--> click en aplicar al calendario
	}
	
	public void ingresarHabitacion()
	{
		// WebElement habitaciones = driver.findElement(imputHabitacionesLoc);
		
		  wait.until(ExpectedConditions.visibilityOf(imputHabitacionesLoc));
		  imputHabitacionesLoc.click();  //---> click para abrir habitaciones
		  
		
		  
		 // WebElement sumaAdulto = driver.findElement(imputSumaAdultoLoc);
		  wait.until(ExpectedConditions.visibilityOf(imputSumaAdultoLoc));
		  imputSumaAdultoLoc.click(); //--> suma 1 adulto
		
		//  WebElement sumaNiño = driver.findElement(imputSumaMenorLoc);
		  wait.until(ExpectedConditions.visibilityOf(imputSumaMenorLoc));
		  imputSumaMenorLoc.click(); //--> suma 1 niño 
		  
		 
		  imputSelectEdadMenorLoc.click(); //--> despliga combo ellecion de edad del menor
		
		  imputSelectOchoAñosLoc.click(); //--> selecciono 8 años
		  
		
		  imputSlectAplicarHabitacion.click(); //--> click en aplicar habitacion
	}
	
	public HotelesPage buscar() //--> metodo tipo homepage
	{
		// WebElement buscar = driver.findElement(imputSelectBuscarLoc);
		  wait.until(ExpectedConditions.visibilityOf(imputSelectBuscarLoc));
		  imputSelectBuscarLoc.click(); //--> click buscar
		  
		  return new HotelesPage(this.driver); //----> devuelve un objeto del tipo hotelesPage , para hacer el encadenamiento entra las paginas/clases
	}
}
