package hello.typeconverter.formatter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class MyNumberFormatterTest {

    MyNumberFormatter formatter = new MyNumberFormatter();

    @Test
    void parse() throws ParseException {
        Number parse = formatter.parse("10,000", Locale.KOREA);
        Assertions.assertThat(parse).isEqualTo(10000L); // Long 타입 주의
    }

    @Test
    void print() {
        String print = formatter.print(10000, Locale.KOREA);
        Assertions.assertThat(print).isEqualTo("10,000");
    }
}