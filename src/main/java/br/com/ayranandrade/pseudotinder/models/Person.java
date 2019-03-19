package br.com.ayranandrade.pseudotinder.models;

import static br.com.ayranandrade.pseudotinder.models.EloScoreRating.DEFAULT_STARTING_ELO_RATING;
import static br.com.ayranandrade.pseudotinder.models.EloScoreRating.K_FACTOR;
import static br.com.ayranandrade.pseudotinder.models.PossibleMatchResults.I_DISLIKED_THAT_PERSON;
import static br.com.ayranandrade.pseudotinder.models.PossibleMatchResults.I_LIKED_THAT_PERSON;
import static br.com.ayranandrade.pseudotinder.models.PossibleMatchResults.THAT_PERSON_DISLIKED_ME;
import static br.com.ayranandrade.pseudotinder.models.PossibleMatchResults.THAT_PERSON_LIKED_ME;
import static java.lang.Math.pow;
import static java.math.RoundingMode.HALF_UP;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.Instant;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "people")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "people_id")
	private Integer id;

	@Column(name = "name")
	@NotEmpty
	@Size(max = 60)
	private String myNameThatIWantOtherPeopleSee;

	@Column(name = "birth_date")
	@NotNull
	private LocalDate birthDate;

	@Column(name = "about_me")
	@NotEmpty
	@Size(max = 1000)
	private String myDescriptionAboutMyself;

	@Column(unique = true)
	@NotEmpty
	@Size(max = 20)
	private String username;

	@Column(name = "elo_score_rating")
	@NotNull
	@Min(0)
	private Integer eloScore;

	@Column(name = "max_distance_kilometer")
	@NotNull
	@Digits(fraction = 3, integer = 4)
	private BigDecimal maxDistanceToLookForPeopleInKilometers;

	@NotNull
	private Instant createdAt;

	@NotNull
	private Boolean active;

	@Column(name = "age_range_start")
	@NotNull
	@Min(18)
	private Integer peopleThatILikeMustHaveAgeBiggerThan;

	@Column(name = "age_range_end")
	@NotNull
	private Integer peopleThatILikeMustHaveAgeLesserThan;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "sexual_orientation_id")
	private SexualOrientation mySexualOrientation;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "gender_id")
	private Gender myGender;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "profession_id")
	private Profession myProfession;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "street_id")
	private Street whereILive;

	protected Person() {
		initializeAttributes();
	}

	private void initializeAttributes() {
		createdAt = Instant.now();
		active = true;
		eloScore = DEFAULT_STARTING_ELO_RATING;
	}

	public void giveLikeTo(Person person) {
		updateMyEloScore(person, I_LIKED_THAT_PERSON);
	}

	public void giveDislikeTo(Person person) {
		updateMyEloScore(person, I_DISLIKED_THAT_PERSON);
	}

	public void receiveLikeFrom(Person person) {
		updateMyEloScore(person, THAT_PERSON_LIKED_ME);
	}

	public void receiveDislikeFrom(Person person) {
		updateMyEloScore(person, THAT_PERSON_DISLIKED_ME);
	}

	private void updateMyEloScore(Person otherPerson, PossibleMatchResults iLikedOrNotThatPerson) {
		BigDecimal myEloScore = new BigDecimal(eloScore);
		BigDecimal probability = getProbabilityOfILikeThisPerson(otherPerson);
		BigDecimal kFactor = new BigDecimal(K_FACTOR);

		eloScore = new BigDecimal(iLikedOrNotThatPerson.getValue())
				.subtract(probability)
				.multiply(kFactor)
				.add(myEloScore)
				.setScale(0, HALF_UP)
				.intValue();
	}

	private BigDecimal getProbabilityOfILikeThisPerson(Person person) {
		Integer eloScoreFromOtherPerson = person.getEloScore();
		Integer delta = eloScoreFromOtherPerson - eloScore;
		double quotient = delta/400.0;
		double tenToThePowerOfQuotient = pow(10.0, quotient);
		double divisor = 1.0 + tenToThePowerOfQuotient;
		double dividend = 1.0;
		double result = dividend/divisor;
		MathContext toThreeDecimalPlaces = new MathContext(3, HALF_UP);
		return new BigDecimal(result).round(toThreeDecimalPlaces);
	}

	public Integer getEloScore() {
		return eloScore;
	}

	public Integer getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	@Override
	public String toString() {
		return "People{" + "id=" + id + ", name=" + myNameThatIWantOtherPeopleSee + ", birthDate=" + birthDate + ", aboutMe="
				+ myDescriptionAboutMyself + ", username=" + username + ", eloScore=" + eloScore + ", maxDistance="
				+ maxDistanceToLookForPeopleInKilometers + ", createdAt=" + createdAt + ", active=" + active + ", age start="
				+ peopleThatILikeMustHaveAgeBiggerThan + ", age end=" + peopleThatILikeMustHaveAgeLesserThan + ", sexualOrientation=" + mySexualOrientation
				+ ", gender=" + myGender + ", profession=" + myProfession + ", street=" + whereILive + '}';
	}

	public static class Builder {
		private final Person person;

		public Builder() {
			person = new Person();
		}

		public Builder name(String name) {
			person.myNameThatIWantOtherPeopleSee = name;
			return this;
		}

		public Builder birthDate(LocalDate birthDate) {
			person.birthDate = birthDate;
			return this;
		}

		public Builder aboutMe(String aboutMe) {
			person.myDescriptionAboutMyself = aboutMe;
			return this;
		}

		public Builder username(String username) {
			person.username = username;
			return this;
		}

		public Builder maxDistance(BigDecimal maxDistance) {
			person.maxDistanceToLookForPeopleInKilometers = maxDistance;
			return this;
		}

		public Builder maxAge(Integer maxAge) {
			person.peopleThatILikeMustHaveAgeLesserThan = maxAge;
			return this;
		}

		public Builder minAge(Integer minAge) {
			person.peopleThatILikeMustHaveAgeBiggerThan = minAge;
			return this;
		}

		public Builder sexualOrientation(SexualOrientation sexualOrientation) {
			person.mySexualOrientation = sexualOrientation;
			return this;
		}

		public Builder gender(Gender gender) {
			person.myGender = gender;
			return this;
		}

		public Builder profession(Profession profession) {
			person.myProfession = profession;
			return this;
		}

		public Builder street(Street street) {
			person.whereILive = street;
			return this;
		}

		public Builder eloScore(Integer eloScore) {
			person.eloScore = eloScore;
			return this;
		}

		public Person build() {
			return person;
		}

	}

}
