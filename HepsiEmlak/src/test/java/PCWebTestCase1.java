import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class PCWebTestCase1 extends BaseTestAll {

    @Step("HepsiEmlak Web Sayfasına Gidilir")
    public void navigateToHepsiEmlak(){
        driver.navigate().to("https://www.hepsiemlak.com/");
    }

    @Step("<second> Saniye kadar bekle.")
    public void waitForSecond(int second) throws InterruptedException {
        Thread.sleep(1000L * second);
    }

    @Step("Satılık butonuna basılır.")
    public void clickSatilikButton() {
        driver.findElement(By.xpath("//a/span[text()=\"Satılık\"]")).click();
    }

    @Step("Konum kısmında yer alan ' İl Seçiniz ' butonuna basılır.")
    public void clickIlSecinizButton() {
        driver.findElement(By.cssSelector("section[class='filter-item-wrap loc locationCitySec']")).click();
    }

    @Step("İzmir seçilir.")
    public void clickIzmir() {
        driver.findElement(By.xpath("//li/span[text()=\"İzmir\"]")).click();
    }

    @Step("Konum kısmında yer alan ' İlçe Seçiniz ' butonuna basılır.")
    public void clickIlceSeciniz() {
        driver.findElement(By.cssSelector("section section~section[class='filter-item-wrap loc locationCountySec']")).click();
    }

    @Step("Bornova seçilir.")
    public void clickBornova() {
        JavascriptExecutor js = (JavascriptExecutor) driver;  // Bornova elementine tıklamamız için ekranı kaydırmamız gerekiyor.

        WebElement flag = driver.findElement(By.cssSelector("div ul[class='he-multiselect__list'] li:nth-child(7)"));
        js.executeScript("arguments[0].scrollIntoView();", flag);
        flag.click();

        driver.findElement(By.cssSelector("section section~section[class='filter-item-wrap loc locationCountySec']")).click();    // Açılan menüyü kapatmak için 'İlçe Seçiniz' elemente ulaştık.
    }

    @Step("Kategori olarak ' İşyeri ' seçilir.")
    public void clickIsyeri() {
        driver.findElement(By.cssSelector("label[for='category1']")).click();
    }

    @Step("Minimum fiyat bilgisi <cost> olarak girilir.")
    public void sendMinFiyat(String cost) {
        driver.findElement(By.cssSelector("input[class='floating-input priceMin']")).sendKeys(cost);
    }

    @Step("Maximum fiyat bilgisi <cost> olarak girilir.")
    public void sendMaxFiyat(String cost) {
        driver.findElement(By.cssSelector("input[class='floating-input priceMax']")).sendKeys(cost);
    }

    @Step("'Bina Yaşı Seçiniz' butonuna tıklanır.")
    public void clickBinaYasiSecinizButton(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
       WebElement flag =  driver.findElement(By.cssSelector("section[class='buildingAgeSec'] section div"));

        js.executeScript("arguments[0].scrollIntoView();", flag);
        flag.click();
    }

    @Step("Sıfır Bina saçeneği seçilir.")
    public void clickSifirBina(){
        driver.findElement(By.cssSelector("ul[class='dropdown-list'] li:nth-child(1) label")).click();
    }

    @Step("1-5 saçeneği seçilir.")
    public void clickBirBesBina(){
        driver.findElement(By.cssSelector("ul[class='dropdown-list'] li:nth-child(2) label")).click();
    }

    @Step("6-10 saçeneği seçilir.")
    public void clickAltiOnBina(){
        driver.findElement(By.cssSelector("ul[class='dropdown-list'] li:nth-child(3) label")).click();
    }

    @Step("Ara butonuna basılır.")
    public void clickAraButton(){
        driver.findElement(By.cssSelector("a[class='btn btn-red btn-large']")).click();
    }

    @Step("Tag Kısmında il = İzmir kontrolü yapılır.")
    public void tagIlAssertion(){
       String ActualTitle = driver.findElement(By.cssSelector("ul[class='applied-filters-list'] li:nth-child(1) span:nth-child(2)")).getText();
       String ExpectedTitle = "İzmir";
       Assert.assertEquals(ActualTitle,ExpectedTitle);
    }

    @Step("Tag kısmında ilçe = Bornova kontrolü yapılır.")
    public void tagIlceAssertion(){
       String ActualTitle = driver.findElement(By.cssSelector("ul[class='applied-filters-list'] li:nth-child(2) span:nth-child(2)")).getText();
       String ExpectedTitle ="Bornova";
       Assert.assertEquals(ActualTitle,ExpectedTitle);
    }

    @Step("Tag kısmında Kategori = İşyeri kontrolü yapılır.")
    public void tagKategoriAssertion(){
        String ActualTitle = driver.findElement(By.cssSelector("ul[class='applied-filters-list'] li:nth-child(3) span:nth-child(2)")).getText();
        String ExpectedTitle ="İşyeri";
        Assert.assertEquals(ActualTitle,ExpectedTitle);
    }

    @Step("Tag kısmında Fiyet = 100.000 TL - 2.000.000 TL kontrolü yapılır.")
    public void tagFiyatAssertion(){
        String ActualTitle = driver.findElement(By.cssSelector("ul[class='applied-filters-list'] li:nth-child(4) span:nth-child(2)")).getText();
        String ExpectedTitle ="100.000 TL - 2.000.000 TL";
        Assert.assertEquals(ActualTitle,ExpectedTitle);
    }

    @Step("Tag kısmında Bina Yaşı = Sıfır Bina kontrolü yapılır.")
    public void tagBinaYasiSifirAssertion(){
        String ActualTitle = driver.findElement(By.cssSelector("li span[class='applied-filters-list-item']")).getText();
        String ExpectedTitle ="Sıfır Bina";
        Assert.assertEquals(ActualTitle,ExpectedTitle);
    }

    @Step("Tag kısmında Bina Yaşı = 1-5 kontrolü yapılır.")
    public void tagBinaYasiBirBesAssertion(){
        String ActualTitle = driver.findElement(By.cssSelector("ul > span[class='applied-filters-list-item']")).getText();
        String ExpectedTitle ="1-5";
        Assert.assertEquals(ActualTitle,ExpectedTitle);
    }

    @Step("Tag kısmında Bina Yaşı = 6-10 kontrolü yapılır.")
    public void tagBinaYasiAltiOnAssertion(){
        String ActualTitle = driver.findElement(By.cssSelector("ul > span[class='applied-filters-list-item last--item']")).getText();
        String ExpectedTitle ="6-10";
        Assert.assertEquals(ActualTitle,ExpectedTitle);
    }



}
