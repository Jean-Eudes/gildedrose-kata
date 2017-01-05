package fr.xebia.katas.gildedrose;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import fr.xebia.katas.gildedrose.rule.AgedBrieRule;
import fr.xebia.katas.gildedrose.rule.BackstageRule;
import fr.xebia.katas.gildedrose.rule.DefaultRule;
import fr.xebia.katas.gildedrose.rule.SulfuraRule;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitQuickcheck.class)
public class ItemInvariantTest {

    @Property
    public void should_not_change_quality_and_sellIn_when_object_is_sulfura(
            @InRange(minInt = 0, maxInt = 50) int sellIn,
            @InRange(minInt = 0, maxInt = 50) int quality) throws Exception {

        // Given
        Item item = new Item(new SulfuraRule(), "Sulfuras, Hand of Ragnaros", sellIn, quality);

        // When
        Item newItem = item.update();

        // Then
        assertThat(newItem.getQuality()).isEqualTo(quality);
        assertThat(newItem.getSellIn()).isEqualTo(sellIn);
    }

    @Property
    public void should_decrease_quality_and_sellIn_when_object_has_default_behaviour(
            @InRange(minInt = 0, maxInt = 50) int sellIn,
            @InRange(minInt = 0, maxInt = 50) int quality) throws Exception {

        // Given
        int qualityDelta = 1;
        Item item = new Item(new DefaultRule(qualityDelta), "standard", sellIn, quality);

        // When
        Item newItem = item.update();

        // Then
        assertThat(newItem.getQuality()).isGreaterThanOrEqualTo(0);
        assertThat(newItem.getQuality()).isLessThanOrEqualTo(50);
        assertThat(newItem.getQuality()).isLessThanOrEqualTo(quality);
        assertThat(newItem.getQuality()).isGreaterThanOrEqualTo(quality - qualityDelta * 2);
        assertThat(newItem.getSellIn()).isEqualTo(sellIn - qualityDelta);
    }

    @Property
    public void should_increase_quality_and_decrease_sellIn_when_object_is_aged_brie(
            @InRange(minInt = 0, maxInt = 50) int sellIn,
            @InRange(minInt = 0, maxInt = 50) int quality) throws Exception {

        // Given
        Item item = new Item(new AgedBrieRule(), "Aged Brie", sellIn, quality);

        // When
        Item newItem = item.update();

        // Then
        assertThat(newItem.getQuality()).isGreaterThanOrEqualTo(0);
        assertThat(newItem.getQuality()).isLessThanOrEqualTo(50);
        assertThat(newItem.getQuality()).isGreaterThanOrEqualTo(quality);
        assertThat(newItem.getQuality()).isLessThanOrEqualTo(quality + 1);
        assertThat(newItem.getSellIn()).isEqualTo(sellIn - 1);
    }

    @Property
    public void should_increase_quality_and_decrease_sellIn_when_object_is_backstage(
            @InRange(minInt = 0, maxInt = 50) int sellIn,
            @InRange(minInt = 0, maxInt = 50) int quality) throws Exception {

        // Given
        Item item = new Item(new BackstageRule(), "Backstage passes to", sellIn, quality);

        // When
        Item newItem = item.update();

        // Then
        assertThat(newItem.getQuality()).isGreaterThanOrEqualTo(0);
        assertThat(newItem.getQuality()).isLessThanOrEqualTo(50);
        if (newItem.getSellIn() < 0) {
            assertThat(newItem.getQuality()).isEqualTo(0);
        } else {
            assertThat(newItem.getQuality()).isGreaterThanOrEqualTo(quality);
        }
        assertThat(newItem.getSellIn()).isEqualTo(sellIn - 1);
    }

}
