import com.google.common.base.Verify;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TestANZ extends Setup {

    @Given("User navigates to the application URL")
    public void userNavigatesToTheApplicationURL() {
        Setup.before();

    }

    @When("User enter the values for the field")
    public void userEnterTheValuesForTheField(DataTable values) {
        List<String> valuesToEnter = values.asList();
        driver.findElement(By.xpath("//label[@for='application_type_single']")).click();
        Select  dependants = new Select(Setup.driver.findElement(By.xpath("//select[@title='Number of dependants']")));
        dependants.selectByIndex(0);
        Setup.driver.findElement(By.xpath("//label[@for='borrow_type_home']")).click();
        Setup.driver.findElement(By.xpath("//label[text()='Your income (before tax)']//following-sibling::div//input")).sendKeys(valuesToEnter.get(1));
        Setup.driver.findElement(By.xpath("//label[text()='Your other income']//following-sibling::div//input")).sendKeys(valuesToEnter.get(2));
        Setup.driver.findElement(By.xpath("//label[text()='Living expenses']//following-sibling::div//input")).sendKeys(valuesToEnter.get(3));
        Setup.driver.findElement(By.xpath("//label[text()='Current home loan repayments']//following-sibling::div//input")).sendKeys(valuesToEnter.get(4));
        Setup.driver.findElement(By.xpath("//label[text()='Other loan repayments']//following-sibling::div//input")).sendKeys(valuesToEnter.get(5));
        Setup.driver.findElement(By.xpath("//label[text()='Other commitments']//following-sibling::div//input")).sendKeys(valuesToEnter.get(6));
        Setup.driver.findElement(By.xpath("//label[text()='Total credit card limits']//following-sibling::div//input")).sendKeys(valuesToEnter.get(7));

    }

    @And("User calculate the borrowing estimate")
    public void userCalculateTheBorrowingEstimate() throws Exception {
        Thread.sleep(2000);
        Setup.driver.findElement(By.xpath("//button[text()='Work out how much I could borrow']")).click();
    }

    @Then("Verify the calculated borrowing estimate")
    public void verifyTheCalculatedBorrowingEstimate() throws Exception {
        Thread.sleep(2000);
        String estimate = Setup.driver.findElement(By.id("borrowResultTextAmount")).getText();
        System.out.println("The borrowing estimate is :" + estimate);
    }

    @Given("User clears the form to start over again")
    public void userClearsTheFormToStartOverAgain() throws Exception {
        Thread.sleep(2000);
        Setup.driver.findElement(By.xpath("(//div[@class='box--right']/button[text()='Start over'])[1]")).click();
    }

    @Given("User enters values only for living expenses")
    public void userEntersValuesOnlyForLivingExpenses() throws Exception {
        Thread.sleep(2000);
        Setup.driver.findElement(By.xpath("//label[text()='Living expenses']//following-sibling::div//input")).sendKeys("1");
    }

    @Then("User verify the message {string}")
    public void userVerifyTheMessage(String msg) {
        String errorMsg = Setup.driver.findElement(By.xpath("//span[@class='borrow__error__text']")).getText();
        Assert.assertEquals(msg,errorMsg);
    }

    @And("User close the browser")
    public void userCloseTheBrowser() throws Exception {
        Thread.sleep(2000);
        Setup.after();
    }
}
