package org.grep4j.console.parsers;

import org.grep4j.console.exception.Grep4jConsoleIllegalArgumentException;

public class ProfileToCRUDParser extends InputParser<String> {

	@Override
	void validateInput(String[] arguments) throws Grep4jConsoleIllegalArgumentException {
		if (arguments[1].isEmpty()) {
			throw new Grep4jConsoleIllegalArgumentException("Profile name to edit is empty");
		}
	}

	@Override
	String interpret(String[] arguments) {
		return arguments[1];
	}

}
