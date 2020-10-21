package ru.example;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;

public class Lesson4Ex7 extends ConfProperties{
    @Test
    public void myFirstTest() {
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
        for (int i = 0; i < boxAppsMenuSize; i++){
            driver.findElements(By.cssSelector("ul#box-apps-menu li#app-")).get(i).click();
            assert(isElementPresent(By.cssSelector("td#content h1")));
            int boxAppsSubMenuSize = driver.findElements(By.cssSelector("ul#box-apps-menu li#app- ul.docs li")).size();
            if (areElementsPresent(By.cssSelector("#app-.selected li")))
                if (boxAppsSubMenuSize > 1)
                    for (int j = 1; j < boxAppsSubMenuSize; j++) {
                        driver.findElements(By.cssSelector("ul#box-apps-menu li#app- ul.docs li")).get(j).click();
                        assert(areElementsPresent(By.cssSelector("#app-.selected li")));
                        assert(isElementPresent(By.cssSelector("td#content h1")));
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
