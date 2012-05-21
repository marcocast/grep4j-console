package org.grep4j.console.parsers;

import static ch.lambdaj.Lambda.selectFirst;
import static java.util.Arrays.asList;
import static org.grep4j.console.matcher.IsAProfileEditorControl.aProfileEditorControl;
import static org.hamcrest.Matchers.is;

import org.grep4j.console.ProfileEditorControl;
import org.grep4j.console.exception.Grep4jConsoleIllegalArgumentException;

public class ProfileEditorControlParser extends InputParser<ProfileEditorControl> {

	@Override
	void validateInput(String[] arguments) throws Grep4jConsoleIllegalArgumentException {
		if (arguments.length < 2) {
			throw new Grep4jConsoleIllegalArgumentException("Arguments are less than 2");
		}
		if (is(aProfileEditorControl()).matches(arguments[0])) {
			if (arguments.length > 2) {
				throw new Grep4jConsoleIllegalArgumentException("Arguments are more than 2");
			}
		}
	}

	@Override
	ProfileEditorControl interpret(String[] arguments) {
		String profileEditorControlString = selectFirst(asList(arguments), is(aProfileEditorControl()));
		if (profileEditorControlString != null) {
			for (ProfileEditorControl profileEditorControl : ProfileEditorControl.values()) {
				if (profileEditorControlString.equalsIgnoreCase(profileEditorControl.getProfileEditorControl())) {
					return profileEditorControl;
				}
			}
		}
		return null;
	}

}
