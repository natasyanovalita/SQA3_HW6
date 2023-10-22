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

public class FillNullShippingInfo {
    WebDriver driver;
    @Given("I open edge browser")
    public void iOpenEdgeBrowser() {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
        driver = new EdgeDriver();
    }

    @And("Open saucedemo website on edge browser")
    public void openSaucedemoWebsiteOnEdgeBrowser() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(1000);
    }

    @And("Located on saucedemo first page")
    public void locatedOnSaucedemoFirstPage() {
        driver.findElement(By.name("login-button")).isDisplayed();
    }

    @When("I input my username")
    public void iInputMyUsername() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
    }

    @And("I input my password")
    public void iInputMyPassword() {
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
    }

    @And("I am directed to saucedemo homepage")
    public void iAmDirectedToSaucedemoHomepage() {
        driver.get("https://www.saucedemo.com/inventory.html");
    }

    @And("I add a product to the cart")
    public void iAddAProductToTheCart() {
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).sendKeys(Keys.ENTER);
    }

    @Then("The selected product is added to The Cart")
    public void The_selected_product_is_added_to_The_Cart() {
        driver.get("https://www.saucedemo.com/cart.html");
    }

    @When("I click checkout button")
    public void iClickCheckoutButton() {
        driver.findElement(By.name("checkout")).sendKeys(Keys.ENTER);
    }

    @And("Located on the shipping form")
    public void locatedOnTheShippingForm() {
        driver.findElement(By.name("continue")).isDisplayed();
    }

    @And("I input empty first name")
    public void iInputValidFirstName() {
        driver.findElement(By.name("firstName")).sendKeys("");
    }

    @And("I input empty last name")
    public void iInputValidLastName() {
        driver.findElement(By.name("lastName")).sendKeys("");
    }

    @And("I input empty ZIP")
    public void iInputValidZIP() {
        driver.findElement(By.name("postalCode")).sendKeys("");
    }

    @Then("I click continue button and get an error message {string}")
    public void iClickContinueButtonAndGetAnErrorMessage(String errorMessage) {
        driver.findElement(By.name("continue")).sendKeys(Keys.ENTER);
        WebElement errorElement = driver.findElement(By.cssSelector(".error-message-container.error"));
        assert (errorElement.getText().contains(errorMessage));
    }
}
