package lesson2.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

class TestHabr {

    @BeforeEach
    void openSite(){
        open("https://habr.com/ru/");
    }

    @Test
    void dropDownListSholdBeVisible() {
        //нажать на раскрывающийся список
       $(byId("dropdown-control")).click();
       // проверить что раскрывающийся список доступен
       $(byId("dropdown")).shouldBe(visible);
    }

    @Test
    void languageShouldBeChangedOnRuntime() {
        //Нажать кнопку смены языка
        $(byCssSelector(".btn_navbar_lang")).click();
        //Переключить язык
        $("label[for='hl_langs_en']").click();
        //Проверить что текст заголовка переключился на английски
        $(".popup__head_lang-settings").shouldBe(text("Language settings"));
    }
    @Test
    void searchBarShouldBeVisible() {
        //Кликнуть на кнопку поиска
        $(".btn_navbar_search").click();
        //Проверить что поле поиска появилось
        $("#search-form-field").shouldBe(visible);
    }
    @Test
    void logInFormShouldBeOpened() {
        //Нажать на кнопку Войти
        $("#login").click();
        // Проверить что форма логина появилась
        $("#login_form").shouldBe(visible);
    }

    @Test
    void registrationFormShouldBeOpened() {
        //Нажать на кнопку Зарегестрироваться
        $(".btn_navbar_registration").click();
        //Проверить что форма регистрации появилась
        $("#register_form").shouldBe(visible);
    }

}