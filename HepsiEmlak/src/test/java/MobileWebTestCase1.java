import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class MobileWebTestCase1 extends BaseTestAll {

    @Step("cookie kapatılır.")
    public void closeCookie(){
        driver.findElement(By.cssSelector("div[class='cookie-policy'] button")).click();
    }

    @Step("Satılık Butonuna Basılır..")
    public void clickSatilikButton(){
        driver.findElement(By.cssSelector("div[class='link-sliding'] a[href='/satilik']")).click();
    }

    @Step("Filtrele Butonuna Basılır.")
    public void clickFiltreleButton(){
        driver.findElement(By.cssSelector("div[class='list-basetab'] button ~ button")).click();
    }

    @Step("İl Seçiniz Butonuna Basılır..")
    public void clickIlseciniz(){
        driver.findElement(By.cssSelector("div[class='city'] select")).click();
    }

    @Step("Listeden İzmir seçilir.")
    public void clickIzmir(){
        driver.findElement(By.cssSelector("option[value='izmir']")).click();
        driver.findElement(By.cssSelector("div[class='city'] select")).click(); //listeyi kapatmak için kullandık.
    }

    @Step("İlçe Seçimi için İlçe Seçiniz Butonuna basılır.")
    public void clickIlceButton(){
        driver.findElement(By.cssSelector("section[class='location'] section[class='select-content']")).click();
    }

    @Step("Bornova Seçimi yapılır.")
    public void clickBornovaIlcesi(){
        driver.findElement(By.xpath("//span[text()=\"Bornova\"]")).click();
    }

    @Step("Uygula Butonuna Basılır.")
    public void clickUygulaButton(){
        driver.findElement(By.cssSelector("#dropdown-lightbox-district > button")).click();
    }

    @Step("İşYeri Seçeneği Seçilir.")
    public void clickIsYeri(){
        driver.findElement(By.cssSelector("label[for='category1']")).click();
    }

    @Step("En Az alanına <cost> Bilgisi girilir.")
    public void sendMinCost(String cost) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
       WebElement flag = driver.findElement(By.cssSelector("section[class='price'] > div > div:nth-child(1) >input"));

       js.executeScript("arguments[0].scrollIntoView();", flag);

        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.cssSelector(" section[class='price'] > div > div:nth-child(1) >input")).sendKeys(cost);

    }

    @Step("En Çok alanına <cost> Bilgisi Girilir.")
    public void sendMaxCost(String cost){
        driver.findElement(By.cssSelector("section[class='price'] > div > div:nth-child(2) >input")).sendKeys(cost);
    }

    @Step("Bina Yaşı Seçiniz butonuna tıklanır.")
    public void clickBinaYasButton(){
        driver.findElement(By.cssSelector("section[class='building-age'] > section")).click();
    }

    @Step("Sıfır Bina yaşı Seçilir.")
    public void clickSifirBina(){
        driver.findElement(By.xpath("//span[text()=\"Sıfır Bina\"]")).click();
    }

    @Step("1-5 Bina yaşı Seçilir.")
    public void clickBirToBesBina(){
        driver.findElement(By.cssSelector("section[class='building-age']  ul :nth-child(3)")).click();
    }

    @Step("6-10 Bina yaşı Seçilir.")
    public void clickAltiOnBina(){
        driver.findElement(By.cssSelector("section[class='building-age']  ul :nth-child(4)")).click();
    }

    @Step("Bina Yaşlarını Onaylamak için Uygula butonuna basıılır.")
    public void clickYasUygulaButton(){
        driver.findElement(By.cssSelector("section[class='room-size'] ~ section >section button[class='btn btn-red filter-close']")).click();
    }

    @Step("Sonuçları Göster Butonuna Tıklanır.")
    public void clickSonuclariGoster(){
        driver.findElement(By.cssSelector("button[class='btn btn-red cardShadow3 get-result']")).click();
    }

    @Step("Filtrele Butonuna Basılır2")
    public void clickFiltreleButton2(){
        driver.findElement(By.cssSelector("div[class='wrapper basetap'] :nth-child(1)~button")).click();
    }

    @Step("Bina Yaşı 6-10 Kontrolü yapılır.")
    public void assertYasAltiOn(){
     String expectedTitle =  driver.findElement(By.cssSelector("div[class='swiper-container swiper-container-initialized swiper-container-horizontal swiper-container-ios'] >div>div:nth-child(1) p")).getText();
     String actualTitle = "6-10";
        Assert.assertEquals("Aynı Değer Dönüyor.",expectedTitle,actualTitle);
    }

    @Step("Bina Yaşı 1-5 Kontrolü yapılır.")
    public void assertYasBirBes(){
     String expectedTitle =  driver.findElement(By.cssSelector("div[class='swiper-container swiper-container-initialized swiper-container-horizontal swiper-container-ios'] >div>div:nth-child(2) p")).getText();
     String actualTitle = "1-5";
        Assert.assertEquals("Aynı Değer Dönmüyor.",expectedTitle,actualTitle);
    }

    @Step("Bina Yaşı Sıfır Bina Kontrolü yapılır.")
    public void assertYasSifir(){
     String expectedTitle =  driver.findElement(By.cssSelector("div[class='swiper-container swiper-container-initialized swiper-container-horizontal swiper-container-ios'] >div>div:nth-child(3) p")).getText();
     String actualTitle = "Sıfır Bina";
        Assert.assertEquals("Aynı Değer Dönmüyor.",expectedTitle,actualTitle);
    }

    @Step("Maximum Fiyat Bilgisi Kontrol Edilir.")
    public void assertYFiyatIkiMilyon(){
        JavascriptExecutor js = (JavascriptExecutor) driver;

     WebElement flag =  driver.findElement(By.cssSelector("div[class='swiper-container swiper-container-initialized swiper-container-horizontal swiper-container-ios'] >div>div:nth-child(4) p"));

     js.executeScript("arguments[0].scrollIntoView();", flag);
        String expectedTitle = flag.getText();
        String actualTitle = "2.000.000 TL";
        Assert.assertEquals("Aynı Değer Dönmüyor.",expectedTitle,actualTitle);
    }

    @Step("Minimum Fiyat Bilgisi Kontrol Edilir.")
    public void assertFiyatYuzBin(){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement flag =  driver.findElement(By.cssSelector("div[class='swiper-container swiper-container-initialized swiper-container-horizontal swiper-container-ios'] >div>div:nth-child(5) p"));

        js.executeScript("arguments[0].scrollIntoView();", flag);
        String expectedTitle = flag.getText();
        String actualTitle = "100.000 TL";
        Assert.assertEquals("Aynı Değer Dönmüyor.",expectedTitle,actualTitle);
    }

    @Step("Kategori Kontrol Edilir.")
    public void assertKategori(){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement flag =  driver.findElement(By.cssSelector("div[class='swiper-container swiper-container-initialized swiper-container-horizontal swiper-container-ios'] >div>div:nth-child(6) p"));

        js.executeScript("arguments[0].scrollIntoView();", flag);
        String expectedTitle = flag.getText();
        String actualTitle = "İşyeri";
        Assert.assertEquals("Aynı Değer Dönmüyor.",expectedTitle,actualTitle);
    }

    @Step("Durumu Kontrol Edilir.")
    public void assertDurumu(){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement flag =  driver.findElement(By.cssSelector("div[class='swiper-container swiper-container-initialized swiper-container-horizontal swiper-container-ios'] >div>div:nth-child(7) p"));

        js.executeScript("arguments[0].scrollIntoView();", flag);
        String expectedTitle = flag.getText();
        String actualTitle = "Satılık";
        Assert.assertEquals("Aynı Değer Dönmüyor.",expectedTitle,actualTitle);
    }






}














