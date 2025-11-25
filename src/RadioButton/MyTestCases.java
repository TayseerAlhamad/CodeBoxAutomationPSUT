package RadioButton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mysql.cj.protocol.Resultset;

public class MyTestCases {

    WebDriver driver = new ChromeDriver();
    String TheURL = "https://codenboxautomationlab.com/practice/";
    Connection con;
    java.sql.Statement stmt;

    ResultSet st;
    String FirstName;
    String LastName;
   Random rand = new Random();
    String Phone;
    String CompanyName;
   Resultset rs;
    int randomId ; 
    @BeforeTest
    public void MyTestSetUp() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","123456");
        driver.get(TheURL);
        driver.manage().window().maximize();
    }

    @Test(enabled = false)
    public void RadioButtonTest() throws SQLException {
        WebElement ContinerRadioButton = driver.findElement(By.xpath("//label[normalize-space()='Radio1']"));
        ContinerRadioButton.findElements(By.tagName("input")).get(0).click();
    }

    @Test(enabled = false)
    public void Dynamic_Dropdown_Example() throws InterruptedException {
        String Cuontries[] = {"Jor","Sys","Ira"};
        WebElement CountryInput = driver.findElement(By.id("autocomplete"));
        CountryInput.sendKeys(Cuontries[0]);
        Thread.sleep(1000);
        CountryInput.sendKeys(Keys.chord(Keys.ARROW_DOWN,Keys.ENTER));
    }

    @Test(enabled = false)
    public void SelectTag() {
        WebElement MySelectTag = driver.findElement(By.id("dropdown-class-example"));
        Select MyTest = new Select(MySelectTag);
        MyTest.selectByIndex(2);
    }

    @Test(enabled = false)
    public void ChechBox() {
        WebElement CheckBoxContiner = driver.findElement(By.xpath("//div[@id='checkbox-example']//fieldset"));
        List<WebElement> AllChechBoxes = CheckBoxContiner.findElements(By.tagName("input"));
        for (WebElement cb : AllChechBoxes) {
            cb.click();
        }
    }

    @Test(enabled = false)
    public void SwitchWindowExample() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,700)");
        Thread.sleep(1000);
        WebElement Navigation = driver.findElement(By.id("openwindow"));
        Navigation.click();

        Set<String> handles = driver.getWindowHandles();
        List<String> AllTabs = new ArrayList<>(handles);
        driver.switchTo().window(AllTabs.get(1));

        WebElement SecondWindow = driver.findElement(By.xpath("//li[@id='menu-item-9680']//a"));
        SecondWindow.click();
        driver.switchTo().window(AllTabs.get(0));
    }

    @Test(enabled = false)
    public void Open_Tab() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,700)");
        Thread.sleep(1000);
        WebElement Navigation = driver.findElement(By.id("opentab"));
        Navigation.click();

        Set<String> handles = driver.getWindowHandles();
        List<String> AllTabs = new ArrayList<>(handles);
        driver.switchTo().window(AllTabs.get(1));
        Thread.sleep(2000);
    }

    @Test(enabled = false)
    public void SwitchToAlertExample() throws InterruptedException {
        WebElement EnterYourName = driver.findElement(By.id("name"));
        WebElement AlartButton = driver.findElement(By.xpath("//input[@id='alertbtn']"));
        EnterYourName.sendKeys("TayseerAlhamad");
        Thread.sleep(2000);
        AlartButton.click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
    }

    @Test(enabled = false)
    public void TheTable() {
        WebElement TheTable = driver.findElement(By.id("product"));
        List<WebElement> AllData =  TheTable.findElements(By.tagName("td"));
        for(int i = 2; i < AllData.size(); i = i + 3){
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
    public void EnabledDisabledExample() {
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
        WebElement ReloadButton = driver.findElement(By.linkText("Top"));
        Thread.sleep(2000);
        ReloadButton.click();
    }

    
    @Test(priority = 1)
    public void AddToData() throws SQLException {

        int randomId = rand.nextInt(5353, 6010);

        String QueryToAddData =
                "INSERT INTO customers (" +
                "customerNumber, " +
                "customerName, " +
                "contactLastName, " +
                "contactFirstName, " +
                "phone, " +
                "addressLine1, " +
                "city, " +
                "country, " +
                "salesRepEmployeeNumber, " +
                "creditLimit" +
                ") VALUES (" +
                randomId + ", " +
                "'Test Company', " +
                "'Smith', " +
                "'John', " +
                "'+1 202 555 0123', " +
                "'123 Test Street', " +
                "'Amman', " +
                "'Jordan', " +
                "1370, " +
                "50000.00" +
                ");";

        stmt = con.createStatement();
        int RowInserted = stmt.executeUpdate(QueryToAddData);

        System.out.println(RowInserted);
    }

    @Test(priority = 2)
    public void UpdateCustomerData() throws SQLException {

        String QueryToUpdate =
                "UPDATE customers SET " +
                "contactFirstName = 'tayseer', " +
                "contactLastName = 'alhamad' " +
                "WHERE customerNumber = " + randomId + ";";

        stmt = con.createStatement();
        int RowsUpdated = stmt.executeUpdate(QueryToUpdate);

        System.out.println(RowsUpdated);
    }


    

    @Test(priority = 3)
    public void CalendarExample() throws InterruptedException, SQLException {
        
           
    	
    	
    	
            WebElement Calender = driver.findElement(By.linkText("Booking Calendar"));
            Calender.click();
            Thread.sleep(1000);
              
            Set<String> handles = driver.getWindowHandles();
            List<String> AllTabs = new ArrayList<>(handles);
            driver.switchTo().window(AllTabs.get(1));
          
           Thread.sleep(1000);
            int randomId = rand.nextInt(144,147);
            
            
            
            
            String QueryToRead = "select *from  customers where customerNumber =" +randomId;
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(QueryToRead);
            while(rs.next()) {
            	
            	FirstName = rs.getString("contactFirstName");
            	LastName  =rs.getString("contactLastName");
            	Phone  = rs.getString("phone");
            	CompanyName  = rs.getString("customerName");
            }
            System.out.println(FirstName);
            System.out.println(LastName);
            
            driver.findElement(By.id("name1")).sendKeys(FirstName);
            driver.findElement(By.id("secondname1")).sendKeys(LastName);
            int Thenumber = rand.nextInt(1000);
            driver.findElement(By.id("email1")).sendKeys(FirstName+LastName+Thenumber+"@gmail.com");
            driver.findElement(By.id("phone1")).sendKeys(Phone);
            driver.findElement(By.id("details1")).sendKeys(CompanyName);
            
            
            
}
    @Test( enabled= false)
    public void DeleteCustomerData() throws SQLException {

        System.out.println(randomId);

        String QueryToDelete =
                "DELETE FROM customers " +
                "WHERE customerNumber = " + randomId + ";";

        stmt = con.createStatement();
        int RowsDeleted = stmt.executeUpdate(QueryToDelete);

        System.out.println(RowsDeleted);
        
    }


}