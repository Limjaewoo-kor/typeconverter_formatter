package hello.typeconverter.formatter;

import hello.typeconverter.converter.IpPortToStringConverter;
import hello.typeconverter.converter.StringToIpPortConverter;
import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;

public class FormattingConversionServiceTest {

    @Test
    void formattingConversionService() {
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();

        //컨버터 등록
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());
        //포메터 등록
        conversionService.addFormatter(new MyNumberFormatter());

        //컨버터 사용
        IpPort convert = conversionService.convert("127.0.0.1:8080", IpPort.class);
        Assertions.assertThat(convert).isEqualTo(new IpPort("127.0.0.1",8080));
        //포메터 사용
        String convert1 = conversionService.convert(1000, String.class);
        Assertions.assertThat(convert1).isEqualTo("1,000");
        Long convert2 = conversionService.convert("1,000", Long.class);
        Assertions.assertThat(convert2).isEqualTo(1000);

    }
}
