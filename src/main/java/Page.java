import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.*;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import ru.yandex.qatools.matchers.webdriver.TextMatcher;


public class Page extends HtmlElement {

    public Page(WebDriver driver){
        HtmlElementLoader.populatePageObject(this, driver);
    }

    public static final String REMEMBER_VALUE_ELEMENT = "Ошибка";

    @Name("Общее время: поле минуты в разделе 'Маршрут'")
    @FindBy(name = "obsee_vremja_1")
    private TextInput TotalTimeFieldMinRoute;

    @Name("Общее время: поле секунды в Разделе 'Маршрут'")
    @FindBy (name = "obsee_vremja_2")
    private TextInput TotalTimeFieldSecRoute;

    @Name("Время ожидания: поле минуты в разделе 'Маршрут'")
    @FindBy (name = "vrema_ozid_1")
    private TextInput WaitingTimeFieldMinRoute;

    @Name("Время ожидания: поле секунды в Разделе 'Маршрут'")
    @FindBy (name = "vrema_ozid_2")
    private TextInput WaitingTimeFieldSecRoute;

    @Name("Поле ускорение, для своего варианта поезда в разделе 'Маршрут' 0-20")
    @FindBy(name = "poezd_1_uskor_1")
    private TextInput AccelerationYourTrain;

    @Name("Поле скорость, для своего варианта поезда в разделе 'Маршрут'")
    @FindBy(name = "poezd_1_skor_1")
    private TextInput SpeedYourTrain;

    @Name("Поле состояние поезда в разделе 'Маршрут'")
    @FindBy (name = "sostojanie_1")
    private TextInput FieldConditionTrainRoute;

    @Name("Меню выбора поезда по которому мерили расстояние, раздел 'Маршрут'")
    @FindBy (name = "poezd_1")
    private Select ChoiceTrain1;

    @Name("Меню выбора поезда для сравнения, раздел 'Расчитать доход с поезда'")
    @FindBy (name = "poezd_2[]")
    private Select choiceTrain2;

    @Name("Поле 'Доход с 1-ого вагона' в разделе 'Расчитать доход с поезда'")
    @FindBy (name = "dohod_vagona")
    private TextInput fieldIncomeTrainCalculate;

    @Name("Чекбокс скорость в разделе 'Маршрут' подраздел 'Улучшения'")
    @FindBy (name = "poezd_1_ul[skorost]")
    private CheckBox checkBoxSpeedRoute;

    @Name("Чекбокс ускорение в разделе 'Маршрут' подраздел 'Улучшения'")
    @FindBy (name = "poezd_1_ul[uskorenie]")
    private CheckBox checkBoxAccelerationRoute;

    @Name("Кнопка '1.Вычислить расстояние'")
    @FindBy (name = "calc_1")
    private Button buttonCalcRoute;

    @Name("Кнопка '2.Вычислить доход'")
    @FindBy (name = "calc_2")
    private Button buttonCalcIncome;

    @Name("Линк 'Свой поезд'")
    @FindBy(partialLinkText = "Свой поезд")
    private Link linkText;

    @Name("Текст 'Ошибка'")
    @FindBy (css = "strong")
    private TextMatcher eror;

    public TextMatcher getEror() {
        return eror;
    }
    public TextInput getTotalTimeFieldMinRoute() { return TotalTimeFieldMinRoute; }
    public TextInput getTotalTimeFieldSecRoute() {
        return TotalTimeFieldSecRoute;
    }
    public TextInput getWaitingTimeFieldMinRoute() {
        return WaitingTimeFieldMinRoute;
    }
    public Select getChoiceTrain1() {
        return ChoiceTrain1;
    }
    public Select getChoiceTrain2() {
        return choiceTrain2;
    }
    public TextInput getWaitingTimeFieldSecRoute() {
        return WaitingTimeFieldSecRoute;
    }
    public TextInput getFieldConditionTrainRoute() {
        return FieldConditionTrainRoute;
    }
    public Button getButtonCalcIncome() {
        return buttonCalcIncome;
    }
    public CheckBox getCheckBoxSpeedRoute() {
        return checkBoxSpeedRoute;
    }
    public CheckBox getCheckBoxAccelerationRoute() {
        return checkBoxAccelerationRoute;
    }
    public TextInput getFieldIncomeTrainCalculate() {
        return fieldIncomeTrainCalculate;
    }
    public Button getButtonCalcRoute() {
        return buttonCalcRoute;
    }
    public Link getLinkText() {
        return linkText;
    }
}
