package progetto_twitter.Springbootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import progetto_twitter.Springbootapp.GETJson.GETJson;
import progetto_twitter.Springbootapp.util.ListManagementImpl;
import progetto_twitter.Springbootapp.util.ListsCreate;

@SpringBootApplication
public class SpringbootappApplication {

	public static void main(String[] args) {
		ListsCreate.ListsInitiate();
		GETJson.GETJ();
		SpringApplication.run(SpringbootappApplication.class, args);
	}

}
