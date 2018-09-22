package com.location;

import com.location.entities.AppRole;
import com.location.properties.FileStorageProperties;
import com.location.service.AccountService;
import com.location.service.MetierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class LocAppApplication implements CommandLineRunner{
    @Autowired
    private MetierService metier;
    @Autowired
    private AccountService account;

	public static void main(String[] args) {
		SpringApplication.run(LocAppApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        //account.saveRole(new AppRole("PROMOTEUR"));
        //account.saveRole(new AppRole("MEMBRE"));
    }
}
