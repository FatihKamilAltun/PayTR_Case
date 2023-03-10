package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.*;
import java.util.List;

public class AmazonStepDefinitions {
    AmazonPage amazonPage = new AmazonPage();
    String path = "C:\\Users\\FatihKamil\\Desktop\\UrunBilgileri.txt";
    File file = new File(path);
    FileWriter fileWriter = new FileWriter(path);

    public AmazonStepDefinitions() throws IOException {
    }

    @Given("Kullanici {string} anasayfasinda")
    public void kullaniciAnasayfasinda(String wantedUrl) {
        Driver.getDriver().get(ConfigReader.getProperty(wantedUrl));
        // ConfigReader araciligi ile configuration.properties dosyasinda olusturulan bilgiler koda alinarak kod daha dinamik hale getirildi.

    }

    @And("Kullanici cookieleri kabul eder")
    public void kullaniciCookieleriKabulEder() {
        amazonPage.acceptCookies.click();
    }

    @And("Kullanici {string} sayfasinda oldugunu dogrular")
    public void kullaniciSayfasindaOldugunuDogrular(String expectedUrl) {
        String pageUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(pageUrl,ConfigReader.getProperty(expectedUrl));
        // amazon.com.tr sayfasina gidildigini dogrulamak icin,
        // sayfanin url'si getCurrentUrl() methodu ile bir String konteynerina konuldu.
        // Gidilmek istenen sayfanin url'sinin gidilen sayfanin url'sine esit oldugunun
        // Assert class'i yardimiyla dogrulanmasi ile dogru sayfaya gidildigi anlasildi.
    }

    @Then("Kullanici {string} aratir")
    public void kullaniciAratir(String wantedWord) {
        amazonPage.searchBox.sendKeys(wantedWord + Keys.ENTER);
        // Arama cubuguna, .feature uzantili file'daki parametreli bolume yazilan urunun adi girildi,
        // ardindan Keys classi kullanilarak klavyedeki ENTER tusuna basilarak arama gerceklestirildi
    }

    @And("Kullanici sonuc sayfasindan ilk sonuca tiklar")
    public void kullaniciSonucSayfasindanIlkSonucaTiklar() {
        amazonPage.firstResult.click();
    }

    @And("Kullanici urunun fiyat, seri adi ve CPU modeli bilgilerini bir dosyaya yazdirir")
    public void kullaniciUrununFiyatSeriAdiVeCPUModeliBilgileriniBirDosyayaYazdirir() throws IOException {
        String price="";
        List<WebElement> priceList=Driver.getDriver().findElements(By.xpath("//div/span/span/span"));
        for (int i = 0; i < 3; i++) {
            price+=priceList.get(i).getText();

        }
        if (file.exists()){

        }else {
            file.createNewFile();
        }
        fileWriter.write("Urun Fiyati: " + price);
        fileWriter.write("\n");
        // Urunun fiyati get.Text() methodu ile alinarak String bir konteyner'a atildi.
        // File class'i kullanilarak projenin kosulacagi bilgisayarin masaustunde
        // 'UrunBilgileri.txt' isminde bir dosya olmamasi durumunda bu isimde bir dosya create edildi.
        // FileWriter class'i kullanilarak String'e atilan urun fiyati bu dosyaya yazdirildi.
        // Eger testin kosulacagi bilgisayarin masa??st??nde
        // 'UrunBilgileri.txt' isimli bir dosya mevcut ise urunun bilgileri bu dosyanin uzerine yazilmis oldu.

        List<WebElement> tableList = Driver.getDriver().findElements(By.xpath("//tr/td/span"));
        int count = 0;
        for (WebElement w : tableList) {
            if (w.getText().equalsIgnoreCase("Seri")) {
                String modelAdi = "Seri Ad??: " + tableList.get(count + 1).getText();
                fileWriter.write(modelAdi);
                fileWriter.write("\n");

            } else if (w.getText().equalsIgnoreCase("CPU Modeli")) {
                String cpuModel = "CPU Modeli: " + tableList.get(count + 1).getText();
                fileWriter.write(cpuModel);
                fileWriter.close();

            }
            count++;
        }
        // Urunun seri adi ve CPU modelinin bulundugu table seklinde olusturulan kisimdaki WebElementler bir List'e atildi.
        // Bu List'teki her WebElement'in text'i tek tek kontrol edilerek 'Seri'ye ve 'CPU Modeli'ne esit olmas?? durumunda
        // kendilerinden bir sonra gelen WebElement'in text bilgileri
        // daha onceden olusturulmus olan 'UrunBilgileri.txt' uzant??l?? dosyaya FileWriter class'i yardimiyla yazdirildi.
        // Zira 'Seri'den sonra gelen WebElement'in text bilgisi urunun seri adini,
        // ayni sekilde 'CPU Modeli'nden sonra gelen WebElement'in text bilgisi de urunun CPU modeli bilgisini icermektedir.
        // Not: Soruda verilen 'model adi' bilgisi yerine urunun ozelliklerinde yer alan 'Seri' bilgisi alinmistir
    }

    @And("Kullanici sayfayi kapatir")
    public void kullaniciSayfayiKapatir() {
        Driver.closeDriver();
    }



}
