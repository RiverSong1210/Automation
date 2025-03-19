package com.tutorialspoint.tests;


import com.tutorialspoint.base.BaseTest;
import com.tutorialspoint.data.TestData;
import com.tutorialspoint.pages.StartPage;
import com.tutorialspoint.pages.SubCategoryPage;
import org.testng.annotations.Test;


public class FindSubCategoryTest extends BaseTest {

    @Test
    public void testFindAndClickSubCategory() {

        String category = testConfig.getCategory();
        String subCategory = testConfig.getSubCategory();

        SubCategoryPage categoryPage = new StartPage()
                .openStartPage()
                .clickCategoryButton()
                .selectCategoryName(category)
                .selectSubCategoryName(subCategory);

        categoryPage.verifySubCategoryPage(subCategory);
    }


    @Test
    public void testMultipleValidCategories() {

        TestData data = com.tutorialspoint.config.ConfigManager.loadTestData();

        for (TestData.Categories cat : data.getValidCategories()) {
            SubCategoryPage categoryPage = new StartPage()
                    .openStartPage()
                    .clickCategoryButton()
                    .selectCategoryName(cat.getCategory())
                    .selectSubCategoryName(cat.getSubCategory());

            categoryPage.verifySubCategoryPage(cat.getSubCategory());
        }
    }



}