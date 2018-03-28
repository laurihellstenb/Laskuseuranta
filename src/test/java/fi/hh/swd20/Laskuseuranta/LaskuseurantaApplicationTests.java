package fi.hh.swd20.Laskuseuranta;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.hh.swd20.Laskuseuranta.webcontrol.InvoiceController;
import fi.hh.swd20.Laskuseuranta.webcontrol.UserController;

/**
 * 
 * @author Lauri Hellsten
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class LaskuseurantaApplicationTests {

	@Autowired
	private InvoiceController icontroller;
	@Autowired
	private UserController ucontroller;

	@Test
	public void contexLoads() throws Exception {
		assertThat(icontroller).isNotNull();
		assertThat(ucontroller).isNotNull();
	}

}