package railnationpackage;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Steps {

    Page page;

    public Steps(WebDriver driver) {
        page = new Page(driver);
    }

    @Step("Заполнить поле Общее время минуты")
    public void findFieldTotalTimeM(String data) {
        page.getTotalTimeFieldMinRoute().sendKeys(data);
    }

    @Step("Заполнить поле 'Общее время секунды'")
    public void findFieldTotalTimeS(String data) {
        page.getTotalTimeFieldSecRoute().sendKeys(data);
    }

    @Step("Заполнить поле 'Время ожидания минуты'")
    public void findFieldWaitTimeM(String data) {
        page.getWaitingTimeFieldMinRoute().sendKeys(data);
    }

    @Step("Заполнить поле 'Время ожидания секунды'")
    public void findFieldWaitTimeS(String data) {
        page.getWaitingTimeFieldSecRoute().sendKeys(data);
    }

    @Step("Заполнить поле состояние поезда 1")
    public void findFieldChoise1(String data) {
        page.getFieldConditionTrainRoute().sendKeys(data);
    }

    @Step("Заполнить поле 'Доход с 1 вагона'")
    public void findFieldIncomeTrade(String data) {
        page.getFieldIncomeTrainCalculate().sendKeys(data);
    }

    @Step("Отметить чекбокс ускорение поезда в разделе 'Маршрут'")
    public void checkOnAccelerationTrain1() {
        page.getCheckBoxAccelerationRoute().select();
    }

    @Step("Отметить чекбокс скорость поезда в разделе 'Маршрут'")
    public void checkOnSpeedTrain1() {
        page.getCheckBoxSpeedRoute().select();
    }

    @Step("Выбор поезда для расчёта маршрута")
    public void changeTrain1(String valuetrain) {
        page.getChoiceTrain1().selectByValue(valuetrain);
    }

    @Step("Выбор поезд-а/ов для сравнения")
    public void changeTrain2(String valuetrain) {
        page.getChoiceTrain2().selectByValue(valuetrain);
    }

    @Step("Нажатие кнопки 1.Вычислить расстояние'")
    public void clickButton1() {
        page.getButtonCalcRoute().click();
    }

    @Step("Нажатие кнопки 2.Вычислить доход")
    public void clickButton2() {
        page.getButtonCalcIncome().click();
    }

    @Step("Проверка наличия текста ошибки на странице")
    public void chekEror() {
        assertThat("Ошибка", page.getEror().getText(), is(equalTo("Ошибка")));
    }

    @Step("Проверка наличия текста 'Теперь выберите поезда!'")
    public void chekCalculateTrue() {
        assertThat("Расчёт маршрута прошёл успешно", page.getCalcTrue().getText(), is(equalTo("Теперь выберите поезда!")));
    }

    @Step("Клик по ссылке 'Свой поезд' на странице")
    public void clickLink() {
        page.getLinkText().click();
    }
}

