package nextstep;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NextCalculatorTest {

    NextCalculator cal;

    @BeforeEach
    void setup() {
        cal = new NextCalculator();
    }

    @Test
    void 빈문자열널값처리() {
        assertEquals(0, cal.add(null));
        assertEquals(0, cal.add(""));
    }

    @Test
    void 숫자하나를입력() {
        assertEquals(2, cal.add("2"));
    }

    @Test
    void 숫자두개를쉼표로입력() {
        assertEquals(3, cal.add("1,2"));
    }

    @Test
    void 쉼표와세미콜론구분자() {
        assertEquals(6, cal.add("1,2;3"));
    }

    @Test
    void 커스텀구분자() {
        assertEquals(6, cal.add("//;\n1;2;3"));
    }

    @Test
    void 음수입력시오류() {
        assertThrows(RuntimeException.class, () -> cal.add("-1,2,3"));
    }
}