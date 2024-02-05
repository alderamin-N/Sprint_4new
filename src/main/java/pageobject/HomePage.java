package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    private final WebDriver driver;
    private final By orderTop = By.className("Button_Button__ra12g"); //кнопка Заказать вверху
    public final By orderDown = By.xpath("//div[@class='Home_FinishButton__1_cWm']/button");//кнопка Заказать внизу
    private final By answers = By.xpath(".//div[@class='accordion__panel']//*");//ответы
    private final By textAboutImportant = By.xpath(".//div[@class='accordion__panel']//*"); //текст ответов
    private final By headerAboutImportant = By.className("Home_FourPart__1uthg");//весь блок вопросов о важном

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void waitForLoadAccordionData() {
        new WebDriverWait(driver,  Duration.ofSeconds(30)).until(driver -> (driver.findElement(textAboutImportant).getText() != null
        ));
    }

    public String checkText(String textAboutImportantQuestion, int counter) {
        String textAnswers = null;
        final String questionOptionTemplate = ".//div[@class='accordion']//*[text()='" + textAboutImportantQuestion + "']";
        driver.findElement(By.xpath(questionOptionTemplate)).click();
        List<WebElement> answersList = driver.findElements(answers);
        waitForLoadAccordionData();
        for (int i = 0; i <= answersList.size(); i++) {
            textAnswers = answersList.get(counter).getText();
        }
        return textAnswers;
    }

    public void waitForLoadProfileData() {
        new WebDriverWait(driver,  Duration.ofSeconds(30)).until(driver -> (driver.findElement(headerAboutImportant).getText() != null
                && !driver.findElement(headerAboutImportant).getText().isEmpty()
        ));
    }


    public void clickOrderDownButton() {
        driver.findElement(orderDown).click();
    }

    public void clickOrderTopButton() {
        driver.findElement(orderTop).click();
    }

}
