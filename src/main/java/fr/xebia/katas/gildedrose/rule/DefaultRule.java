package fr.xebia.katas.gildedrose.rule;

import fr.xebia.katas.gildedrose.Item;

public class DefaultRule implements ItemRule {

    private int qualityDelta;

    public DefaultRule(int qualityDelta) {
        this.qualityDelta = qualityDelta;
    }

    @Override
    public Item updateItem(Item item) {
        Item newItem = item.decreaseSellIn();

        if (newItem.getSellIn() < 0) {
            return newItem.updateQuality(-2 * qualityDelta);
        }

        return newItem.updateQuality(-qualityDelta);
    }

}
