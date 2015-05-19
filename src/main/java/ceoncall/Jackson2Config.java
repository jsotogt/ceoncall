package ceoncall;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Configuration
@EnableTransactionManagement
public class Jackson2Config {

    @Bean
    public ObjectMapper jacksonObjectMapper() {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.setDateFormat(df);

        return objectMapper;

    }

}
