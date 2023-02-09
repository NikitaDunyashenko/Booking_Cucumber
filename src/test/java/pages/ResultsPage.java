package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultsPage extends BasePage{

    private final static By HOTEL_NAMES = By.xpath("//div[@data-testid='property-card']//div[@data-testid='title']");
    private final static By RATING_SCORE = By.xpath("//div[contains(@aria-label,'Scored')]");

    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    public String getHotelNameByIndex(int index) {
        return driver.findElements(HOTEL_NAMES).get(index - 1).getText();
    }

    public String getScoreOfTheHotelByIndex(int index) {
        return driver.findElements(RATING_SCORE).get(index - 1).getText();
    }

}
