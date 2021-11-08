package com.gildedrose;

public class ConjuredProduct extends Product {
    public ConjuredProduct(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected int getModifier() {
        return -2;
    }
}
