package br.com.ayranandrade.pseudotinder.models;

import java.time.Instant;
import java.util.Optional;

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

@Entity
@Table(name = "messages")
public class Message {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "message_id")
  private Integer id;

  @Column(nullable = false, length = 1000)
  @NotBlank
  @Size(max = 1000)
  private String message;

  @Column(name = "sent_at", nullable = false)
  @NotNull
  private Instant sentAt = Instant.now();
  
  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "sent_from")
  private People from;

  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "sent_to")
  private People to;

  @Column(nullable = false)
  @NotNull
  private Boolean active = true;

  /**
  * This constructor is only for JPA use.
  */
  private Message() {}

  public Message(String message, People from, People to) {
    this.from = Optional.ofNullable(from)
        .orElseThrow(() -> new IllegalArgumentException("The senter from message " 
        + "can not be null."));

    this.to = Optional.ofNullable(to)
      .orElseThrow(() -> new IllegalArgumentException("The receiver from message " 
      + "can not be null."));

    String messageNotNull = Optional.ofNullable(message)
        .orElseThrow(() -> new IllegalArgumentException("The message can not be null."));

    if (!messageNotNull.isEmpty()) {
      this.message = messageNotNull;
    } else {
      throw new IllegalArgumentException("The message can not be empty.");
    }
  }

  public Integer getId() {
    return id;
  }

  public Boolean getActive() {
    return active;
  }

  public People getFrom() {
    return from;
  }

  public People getTo() {
    return to;
  }

  public String getMessage() {
    return message;
  }

  public Instant getSentAt() {
    return sentAt;
  }

  /**
  * Set the sentAt different than when this object was created. 
  * This value needs to be in the past.
  */
  public void setSentAt(Instant sentAt) {
    Instant sentAtNotNull = Optional.ofNullable(sentAt)
        .orElseThrow(() -> new IllegalArgumentException("Message's sentAt can not be null."));
    if (sentAtNotNull.isBefore(Instant.now())) {
      this.sentAt = sentAtNotNull;
    } else {
      throw new 
          IllegalArgumentException("The instant of creation of a message can not be in the past.");
    }
  }
}