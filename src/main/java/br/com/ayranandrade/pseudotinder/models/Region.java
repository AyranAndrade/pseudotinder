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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "regions")
public class Region {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "region_id")
	private Integer id;

	@NotEmpty
	@Size(max = 30)
	private String name;

	@NotNull
	private Instant createdAt;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "city_id", referencedColumnName = "city_id")
	private City cityInWhichRegionLies;

	protected Region() {
		initializeAttributes();
	}

	private void initializeAttributes() {
		createdAt = Instant.now();
	}

	public Region(String name, City city) {
		this.name = name;
		cityInWhichRegionLies = city;
		initializeAttributes();
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Region [id=" + id + ", name=" + name + ", createdAt="
				+ createdAt + ", cityInWhichRegionLies=" + cityInWhichRegionLies + "]";
	}

}

