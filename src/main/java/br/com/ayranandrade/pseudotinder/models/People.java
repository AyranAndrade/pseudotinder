package br.com.ayranandrade.pseudotinder.models;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "people")
public class People {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "people_id")
  private Integer id;

  @Column(nullable = false, length = 60)
  @NotBlank
  @Size(max = 60)
  private String name;

  @Column(name = "birth_date")
  @NotNull
  private LocalDate birthDate;

  @Column(name = "about_me", nullable = false, length = 1000)
  @NotBlank
  @Size(max = 1000)
  private String aboutMe;
  
  @Column(nullable = false, length = 20, unique = true)
  @NotBlank
  @Size(max = 20)
  private String username;

  @Column(name = "elo_score_rating", nullable = false)
  @NotNull
  @Size(min = 0)
  private Integer eloScore;

  @Column(name = "max_distance_kilometer", nullable = false)
  @NotNull
  @Digits(fraction = 3, integer = 4)
  private BigDecimal maxDistance;

  @Column(name = "created_at", nullable = false)
  @NotNull
  private Instant createdAt = Instant.now();

  @Column(nullable = false)
  @NotNull
  private Boolean active = true;

  @Embedded
  private AgeRange ageRange;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "sexual_orientation_id")
  private SexualOrientation sexualOrientation;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "gender_id")
  private Gender gender;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "profession_id")
  private Profession profession;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "street_id")
  private Street street;

  public People() {}

  public Integer getId() {
    return id;
  }

  public String getAboutMe() {
    return aboutMe;
  }

  public Boolean getActive() {
    return active;
  }

  public AgeRange getAgeRange() {
    return ageRange;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public Integer getEloScore() {
    return eloScore;
  }

  public Gender getGender() {
    return gender;
  }

  public BigDecimal getMaxDistance() {
    return maxDistance;
  }

  public String getName() {
    return name;
  }

  public Profession getProfession() {
    return profession;
  }

  public SexualOrientation getSexualOrientation() {
    return sexualOrientation;
  }

  public Street getStreet() {
    return street;
  }

  public String getUsername() {
    return username;
  }

  @Override
  public String toString() {
    return "People{" + "id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", aboutMe=" 
            + aboutMe + ", username=" + username + ", eloScore=" + eloScore + ", maxDistance=" 
            + maxDistance + ", createdAt=" + createdAt + ", active=" + active + ", ageRange=" 
            + ageRange + ", sexualOrientation=" + sexualOrientation + ", gender=" + gender 
            + ", profession=" + profession + ", street=" + street + '}';
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public void setAboutMe(String aboutMe) {
    this.aboutMe = aboutMe;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setEloScore(Integer eloScore) {
    this.eloScore = eloScore;
  }

  public void setMaxDistance(BigDecimal maxDistance) {
    this.maxDistance = maxDistance;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public void setAgeRange(AgeRange ageRange) {
    this.ageRange = ageRange;
  }

  public void setSexualOrientation(SexualOrientation sexualOrientation) {
    this.sexualOrientation = sexualOrientation;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public void setProfession(Profession profession) {
    this.profession = profession;
  }

  public void setStreet(Street street) {
    this.street = street;
  }
}