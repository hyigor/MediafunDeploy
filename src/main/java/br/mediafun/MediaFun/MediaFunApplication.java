package br.mediafun.MediaFun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@SpringBootApplication
public class MediaFunApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediaFunApplication.class, args);
	}


	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://ec2-54-160-96-70.compute-1.amazonaws.com:5432/dbrr490nasf5gh?useSSL=false");
		dataSource.setUsername("bjakctqhtmqclj");
		dataSource.setPassword("8e31264cc64bf1d08c4fffd46a3aa68e0ddb08b328d8b23fdfc89befce12ee0f");
		return dataSource;


	}
}
