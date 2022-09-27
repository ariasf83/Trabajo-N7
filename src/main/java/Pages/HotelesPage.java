package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelesPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	//By imputSelectHotelLoc = By.xpath("/html/body/aloha-app-root/aloha-results/div/div/div/div[2]/div[2]/aloha-list-view-container/div[3]/div[1]/aloha-cluster-container/div/div/div[1]/div/div[2]/div[1]");
	@FindBy(xpath = "/html/body/aloha-app-root/aloha-results/div/div/div/div[2]/div[2]/aloha-list-view-container/div[3]/div[1]/aloha-cluster-container/div/div/div[1]/div/div[2]/div[1]") ///---> cerrar cooquies
	WebElement imputSelectHotelLoc;
	
	@FindBy(xpath = "/html/body/aloha-app-root/aloha-results/div/div/div/div[1]/aloha-re-search-container/div/div/div/div/div/div[2]/div[1]/div/h1")
	WebElement ValidarTitulo;
	
	public HotelesPage(WebDriver driver)
	{
		this.driver = driver;
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver , this);
	}
	
	public HotelResultadoPage selecioHotel()
	{
		// WebElement hotelSelect = driver.findElement(imputSelectHotelLoc);
		  wait.until(ExpectedConditions.visibilityOf(imputSelectHotelLoc));
		  imputSelectHotelLoc.click(); //--> selecciono la primera opcion de la busqueda
		  
		  return new HotelResultadoPage(this.driver); //--> encademos coon la pag siguiente
	}
	
	public WebElement returnTitulo() //----> retorna el titulo de la pagina para el assert
	{
		 wait.until(ExpectedConditions.visibilityOf(ValidarTitulo));
		return ValidarTitulo;
	}
}
