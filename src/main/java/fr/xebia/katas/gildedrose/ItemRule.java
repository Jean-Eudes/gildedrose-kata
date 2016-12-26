package fr.xebia.katas.gildedrose;

public enum ItemRule {

    AGED_BRIE {
        @Override
        Item updateItem(Item item) {
            Item newItem = item.decreaseSellIn();
            return newItem.updateQuality(1);
        }
    },
    BACKSTAGE {
        @Override
        Item updateItem(Item item) {
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
    },
    SULFURAS {
        @Override
        Item updateItem(Item item) {
            return item;
        }
    },
    CONJURED {
        @Override
        Item updateItem(Item item) {
            Item newItem = item.decreaseSellIn();

            if (newItem.getSellIn() < 0) {
                return newItem.updateQuality(-4);
            }

            return newItem.updateQuality(-2);
        }
    },
    DEFAULT {
        @Override
        Item updateItem(Item item) {
            Item newItem = item.decreaseSellIn();

            if (newItem.getSellIn() < 0) {
                return newItem.updateQuality(-2);
            }

            return newItem.updateQuality(-1);
        }
    };

    abstract Item updateItem(Item item);
}
