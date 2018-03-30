package br.com.ayranandrade.pseudotinder.models;

import java.time.Instant;
import java.util.Arrays;
import java.util.Optional;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "genders")
public class Gender {
    
  @Id 
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "gender_id")
  private Integer id;
  
  @Column(nullable = false)
  @NotNull
  @Enumerated(EnumType.STRING)
  private GenderType name;
  
  @Column(name = "created_at", nullable = false)
  @NotNull
  private Instant createdAt = Instant.now();

  /**
   * This constructor is only for JPA use.
   */
  private Gender() {}

  public Gender(GenderType name) {
    this.name = Optional.ofNullable(name)
        .orElseThrow(() -> new IllegalArgumentException("Name of gender can not be null."));
  }

  /**
   * Given a name not null, this constructor looks for a GenderType 
   * that value be equal to name ignoring case. Otherwise, a IllegalArgumentException is thrown.
   */
  public Gender(String name) {
    String nameNotNull = Optional.ofNullable(name)
        .orElseThrow(() -> new IllegalArgumentException("Name of gender can not be null."));

    this.name = Arrays.asList(GenderType.values()).stream()
        .filter(g -> g.getGenderName().equalsIgnoreCase(nameNotNull))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Name of gender needs " 
        + "to be a valid value contained in GenderType enum."));
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name.getGenderName();
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  /**
   * Set the moment of creation of gender. This value can not be null and needs to be in past.
   */
  public void setCreatedAt(Instant createdAt) {
    Instant createdAtNotNull = Optional.ofNullable(createdAt)
        .orElseThrow(() -> new IllegalArgumentException("The moment of creation " 
        + "from a gender can not be null."));

    if (createdAtNotNull.isBefore(Instant.now())) {
      this.createdAt = createdAtNotNull;
    } else {
      throw new IllegalArgumentException("The moment of creation from a gender needs " 
      + "to be in past.");
    }
    
  }
}
