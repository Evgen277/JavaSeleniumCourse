package ru.example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import static org.junit.Assert.assertTrue;

public class Lesson6Ex12 extends ConfProperties{

    @Test
    public void addNewProduct() {

        driver.get("http://localhost/litecard/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("td#content"))));
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.cssSelector("ul.list-vertical li#app-:nth-child(2) a")).click();
                try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("ul.list-horizontal"))));

        driver.findElement(By.cssSelector("td#content div a:nth-child(2)")).click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {  ////Ну вот так, по другому не работает
            e.printStackTrace();
        }
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.content"))));


        //Заполнение General
        driver.findElement(By.cssSelector("div#tab-general table tbody tr td label input[value = '1']")).click();
        driver.findElement(By.cssSelector("tbody tr:nth-child(2) td span.input-wrapper input")).sendKeys("NewDuck");
        driver.findElement(By.cssSelector("tbody tr:nth-child(3) td input")).sendKeys("215321");
        driver.findElement(By.cssSelector("table tbody tr td input[value = '1-1']")).click();
        driver.findElement(By.cssSelector("table tbody tr td input[name = 'quantity']")).clear();
        driver.findElement(By.cssSelector("table tbody tr td input[name = 'quantity']")).sendKeys("156");
        String fileLocation = System.getProperty("user.dir") + "\\src\\main\\resources\\yellowduck.png";
        driver.findElement(By.cssSelector("table tbody tr td input[type = 'file']")).sendKeys(fileLocation);
        driver.findElement(By.cssSelector("table tbody tr td input[name = 'date_valid_from']")).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value','2020-11-03')", driver.findElement(By.cssSelector("table tbody tr td input[name = 'date_valid_from']")));
        driver.findElement(By.cssSelector("table tbody tr td input[name = 'date_valid_to']")).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value','2020-11-10')", driver.findElement(By.cssSelector("table tbody tr td input[name = 'date_valid_to']")));

        //Заполнение Information
        driver.findElement(By.cssSelector("div.tabs li:nth-child(2) a")).click();
        Select states = new Select(driver.findElement(By.cssSelector("select[name='manufacturer_id']")));
        states.selectByIndex(1);
        driver.findElement(By.cssSelector("tr td input[name = 'keywords']")).sendKeys("duck, yellow, yellowduck");
        driver.findElement(By.cssSelector("tr td input[name = 'short_description[en]']")).sendKeys("Just Yellow Duck");
        driver.findElement(By.cssSelector("tr td div.trumbowyg-editor")).sendKeys("Just Yellow Duck, usual yellow Duck, nothing special");
        driver.findElement(By.cssSelector("tr td input[name = 'head_title[en]']")).sendKeys("New Duck");
        driver.findElement(By.cssSelector("tr td input[name = 'meta_description[en]']")).sendKeys("Just Yellow Duck Meta Info");

        //Заполнение Prices
        driver.findElement(By.cssSelector("div.tabs li:nth-child(4) a")).click();
        driver.findElement(By.cssSelector("table tbody tr td input[name = 'purchase_price']")).clear();
        driver.findElement(By.cssSelector("table tbody tr td input[name = 'purchase_price']")).sendKeys("15");
        Select currency = new Select(driver.findElement(By.cssSelector("select[name='purchase_price_currency_code']")));
        currency.selectByIndex(1);
        driver.findElement(By.cssSelector("table tbody tr td input[name = 'gross_prices[USD]']")).sendKeys("15");
        driver.findElement(By.cssSelector("table tbody tr td input[name = 'gross_prices[EUR]']")).sendKeys("16");
        driver.findElement(By.cssSelector("span.button-set button[name='save']")).click();

        assertTrue(areElementsPresent(By.cssSelector("table.dataTable tbody tr td img")));

    }
}
