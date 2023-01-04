import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;

public class TestCardForm {
    @Test
    void shouldTestWithSpace() {
        open("http://0.0.0.0:9999/");
        $("[data-test-id=name] input").setValue("Василий Паршенцев");
        $("[data-test-id=phone] input").setValue("+79110922037");
        $("[data-test-id=agreement]").click();
        $("div button.button").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void shouldTestWithHyphen() {
        open("http://0.0.0.0:9999/");
        $("[data-test-id=name] input").setValue("Василий-Оглы Паршенцев-Иванов");
        $("[data-test-id=phone] input").setValue("+79110922037");
        $("[data-test-id=agreement]").click();
        $("div button.button").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}
