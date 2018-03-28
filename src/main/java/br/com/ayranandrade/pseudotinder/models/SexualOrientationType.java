package br.com.ayranandrade.pseudotinder.models;

public enum SexualOrientationType {
  HETEROSEXUAL("heterosexual"),
  HOMOSEXUL("homosexual"),
  BISEXUAL("bisexual"),
  ASEXUAL("asexual"),
  PANSEXUAL("pansexual");

  private final String orientation;

  private SexualOrientationType(String orientation) {
    this.orientation = orientation;
  }

  public String getOrientation() {
    return this.orientation;
  }
}