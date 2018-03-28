package br.com.ayranandrade.pseudotinder.models;

public enum GenderType {
  TRANSMAN("transman"),
  TRANSWOMAN("transwoman"),
  CISMAN("cisman"),
  CISWOMAN("ciswoman"),
  AGENDER("agender");

  private final String genderName;

  private GenderType(String gender) {
    this.genderName = gender;
  }

  public String getGenderName() {
    return this.genderName;
  }
}