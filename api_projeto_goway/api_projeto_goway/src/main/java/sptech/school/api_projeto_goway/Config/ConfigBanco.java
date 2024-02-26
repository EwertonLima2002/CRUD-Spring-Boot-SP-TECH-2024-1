package sptech.school.api_projeto_goway.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class ConfigBanco {

     @Bean
     public DataSource dataSource() {
         DriverManagerDataSource dataSource = new DriverManagerDataSource();
         dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
         dataSource.setUrl("jdbc:mysql://localhost:3306/goway?useTimezone=true&serverTimezone=UTC");
         dataSource.setUsername("root");
         dataSource.setPassword("root");
         return dataSource;
     }
}
