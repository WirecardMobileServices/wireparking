package com.example.wire;

import javax.sql.DataSource;
import com.example.wire.domain.ParkingHouse;
import com.example.wire.domain.ParkingPlace;
import com.example.wire.domain.User;
import com.example.wire.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

import static com.example.wire.domain.enums.Salutation.MR;

@SpringBootApplication
public class WireApplication {



	public static void main(String[] args) {

//		ParkingHouse parkingHouse = new ParkingHouse("test",12,12,"test","tetet",1231223);
//
//		ParkingPlace parkingPlace = new ParkingPlace("test","test");
//
//		parkingHouse.add(parkingPlace);
//
//		parkingPlace.setParkingHouse(parkingHouse);
//

//		ApplicationContext   context =  SpringApplication.run(WireApplication.class, args);
//
//		UserService userService = context.getBean("userService", UserService.class);
//
//		User user =  new User(MR,"test","test","test","Test","Test","Test","Test","Test",true);
//
//		userService.saveAndFlush(user);
//
//
//		System.out.println();

	}

	}
