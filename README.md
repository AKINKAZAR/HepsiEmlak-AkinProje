# HepsiEmlak-AkinProje

- This project works on Google Chrome browser.
- You need to downloads chrome web driver and add this driver to Driver class.  -> Driver link: https://chromedriver.chromium.org/downloads 
- Created as a Gauge project and added Selenium to their dependencies.
- Before Running the project, you need to select the browser startup as mobile or web from BaseTestAll.
- A living documentation has been created with BDD logic in Spec files.
- The project includes 4 scenario , 2 web and 2 mobile.
- Mobile cases are made with iphone8 screen size. ( but you can run it from any mobile phone.)

 Scenario1 Case1 WEB: 
 
 1. Go to the home page of HepsiEmlak.com.
 2. Click on “Satılık” button. 
 3. Select from the filter field on the left: Izmir - Bornova; İş Yeri; Fiyat : 100.000 TL - 2.000.000 TL; Bina Yaşı: Sıfır Bina, 1-5, 6-10;
 4. Click "Ara" Button.
 5. Check for Tags in the filter area on top: Izmir - Bornova; İş Yeri; 100.000 TL - 2.000.000 TL; Sıfır Bina, 1-5, 6-10;
 
 Scenario2 Case1 MOBILE:
 
 1. Go to the home page of HepsiEmlak.com.
 2. Click on “Satılık” button.
 3. Click "Filtrele" button.
 4. Select from the filter field on the left: Izmir - Bornova; İş Yeri; Fiyat : 100.000 TL - 2.000.000 TL; Bina Yaşı: Sıfır Bina, 1-5, 6-10;
 5. Click "Ara" button.
 6. Click "Filtrele" button.
 7. Check for Tags in the filter area on top: Izmir - Bornova; İş Yeri; 100.000 TL - 2.000.000 TL; Sıfır Bina, 1-5, 6-10;
 
 Scenario3 Case2 WEB:
 
 1. Go to the home page of HepsiEmlak.com.
 2. Click on "Kiralık” button.
 3. Select from the filter field on the left: Ankara - Çankaya; Konut; 2+1; Site İçerisinde: Evet ;
 4. Click "Ara" Button.
 5. Go to the details of the 3rd house in the list.
 6. Click "Telefonu Göster" button.
 7. Check the correctness of the phone number.

 Scenario4 Case2 MOBILE:
 
 1. Go to the home page of HepsiEmlak.com.
 2. Click on "Kiralık” button.
 3. Click "Filtrele" button 
 4. Select from the filter field on the left: Ankara - Çankaya; Konut; 2+1; Site İçerisinde: Evet ;
 5. Click "Ara" Button.
 6. Go to the details of the 3rd house in the list.
 7. Click "Telefonu Göster" button.
 8. Check the correctness of the phone number.


    

 


