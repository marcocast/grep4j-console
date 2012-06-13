package org.grep4j.console.converters;

import static org.grep4j.core.options.ExtraLines.extraLinesAfter;
import static org.grep4j.core.options.ExtraLines.extraLinesBefore;

import org.grep4j.console.exception.Grep4jConsoleIllegalArgumentException;
import org.grep4j.core.options.ExtraLines;
import org.grep4j.core.options.ExtraLinesOption;

import ch.lambdaj.function.convert.PropertyExtractor;

public class ExtraLinesConverter extends PropertyExtractor<String, ExtraLines> {

	public ExtraLinesConverter() {
		super("ExtraLinesConverter");
	}

	@Override
	public ExtraLines convert(String input) {
		ExtraLines extraLines = null;
		if (ExtraLinesOption.isAnExtraLinesOption(input)) {
			ExtraLinesOption extraLineOption = ExtraLinesOption.parseOption(input);
			String numberOfLinesString = input.replaceAll(extraLineOption.getExtraLineOptionType(), "");
			if (numberOfLinesString.isEmpty()) {
				throw new Grep4jConsoleIllegalArgumentException("No Context Control was specified");
			}
			else {
				switch (extraLineOption) {
					case after: {
						extraLines = extraLinesAfter(Integer.parseInt(numberOfLinesString));
						break;
					}
					case before: {
						extraLines = extraLinesBefore(Integer.parseInt(numberOfLinesString));
						break;
					}
				}
			}
		}
		return extraLines;
	}
}