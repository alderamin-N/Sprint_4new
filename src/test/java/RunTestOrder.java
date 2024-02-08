import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.HomePage;
import pageobject.OrderPage;

import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class RunTestOrder {
    WebDriver driver;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String number;
    private final String metro;
    private final String dateRent;
    private final String comment;
    private final String periodRent;

    private final String orderButton;
    final private By cookieButton = By.id("rcc-confirm-button");

    public RunTestOrder(String firstName, String lastName, String address, String number, String metro, String dateRent,
                        String comment, String periodRent, String orderButton) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.number = number;
        this.metro = metro;
        this.dateRent = dateRent;
        this.comment = comment;
        this.periodRent = periodRent;
        this.orderButton = orderButton;
    }

    @Parameterized.Parameters
    public static Object[][] getTestDate() {
        return new Object[][]{
                {"Александр", "Пушкин", "119049, г Москва, ул Донская, д 18", "89639633636", "Сокольники", "10.02.2024", "Комментарий 1", "сутки", "Заказ вверху"},
                {"Федор", "Достоевский", "101000, г Москва, ул Пушкина, д 7", "+75635635656", "Лубянка", "11.02.2024", "Комментарий 2", "двое суток", "Заказ внизу"},
        };
    }

    @Before
    public void startTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(cookieButton).click();
    }


    @Test
    public void shouldCheckOrderTest() {
        HomePage homePage = new HomePage(driver);
        if (orderButton.equals("Заказ вверху")) {
            homePage.clickOrderTopButton();
        } else {
            homePage.clickOrderDownButton();
        }

        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillAutoCompleteOrderField(metro);
        orderPage.fillOrderField(firstName, lastName, address, number);
        orderPage.сlickFuther();
        orderPage.fillRentField(dateRent, comment);
        orderPage.fillPeriodRentField(periodRent);
        orderPage.orderButton();
        orderPage.appearModalWindowOrderChekout();
        orderPage.modalWindowButton();
        orderPage.appearIssuedModalWindowOrderProcessed();
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
