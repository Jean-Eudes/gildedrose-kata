package fr.xebia.katas.gildedrose;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

public class InnTest {

    @Test
    public void should_test_the_truth() throws Exception {
        Inn inn = new Inn();
        inn.updateQuality();

        List<Item> items = inn.getItems();

        assertThat(items).extracting("name", "sellIn", "quality").contains(
                tuple("+5 Dexterity Vest", 9, 19),
                tuple("Aged Brie", 1, 1),
                tuple("Elixir of the Mongoose", 4, 6),
                tuple("Sulfuras, Hand of Ragnaros", 0, 80),
                tuple("Backstage passes to a TAFKAL80ETC concert", 14, 21),
                tuple("Conjured Mana Cake", 2, 4)
        );
    }

}
