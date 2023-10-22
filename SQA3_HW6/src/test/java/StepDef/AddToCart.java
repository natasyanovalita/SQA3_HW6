package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AddToCart {
    WebDriver driver;
    @Given("I open my browser")
    public void iOpenMyBrowser() {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
        driver = new EdgeDriver();
    }

    @And("Open saucedemo website")
    public void openSaucedemoWebsite() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(1000);
    }

    @And("Located on saucedemo website")
    public void locatedOnSaucedemoWebsite() {
        driver.findElement(By.name("login-button")).isDisplayed();
    }

    @When("I input the right username")
    public void iInputTheRightUsername() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
    }

    @And("I input the right password")
    public void iInputTheRightPassword() {
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
    }

    @And("I go to the homepage")
    public void iGoToTheHomepage() {
        driver.get("https://www.saucedemo.com/inventory.html");
    }

    @And("I add product to cart")
    public void iAddProductToCart() {
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).sendKeys(Keys.ENTER);
    }

    @Then("The product is added to Cart")
    public void The_product_is_added_to_Cart() {
        driver.get("https://www.saucedemo.com/cart.html");
    }
}
