package ru.example;


import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.util.Random;

import static org.openqa.selenium.Keys.ENTER;

public class Lesson6Ex11 extends ConfProperties{


    @Test
    public void userRegistration(){
        driver.get("http://localhost/litecard/");
        driver.findElement(By.cssSelector("div.content form table tbody tr td a")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button[name = 'create_account']"))));
        driver.findElement(By.cssSelector("input[name='tax_id']")).sendKeys("321123");
        driver.findElement(By.cssSelector("input[name='company']")).sendKeys("Industry LTD");
        driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("John");
        driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("Dow");
        driver.findElement(By.cssSelector("input[name='address1']")).sendKeys("Smith str 98");
        driver.findElement(By.cssSelector("input[name='address2']")).sendKeys("Jackson str 23");
        driver.findElement(By.cssSelector("input[name='postcode']")).sendKeys("56787");
        driver.findElement(By.cssSelector("input[name='city']")).sendKeys("New-York");
        driver.findElement(By.cssSelector("span.select2-selection__rendered")).click();
        driver.findElement(By.cssSelector("input.select2-search__field")).sendKeys("United States");
        driver.findElement(By.cssSelector("input.select2-search__field")).sendKeys(ENTER);
        Select states = new Select(driver.findElement(By.cssSelector("select[name='zone_code']")));
        states.selectByVisibleText("Florida");
        String rand = String.format(Integer.toString(new Random().nextInt(999999)), "%06d");
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys(rand+"@mail.com");
        driver.findElement(By.cssSelector("input[name='phone']")).sendKeys(rand);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("12345qwerty");
        driver.findElement(By.cssSelector("input[name='confirmed_password']")).sendKeys("12345qwerty");
        driver.findElement(By.cssSelector("button[name = 'create_account']")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.box div.content ul.list-vertical"))));
        driver.findElement(By.cssSelector("div.content ul.list-vertical li:nth-child(4) a")).click();
        driver.findElement(By.cssSelector("div.content form table tbody tr td input[name = 'email']")).sendKeys(rand+"@mail.com");
        driver.findElement(By.cssSelector("div.content form table tbody tr td input[name = 'password']")).sendKeys("12345qwerty");
        driver.findElement(By.cssSelector("div.content form table tbody tr td span.button-set button[name = 'login']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.box div.content ul.list-vertical")));
        driver.findElement(By.cssSelector("div.content ul.list-vertical li:nth-child(4) a")).click();
    }
}
