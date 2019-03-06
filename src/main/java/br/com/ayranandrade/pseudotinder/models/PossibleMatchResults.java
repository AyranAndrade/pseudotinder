package br.com.ayranandrade.pseudotinder.models;

public enum PossibleMatchResults {
	I_LIKED_THAT_PERSON(0), THAT_PERSON_LIKED_ME(1),

	I_DISLIKED_THAT_PERSON(1), THAT_PERSON_DISLIKED_ME(0);
	
	private Integer value;
	
	private PossibleMatchResults(Integer value) {
		this.value = value;
	}
	
	public Integer getValue() {
		return value;
	}
};
