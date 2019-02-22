package br.com.ayranandrade.pseudotinder;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.ayranandrade.pseudotinder.controllers.HomeController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {
	
	@Autowired
    private HomeController homeController;

	@Test
	public void contextLoads() {
		assertNotNull(homeController);
	}

}
