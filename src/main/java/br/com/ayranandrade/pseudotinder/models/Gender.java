package br.com.ayranandrade.pseudotinder.models;

import java.time.Instant;
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

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name.getGenderName();
  }

  public void setName(GenderType name) {
    this.name = name;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }
}
