package br.mediafun.MediaFun;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {


        @Value("postgres://bjakctqhtmqclj:8e31264cc64bf1d08c4fffd46a3aa68e0ddb08b328d8b23fdfc89befce12ee0f@ec2-54-160-96-70.compute-1.amazonaws.com:5432/dbrr490nasf5gh\n")
        private String dbUrl;

        @Bean
        public DataSource dataSource() {
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(dbUrl);
            return new HikariDataSource(config);
        }
}
