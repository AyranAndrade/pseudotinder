package br.com.ayranandrade.pseudotinder.repositories;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.ayranandrade.pseudotinder.AbstractSpringBootTest;
import br.com.ayranandrade.pseudotinder.models.Message;
import br.com.ayranandrade.pseudotinder.models.People;

public class MessageRepositoryTest extends AbstractSpringBootTest {
	
    @Autowired
    private MessageRepository messageRepository;
    
    @Autowired
    private PeopleRepository peopleRepository;
    
    @Test
    public void shouldAddMessageToDatabase() {
    	People sender = peopleRepository.getOne(10);
    	People recipient = peopleRepository.getOne(11);
    	String messageBody = "Hello! How are you?";
    	Message message = new Message(sender, recipient, messageBody);
    	messageRepository.save(message);
    	Integer messageId = message.getId();
    	Optional<Message> optionalMessage = messageRepository.findById(messageId);
    	assertTrue(optionalMessage.isPresent());
    }

    @Test
    @Transactional
    public void shouldGetMessageById() {
    	Optional<Message> optionalMessage = messageRepository.findById(1);
    	assertTrue(optionalMessage.isPresent());
    	String messageToString = optionalMessage.get().toString(); 
    	assertTrue(messageToString.contains("1"));
    }
    
    @Test
    public void shouldDeleteMessageFromDatabase() {
    	messageRepository.deleteById(2);
    	Optional<Message> optionalMessage = messageRepository.findById(2);
    	assertTrue(optionalMessage.isEmpty());
    }

}
