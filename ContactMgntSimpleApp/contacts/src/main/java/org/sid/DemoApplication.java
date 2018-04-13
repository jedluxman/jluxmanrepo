package org.sid;

import org.sid.dao.ContactRepository;
import org.sid.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	@Autowired
	private ContactRepository contactRepository;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		contactRepository.save(new Contact("Jed","Othmani",
				"jed@yahoo.com",78872678,"jedpass.jpg"));
		contactRepository.save(new Contact("Adem","Othmani",
				"adem@yahoo.com",738736544,"adem.jpg"));
		contactRepository.save(new Contact("Abdou","Othmani",
				"abdou@yahoo.com",73874333,"abdou.jpg"));

		/*contactRepository.save(new Contact("Jed","Othmani",df.parse("12/06/1981"),
				"jed@yahoo.com",78872678,"jedpass.jpg"));
		contactRepository.save(new Contact("Adem","Othmani",df.parse("29/07/2014"),
				"adem@yahoo.com",738736544,"adem.jpg"));
		contactRepository.save(new Contact("Abdou","Othmani",df.parse("29/05/2016"),
				"abdou@yahoo.com",73874333,"abdou.jpg"));*/

		contactRepository.findAll().forEach(c->{
					System.out.println(c.getNom());
				}
		);
	}
}
