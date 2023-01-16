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
    String path = "C:\\Users\\FatihKamil\\Desktop\\payTR.txt";
    File file = new File(path);
    FileWriter fileWriter = new FileWriter(path);

    public AmazonStepDefinitions() throws IOException {
    }

    @Given("Kullanici {string} anasayfasinda")
    public void kullaniciAnasayfasinda(String expectedUrl) {
        Driver.getDriver().get(ConfigReader.getProperty(expectedUrl));

    }

    @And("Kullanici cookieleri kabul eder")
    public void kullaniciCookieleriKabulEder() {
        amazonPage.acceptCookies.click();
    }

    @And("Kullanici {string} sayfasinda oldugunu dogrular")
    public void kullaniciSayfasindaOldugunuDogrular(String expectedTitle) {
        String pageTitle = Driver.getDriver().getTitle();
        assert pageTitle.contains(expectedTitle);
    }

    @Then("Kullanici {string} aratir")
    public void kullaniciAratir(String istenenKelime) {
        amazonPage.searchBox.sendKeys(istenenKelime + Keys.ENTER);
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
    }

    @And("Kullanici sayfayi kapatir")
    public void kullaniciSayfayiKapatir() {
        Driver.closeDriver();
    }


}
