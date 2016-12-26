package fr.xebia.katas.gildedrose;

public class Item {

    private static final int MIN_QUALITY = 0;
    private static final int MAX_QUALITY = 50;

    private final String name;
    private final int sellIn;
    private final int quality;
    private final ItemRule itemRule;

    public Item(ItemRule itemRule, String name, int sellIn, int quality) {
        this.itemRule = itemRule;
        this.name = name;
        this.quality = quality;
        this.sellIn = sellIn;
    }

    public String getName() {
        return name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public Item update() {
        return itemRule.updateItem(this);
    }

    Item updateQuality(int increment) {
        int newQuality = quality + increment;
        if (newQuality > MAX_QUALITY) {
            newQuality = MAX_QUALITY;
        }
        if (newQuality < MIN_QUALITY) {
            newQuality = MIN_QUALITY;
        }
        return new Item(itemRule, name, sellIn, newQuality);
    }

    Item removeQuality() {
        return new Item(itemRule, name, sellIn, MIN_QUALITY);
    }

    Item decreaseSellIn() {
        return new Item(itemRule, name, sellIn - 1, quality);
    }

}
