package br.mediafun.MediaFun;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;

@Configuration
public class DatabaseConfig {

        private Environment environment;

        @Bean
        public Properties addProperties(){
            Properties props = new Properties();
            props.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
            props.setProperty("hibernate.show_sql", "true");
            props.setProperty("hibernate.hbm2ddl.auto", "update");
            return props;
        }

//        @Value("${spring.datasource.url}")
//        private String dbUrl;

        @Bean
        public DataSource dataSource() throws URISyntaxException {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName("org.postgresql.Driver");

            URI dbURL = new URI(environment.getProperties().getProperty("DATABSE_URL"));
            dataSource.setUrl("jdbc:postgresql://"+dbURL.getHost()+":"+dbURL.getPort()+dbURL.getPath());
            dataSource.setUsername(dbURL.getUserInfo().split(":")[0]);
            dataSource.setPassword(dbURL.getUserInfo().split(":")[1]);
//            HikariConfig config = new HikariConfig();
//            config.setJdbcUrl(dbUrl);
//            return new HikariDataSource(config);
            return dataSource;
        }
}
