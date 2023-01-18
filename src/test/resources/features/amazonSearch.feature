@wip
Feature: Amazon Search

  Background: Ortak adim
    Given Kullanici "amazonUrl" anasayfasinda

  Scenario: TC001 Kullanici amazonda 'MacBook Pro' aratir ve bilgilerini bir dosyaya yazdirir
    And Kullanici cookieleri kabul eder
    And Kullanici "Amazon" sayfasinda oldugunu dogrular
    Then Kullanici "lenovo ideapad 5 pro" aratir
    And Kullanici sonuc sayfasindan ilk sonuca tiklar
    And Kullanici urunun fiyat, seri adi ve CPU modeli bilgilerini bir dosyaya yazdirir
    And Kullanici sayfayi kapatir