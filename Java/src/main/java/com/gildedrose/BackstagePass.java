package com.gildedrose;

public class BackstagePass extends Product {

    public BackstagePass(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected int getModifier() {
        int modifier;
        if (getSellIn() >= 10) {
            modifier = 1;
        } else if (getSellIn() >= 5) {
            modifier = 2;
        } else if (getSellIn() >= 0) {
            modifier = 3;
        } else {
            modifier = 0;
        }
        return modifier;
    }

    @Override
    public void degrade() {
        super.degrade();
        if (getSellIn() <= 0) {
            setQuality(0);
        }

    }
}
