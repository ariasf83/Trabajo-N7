package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelResultadoPage {
	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "/html/body/aloha-app-root/aloha-detail/div/div[3]/aloha-mosaic-gallery/div/ul/li[1]/aloha-media-picture-container/media-picture/div/div/img")
	WebElement resultadoImagen ;
	
	public HotelResultadoPage(WebDriver driver)
	{
		this.driver = driver;
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver , this);
	}
	
	public WebElement retornoResultado()
	{
		wait.until(ExpectedConditions.visibilityOf(resultadoImagen));
		return resultadoImagen;
	}
}
