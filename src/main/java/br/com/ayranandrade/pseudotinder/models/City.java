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
@Table(name = "cities")
public class City {
    
  @Id 
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "city_id")
  private Integer id;
    
  @NotBlank
  @Size(max = 30)
  @Column(nullable = false, length = 30)
  private String name;
    
  @NotNull
  @Column(name = "created_at", nullable = false)
  private Instant createdAt = Instant.now();
    
  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "state_id", referencedColumnName = "state_id")
  private State state;

  /**
   * This constructor is only for JPA use.
   */
  private City() {}

  public City(String name) {
    this.name = Optional.ofNullable(name)
    .orElseThrow(() -> new IllegalArgumentException("City's name can not be null."));
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  /**
   * Set the createdAt different than when this object was created. 
   * This value needs to be in the past.
   */
  public void setCreatedAt(Instant createdAt) {
    Instant createdAtNotNull = Optional.ofNullable(createdAt)
        .orElseThrow(() -> new IllegalArgumentException("City's createdAt can not be null."));
    if (createdAtNotNull.isBefore(Instant.now())) {
      this.createdAt = createdAtNotNull;
    } else {
      throw new 
          IllegalArgumentException("The instant of creation of a city can not be in the past.");
    }
  }
}
