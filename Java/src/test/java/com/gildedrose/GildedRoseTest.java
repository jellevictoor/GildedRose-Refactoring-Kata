package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Product product = new Product("foo", 0, 0);
        GildedRose app = new GildedRose(Collections.singletonList(product));
        app.updateQuality();
        assertEquals("foo", app.getItems().get(0).getName());
    }

    @Test
    void agedBrieIncreasesQuality() {
        Product product = new AgingItem("Aged Brie", 5, 0);
        GildedRose app = new GildedRose(Collections.singletonList(product));
        app.updateQuality();
        assertEquals(1, app.getItems().get(0).getQuality());
    }

    @Test
    void backstagePassesIncreasesQualityMoreThan10days() {
        Product product = new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 11, 0);
        GildedRose app = new GildedRose(Collections.singletonList(product));
        app.updateQuality();
        assertEquals(1, app.getItems().get(0).getQuality());
    }

    @Test
    void backstagePassesIncreasesQualityBetween10and5days() {
        Product product = new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 6, 0);
        GildedRose app = new GildedRose(Collections.singletonList(product));
        app.updateQuality();
        assertEquals(2, app.getItems().get(0).getQuality());
    }

    @Test
    void backstagePassesIncreasesQualityLessThan5Days() {
        Product product = new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 4, 0);
        GildedRose app = new GildedRose(Collections.singletonList(product));
        app.updateQuality();
        assertEquals(3, app.getItems().get(0).getQuality());
    }

    @Test
    void backstagePassesWorthNothingAfterConcert() {
        Product product = new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 0, 20);
        GildedRose app = new GildedRose(Collections.singletonList(product));
        app.updateQuality();
        assertEquals(0, app.getItems().get(0).getQuality());
    }

    @Test
    void randomItemDecreasesQuality() {
        Product product = new Product("random item", 5, 10);
        GildedRose app = new GildedRose(Collections.singletonList(product));
        app.updateQuality();
        assertEquals(9, app.getItems().get(0).getQuality());
    }

    @Test
    void limitQualityTo50() {
        Product product = new AgingItem("Aged Brie", 5, 50);
        GildedRose app = new GildedRose(Collections.singletonList(product));
        app.updateQuality();
        assertEquals(50, app.getItems().get(0).getQuality());
    }

    @Test
    void SulfurasRemainsSame() {
        Product product = new LegendaryProduct("Sulfuras, Hand of Ragnaros", 5, 50);
        GildedRose app = new GildedRose(Collections.singletonList(product));
        app.updateQuality();
        assertEquals(50, app.getItems().get(0).getQuality());
        assertEquals(5, app.getItems().get(0).getSellIn());
        app.updateQuality();
        assertEquals(50, app.getItems().get(0).getQuality());
        assertEquals(5, app.getItems().get(0).getSellIn());

    }

    @Test
    void doubleExpirationRate() {
        Product product = new Product("foo", -1, 10);
        GildedRose app = new GildedRose(Collections.singletonList(product));
        app.updateQuality();
        assertEquals(8, app.getItems().get(0).getQuality());
    }

    @Test
    void qualityRemainsPositive() {
        Product product = new Product("foo", 10, 0);
        GildedRose app = new GildedRose(Collections.singletonList(product));
        app.updateQuality();
        assertEquals(0, app.getItems().get(0).getQuality());
        app.updateQuality();
        assertEquals(0, app.getItems().get(0).getQuality());
    }

    @Test
    void conjuredItemsDecreaseTwiceAsFast() {
        Product product = new ConjuredProduct("foo", 10, 12);
        GildedRose app = new GildedRose(Collections.singletonList(product));
        app.updateQuality();
        assertEquals(10, app.getItems().get(0).getQuality());
    }
}
