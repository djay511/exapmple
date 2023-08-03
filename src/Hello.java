

	import java.util.NoSuchElementException;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.FluentWait;

	import com.google.common.base.Function;

	public class Hello 
	{
		
	  public static void main(String[] args) throws InterruptedException {
		test();
	}
		
		static WebDriver driver=null;
		public static void test() throws InterruptedException
		{
			String projectPath=System.getProperty("user.dir");
			System.out.println("Project path : " +projectPath);
			System.setProperty("webdriver.chrome.driver", projectPath+"\\Driver\\ChromeDriver\\chromedriver.exe"); 
			driver=new ChromeDriver(); 
			
			driver.get("https://www.google.com/");
			driver.findElement(By.id("APjFqb")).sendKeys("abcd");
			Thread.sleep(1000);
			driver.findElement(By.className("gNO89b")).sendKeys(Keys.RETURN);
		Thread.sleep(4000);
			
			//driver.findElement(By.linkText("Trusted Security Automation - Simplify Security")).click();
			
			// Waiting 30 seconds for an element to be present on the page, checking
			   // for its presence once every 5 seconds.
			   FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(30, TimeUnit.SECONDS)
			       .pollingEvery(2, TimeUnit.SECONDS)
			       .ignoring(NoSuchElementException.class);

			   WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver) {
			       WebElement linkelement=driver.findElement(By.linkText("ABCD In the Morning Brush your Teeth ABC SONG | Lingokids"));
				
			       
			       if(linkelement.isEnabled()) 
			       {
			    	   System.out.println("Elemeent found");
			    	  
			       }
			       return linkelement;
			     }
			   });
			   
			   element.click();

			
			Thread.sleep(2000);
			driver.close();
			driver.quit();

	}
	}



