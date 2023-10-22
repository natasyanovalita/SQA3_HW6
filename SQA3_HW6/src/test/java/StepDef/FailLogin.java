package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class FailLogin {
    WebDriver driver;
    @Given("I open the browser")
    public void i_open_the_browser() {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
        driver = new EdgeDriver();
    }

    @And("Open the website saucedemo")
    public void Open_the_website_saucedemo() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(1000);
    }

    @And("Located on saucedemo site")
    public void Located_on_saucedemo_site() {
        driver.findElement(By.name("login-button")).isDisplayed();
    }

    @When("I input wrong username")
    public void I_input_wrong_username() {
        driver.findElement(By.name("user-name")).sendKeys("wrong_user");
    }

    @And("I input wrong password")
    public void I_input_wrong_password() {
        driver.findElement(By.name("password")).sendKeys("wrong_pass");
        driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
    }

    @Then("I got error message {string}")
    public void I_Got_Error_Message(String errorMessage) {
        WebElement errorElement = driver.findElement(By.cssSelector(".error-message-container.error"));
        assert (errorElement.getText().contains(errorMessage));
    }
}
