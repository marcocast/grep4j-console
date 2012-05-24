package org.grep4j.console.parsers;

import static ch.lambdaj.Lambda.filter;
import static java.util.Arrays.asList;
import static org.grep4j.console.matchers.IsAnAccetablepProfile.anAccetableProfile;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.grep4j.console.exception.Grep4jConsoleIllegalArgumentException;

public class ProfileParser extends InputParser<List<String>> {

	@Override
	void validateInput(String[] arguments) throws Grep4jConsoleIllegalArgumentException {
		if (arguments.length < 2) {
			throw new Grep4jConsoleIllegalArgumentException("Arguments are less than 2");
		}
		if (filter(is(anAccetableProfile()), asList(arguments)).isEmpty()) {
			if (arguments.length > 2) {
				throw new Grep4jConsoleIllegalArgumentException("Arguments passed does not match any known profile");
			}
		}
	}

	@Override
	List<String> interpret(String[] arguments) {
		return filter(is(anAccetableProfile()), asList(arguments));
	}
}
