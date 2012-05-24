package org.grep4j.console.parsers;

import static ch.lambdaj.Lambda.filter;
import static java.util.Arrays.asList;
import static org.grep4j.core.matchers.IsAContextcontrol.aContextcontrol;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.grep4j.console.exception.Grep4jConsoleIllegalArgumentException;
import org.grep4j.core.ContextControl;

public class ContextControlParser extends InputParser<List<String>> {

	@Override
	void validateInput(String[] arguments) throws Grep4jConsoleIllegalArgumentException {
		for (String input : arguments) {
			if (ContextControl.isAContextControl(input)) {
				ContextControl contextControl = ContextControl.getContextControlFromFullValue(input);
				if (input.replaceAll(contextControl.getContextControl(), "").isEmpty()) {
					throw new Grep4jConsoleIllegalArgumentException("No Context Control was specified");
				}
			}
		}
	}

	@Override
	List<String> interpret(String[] arguments) {
		return filter(is(aContextcontrol()), asList(arguments));
	}

}
