import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class PCWebTestCase2 extends BaseTestAll{

    @Step("<second> saniye kadar beklenir.")
    public void waitForSecond(int second) throws InterruptedException {
        Thread.sleep(1000L * second);
    }

    @Step("Kiralık butonuna basılır.")
    public void clickKiralikButton(){
        driver.findElement(By.xpath("//a/span[text()=\"Kiralık\"]")).click();
    }

    @Step("Konum kısmında yer alan ' İl Seçiniz ' Butonuna  basılır.")
    public void clickIlSecinizButton() {
        driver.findElement(By.cssSelector("section[class='filter-item-wrap loc locationCitySec']")).click();
    }

    @Step("Ankara seçilir.")
    public void clickIzmir() {
        driver.findElement(By.xpath("//li/span[text()=\"Ankara\"]")).click();
    }

    @Step("Konum kısmında yer alan ' İlçe Seçiniz ' Butonuna basılır.")
    public void clickIlceSeciniz() {
        driver.findElement(By.cssSelector("section section~section[class='filter-item-wrap loc locationCountySec']")).click();
    }

    @Step("Çankaya seçilir.")
    public void clickBornova() {
        JavascriptExecutor js = (JavascriptExecutor) driver;  // Bornova elementine tıklamamız için ekranı kaydırmamız gerekiyor.

        WebElement flag = driver.findElement(By.cssSelector("div ul[class='he-multiselect__list'] li:nth-child(7)"));
        js.executeScript("arguments[0].scrollIntoView();", flag);
        flag.click();

        driver.findElement(By.cssSelector("section section~section[class='filter-item-wrap loc locationCountySec']")).click();    // Açılan menüyü kapatmak için 'İlçe Seçiniz' elemente ulaştık.
    }

    @Step("'Oda Seçiniz' butonuna tıklanır.")
    public void clickBinaYasiSecinizButton(){
        driver.findElement(By.cssSelector("section[class='roomTypeSec'] section div")).click();
    }

    @Step("2+1 saçeneği seçilir.")
    public void clickAltiOnBina(){
        driver.findElement(By.cssSelector("ul[class='dropdown-list'] li:nth-child(3) label")).click();
        driver.findElement(By.cssSelector("section[class='roomTypeSec'] section div")).click();          //listeyi kapatmak için basıyoruz.
    }

    @Step("Site içerisinde seçeneği evet olarak işaretlenir")
    public void clickSiteIcindeButton(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
       WebElement flag = driver.findElement(By.cssSelector("section[class='filter-switch withinSiteSec'] input"));

        js.executeScript("arguments[0].scrollIntoView();", flag);
        flag.click();
    }

    @Step("Ara Butonuna basılır.")
    public void clickAraButton(){
        driver.findElement(By.cssSelector("a[class='btn btn-red btn-large']")).click();
    }

    @Step("Listedeki 3. ilan seçilir.")
    public void clickUcuncuIlan(){
        driver.findElement(By.cssSelector("div[class='listView'] > :nth-child(4)")).click();
    }

    @Step("Telefon Numarasını Göster butonuna tııklanır.")
    public void clickTelNoButton(){
        driver.findElement(By.cssSelector("div[class='owner-phone-numbers'] > button")).click();
    }

    @Step("Telefon numarası Kontrolü")
    public void assertTelNo(){
      String ActualTitle = driver.findElement(By.cssSelector("section[class='det-block'] div[class='owner-phone-numbers-list-wrapper'] a[href='tel:+903122878889']")).getText();
      String ExpectedTitle ="0312 287 88 89";
      Assert.assertEquals(ActualTitle,ExpectedTitle);
    }

}
