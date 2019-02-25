package br.com.ayranandrade.pseudotinder.helpers;

import java.util.Optional;

public abstract class ReliabilityHelper {

	public static <T> T throwsExceptionIfNull(T object) {
		return Optional.of(object).get();
	} 

}
