package RadioButton;

import java.awt.Desktop.Action;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {

    WebDriver driver = new ChromeDriver();
    String TheURL = "https://codenboxautomationlab.com/practice/";
      @BeforeTest 
    public void MyTestSetUp() {
        driver.get(TheURL);
        driver.manage().window().maximize();
        
    }

    @Test (enabled = false)
    public void RadioButtonTest() {
        MyTestSetUp(); // 
        WebElement ContinerRadioButton = driver.findElement(By.xpath("//label[normalize-space()=\"Radio1\"]"));
        
        ContinerRadioButton.findElements(By.tagName("input")).get(0).click(); 
    }
    @Test (enabled = false)
    public void Dynamic_Dropdown_Example() throws InterruptedException {
    	
    	String Cuontries [] = {"Jor","Sys","Ira"};
    	
    	WebElement CountryInput = driver.findElement(By.id("autocomplete"));
    	CountryInput.sendKeys(Cuontries[0]);
    	Thread.sleep(1000);
    	CountryInput.sendKeys(Keys.chord(Keys.ARROW_DOWN,Keys.ENTER));
    	
    }
    @Test(enabled = false)
    public void SelectTag()  {
    	
    	WebElement MySelectTag = driver.findElement(By.id("dropdown-class-example"));
    	
    	Select MyTest = new Select(MySelectTag);
    	
    	MyTest.selectByIndex(2);
    	
    	//MyTest.selectByValue("option3");
    	//MyTest.selectByVisibleText("API");
    	
    }
    @Test(enabled = false)
    public void ChechBox() {  
    	WebElement CheckBoxContiner = driver.findElement(By.xpath("//div[@id=\"checkbox-example\"]//fieldset"));
    	List<WebElement> AllChechBoxes= (List<WebElement>) CheckBoxContiner .findElements(By.tagName("input"));
    	
    	for(int i=0 ;i < AllChechBoxes.size() ;i++ ) {
    		
    		AllChechBoxes.get(i).click();
    		
    		
    	}
    }
    @Test(enabled = false)
    public void SwitchWindowExample() throws InterruptedException {
    	
    	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,700)");
		Thread.sleep(1000);
		WebElement Navigation = driver.findElement(By.id("openwindow"));
		Navigation.click();
		
		System.out.println(driver.getTitle());
		
		Set<String> handles = driver.getWindowHandles();
		List<String> AllTabs = new ArrayList <String>(handles);
		driver.switchTo().window (AllTabs.get(1));
		
		WebElement SecondWindow = driver.findElement(By.xpath("//li[@id=\"menu-item-9680\"]//a"));
		SecondWindow.click();
		driver.switchTo().window (AllTabs.get(0));
		System.out.println(driver.getTitle());
    }
    @Test(enabled = false)
    public void Open_Tab() throws InterruptedException {
    	
    	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,700)");
		Thread.sleep(1000);
		WebElement Navigation = driver.findElement(By.id("opentab"));
		Navigation.click();
		
		System.out.println(driver.getTitle());
		
		Set<String> handles = driver.getWindowHandles();
		List<String> AllTabs = new ArrayList <String>(handles);
		driver.switchTo().window (AllTabs.get(1));
		Thread.sleep(2000);
		
		
		
		System.out.println(driver.getTitle());
    }
    @Test(enabled = false)
    public void SwitchToAlertExample() throws InterruptedException {
    	
    	WebElement EnterYourName = driver.findElement(By.id("name"));
    	WebElement AlartButton = driver.findElement(By.xpath("//input[@id=\"alertbtn\"]"));
    	
    	EnterYourName.sendKeys("TayseerAlhamad");
    	Thread.sleep(2000);
    	AlartButton.click();
    	Thread.sleep(2000);
    	driver.switchTo().alert().accept();
    }
    @Test(enabled = false)
    public void TheTable() {
    	//Look at the i = 2 ,
    	WebElement TheTable = driver.findElement(By.id("product"));
    	
    	List<WebElement> AllData =  TheTable.findElements(By.tagName("td"));
    	
    	for(int i=2;i < AllData.size();i=i+3){
    		
    		System.out.println(AllData.get(i).getText());
    	}
    }
    @Test(enabled = false)
    public void ElementDisplayedExample() throws InterruptedException {
    	
    	WebElement TheElementWeNeedToHide = driver.findElement(By.id("displayed-text"));
    	
    	WebElement Hide = driver.findElement(By.id("hide-textbox"));
    	Hide.click();
    	
    	
    	System.out.println(TheElementWeNeedToHide.isDisplayed());
    	Thread.sleep(2000);
    	WebElement Show = driver.findElement(By.id("show-textbox"));
    	Show.click();
    	System.out.println(Show.isDisplayed());
    	
    	
    }
    @Test(enabled = false)
    public void EnabledDisabledExample(){
    	
    	WebElement DisableButton = driver.findElement(By.id("disabled-button"));
    	WebElement InputFiled = driver.findElement(By.id("enabled-example-input"));
    	DisableButton.click();
    	System.out.println(InputFiled.isEnabled());
    	
    	WebElement EnableButton = driver.findElement(By.id("enabled-button"));
    	EnableButton.click();
    	System.out.println(InputFiled.isEnabled());
    	
    	
    }
    @Test(enabled = false)
    public void MouseHoverExample() throws InterruptedException {
        WebElement MouseHover = driver.findElement(By.id("mousehover"));
        
        Actions action = new Actions(driver);
        
        action.moveToElement(MouseHover).build().perform();
        
        //WebElement TopButton = driver.findElement(By.linkText("Top"));
        
        WebElement ReloadButton = driver.findElement(By.linkText("Top"));
        
        Thread.sleep(2000);
        ReloadButton.click();
        //TopButton.click();
        
        
    }
    @Test
    public void CalendarExample() throws InterruptedException {
        WebElement Calender = driver.findElement(By.linkText("Booking Calendar"));
        Calender.click();
        
        // انتظر حتى تفتح النافذة الجديدة
        Set<String> handles = driver.getWindowHandles();
        List<String> AllTabs = new ArrayList<>(handles);
        
        // التبديل إلى النافذة الجديدة
        driver.switchTo().window(AllTabs.get(1));
        
        // انتظر قليلاً حتى يظهر اليوم
        Thread.sleep(2000);
        
        // اضغط على اليوم 25
        WebElement NumberTest = driver.findElement(By.xpath("//a[normalize-space()='25']"));
        NumberTest.click();
        
    }



}

