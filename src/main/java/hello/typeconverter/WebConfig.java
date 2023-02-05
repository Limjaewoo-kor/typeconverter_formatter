package hello.typeconverter;

import hello.typeconverter.converter.IntegerToStringConverter;
import hello.typeconverter.converter.IpPortToStringConverter;
import hello.typeconverter.converter.StringToIntegerConverter;
import hello.typeconverter.converter.StringToIpPortConverter;
import hello.typeconverter.formatter.MyNumberFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        //컨버터
//        [주석상태인 2가지는 포메터와 동일하게 숫자->문자 , 문자->숫자이기에 우선순위문제가 발생하여서 주석으로 처리하였다. 우선순위 -> 1.컨버터 /   2.포메터]
//        registry.addConverter(new StringToIntegerConverter());
        registry.addConverter(new StringToIpPortConverter());
//        registry.addConverter(new IntegerToStringConverter());
        registry.addConverter(new IpPortToStringConverter());

        //포메터
        registry.addFormatter(new MyNumberFormatter());

    }
}
