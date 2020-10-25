package ru.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.json.JsonOutput;
import org.w3c.dom.ls.LSOutput;

import java.beans.Transient;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertTrue;

//Урок 5 Задание 9

public class Lesson5Ex9 extends ConfProperties {

    @Test
    public void testSortCountriesA() {
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
            if (menuAtt.contains(" Countries")) {
                driver.findElements(By.cssSelector("ul#box-apps-menu li#app-")).get(i).click();
                List<WebElement> countries = driver.findElements(By.cssSelector("table.dataTable tr.row td:nth-child(5)"));
                List<String> countriesList = new ArrayList<>();
                for (WebElement j : countries) {
                    countriesList.add(j.getAttribute("innerText"));
                }
                List<String> countriesSortedList = new ArrayList<>();
                for (String s : countriesList) {
                    countriesSortedList.add(s);
                }
                Collections.sort(countriesSortedList);
                assertTrue(countriesList.equals(countriesSortedList));

            }
        }
    }


    @Test
    public void sortGeoZones1() {
        int geoZone = driver.findElements(By.cssSelector("table.dataTable tr.row td:nth-child(6)")).size();
        for (int t = 0; t < geoZone; t++) {

            if (!driver.findElements(By.cssSelector("table.dataTable tr.row td:nth-child(6)")).get(t).getText().equals("0")) {
                driver.findElements(By.cssSelector("table.dataTable tr.row td:nth-child(5) a")).get(t).click();
                List<WebElement> geoZones = driver.findElements(By.cssSelector("table#table-zones tbody tr td:nth-child(3)"));
                List<String> geoZonesList = new ArrayList<>();
                for (WebElement l : geoZones) {
                    geoZonesList.add(l.getAttribute("innerText"));
                }
                geoZonesList.remove(geoZonesList.size() - 1);
                List<String> geoZonesSortedList = new ArrayList<>();
                for (String b : geoZonesList) {
                    geoZonesSortedList.add(b);
                }
                Collections.sort(geoZonesSortedList);
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                assertTrue(geoZonesList.equals(geoZonesSortedList));
                driver.get("http://localhost/litecard/admin/?app=countries&doc=countries");
            }


        }
    }

    @Test
    public void sortGeoZones2() {
        int boxAppsMenuSize1 = driver.findElements(By.cssSelector("ul#box-apps-menu li#app-")).size();
        for (int y = 0; y < boxAppsMenuSize1; y++) {
            String menuAtt1 = driver.findElements(By.cssSelector("ul#box-apps-menu li#app- a ")).get(y).getAttribute("innerText");
            if (menuAtt1.contains(" Geo Zones")) {
                driver.findElements(By.cssSelector("ul#box-apps-menu li#app-")).get(y).click();
            }
        }
        int countriesLis = driver.findElements(By.cssSelector("table.dataTable tr.row td:nth-child(3) a")).size();
        for (int f = 1; f <= countriesLis; f++) {
            driver.findElements(By.cssSelector("table.dataTable tr.row td a")).get(f).click();
            List<WebElement> geoZone = driver.findElements(By.cssSelector("table#table-zones tbody tr:not(header) td:nth-child(3) select option[selected]"));
            List<String> geoZoneList = new ArrayList<>();
            for (WebElement g : geoZone) {
                geoZoneList.add(g.getAttribute("innerText"));
            }
            List<String> geoZoneSortedList = new ArrayList<>();
            for (String e : geoZoneList) {
                geoZoneSortedList.add(e);
            }
            Collections.sort(geoZoneSortedList);
            assertTrue(geoZoneList.equals(geoZoneSortedList));
            driver.get("http://localhost/litecard/admin/?app=geo_zones&doc=geo_zones");
        }
    }
}
