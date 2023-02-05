package hello.typeconverter.converter;


import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConverterTest {

    @Test
    void StringToInteger() {
        StringToIntegerConverter converter = new StringToIntegerConverter();
        Integer convert = converter.convert("10");
        Assertions.assertThat(convert).isEqualTo(10);
    }


    @Test
    void IntegerToString() {
        IntegerToStringConverter converter = new IntegerToStringConverter();
        String convert = converter.convert(10);
        Assertions.assertThat(convert).isEqualTo("10");
    }

    @Test
    void IpPortToString() {
        IpPortToStringConverter converter = new IpPortToStringConverter();
        String convert = converter.convert(new IpPort("127.0.0.1", 8080));
        Assertions.assertThat(convert).isEqualTo("127.0.0.1:8080");

    }

    @Test
    void StringToIpPort() {
        StringToIpPortConverter converter = new StringToIpPortConverter();
        IpPort convert = converter.convert("127.0.0.1:8080");
        Assertions.assertThat(convert).isEqualTo(new IpPort("127.0.0.1",8080));
        Assertions.assertThat(convert.getIp()).isEqualTo("127.0.0.1");
        Assertions.assertThat(convert.getPort()).isEqualTo(8080);
    }
}
