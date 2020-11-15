package ru.example;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ConfProperties {
    protected static FileInputStream fileInputStream;
    protected static Properties PROPERTIES;
    public static ThreadLocal<WebDriver>tlDriver = new ThreadLocal<>();
    public WebDriver driver;
    public WebDriverWait wait;

    static {
        try {
            fileInputStream = new FileInputStream( "src/main/resources/conf.properties");
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
    public static String getProperty(String key) { return PROPERTIES.getProperty(key); }



    public boolean isElementPresent(By locator){
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex){
            return false;
        }
    }

    public ExpectedCondition<String>anyWindowOtherThan(Set<String> oldWindows){
        return new ExpectedCondition<String>() {
            public String apply(WebDriver driver) {
                Set<String>handles = driver.getWindowHandles();
                handles.removeAll(oldWindows);
                return  handles.size() > 0 ? handles.iterator().next():null;
            }
        };
    }
    public boolean areElementsPresent(By locator) {
        try {
            return driver.findElements(locator).size() > 0;
        } catch (InvalidSelectorException ex) {
            return false;
        }
    }

    public static int[] colorRGB(String priceCol) {
        String colRGB = priceCol.replaceAll("[,.rgba)(]", "");
        String strArrRGB[] = colRGB.split(" ");
        int numArrRGB[] = new int[strArrRGB.length];
        for (int i = 0; i < strArrRGB.length; i++) {
            numArrRGB[i] = Integer.parseInt(strArrRGB[i]);
        }
        return numArrRGB;
    }

    public static float fontSizePX(String priceSize) {
        String priceFont = priceSize.replaceAll("[px]", "");
        float numArrPX = Float.parseFloat(priceFont);
        return numArrPX;
    }

    @Before
    public void start() {
        if (tlDriver.get() != null) {
            driver = tlDriver.get();
            wait = new WebDriverWait(driver, 15);
            return;
        }
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver.path"));
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        tlDriver.set(driver);
        wait = new WebDriverWait(driver, 15);
        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> {
                    driver.quit();
                    driver = null;
                })
        );
    }
}
