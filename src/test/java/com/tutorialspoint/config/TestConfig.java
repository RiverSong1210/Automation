package com.tutorialspoint.config;

/**
 * Plain Java object matching the fields in test-config.json
 */
public class TestConfig {
    private String baseUrl;
    private String category;
    private String subCategory;

    public TestConfig() {
    }

    public TestConfig(String baseUrl, String category, String subCategory) {
        this.baseUrl = baseUrl;
        this.category = category;
        this.subCategory = subCategory;
    }

    public String getBaseUrl() {
        return baseUrl;
    }
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String categoryName) {
        this.category = categoryName;
    }
    public String getSubCategory() {
        return subCategory;
    }
    public void setSubCategory(String subCategoryName) {
        this.subCategory = subCategoryName;
    }
}

