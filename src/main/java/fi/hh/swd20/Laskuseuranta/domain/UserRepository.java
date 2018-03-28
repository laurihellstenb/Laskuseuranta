package fi.hh.swd20.Laskuseuranta.domain;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Lauri Hellsten
 */

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}
