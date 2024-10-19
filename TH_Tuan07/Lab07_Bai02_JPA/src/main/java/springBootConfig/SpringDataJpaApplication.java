package springBootConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"controller", "service", "repository"})
@EntityScan(basePackages = "entities")  
@EnableJpaRepositories(basePackages = "repository")  
public class SpringDataJpaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }
}



// Insert data
/*
 * Dùng Postman, phương thưc POST
 	{
	  "name": "Nguyen Duc Nhat",
	  "role": "Developer"
	}
 * Ấn send
 */

//Get data
/*
 * Dùng Postman, phương thưc GET, điền địa chỉ http://localhost:8080/employees  Ấn send
 */