# typeconverter_formatter

타입 컨버터

String -> Integer 등으로 타입을 변환해주는 것이며, @RequestParam , @ModelAttribute , @PathVariable등에서 스프링이 Argument를 받을때 자동으로 사용한다.
타입 컨버터를 사용하려면 org.springframework.core.convert.converter.Converter 인터페이스를 구현하면 된다. 
스프링에 컨버터 사용시에는 WebMvcConfigurer 을 implements받는 WebConfig를 만들어서 addFormatters를 등록한후에 사용하면된다.



포맷터 - Formatter 

숫자 1000 을 문자 "1,000"으로 1000자리수마다 ,가 들어가는 등을 만들수있다.
FormattingConversionService 는 ConversionService 관련 기능을 상속받기 때문에 결과적으로 컨버터도 포맷터도 모두 등록할 수 있다. 
그리고 사용할 때는 ConversionService 가 제공하는 convert 를 사용하면 된다. 
추가로 스프링 부트는 DefaultFormattingConversionService 를 상속 받은 WebConversionService 를 내부에서 사용한다. 



정리
사용할 때는 컨버전 서비스를 통해서 일관성 있게 사용할 수 있다
JSON을 객체로 변환하는 메시지 컨버터는 내부에서 Jackson 같은 라이브러리를 사용한다. 
따라서 JSON 결과로 만들어지는 숫자나 날짜 포맷을 변경하고 싶으면 해당 라이브러리가 제공하는 설정을 통해서 포맷을 지정해야 한다.

-
메시지 컨버터( HttpMessageConverter )에는 컨버전 서비스가 적용되지 않는다.
컨버전 서비스는 @RequestParam , @ModelAttribute , @PathVariable , 뷰 템플릿 등에서 사용할 수 있다. 
- 일반적으로 위의 3가지 어노테이션에서 Integer나 객체등으로 Argument를 받으면 스프링에서 컨버전서비스를 동작하여 변환해준다.
- 기본적으로는 전부 String로 들어온다.

@Responsebody, Responseentity에는 적용 안됨
