package testsHotel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

public class HotelBase {
	
	
	private enum browsers{
		CHROME, FIREFOX
	}
	
	public static WebDriver DriverConection(String browserName, String url) //--> metodo para eleccion del navegador
	{
		WebDriver driver = null ;
		
		switch(browsers.valueOf(browserName)) {
		case CHROME:{
			System.setProperty("webdriver.chrome.driver","C:\\WebDrivers/chromedriver.exe");
			System.out.println("Se inicia Chrome");
			driver = new ChromeDriver();
			break;
		}
		case FIREFOX:{
			System.setProperty("webdriver.gecko.driver","C:\\WebDrivers\\geckodriver-v0.31.0-win64/geckodriver.exe");
			System.out.println("Se inicia firefox");
			driver = new FirefoxDriver();
			break;
	    }
		default:{
			
			System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers/chromedriver.exe");
			System.out.println("Se inicia chrome");
			driver = new ChromeDriver();
			break;
		}
	}
	driver.manage().window().maximize();
	driver.get(url);
	return driver;
	}
	
	
	
	
		////////////////////////////////////////////////////////////////////////////////////////////////
	
	/*	private WebDriver driver;
		
		public void BaseAlojamientos(WebDriver driver) //--> constructor
		{
			this.driver = driver;
		}
		
		public static WebDriver DriverConection() //--> metodo para la conexion con chrome
		{
			WebDriver driver = null ;
			
			System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers/chromedriver.exe");  // ubicacion del webdriver
			driver = new ChromeDriver(); // creo objeto webdriver
			
			
			//System.setProperty("webdriver.gecko.driver", "C:\\WebDrivers\\geckodriver-v0.31.0-win64/geckodriver.exe");			
			//driver = new FirefoxDriver();
			
			//System.setProperty("webdriver.edge.driver", "C:\\WebDrivers/IEDriverServer.exe");  // ubicacion del webdriver
			//driver = new EdgeDriver();
			
			driver.manage().window().maximize(); // maximiza la ventana
			driver.get("http://www.despegar.com.ar/hoteles");
			return driver;
		} */
		
        
		
	

}
