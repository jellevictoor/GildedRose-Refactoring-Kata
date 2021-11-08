package com.gildedrose;

import java.util.List;

class GildedRose {
    private List<Product> products;

    public GildedRose(List<Product> products) {
        this.products = products;
    }

    public void updateQuality() {
        for (Product product : products) {
            product.degrade();
        }
    }

    public List<Product> getItems() {
        return products;
    }
}
