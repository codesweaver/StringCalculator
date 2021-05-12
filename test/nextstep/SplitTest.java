package nextstep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SplitTest {

    @Test
    void 스플릿테스트() {
        assertArrayEquals(new String[] {"1"}, "1".split(","));
        assertArrayEquals(new String[] {"1", "2"}, "1,2".split(","));
        assertArrayEquals(new String[] {"1", "2", "3"}, "1,2;3".split(",|;"));
    }
}
