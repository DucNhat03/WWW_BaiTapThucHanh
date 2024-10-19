package iuh.exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoRestApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoRestApiApplication.class, args);
	}

}

//private final static Logger logger = LoggerFactory.getLogger(EmployeeController.class.getName());

//logger.info("info");
//logger.trace("trace");
//logger.debug("debug");
//logger.warn("warn");
//logger.error("error");