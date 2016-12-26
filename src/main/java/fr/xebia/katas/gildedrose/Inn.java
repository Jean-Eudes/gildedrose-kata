package fr.xebia.katas.gildedrose;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static fr.xebia.katas.gildedrose.ItemRule.*;

public class Inn {

    private List<Item> items;

    public Inn() {
        items = new ArrayList<>();
        items.add(new Item(DEFAULT, "+5 Dexterity Vest", 10, 20));
        items.add(new Item(AGED_BRIE, "Aged Brie", 2, 0));
        items.add(new Item(DEFAULT, "Elixir of the Mongoose", 5, 7));
        items.add(new Item(SULFURAS, "Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item(BACKSTAGE, "Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item(CONJURED, "Conjured Mana Cake", 3, 6));
    }

    public List<Item> getItems() {
        return items;
    }

    public void updateQuality() {
        items = items.stream()
                .map(Item::update)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println("OMGHAI!");
        new Inn().updateQuality();
    }

}
