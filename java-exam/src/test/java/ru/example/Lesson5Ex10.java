package ru.example;

import org.junit.Test;
import org.openqa.selenium.By;

public class Lesson5Ex10 extends ConfProperties{

    @Test
    public void productCompare(){
        driver.get("http://localhost/litecard/");
        String nameMain = driver.findElement(By.cssSelector("div#box-campaigns div.content ul li a div.name")).getAttribute("innerText");
        String priceMain = driver.findElement(By.cssSelector("div#box-campaigns div.content ul li a div.price-wrapper s")).getAttribute("innerText");
        String priceActMain = driver.findElement(By.cssSelector("div#box-campaigns div.content ul li a div.price-wrapper strong")).getAttribute("innerText");
        String priceStyleMain = driver.findElement(By.cssSelector("div#box-campaigns div.content ul li a div.price-wrapper s")).getCssValue("textDecoration");
        String priceColMain = driver.findElement(By.cssSelector("div#box-campaigns div.content ul li a div.price-wrapper s")).getCssValue("color");
        String priceActStyleMain = driver.findElement(By.cssSelector("div#box-campaigns div.content ul li a div.price-wrapper strong")).getCssValue("fontWeight");
        String priceActColMain = driver.findElement(By.cssSelector("div#box-campaigns div.content ul li a div.price-wrapper strong")).getCssValue("color");
        String priceSizeMain = driver.findElement(By.cssSelector("div#box-campaigns div.content ul li a div.price-wrapper s")).getCssValue("fontSize");
        String priceActSizeMain = driver.findElement(By.cssSelector("div#box-campaigns div.content ul li a div.price-wrapper strong")).getCssValue("fontSize");
        System.out.println(nameMain);
        System.out.println(priceMain);
        System.out.println(priceActMain);
        System.out.println(priceStyleMain);
        System.out.println(priceColMain);
        System.out.println(priceActStyleMain);
        System.out.println(priceActColMain);
        System.out.println(priceSizeMain);
        System.out.println(priceActSizeMain);

    }


}
