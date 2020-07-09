package progetto_twitter.Springbootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import progetto_twitter.Springbootapp.GETJson.GETJson;

@SpringBootApplication
public class SpringbootappApplication{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootappApplication.class, args);
		GETJson.GETJ();
	}

}
