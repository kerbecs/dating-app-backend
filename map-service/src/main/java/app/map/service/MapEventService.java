package app.map.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MapEventService {

	public static void main(String[] args) {
		SpringApplication.run(MapEventService.class, args);
	}

}
