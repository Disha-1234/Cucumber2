package StepDefinitions;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;


public class LoginStepDefinitions{


    static WebDriver driver;

    @Given("user is on login page")
    public void user_is_on_login_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://example.testproject.io/web/");
    }


    @When("User Enter Valid fullname")
    public void user_enter_valid_full_name() {
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Disha Patel");
        System.out.println("full name");
    }

    @And("User Enter valid password")
    public void user_enter_valid_password() {
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("12345");
        System.out.println("password");
    }

    @And("User click on  login button")
    public void user_click_on_login_in_button() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@id='login']")).click();
        System.out.println("login button click");
    }

    @When("User enter  {string},{string}")
    public void userEnterAnd(String fullname , String password) {
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(fullname);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);


    }

    @Then("User should see invalidation message{string}")
    public void userShouldSeeInvalidationMessage(String message) throws InterruptedException {

        Thread.sleep(3000);
        String invalidMessage = driver.findElement(By.xpath("//div[normalize-space()='Password is invalid']")).getText();
        assertEquals(message, invalidMessage);
        driver.quit();
    }
    @Then("User should see error message{string}")
    public void userShouldSeeErrorMessage(String message) throws InterruptedException {

        Thread.sleep(3000);
        String userfullname = driver.findElement(By.xpath("//div[contains(text(),'Please provide your full name')]")).getText();
        assertEquals(message, userfullname);
        driver.quit();
    }

    @Then("user should see a validation message {string}")
    public void userShouldSeeAValidationMessage(String message) throws InterruptedException {
        Thread.sleep(3000);
        String welcomeMessage = driver.findElement(By.id("greetings")).getText();
        System.out.println(welcomeMessage);
        assertEquals(message, welcomeMessage);
        driver.quit();
    }
}