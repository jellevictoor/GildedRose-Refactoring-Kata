package com.gildedrose;

public class LegendaryProduct extends Product {
    public LegendaryProduct(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void degrade() {
        // legendary
    }
}
