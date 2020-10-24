package ru.example;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Lesson5Ex9 extends ConfProperties{


    @Test
    public void testSortCountries() {
        driver.get("http://localhost/litecard/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int boxAppsMenuSize = driver.findElements(By.cssSelector("ul#box-apps-menu li#app-")).size();

        for (int i = 0; i < boxAppsMenuSize; i++) {
            String menuAtt = driver.findElements(By.cssSelector("ul#box-apps-menu li#app- a ")).get(i).getAttribute("innerText");
            if  (menuAtt.contains(" Countries")) {
                driver.findElements(By.cssSelector("ul#box-apps-menu li#app-")).get(i).click();
                List<WebElement> countries = driver.findElements(By.cssSelector("table.dataTable tr.row td:nth-child(5)"));
                List<String> countriesList = new ArrayList<>();
                for (int j = 0; j < countries.size(); j++) {
                    countriesList.add(countries.get(j).getAttribute("innerText"));
                }
                System.out.println(countriesList);
            }


        }
    }


    @After
    public void stop() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
