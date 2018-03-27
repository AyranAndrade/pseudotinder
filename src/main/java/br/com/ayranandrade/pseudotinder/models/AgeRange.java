package br.com.ayranandrade.pseudotinder.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Embeddable
public class AgeRange {

  @Column(name = "age_range_start", nullable = false)
  @NotNull
  @Min(18)
  private Integer start;

  @Column(name = "age_range_end", nullable = false)
  @NotNull
  private Integer end;

  /**
   * Create an object AgeRange with start and end parameters that must not be null and
   * end number must be greater than start parameter.
   */
  public AgeRange(Integer start, Integer end) {
    if (start != null && end != null) {
      if (end >= start) {
        this.end = end;
        this.start = start;
      } else {
        throw new IllegalArgumentException("The end must be greter than start.");
      }
    } else {
      throw new IllegalArgumentException("The start and end must not be null.");
    }
  }

  public Integer getStart() {
    return start;
  }

  public Integer getEnd() {
    return end;
  }
}
