package org.grep4j.console.parsers;

import static ch.lambdaj.Lambda.filter;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.grep4j.core.matchers.IsAnExtraLinesOption.anExtraLinesOption;

import java.util.List;

import org.grep4j.console.exception.Grep4jConsoleIllegalArgumentException;
import org.grep4j.core.options.ExtraLinesOption;

public class ContextControlParser extends InputParser<List<String>> {

	@Override
	void validateInput(String[] arguments) throws Grep4jConsoleIllegalArgumentException {
		for (String input : arguments) {
			if (ExtraLinesOption.isAnExtraLinesOption(input)) {
				ExtraLinesOption extraLineOption = ExtraLinesOption.parseOption(input);
				if (input.replaceAll(extraLineOption.getExtraLineOptionType(), "").isEmpty()) {
					throw new Grep4jConsoleIllegalArgumentException("No Context Control was specified");
				}
			}
		}
	}

	@Override
	List<String> interpret(String[] arguments) {
		return filter(is(anExtraLinesOption()), asList(arguments));
	}

}
