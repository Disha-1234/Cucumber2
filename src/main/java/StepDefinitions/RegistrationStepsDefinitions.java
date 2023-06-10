package StepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class RegistrationStepsDefinitions{

    static WebDriver driver;


    @Given(": I am on registration page")
    public void i_am_on_registration_page() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        // driver.findElement(By.cssSelector(".ico-register")).click();

        System.out.println("Registration");



    }
    @When(": I enter valid First Name")
    public void i_enter_valid_first_name() {

        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Disha");

        System.out.println("firstname");




    }
    @When(": I enter valid Last Name")
    public void i_enter_valid_last_name() {
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Patel");

    }
    @When(": I enter valid Email")
    public void i_enter_valid_email() {
        driver.findElement(By.xpath("//input[@name='Email']")).sendKeys("disha.patel"+Math.random() +"@gmail.com");
    }
    @When(": I enter valid Password")
    public void i_enter_valid_password() {
        driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("Nid@9876");
    }
    @When(": I enter valid Confirm password")
    public void i_enter_valid_confirm_password() throws InterruptedException {
        driver.findElement(By.xpath("//input[@name='ConfirmPassword']")).sendKeys("Nid@9876");
        Thread.sleep(3000);
    }
    @When(": I click REGISTER button")
    public void i_click_register_button() {
        driver.findElement(By.xpath("//button[@id='register-button']")).click();
    }
    @Then(": I should register successfully")
    public void i_should_register_successfully() {
        WebElement logout = driver.findElement(By.className("result"));
        System.out.println("I have registered successfully");


        Assert.assertEquals("I am registered successfully",logout.getText(),"Your registration completed");


    }


}