package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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
    public void kullaniciAnasayfasinda(String expectedUrl) {
        Driver.getDriver().get(ConfigReader.getProperty(expectedUrl));
        // ConfigReader araciligi ile configuration.properties dosyasinda olusturulan bilgiler koda alinarak kod daha dinamik hale getirildi.

    }

    @And("Kullanici cookieleri kabul eder")
    public void kullaniciCookieleriKabulEder() {
        amazonPage.acceptCookies.click();
    }

    @And("Kullanici {string} sayfasinda oldugunu dogrular")
    public void kullaniciSayfasindaOldugunuDogrular(String expectedTitle) {
        String pageTitle = Driver.getDriver().getTitle();
        assert pageTitle.contains(expectedTitle);
        // amazon.com.tr sayfasina gidildigini dogrulamak icin, sayfanin basligi bir String konteynerina konuldu.
        // Sayfanin basliginda 'Amazon' kelimesinin icerdiginin dogrulanmasi ile dogru sayfaya gelindigi anlasildi.
    }

    @Then("Kullanici {string} aratir")
    public void kullaniciAratir(String istenenKelime) {
        amazonPage.searchBox.sendKeys(istenenKelime + Keys.ENTER);
        // Arama cubuguna, .feature uzantili file'daki parametreli bolume yazilan urunun adi girildi,
        // ardindan Keys classi kullanilarak klavyedeki ENTER tusuna basilarak arama gerceklestirildi
    }

    @And("Kullanici sonuc sayfasindan ilk sonuca tiklar")
    public void kullaniciSonucSayfasindanIlkSonucaTiklar() throws InterruptedException {
        amazonPage.firstResult.click();
    }

    @And("Kullanici urunun fiyat, model adi ve CPU modeli bilgilerini bir dosyaya yazdirir")
    public void kullaniciUrununFiyatModelAdiVeCPUModeliBilgileriniBirDosyayaYazdirir() throws IOException {
        String price=amazonPage.priceOfProduct.getText();
        if (file.exists()){

        }else {
            file.createNewFile();
        }
        fileWriter.write(price);
        fileWriter.write("\n");
        // Urunun fiyati get.Text() methodu ile alinarak String bir konteyner'a atildi.
        // File class'i kullanilarak projenin kosulacagi bilgisayarin masaustunde
        // 'UrunBilgileri.txt' isminde bir dosya olmamasi durumunda bu isimde bir dosya create edildi.
        // FileWriter class'i kullanilarak String'e atilan urun fiyati bu dosyaya yazdirildi

        List<WebElement> table = Driver.getDriver().findElements(By.xpath("//tr/td/span"));
        int count = 0;
        for (WebElement w : table) {
            if (w.getText().equalsIgnoreCase("Model Adı")) {
                String modelAdi = "Model Adı: " + table.get(count + 1).getText();
                fileWriter.write(modelAdi);
                fileWriter.write("\n");

            } else if (w.getText().equalsIgnoreCase("CPU Modeli")) {
                String cpuModel = "CPU Modeli: " + table.get(count + 1).getText();
                fileWriter.write(cpuModel);
                fileWriter.close();

            }
            count++;
        }
        // Urunun model adi ve CPU modelinin bulundugu table seklinde olusturulan kisimdaki WebElementler bir List'e atildi.
        // Bu List'teki her WebElement'in text'i tek tek kontrol edilerek 'Model Adı'na ve 'CPU Modeli'ne esit olması durumunda
        // kendilerinden bir sonra gelen WebElement'in text bilgileri
        // daha onceden olusturulmus olan 'UrunBilgileri.txt' uzantılı dosyaya FileWriter class'i yardimiyla yazdirildi.
        // Zira 'Model Adi'ndan sonra gelen WebElement'in text bilgisi urunun model adini,
        // ayni sekilde 'CPU Modeli'nden sonra gelen WebElement'in text bilgisi de urunun CPU modeli bilgisini icermektedir.
    }

    @And("Kullanici sayfayi kapatir")
    public void kullaniciSayfayiKapatir() {
        Driver.closeDriver();
    }


}
