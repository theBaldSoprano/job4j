package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SegmentTest {
    @Test
    public void whenCrossingThenTrue(){
        Segment segment = new Segment(5, 9);
        Segment segment1 = new Segment(1, 7);
        boolean result = segment1.isCrossing(segment);
        assertThat(result, is(true));
    }
    @Test
    public void whenNotCrossingThenFalse(){
        Segment segment = new Segment(5, 9);
        Segment segment1 = new Segment(10, 11);
        boolean result = segment.isCrossing(segment1);
        assertThat(result, is(false));
    }
}
