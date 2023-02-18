import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class kirilldkoTest {

    // TC_1_1 - Тест кейс:
    // 1. Открыть страницу https://openweathermap.org/
    // 2. Набрать в строке поиска город Paris
    // 3. Нажать пункт меню Search
    // 4. Из выпадающего списка выбрать Paris, FR
    // 5. Подтвердить, что заголовок изменился на "Paris, FR"
    @Test
    // правило что где когда
    public void testH2TagText_WhenSearchingCityContry() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        

        String url = "https://openweathermap.org/";
        String cityName = "Paris";
        String expectedResult = "Paris, FR";

        //просим драйвер перейти на сайт
        driver.get(url);


        Thread.sleep(5000);// задержка на 5 секунд

        // даем команду драйверу найти эдемент
        // используем веб элемент силениума
        // field поле

        // By - тип даных, определение по которому мы ищем наш элемент
        // xpath - путь. пишем в ""
        WebElement searchCityField =driver.findElement(
                By.xpath("//div[@id ='weather-widget']/div/div/div//div/div/input[@placeholder='Search city']")
        );
        //нажать на строку
        searchCityField.click();
        // передать текст
        searchCityField.sendKeys(cityName);


        WebElement searchButton = driver.findElement(
                By.xpath("//button[@type='submit']")
        );
        searchButton.click();
        // даем секунду прогрузиться
        Thread.sleep(1000);


        //во всплывающем окне находим нужный город
        WebElement parisFRChoiceInDropdownMenu = driver.findElement(
                By.xpath("//ul[@class ='search-dropdown-menu']/li/span[text() = 'Paris, FR ']")
        );
        parisFRChoiceInDropdownMenu.click();

        // берем текст с вывески
        WebElement h2CityContryNameHeader = driver.findElement(
                By.xpath("//div[@id='weather-widget']//h2")
        );
        // заносим в переменную, что бы получить текст////

        Thread.sleep(2000);
        String actResult = h2CityContryNameHeader.getText();


        Assert.assertEquals(actResult,expectedResult);

        Thread.sleep(5000);
            driver.quit();

    }
}
