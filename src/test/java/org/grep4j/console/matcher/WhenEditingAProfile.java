package org.grep4j.console.matcher;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.grep4j.console.ProfileEditorControl;
import org.grep4j.console.parsers.ProfileEditorControlParser;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WhenEditingAProfile {

	private ProfileEditorControlParser profileEditorControlParser;

	@BeforeTest
	public void init() {
		profileEditorControlParser = new ProfileEditorControlParser();
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void andTheArgumentsAreMoreThan3thenAIllegalArgumentExceptionShouldBeThrown() {
		String[] arguments = { "-EDIT", "profile", "3" };
		profileEditorControlParser.parse(arguments);
	}

	@Test
	public void andTheFirstParamIsNotAProfileeditorContextcommandNoExceptionShouldBeThrown() {
		String[] arguments = { "-NOT_A_PROFILE_EDITOR_CONTEXT", "profile" };
		profileEditorControlParser.parse(arguments);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void andTheArgumentsAreLessThan2thenAIllegalArgumentExceptionShouldBeThrown() {
		String[] arguments = { "-EDIT" };
		profileEditorControlParser.parse(arguments);
	}

	@Test
	public void thenTheAddProfileEditorControlShouldReturn() {
		String[] arguments = { "-EDIT", "test-profile" };
		ProfileEditorControl actual = profileEditorControlParser.parse(arguments);
		assertThat(actual, is(ProfileEditorControl.edit));
	}
}
