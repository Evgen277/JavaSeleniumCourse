package ru.example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class Lesson8Ex14 extends ConfProperties{

    @Test
    public void linkCheck() {

        driver.get("http://localhost/litecard/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.get("http://localhost/litecard/admin/?app=countries&doc=countries");
        driver.findElement(By.cssSelector("table.dataTable tbody tr:nth-child(14) td:nth-child(5) a")).click();

        List<WebElement> links = driver.findElements(By.cssSelector("td#content td a[target='_blank']"));

        for (int i = 0; i < links.size(); i++){
            String generalWindow = driver.getWindowHandle();
            Set<String> oldWindows = driver.getWindowHandles();
            driver.findElements(By.cssSelector("td#content td a[target='_blank']")).get(i).click();
            String newWindow = wait.until(anyWindowOtherThan(oldWindows));
            driver.switchTo().window(newWindow);
            driver.close();
            driver.switchTo().window(generalWindow);
        }
    }
}
