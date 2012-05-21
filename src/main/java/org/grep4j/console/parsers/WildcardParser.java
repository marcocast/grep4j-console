package org.grep4j.console.parsers;

import org.grep4j.console.exception.Grep4jConsoleIllegalArgumentException;

public class WildcardParser extends InputParser<String> {

	public static final String WILD_CARD = "-W";

	@Override
	void validateInput(String[] arguments) throws Grep4jConsoleIllegalArgumentException {
		for (String input : arguments) {
			if (input.startsWith(WILD_CARD)) {
				if (input.replaceAll(WILD_CARD, "").isEmpty()) {
					throw new Grep4jConsoleIllegalArgumentException("No wildcard was specified");
				}
			}
		}
	}

	@Override
	String interpret(String[] arguments) {
		String wildcard = null;
		for (String input : arguments) {
			if (input.startsWith(WILD_CARD)) {
				wildcard = input.replaceAll(WILD_CARD, "");
			}
		}
		return wildcard;
	}

}
