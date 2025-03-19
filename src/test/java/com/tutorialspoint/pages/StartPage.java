package com.tutorialspoint.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class StartPage  {


    private final String mainCategoryButton = "button[aria-controls=\"category\"]";
    private final ElementsCollection categories = $$("div.categories-menu ul li.category-button");
    private final ElementsCollection subCategories = $$(".categories-menu-section ul li a");

    public StartPage openStartPage() {
        open("https://www.tutorialspoint.com/css/index.htm");
        return this;
    }

    public StartPage clickCategoryButton() {
        $(mainCategoryButton).click();
        return this;
    }

    public StartPage selectCategoryName(String categoryName) {
        //categories.findBy(text(categoryName)).click();
        searchElement(categoryName, categories).click();
        return this;
    }

    public SubCategoryPage selectSubCategoryName(String subCategoryName) {
        //subCategories.findBy(text(subCategoryName)).click();
        searchElement(subCategoryName, subCategories).click();
        return new SubCategoryPage();
    }

    public SelenideElement searchElement (String name, ElementsCollection elements) {
        return elements.shouldHave(CollectionCondition
                .anyMatch("Search for category",
                el -> el.getText().trim().equalsIgnoreCase(name)))
                .find(text(name));
    }

}

