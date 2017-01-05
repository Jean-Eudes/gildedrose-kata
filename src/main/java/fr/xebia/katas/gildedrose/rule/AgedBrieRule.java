package fr.xebia.katas.gildedrose.rule;

import fr.xebia.katas.gildedrose.Item;

public class AgedBrieRule implements ItemRule {

    @Override
    public Item updateItem(Item item) {
        Item newItem = item.decreaseSellIn();
        return newItem.updateQuality(1);
    }

}
