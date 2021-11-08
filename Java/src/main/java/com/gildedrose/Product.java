package com.gildedrose;

public class Product {
    private static final int MAX_QUALITY = 50;
    private final Item item;

    public Product(String name, int sellIn, int quality) {
        this.item = new Item(name, sellIn, quality);
    }

    /**
     * degrades a product
     */
    public void degrade() {
        decreaseSellingDays();
        updateQuality();
    }

    private void updateQuality() {
        int newQuality = getQuality() + getModifier();
        if (MAX_QUALITY > newQuality) {
            if (newQuality < 0) {
                newQuality = 0;
            }
            setQuality(newQuality);
        }
    }

    void decreaseSellingDays() {
        setSellIn(getSellIn() - 1);
    }

    /**
     * modifier defines how a quality is changed
     *
     * @return the amount to add to the quality
     */
    protected int getModifier() {
        int modifier;
        if (getSellIn() >= 0) {
            modifier = -1;
        } else {
            modifier = -2;
        }
        return modifier;
    }

    public int getSellIn() {
        return item.sellIn;
    }

    private void setSellIn(int sellIn) {
        item.sellIn = sellIn;
    }

    protected void setQuality(int quality) {
        item.quality = quality;
    }

    public int getQuality() {
        return item.quality;
    }

    public String getName() {
        return item.name;
    }
}
