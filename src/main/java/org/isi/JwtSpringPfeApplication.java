package org.isi;

import java.util.stream.Stream;

import org.isi.dao.TaskRepository;
import org.isi.entities.AppRole;
import org.isi.entities.AppUser;
import org.isi.entities.Task;
import org.isi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication

public class JwtSpringPfeApplication implements CommandLineRunner {
	@Autowired
	
	private TaskRepository taskRepository ;
	@Autowired
	private AccountService accountService ;

	public static void main(String[] args) {
		SpringApplication.run(JwtSpringPfeApplication.class, args);
	}
	@Bean
	public BCryptPasswordEncoder getBCPE() {
		
		return new BCryptPasswordEncoder ();
		
	}

	@Override
	public void run(String... args) throws Exception {
/*		accountService.saveUser(new AppUser(null,"admin","1234",null));
		accountService.saveUser(new AppUser(null,"user","1234",null));
		accountService.saveRole(new AppRole(null,"ADMIN"));
		accountService.saveRole(new AppRole(null,"USER"));
		accountService.addRoleToUser("admin", "ADMIN");
		accountService.addRoleToUser("admin", "USER");
		accountService.addRoleToUser("user", "USER");*/
		
	Stream.of("T1","T2","T3","T3").forEach(t->{
		taskRepository.save( new Task(null,t));
		
	});
	taskRepository.findAll().forEach(t->{
		System.out.println(t.getTaskName());
	});
	}
	
	
}