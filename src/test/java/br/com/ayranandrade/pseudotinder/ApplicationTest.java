package br.com.ayranandrade.pseudotinder;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.ayranandrade.pseudotinder.controllers.HomeController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {
	
	@LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    
	@Autowired
    private HomeController homeController;

	@Test
	public void contextLoads() {
		assertNotNull(homeController);
	}
	
	@Test
    public void appMustBeRunningAndRespondingWithLoginPage() throws Exception {
		String pageReturned = this.restTemplate.getForObject("http://localhost:" + port + "/", 
				String.class);
		assertTrue(pageReturned.contains("Bem-vindo ao Pseudotinder!"));
    }

}
