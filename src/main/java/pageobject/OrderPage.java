package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    private final WebDriver driver;
    //страница заказа
    private By personName = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/input");
    private By personLastName = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/input");
    private By personAddress = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[3]/input");
    private By metroStation = By.className("select-search__input");
    private By phoneNumber = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[5]/input");


    //страница аренды
    private By dateOrder = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/div/div/input"); //когда
    private By periodDate = By.className("Dropdown-control"); //срок
    private By blackColor = By.id("black");
    private By greyColor = By.id("grey");
    private By commentField = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[4]/input"); //комментарий
    private By ordeRent = By.xpath("//*[@id='root']/div/div[2]/div[3]/button[2]");//кнопка заказать из Аренды
    private By modalWindowButton = By.xpath(".//button[text() = 'Да']");// Да из модального окна


    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //относится к заполнению о клиенте
    public void fillOrderField(String firstName, String lastName, String address, String number) {
        driver.findElement(personName).sendKeys(firstName);
        driver.findElement(personLastName).sendKeys(lastName);
        driver.findElement(personAddress).sendKeys(address);
        driver.findElement(phoneNumber).sendKeys(number);
    }

    public void fillAutoCompleteOrderField(String metro) {
        final String metroOptionTemplate = ".//div[@class='select-search__select']//*[text()='" + metro + "']";
        driver.findElement(metroStation).sendKeys(metro);
        driver.findElement(By.xpath(metroOptionTemplate)).click();
    }


    public void сlickFuther() {
        final String furtherButton = ".//div[@class='Order_NextButton__1_rCA']//*[text()='Далее']";
        driver.findElement(By.xpath(furtherButton)).click();
    }

    //относится к заказу аренды
    public void fillRentField(String dateRent, String comment) {
        driver.findElement(dateOrder).sendKeys(dateRent);
        driver.findElement(blackColor).click();
        driver.findElement(commentField).sendKeys(comment);
    }


    public void fillPeriodRentField(String periodRent) {
        final String periodRentTemplate = ".//div[@class='Dropdown-menu']/div[text()='" + periodRent + "']";
        driver.findElement(periodDate).click();
        driver.findElement(By.xpath(periodRentTemplate)).click();
    }

    public void orderButton() {
        driver.findElement(ordeRent).click();
    }

    public void appearModalWindowOrderChekout() {
        final By textAboutImportantField = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div[text()='Хотите оформить заказ?']");
        driver.findElement(textAboutImportantField).isDisplayed();
    }


    public void modalWindowButton() {
        driver.findElement(modalWindowButton).click();
    }

    public void appearIssuedModalWindowOrderProcessed() {
        final By textAboutImportantField = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div[text()='Заказ оформлен']");
        driver.findElement(textAboutImportantField).isDisplayed();
    }

}
