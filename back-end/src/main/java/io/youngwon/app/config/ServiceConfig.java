package io.youngwon.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class ServiceConfig {

//    @Bean
//    public Jwt jwt(JwtTokenConfigure jwtTokenConfigure) {
//        return new Jwt(jwtTokenConfigure.getIssuer(), jwtTokenConfigure.getClientSecret(), jwtTokenConfigure.getExpirySeconds());
//    }

//    @Bean
//    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
//        return builder -> {
//            AfterburnerModule abm = new AfterburnerModule();
//            JavaTimeModule jtm = new JavaTimeModule();
//            jtm.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//            jtm.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//            jtm.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//            jtm.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//
//            builder.visibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
//            builder.visibility(PropertyAccessor.IS_GETTER, JsonAutoDetect.Visibility.NONE);
//            builder.visibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
//
//            builder.serializationInclusion(JsonInclude.Include.ALWAYS);
//            builder.modulesToInstall(abm, jtm);
//        };
//    }
}
