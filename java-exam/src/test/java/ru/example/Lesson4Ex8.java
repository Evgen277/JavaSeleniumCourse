package ru.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Lesson4Ex8 extends ConfProperties{
    @Test
    public void mySecondTest() {
        driver.get("http://localhost/litecard/en/");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int productsAmount = driver.findElements(By.cssSelector("div.content ul li.product")).size();
        System.out.println(productsAmount);
        int stickersAmount = driver.findElements(By.cssSelector("div.content ul li.product div.sticker")).size();
        System.out.println(stickersAmount);
        Assert.assertEquals("Неверное количество стикеров", productsAmount, stickersAmount);

    }
    @After
    public void stop(){
        driver.quit();
    }
}
