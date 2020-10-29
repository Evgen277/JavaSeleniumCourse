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
        String priceSizeProd = (driver.findElement(By.cssSelector("s.regular-price")).getCssValue("fontSize"));
        String priceActSizeProd = (driver.findElement(By.cssSelector("strong.campaign-price")).getCssValue("fontSize"));

        //а) на главной странице и на странице товара совпадает текст названия товара
        assertTrue(nameMain.equalsIgnoreCase(nameProd));
        //б) на главной странице и на странице товара совпадают цены (обычная и акционная)
        assertTrue(priceMain.equalsIgnoreCase(priceProd));
        assertTrue(priceActMain.equalsIgnoreCase(priceActProd));
        //в) обычная цена зачёркнутая и серая
        int[] col = colorRGB(priceColMain);
        assertTrue(col[0]==col[1]&&col[1]==col[2]);
        int[] colProd = colorRGB(priceColProd);
        assertTrue(colProd[0]==colProd[1]&&colProd[1]==colProd[2]);
        assertTrue(priceStyleMain.equalsIgnoreCase("line-through"));
        assertTrue(priceStyleProd.equalsIgnoreCase("line-through"));
        //г) акционная жирная и красная
        int[] colAct = colorRGB(priceActColMain);
        assertTrue(colAct[1]==0&&colAct[2]==0);
        int[] colActProd = colorRGB(priceActColProd);
        assertTrue(colActProd[1]==0&&colActProd[2]==0);
        int t = Integer.parseInt(priceActStyleMain);
        assertTrue(t > 400);
        //г) акционная цена крупнее, чем обычная
        float fontSize = fontSizePX(priceSizeMain);
        float fontSizeAct = fontSizePX(priceActSizeMain);
        assertTrue(fontSize < fontSizeAct);
        float fontSizeProd = fontSizePX(priceSizeProd);
        float fontSizeActProd = fontSizePX(priceActSizeProd);
        assertTrue(fontSizeProd < fontSizeActProd);

    }


}
