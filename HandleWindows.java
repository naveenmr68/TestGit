package MyTestPackage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleWindows {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.manage().window().maximize();
		
//		//getWindowHandle method --1
//		
//		
//		String  windowID =driver.getWindowHandle();
//		
//		System.out.println("Window id : " +windowID);
		
		//getWindowHandles method --2
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();

		// Now u can get both parent window id and child window id
		
		Set <String> windowIDs=driver.getWindowHandles(); // return IDs of multiple browser windows
		
		// wecan retrive the windowIDs by using Two methods
		
		//First Method is : Iterartor()
		
//		Iterator <String> it= windowIDs.iterator();
//		
//		  String parentWindow=it.next();
//		  String childWindow=it.next();
//		  
//		  System.out.println("Parent windowID :"+parentWindow );
//		  System.out.println("Child windowID :"+childWindow );
		  
		//Second Method is : List/ArrayList
		  
		  List <String> windowIDsList=new ArrayList(windowIDs);
				  
//				String  parentWindowtID=windowIDsList.get(0);
//		        String  childWindowID=windowIDsList.get(1);
		        
//				  System.out.println("Parent windowID :"+parentWindowtID);
//				  System.out.println("Child windowID :"+childWindowID);
//		        
		  //using foreach loop we can retrive the window ids
		  //OrangeHRM
		 // Human Resources Management Software | OrangeHRM
		  
		  
		  for(String WIDs:windowIDsList)
			  
		  {
			 String tittle= driver.switchTo().window(WIDs).getTitle();
//			 
//			 System.out.println(tittle);
			  
			  if(tittle.equals("OrangeHRM"))  // if you want close specific browser us this cindition
			  {
				  driver.close();
			  }
		  }
				  
	}

}
