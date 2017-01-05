package fr.xebia.katas.gildedrose;

import fr.xebia.katas.gildedrose.rule.AgedBrieRule;
import fr.xebia.katas.gildedrose.rule.BackstageRule;
import fr.xebia.katas.gildedrose.rule.DefaultRule;
import fr.xebia.katas.gildedrose.rule.SulfuraRule;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Inn {

    private List<Item> items;

    public Inn() {
        items = new ArrayList<>();
        items.add(new Item(new DefaultRule(1), "+5 Dexterity Vest", 10, 20));
        items.add(new Item(new AgedBrieRule(), "Aged Brie", 2, 0));
        items.add(new Item(new DefaultRule(1), "Elixir of the Mongoose", 5, 7));
        items.add(new Item(new SulfuraRule(), "Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item(new BackstageRule(), "Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item(new DefaultRule(2), "Conjured Mana Cake", 3, 6));
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
