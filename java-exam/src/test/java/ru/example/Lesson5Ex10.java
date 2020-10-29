package ru.example;

import org.junit.Test;
import org.openqa.selenium.By;
import static org.junit.Assert.assertTrue;

public class Lesson5Ex10 extends ConfProperties{

    @Test
    public void productCompare(){
        driver.get("http://localhost/litecard/");
        String nameMain = driver.findElement(By.cssSelector("div#box-campaigns div.content ul li a div.name")).getAttribute("innerText");
        String priceMain = driver.findElement(By.cssSelector("div#box-campaigns div.content ul li a div.price-wrapper s")).getAttribute("innerText");
        String priceActMain = driver.findElement(By.cssSelector("div#box-campaigns div.content ul li a div.price-wrapper strong")).getAttribute("innerText");
        String priceStyleMain = driver.findElement(By.cssSelector("div#box-campaigns div.content ul li a div.price-wrapper s")).getCssValue("textDecorationLine");
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
        driver.findElement(By.cssSelector("div#box-campaigns div.content ul li a.link")).click();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String nameProd = driver.findElement(By.cssSelector("h1[itemprop = 'name']")).getAttribute("innerText");
        String priceProd = driver.findElement(By.cssSelector("s.regular-price")).getAttribute("innerText");
        String priceActProd = driver.findElement(By.cssSelector("strong.campaign-price")).getAttribute("innerText");
        String priceStyleProd = driver.findElement(By.cssSelector("s.regular-price")).getCssValue("textDecorationLine");
        String priceColProd = driver.findElement(By.cssSelector("s.regular-price")).getCssValue("color");
        String priceActStyleProd = driver.findElement(By.cssSelector("strong.campaign-price")).getCssValue("fontWeight");
        String priceActColProd = driver.findElement(By.cssSelector("strong.campaign-price")).getCssValue("color");
        float priceSizeProd = Float.parseFloat(driver.findElement(By.cssSelector("s.regular-price")).getCssValue("fontSize"));
        float priceActSizeProd = Float.parseFloat(driver.findElement(By.cssSelector("strong.campaign-price")).getCssValue("fontSize"));
        System.out.println(nameProd);
        System.out.println(priceProd);
        System.out.println(priceActProd);
        System.out.println(priceStyleProd);
        System.out.println(priceColProd);
        System.out.println(priceActStyleProd);
        System.out.println(priceActColProd);
        System.out.println(priceSizeProd);
        System.out.println(priceActSizeProd);
        //assertTrue(nameMain == nameProd);
        assertTrue(priceMain == priceProd);
        assertTrue(priceActMain == priceActProd);





    }


}
