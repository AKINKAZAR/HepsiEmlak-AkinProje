import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class MobileWebTestCase2 extends BaseTestAll {

    @Step("Kiralık Butonuna Tıkla.")
    public void clickKiralikButton2() {
        driver.findElement(By.cssSelector("div[class='link-sliding'] a[href='/kiralik']")).click();
    }

    @Step("Filtrele Butonuna Tıkla2.")
    public void clickFiltreleButton3() {
        driver.findElement(By.cssSelector("div[class='list-basetab'] button ~ button")).click();
    }

    @Step("İl Seçiniz Butonuna Bas.")
    public void clickIlseciniz2() {
        driver.findElement(By.cssSelector("div[class='city'] select")).click();
    }

    @Step("Listeden Ankara seçilir.")
    public void clickAnkara() {
        driver.findElement(By.cssSelector("option[value='ankara']")).click();
        driver.findElement(By.cssSelector("div[class='city'] select")).click(); //listeyi kapatmak için kullandık.

    }

    @Step("İlçe Seçiniz Butonuna Bas.")
    public void clickIlceButton2(){
        driver.findElement(By.cssSelector("section[class='location'] section[class='select-content']")).click();
    }

    @Step("Çankaya Seçimini yap.")
    public void clickAnkaraIlcesi(){
        driver.findElement(By.xpath("//span[text()=\"Çankaya\"]")).click();
    }

    @Step("Uygula Butonuna Bas.")
    public void clickUygulaButton2(){
        driver.findElement(By.cssSelector("#dropdown-lightbox-district > button")).click();
    }

    @Step("'Oda Seçiniz' butonuna tıkla.")
    public void clickOdaYasiSecinizButton2(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement flag =  driver.findElement(By.cssSelector("section[class='room-type'] > section"));

        js.executeScript("arguments[0].scrollIntoView();", flag);
        flag.click();
    }

    @Step("2+1 Oda seç.")
    public void clickIkiArtiBirOda(){
        driver.findElement(By.cssSelector("section[class='room-type'] ul :nth-child(4)")).click();
    }

    @Step("Uygula Butonuna Bas2.")
    public void clickUygulaButton3(){
        driver.findElement(By.cssSelector("section[class='room-type'] button[class='btn btn-red filter-close']")).click();
    }

    @Step("Site İçerisinde İkonunu İşaretle.")
    public void clickSiteIciButton2() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement flag =  driver.findElement(By.cssSelector("section[class='within-site d-flex']"));

        js.executeScript("arguments[0].scrollIntoView();", flag);
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.cssSelector("section[class='within-site d-flex'] label")).click();
    }

    @Step("Sonuçları Göster Butonuna Tıkla.")
    public void clickSonuclariGoster2(){
        driver.findElement(By.cssSelector("button[class='btn btn-red cardShadow3 get-result']")).click();
    }

    @Step("3. İlan'a Tıkla.")
    public void clickUcuncuIlan2() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement flag =  driver.findElement(By.cssSelector("div[class='reality-list'] > :nth-child(3) .inner >div.card-link"));

        js.executeScript("arguments[0].scrollIntoView();", flag);
        TimeUnit.SECONDS.sleep(1);
        flag.click();
    }

    @Step("Telefonu Göster Butonuna Tıklaa.")
    public void clickTelNoGoster() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement flag =  driver.findElement(By.cssSelector("div[class='contact'] >button[class='btn btn-red btn-large']"));

        js.executeScript("arguments[0].scrollIntoView();", flag);
        TimeUnit.SECONDS.sleep(1);
        flag.click();
    }

    @Step("Telefon Numarasının Gerçekliğini Kontrol Et.")
    public void assertPhoneNumber2(){
        String ecpectedTitle = driver.findElement(By.cssSelector("a[href='tel:+903122878889']")).getText();
        String actualTitle = "0312 287 88 89";
        Assert.assertEquals("Numara Gerçek Değil",ecpectedTitle,actualTitle);
    }








}