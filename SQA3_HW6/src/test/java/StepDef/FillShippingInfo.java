package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FillShippingInfo {
    WebDriver driver;
    @Given("I open my edge browser")
    public void iOpenMyEdgeBrowser() {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
        driver = new EdgeDriver();
    }

    @And("Open saucedemo website on browser")
    public void openSaucedemoWebsiteOnBrowser() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(1000);
    }

    @And("Located on saucedemo login page")
    public void locatedOnSaucedemoLoginPage() {
        driver.findElement(By.name("login-button")).isDisplayed();
    }

    @When("I input the given username")
    public void iInputTheGivenUsername() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
    }

    @And("I input the given password")
    public void iInputTheGivenPassword() {
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
    }

    @And("I go to saucedemo homepage")
    public void iGoToSaucedemoHomepage() {
        driver.get("https://www.saucedemo.com/inventory.html");
    }

    @And("I add product to the cart")
    public void iAddProductToTheCart() {
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).sendKeys(Keys.ENTER);
    }

    @Then("The product is added to The Cart")
    public void The_product_is_added_to_The_Cart() {
        driver.get("https://www.saucedemo.com/cart.html");
    }

    @When("I click checkout")
    public void iClickCheckout() {
        driver.findElement(By.name("checkout")).sendKeys(Keys.ENTER);
    }

    @And("Located on shipping form")
    public void locatedOnShippingForm() {
        driver.findElement(By.name("continue")).isDisplayed();
    }

    @And("I input valid first name")
    public void iInputValidFirstName() {
        driver.findElement(By.name("firstName")).sendKeys("Rachmat");
    }

    @And("I input valid last name")
    public void iInputValidLastName() {
        driver.findElement(By.name("lastName")).sendKeys("Sadikin");
    }

    @And("I input valid ZIP")
    public void iInputValidZIP() {
        driver.findElement(By.name("postalCode")).sendKeys("15130");
    }

    @Then("I click continue")
    public void iClickContinue() {
        driver.findElement(By.name("continue")).sendKeys(Keys.ENTER);
    }
}

