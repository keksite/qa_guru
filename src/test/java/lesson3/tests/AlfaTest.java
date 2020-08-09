package lesson3.tests;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

class AlfaTest {
    static int CELL_SIZE = 3;

    @BeforeEach
    void openSite() {
        open("https://alfabank.ru/");
    }

    @Test
    void sizeOfElementsInCellBox() {

        $(byAttribute("title","Вклады")).hover();
        $(byAttribute("title","Депозиты")).click();
        $(byLinkText("Архивные депозиты")).click();
        SelenideElement cellBox= $(".product-cell__cell-box");
        cellBox.$$(".product-cell__cell ").shouldHaveSize(CELL_SIZE);

    }

    @Test
    void cellInNavigationBoxShouldHaveText() {
        $("#alfa").parent().$(byText("Вклады")).click();
        $(".layout.layout_type_inner").$(".navigation").$("li")
                .sibling(4).shouldHave(text("Страхование вкладов"));
    }
}