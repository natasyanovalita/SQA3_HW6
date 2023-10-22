package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Login {
    WebDriver driver;
    @Given("I open browser")
    public void i_open_browser() {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
        driver = new EdgeDriver();
    }

    @And("Open website saucedemo")
    public void Open_website_saucedemo() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(1000);
    }

    @And("Located on saucedemo")
    public void Located_on_saucedemo() {
        driver.findElement(By.name("login-button")).isDisplayed();
    }

    @When("I input valid username")
    public void I_input_valid_username() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
    }

    @And("I input valid password")
    public void I_input_valid_password() {
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
    }

    @Then("I go to homepage")
    public void I_go_to_homepage() {
        driver.get("https://www.saucedemo.com/inventory.html");
    }
}

