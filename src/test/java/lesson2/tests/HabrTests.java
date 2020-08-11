package lesson2.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


class HabrTests {

    @Test
    void dropDownListShouldBeVisibleTest() {
        open("https://habr.com/ru/");
        
       $("#dropdown-control").click(); // нажать на раскрывающийся список
        
       $("#dropdown").shouldBe(visible); // проверить что раскрывающийся список доступен
    }

    @Test
    void languageShouldBeChangedOnRuntimeTest() {
        open("https://habr.com/ru/");
        
        $(".js-show_lang_settings").click(); // Нажать кнопку смены языка
        $(by("for", "hl_langs_en").click(); // Переключить язык
        
        //Проверить что текст заголовка переключился на английски
        $(".popup__head-title").shouldHave(text("Language settings"));
    }
    @Test
    void searchBarShouldBeVisibleTest() {
        open("https://habr.com/ru/");

        $(".btn_navbar_search").click(); // Кликнуть на кнопку поиска
        
        $("#search-form-field").shouldBe(visible); // Проверить что поле поиска появилось
    }
    @Test
    void logInFormShouldBeOpenedTest() {
        open("https://habr.com/ru/");
        
        $("#login").click(); // Нажать на кнопку Войти
        
        $("#login_form").shouldBe(visible); // Проверить что форма логина появилась
    }

    @Test
    void registrationFormShouldBeOpenedTest() {
        open("https://habr.com/ru/");
        
        $(".btn_navbar_registration").click(); // Нажать на кнопку Зарегестрироваться
        
        $("#register_form").shouldBe(visible); // Проверить что форма регистрации появилась
    }

}
