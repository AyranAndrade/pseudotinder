package br.com.ayranandrade.pseudotinder.models;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static br.com.ayranandrade.pseudotinder.helpers.ReliabilityHelper.throwsExceptionIfNull;

@Entity
@Table(name = "messages")
public class Message {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "message_id")
  private Integer id;

  @Column(name = "message", nullable = false, length = 1000)
  @NotBlank
  @Size(max = 1000)
  private String messageBody;

  @Column(nullable = false)
  @NotNull
  private Instant sentAt;
  
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "sent_from")
  private People sender;

  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "sent_to")
  private People recipient;

  @Column(nullable = false)
  @NotNull
  private Boolean active;

  private Message() {
	  initializeAttributes();
  }
  
  public Message(People sender, People recipient, String messageBody) {
	  initializeAttributes();
	  
	  this.sender = throwsExceptionIfNull(sender);
	  
	  this.recipient = throwsExceptionIfNull(recipient);
	  
	  this.messageBody = throwsExceptionIfNull(messageBody);
  }
  
  private void initializeAttributes() {
	  active = true;
	  sentAt = Instant.now();
  }
  
  public Integer getId() {
	  return id;
  }

  @Override
  public String toString() {
	  return "Message [id=" + id + ", messageBody=" + messageBody + ", sentAt=" + sentAt + ", sender=" + sender
			  + ", recipient=" + recipient + ", active=" + active + "]";
  }
  
}