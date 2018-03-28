package fi.hh.swd20.Laskuseuranta;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.hh.swd20.Laskuseuranta.domain.Invoice;
import fi.hh.swd20.Laskuseuranta.domain.InvoiceRepository;
import fi.hh.swd20.Laskuseuranta.domain.Payment;
import fi.hh.swd20.Laskuseuranta.domain.PaymentRepository;
import fi.hh.swd20.Laskuseuranta.domain.User;
import fi.hh.swd20.Laskuseuranta.domain.UserRepository;

/**
 * 
 * @author Lauri Hellsten
 *
 */

@SpringBootApplication
public class LaskuseurantaApplication {

	private static final Logger log = LoggerFactory.getLogger(LaskuseurantaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LaskuseurantaApplication.class, args);
	}

	@Bean
	public CommandLineRunner laskuseurantaDemo(InvoiceRepository repository, PaymentRepository prepository,
			UserRepository urepository) {
		return (args) -> {
			log.info("adding payment types");
			prepository.save(new Payment("Paid"));
			prepository.save(new Payment("Unpaid"));

			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER", "");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN", "");
			urepository.save(user1);
			urepository.save(user2);

			log.info("fetch all invoices");
			for (Invoice invoice : repository.findAll()) {
				log.info(invoice.toString());
			}

		};
	}
}
