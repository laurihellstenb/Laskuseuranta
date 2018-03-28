package fi.hh.swd20.Laskuseuranta.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/** 
 * 
 * @author Lauri Hellsten
 *
 */

public interface PaymentRepository extends CrudRepository<Payment, Long>{
	
	List<Payment> findByName(String name);

}
