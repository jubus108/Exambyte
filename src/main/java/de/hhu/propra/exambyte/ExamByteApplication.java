package de.hhu.propra.exambyte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication() // exclude = {DataSourceAutoConfiguration .class }
@EnableJdbcRepositories(basePackages = "de.hhu.propra.exambyte.db")
public class ExamByteApplication {

	public static void main(String[] args) {

		SpringApplication.run(ExamByteApplication.class, args);
	}

}
