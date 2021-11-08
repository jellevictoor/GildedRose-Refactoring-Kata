package com.gildedrose;

public class AgingItem extends Product {
    public AgingItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected int getModifier() {
        return 1;
    }
}
