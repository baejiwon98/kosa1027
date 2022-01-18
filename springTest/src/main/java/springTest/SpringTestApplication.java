package springTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class SpringTestApplication {
	@RequestMapping("/")
	String aaa() {
		return "hello world";
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringTestApplication.class, args);
	}

}
