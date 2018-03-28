package fi.hh.swd20.Laskuseuranta.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * 
 * @author Lauri Hellsten
 *
 */

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

	List<Invoice> findByName(String name);

}
