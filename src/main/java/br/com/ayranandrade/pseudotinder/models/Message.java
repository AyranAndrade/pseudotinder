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

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public People getFrom() {
    return from;
  }

  public void setFrom(People from) {
    this.from = from;
  }

  public People getTo() {
    return to;
  }

  public void setTo(People to) {
    this.to = to;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Instant getSentAt() {
    return sentAt;
  }

  public void setSentAt(Instant sentAt) {
    this.sentAt = sentAt;
  }
}