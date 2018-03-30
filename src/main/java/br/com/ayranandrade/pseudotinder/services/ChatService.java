package br.com.ayranandrade.pseudotinder.services;

import br.com.ayranandrade.pseudotinder.models.Message;
import br.com.ayranandrade.pseudotinder.models.People;

import java.util.List;

public interface ChatService {
  public void sendMessage(Message message);

  public List<Message> showMessages(People senter, People receiver);
}