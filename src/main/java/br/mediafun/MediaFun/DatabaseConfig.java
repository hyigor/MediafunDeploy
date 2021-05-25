package br.mediafun.MediaFun;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {


//        @Value("${spring.datasource.url}")
//        private String dbUrl;
//
//        @Bean
//        public DataSource dataSource() {
//            HikariConfig config = new HikariConfig();
//            config.setJdbcUrl(dbUrl);
//            return new HikariDataSource(config);
//        }


    @Value("${spring.datasource.driver-class-name}")
    private String driverClass;
    @Value("${spring.datasource.data-username}")
    private String url;
    @Value("${spring.datasource.data-username}")
    private String userName;
    @Value("${spring.datasource.data-password}")
    private String password;

    @Bean
    public DataSource getDataSource() {
        return DataSourceBuilder.create()
                .driverClassName(driverClass)
                .url(url)
                .username(userName)
                .password(password)
                .build();
    }
}
