package fr.xebia.katas.gildedrose.rule;

import fr.xebia.katas.gildedrose.Item;

public class BackstageRule implements ItemRule {

    @Override
    public Item updateItem(Item item) {
        Item newItem = item.decreaseSellIn();

        // pattern matching :'(
        if (newItem.getSellIn() < 0) {
            return newItem.removeQuality();
        }

        if (newItem.getSellIn() < 5) {
            return newItem.updateQuality(3);
        }

        if (newItem.getSellIn() < 10) {
            return newItem.updateQuality(2);
        }

        return newItem.updateQuality(1);
    }

}
