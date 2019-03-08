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
  
  @Column(name = "name")
  @NotNull
  @Enumerated(EnumType.STRING)
  private GenderType genderName;
  
  @NotNull
  private Instant createdAt;

  protected Gender() {}
  
  @Override
  public String toString() {
	  return "Gender [id=" + id + ", genderName=" + genderName + ", createdAt=" + createdAt + "]";
  }

}
