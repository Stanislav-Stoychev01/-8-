package selenium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import java.util.List;
import java.util.logging.Level;

public class SeleniumTests {

    public static WebDriver DRIVER;

    private static final String BASE_URL = "http://127.0.0.1:5500/HTML/";
    private final static By BRAND = By.xpath("//input[@id='Brand']");
    private final static By MODEL = By.xpath("//input[@id='Model']");
    private final static By COLOUR = By.xpath("//input[@id='Colour']");
    private final static By SIZE = By.xpath("//input[@id='Size']");
    private final static By PRICE = By.xpath("//input[@id='Price']");
    private final static By SUBMIT = By.xpath("//button[@id='submit']");

    protected static String getText(By elementLocator) {
        return DRIVER.findElement(elementLocator).getText();
    }
    public static void click(By elementLocator) {
        DRIVER.findElement(elementLocator).click();
    }
    protected static void type(By elementLocator, String whatToType) {
        DRIVER.findElement(elementLocator).sendKeys(whatToType);
    }

    @BeforeEach
    public void setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability(ChromeOptions.LOGGING_PREFS, getLoggingPreferences());

        DRIVER = new ChromeDriver(chromeOptions);
        DRIVER.manage().window().maximize();
    }

    @Test
    public void submitLogsStatus200() throws InterruptedException {
        DRIVER.get(BASE_URL);
        type(BRAND, "Adidas");
        type(MODEL, "Casual");
        type(COLOUR, "RED");
        type(SIZE, "12");
        type(PRICE, "1000");
        Thread.sleep(1000);
        click(SUBMIT);
        Thread.sleep(1000);
        Assertions.assertTrue(checkLogs("200"));
        DRIVER.getWindowHandle();
    }

    @Test
    public void submit_invalidColour_LogsStatus400() throws InterruptedException {
        DRIVER.get(BASE_URL);
        type(BRAND, "Adidas");
        type(MODEL, "Casual");
        type(COLOUR, "InvalidValue");
        type(SIZE, "12");
        type(PRICE, "1000");
        Thread.sleep(1000);
        click(SUBMIT);
        Thread.sleep(1000);
        Assertions.assertTrue(checkLogs("400"));
        DRIVER.getWindowHandle();
    }

    @Test
    public void submit_invalidSize_LogsStatus400() throws InterruptedException {
        DRIVER.get(BASE_URL);
        type(BRAND, "Adidas");
        type(MODEL, "Casual");
        type(COLOUR, "GREEN");
        type(SIZE, "InvalidValue");
        type(PRICE, "1000");
        Thread.sleep(1000);
        click(SUBMIT);
        Thread.sleep(1000);
        Assertions.assertTrue(checkLogs("400"));
        DRIVER.getWindowHandle();
    }

    private boolean checkLogs(String targetValue) {
        boolean result = false;
        LogEntries entries = DRIVER.manage().logs().get(LogType.BROWSER);
        List<LogEntry> logs = entries.getAll();
        for (LogEntry entry : logs) {
            String message = entry.getMessage();
            if (message.contains(targetValue)) {
                result = true;
                break;
            }
        }
        return result;
    }

    private static LoggingPreferences getLoggingPreferences() {
        LoggingPreferences logs = new LoggingPreferences();
        logs.enable("browser", Level.INFO);
        logs.enable("performance", Level.INFO);
        return logs;
    }

}
