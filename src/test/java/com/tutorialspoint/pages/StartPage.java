package com.tutorialspoint.pages;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import static com.codeborne.selenide.Selenide.*;

public class StartPage  {


    private final String mainCategoryButton = "button[aria-controls=\"category\"]";

    // Open the URL of the login page
    public StartPage openStartPage() {
        open("https://www.tutorialspoint.com/css/index.htm");
        return this;
    }

    public StartPage clickCategoryButton() {
        $(mainCategoryButton).click();
        return this;
    }

    public StartPage selectCategoryName(String categoryName) {
        $x("//li[contains(@class, 'category-button') and text()='" + categoryName + "']").click();
        return this;
    }

    public SubCategoryPage selectSubCategoryName(String subCategoryName) {
        $x("//a[text()='" + subCategoryName + "']").click();
        // You will be redirected to subCategoryPage on success
        return new SubCategoryPage();
    }


    public StartPage clickSubCategoryFail(String subCategoryName) {
        $x("//a[text()='" + subCategoryName + "']").click();
        return this;
    }




}

