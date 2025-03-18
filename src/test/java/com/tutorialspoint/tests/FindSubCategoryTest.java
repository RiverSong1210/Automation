package com.tutorialspoint.tests;


import com.tutorialspoint.base.BaseTest;
import com.tutorialspoint.data.TestData;
import com.tutorialspoint.pages.StartPage;
import com.tutorialspoint.pages.SubCategoryPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.annotations.Test;


public class FindSubCategoryTest extends BaseTest {

    @Test
    public void testFindAndClickSubCategory() {
        // 1. testConfig is loaded in BaseTest
        String category = testConfig.getCategory();
        String subCategory = testConfig.getSubCategory();



        // 2. Use them in your test steps
        SubCategoryPage categoryPage = new StartPage()
                .openStartPage()
                .clickCategoryButton()
                .selectCategoryName(category)
                .selectSubCategoryName(subCategory);

        categoryPage.verifySubCategoryPage(subCategory);
    }


    @Test
    public void testMultipleValidCategories() {
        // Load test data (arrays of valid/invalid credentials)
        TestData data = com.tutorialspoint.config.ConfigManager.loadTestData();

        // For each valid credential set, do a quick test
        for (TestData.Categories cat : data.getValidCategories()) {
            SubCategoryPage categoryPage = new StartPage()
                    .openStartPage()
                    .clickCategoryButton()
                    .selectCategoryName(cat.getCategory())
                    .selectSubCategoryName(cat.getSubCategory());

            categoryPage.verifySubCategoryPage(cat.getSubCategory());
        }
    }


   @Test

   public void testInvalidCredentials() {
      TestData data = com.tutorialspoint.config.ConfigManager.loadTestData();
      for (TestData.Categories cat : data.getInvalidCategories()) {
          StartPage startPage = new StartPage()
                  .openStartPage()
                  .clickCategoryButton()
                  .selectCategoryName(cat.getCategory())
                  .clickSubCategoryFail(cat.getSubCategory());
        }
    }
}