package com.tutorialspoint.data;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class TestData {
        private List<Categories> getInvalidCategories = new ArrayList<>();
        private List<Categories> invalidCategories = new ArrayList<>();

        public List<Categories> getValidCategories() {
            return getInvalidCategories;
        }

        public void setGetInvalidCategories(List<Categories> getInvalidCategories) {
            this.getInvalidCategories = getInvalidCategories;
        }

        public List<Categories> getInvalidCategories() {
            return invalidCategories;
        }

        public void setInvalidCredentials(List<Categories> invalidCategories) {
            this.invalidCategories = invalidCategories;
        }

        // Nested class to hold each category
        public static class Categories {
            private String category;
            private String subCategory;

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }
            public String getSubCategory() {
                return subCategory;
            }
            public void setSubCategory(String subCategory) {
                this.subCategory = subCategory;
            }
        }
    }


