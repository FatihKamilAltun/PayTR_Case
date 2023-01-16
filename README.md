# 💻 PayTR Çalışma Senaryosu 💻
### Projede Kullandığım Toollar <br> 
[<a href="https://www.jetbrains.com/idea/features/" target="_blank" rel=”noopener”> <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQalKFwVDd0H7Xx8HaqWBbUmDRdrgxUoicGBZC0eIzTsww7Sev-ySXJ3in9Udv2R9CR3lo&usqp=CAU" alt="IntelliJ" width="50" height="50"/> </a>][intellij]
[<img height="50" width="50" src="https://raw.githubusercontent.com/github/explore/5b3600551e122a3277c2c5368af2ad5725ffa9a1/topics/java/java.png">][java]
[<img height="50" width="50" src="https://raw.githubusercontent.com/github/explore/5b3600551e122a3277c2c5368af2ad5725ffa9a1/topics/selenium/selenium.png">][selenium]
<img src="https://github.com/devicons/devicon/blob/master/icons/cucumber/cucumber-plain.svg" title="Cucumber" alt="Cucumber" width="50" height="50"/>
[<img width="50" src="https://raw.githubusercontent.com/github/explore/80688e429a7d4ef2fca1e82350fe8e3517d3494d/topics/postgresql/postgresql.png" />][postgresql]
[<img width="50" src="https://raw.githubusercontent.com/github/explore/80688e429a7d4ef2fca1e82350fe8e3517d3494d/topics/sql/sql.png" />][sql]
[<img height="50" width="50" src="https://raw.githubusercontent.com/github/explore/5b3600551e122a3277c2c5368af2ad5725ffa9a1/topics/github/github.png">][github]

[intellij]: https://www.jetbrains.com/idea/download/#section=windows
[java]: https://www.java.com/
[selenium]: https://www.selenium.dev/
[cucumber]: https://cucumber.io/
[postgresql]: https://www.postgresql.org/
[sql]: https://www.w3schools.com/sql/
[github]: https://github.com/FatihKamilAltun

<hr>

## Proje Hakkında
### 1️⃣ Otomasyon Test Projesi
### Framework

⚡Otomasyon kodlarımı yazarken Java programlama dilini ve Selenium kütüphanesini kullandım <br>
⚡Java programlama dili ile birlikte OOP (Object - Oriented Programming) konseptini kullandım <br>
⚡Cucumber frameworkunu POM (Page Object Model) modeli üzerine oluşturdum <br>
⚡'test' package'inin altinda 'pages', 'runners', 'stepDefinitions', 'utilities' package'leri oluşturdum <br>
![image](https://user-images.githubusercontent.com/111094536/212743663-796756e4-79a1-40e2-a456-ffcda60b6d23.png) <br> <br>

### Kodlama
⚡Kodlarımı yazarken solid prensiplerine uyarak clean yazmaya dikkat ettim <br>
⚡Verilen task kapsamında ilgili sitenin locate'lerini alarak 'AmazonPage' class'ına koydum ve daha sonra bu class'tan oluşturduğum obje ile bu locate'leri kullandım <br>
⚡'features' package'inin altinda olusturdugum .feature uzantılı dosyada test steplerini Gherkin Language ile yazdım <br>
⚡.feature uzantılı dosyada yazdığım steplerin kodlarını 'AmazonStepDefinitions' class'inda yazdım <br>
⚡Gherkin Language ile oluşturduğum adımlarıda bazı değerleri parametreli olarak oluşturarak daha dinamik bir kodlamayı hedefledim
<br> &emsp; ![image](https://user-images.githubusercontent.com/111094536/212753751-6c8808d6-4eba-4084-8d17-0cc994c7881b.png)
⚡'configuration.properties' file'ini oluşturarak tekrar tekrar kullanılacak olan verileri buraya kaydettim ve bu verileri utilities package'i altindaki ConfigReader class'ı aracılığı ile dinamik bir şekilde kullandım <br> <br>

### Projenin Ayağa Kaldırılması
⚡Projem hem .feature file'indan hem de Runners class'indan ayağa kaldırılabilmektedir <br>
⚡Projenin ayağa kalkmasından sonra test adımları çalışarak sırasıyla, tarayıcı açılmakta, amazon.com.tr sayfasından 'Macbook Pro' isimli ürün aratılıp ilk çıkan sonucun ayrıntıları açılmakta daha sonrasında detayları görüntülenen ürünün fiyatı, model adı ve CPU modeli bir dosyaya yazdırılıp tarayıcı kapanmaktadır <br>
⚡File ve FileWriter class'ları sayesinde kullanıcının masaüstünde bir .txt uzantılı dosya oluşturularak aratılan ürünün istenen bilgileri bu dosyaya yazdırılmıştır <br>
⚡Önemle belirtmem gerekir ki, bu testi localinde koşmak isteyen kullanıcının projemin 'AmazonStepDefinitions' class'inin 18. satırındaki path değişkenindeki dosya yolunu kendi bilgisayarına uyarlaması gerekmektedir <br>
⚡Aşağıdaki linkte testin koşum videosu bulunmaktadır <br>
https://www.loom.com/share/c045b738c7494ed5b85f175937658cb8
<br> <br>

### Raporlama
⚡'runners' package'i altındaki Runner class'ındaki plugin sayesinde kod her çalıştığında .html uzantılı bir dosya oluşturularak raporlarım bu dosyaya kaydedildi <br>
⚡Bu .html uzantılı dosyayı tarayıcıda açtığımda bana raporları sağlıklı bir şekilde verdi 
![WhatsApp Görsel 2023-01-16 saat 22 35 44](https://user-images.githubusercontent.com/111094536/212754314-b607a803-b640-472d-9afb-a96bb6e49026.jpg) 
![image](https://user-images.githubusercontent.com/111094536/212754516-d103f3c6-8176-4a6d-a8e5-b520f75603d4.png)
![image](https://user-images.githubusercontent.com/111094536/212754460-715fb746-cc55-435b-a917-bca244692912.png) 



### 2️⃣ Manuel Test Case Yazımı
⚡Manuel test case'leri 'Microsoft Excel Çalışma Sayfasında' oluşturdum <br>
⚡Manuel test case yazarken minimum test step'i ile maksimum alanı test etmeye odaklandım <br>
⚡Manuel test case'lerimde US_001'de pozitif login testinin senaryosunu oluştururken US_002'de negatif login test senaryoları oluşturdum <br>
⚡Manuel test case'lerimi Otomasyon Test projemin içerisine ekledim
![Adsız](https://user-images.githubusercontent.com/111094536/212745153-db7687a0-ebbd-4b62-ac12-d3a0ad0af42c.png) 
<hr>



### 3️⃣ SQL Sorguları
⚡SQL sorgularını yazarken PostgreSQL toolunu kullandım <br>
⚡Sorguları yazmadan önce bana verilen table'ı create ettim <br>
⚡SQL sorgularını yazdığım file'ı Otomasyon Test projemde 'soruDosyasi' package'i içerisine 'SqlKomutlari' file'i ile ekledim
![WhatsApp Görsel 2023-01-16 saat 21 31 52](https://user-images.githubusercontent.com/111094536/212746099-d5cb57c6-b35a-4749-9f80-2016718c265e.jpg)
<hr>



### 4️⃣ Genel Kod Yazım Standartları Çalışması
⚡Task'de verilen kod parçasını genel kod yazım standartlarına uygun olarak düzenleyerek yeniden yazdım <br>
⚡Kod parçasındaki en önemli hatalar Türkçe karakterlerin kullanılması, keywordlerin büyük harfle başlamasıydı <br>
⚡Bu çalışmamı da Otomasyon Test projemde 'soruDosyasi' package'i içerisine 'GenelKodYazimStandartlari' file'i ile ekledim
![WhatsApp Görsel 2023-01-16 saat 21 41 09](https://user-images.githubusercontent.com/111094536/212746962-e0699a12-dc7c-4328-9ec3-94db6d6d6199.jpg)




<hr>
