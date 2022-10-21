package ru.netology.web;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

class CallbackTest {
    SelenideElement notification = $("[data-test-id=notification]");

    @Test
    void positiveTest() {
        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").setValue("12.12.2022");
        $("[data-test-id=name] input").setValue("Степанова Инна-Анна");
        $("[data-test-id=phone] input").setValue("+79851452364");
        $("[data-test-id=agreement]").click();
        $("[class=button__text]").click();
        $("[data-test-id=notification]").shouldBe(visible, Duration.ofSeconds(15));
        notification.$x(".//div[@class='notification__title']").should(text("Успешно!"));
        notification.$x(".//div[@class='notification__content']").should(text("Встреча успешно забронирована на 12.12.2022"));
    }
}