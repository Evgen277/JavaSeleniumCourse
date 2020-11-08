package ru.example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class Lesson7Ex13 extends ConfProperties{


    @Test
    public void workWithCart(){

        driver.get("http://localhost/litecard/");
        driver.findElement(By.cssSelector("nav#site-menu ul li:nth-child(2) a")).click();
        for (int i = 0; i < 3; i++){
            driver.findElements(By.cssSelector("ul.listing-wrapper.products li")).get(i).click();
            int cartSize = Integer.parseInt(driver.findElement(By.cssSelector("div#cart-wrapper div#cart a span.quantity")).getAttribute("textContent"));
            if (isElementPresent(By.cssSelector("select[name='options[Size]']"))) {
                Select size = new Select(driver.findElement(By.cssSelector("select[name='options[Size]']")));
                size.selectByIndex(1);
            }
            driver.findElement(By.cssSelector("button[name='add_cart_product']")).click();
            wait.until(ExpectedConditions.textToBe(By.cssSelector("div#cart-wrapper div#cart a span.quantity"), String.valueOf(cartSize + 1)));
            driver.findElement(By.cssSelector("nav#site-menu ul li:nth-child(2) a")).click();
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
