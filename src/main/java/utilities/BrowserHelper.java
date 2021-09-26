package utilities;

import actions.BrowserName;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class BrowserHelper {

    static WebDriver driver;

    public static WebDriver launchBrowser(BrowserName browserName, String url) {
        DriverConfig.setDriverPath(browserName);
        switch (browserName) {
            case CHROME:
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Browser name is invalid");
        }
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }


    public static void sleep(String timeInMillis) {
        try {
            Thread.sleep(Long.parseLong(timeInMillis));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void closeBrowser() {
        driver.quit();
    }

    // click on an element
    public static void click(By locator, String elementName) {
        driver.findElement(locator).click();
    }

    // locate an element
    public static WebElement getElement(By locator, String elementName) {
        WebElement element = driver.findElement(locator);
        return element;
    }

    // enter text
    public static void enterText(By locator, String textToEnter, String elementName) {
        getElement(locator, elementName).sendKeys(textToEnter);
    }

    // select an option of drop down
    public static void selectOption(By locator, String option, String elementName) {
        Select select = new Select(getElement(locator, elementName));
        List<WebElement> options = select.getOptions();
        Optional<String> first = options.stream().map(WebElement::getText).filter(optionText -> optionText.equalsIgnoreCase(option)).findFirst();
        select.selectByVisibleText(first.get());
    }

    // aselect.selectByVisibleText(first);                                                                                                        ccept alert
    public static String acceptAlert() {
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        alert.accept();
        return text;
    }

    // mouse hover event
    public static void mouseHoverToElement(By locator, String elementName) {
        WebElement ele = getElement(locator, elementName);
        Actions actions = new Actions(driver);
        actions.moveToElement(ele).build().perform();
    }

    // take screenshot
    public static byte[] attachScreenshotToReport(String imageName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
        return FileUtils.readFileToByteArray(screenshotAs);
    }


    public static byte[] getScreenShotAsFile(String imageName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
        File screenshots = new File(DriverConfig.getFolderPath("screenshots") + imageName);
        FileHandler.copy(screenshotAs, screenshots);
        return FileUtils.readFileToByteArray(screenshotAs);
    }

    public static String getAttributeValue(By element, String attributeName, String eleName) {
        return getElement(element, eleName).getAttribute(attributeName);
    }

    public boolean isElementDisplayed(By element, String eleName){
        return getElement(element, eleName).isDisplayed();
    }
}
