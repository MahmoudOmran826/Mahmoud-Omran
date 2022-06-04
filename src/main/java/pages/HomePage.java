package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private By searchBox = By.cssSelector("input[name='q']");
    private By searchBtn = By.xpath("//div[@class='iblpc']");
    private By validSearchResults = By.xpath("//div[@id='search']//h3[text()='Fast.com: اختبار سرعة الإنترنت']");
    private By inValidSearchResults = By.xpath("//div[@id='res']//p[text()='لم ينجح بحثك عن ']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickSearchBTN() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
            driver.findElement(searchBtn).click();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void enterTextAndSearch(String text) {
        try {
            driver.findElement(searchBox).sendKeys(text);
            driver.findElement(searchBox).sendKeys(Keys.ENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param validFlag if it's true then we will get a positive response and vice versa.
     *
     */
    public String result(boolean validFlag) {
        String text="";
        try {
            if (validFlag) {
                text = driver.findElement(validSearchResults).getText();
            }else
                text = driver.findElement(inValidSearchResults).getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }
}
