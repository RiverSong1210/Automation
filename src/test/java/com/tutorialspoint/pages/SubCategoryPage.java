package com.tutorialspoint.pages;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class SubCategoryPage {

    private final String heading = ".heading";

    public void verifyHeadingContains(String subCategory) {
        $$(heading).findBy(text(subCategory)).shouldBe(visible);
    }

    public void verifyPageContains(String subCategory) {
        $x("//*[@id='mainContent']/h1").shouldHave(text(subCategory)).shouldBe(visible);
    }


    // Verify that you are on SubCategoryPage
    public void verifySubCategoryPage(String subCategory) {
        verifyHeadingContains(subCategory);
        verifyPageContains(subCategory);
    }


}

