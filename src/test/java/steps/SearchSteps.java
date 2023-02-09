package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.ResultsPage;
import pages.SearchPage;

import java.util.concurrent.TimeUnit;

public class SearchSteps {
    WebDriver driver;
    SearchPage searchPage;
    ResultsPage resultsPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        searchPage = new SearchPage(driver);
        resultsPage = new ResultsPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("I am at Booking.com page")
    public void navigateToBookingWebsite() {
        searchPage.open();
    }

    @When("I set {string} in the search bar")
    public void iSetHiltonHeadIslandInTheSearchBar(String value) {
        searchPage.searchForTheHotel(value);
    }

    @And("I click {string} in the dropdown menu")
    public void iClickHiltonHeadIslandInTheDropdownMenu(String value) {
        searchPage.chooseDropdownOption(value);
    }

    @And("I click the search button")
    public void iClickTheSearchButton() {
        searchPage.clickSearchButton();
    }

    @Then("{string}  should be present under index {int}")
    public void theWestinHiltonHeadIslandResortSpaShouldBePresent(String value, int index) {
        String hotelName = resultsPage.getHotelNameByIndex(index);
        Assert.assertTrue(hotelName.equals(value));
    }


    @Then("The hotel under index {int} should have score {string}")
    public void theHotelShouldHaveScore(int index, String score) {
        String hotelScore = resultsPage.getScoreOfTheHotelByIndex(index);
        Assert.assertTrue(hotelScore.equals(score));
    }
}
