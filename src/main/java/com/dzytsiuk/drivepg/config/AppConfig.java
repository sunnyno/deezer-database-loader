package com.dzytsiuk.drivepg.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "com.dzytsiuk.drivepg",
        excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX,
                pattern = "com\\.dzytsiuk\\.drivepg\\.web\\.controller.*"))
@PropertySource(
        value = {"classpath:properties/application.properties"})
public class AppConfig {

    @Bean
    public BasicDataSource dataSource(@Value("${db.url}") String url
            , @Value("${db.username}") String username
            , @Value("${db.password}") String password) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
