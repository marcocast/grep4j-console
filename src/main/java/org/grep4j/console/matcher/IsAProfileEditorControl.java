package org.grep4j.console.matcher;

import org.grep4j.console.ProfileEditorControl;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class IsAProfileEditorControl extends TypeSafeMatcher<String> {

	public void describeTo(Description description) {
		description.appendText("not a profile editor control");
	}

	@Override
	public boolean matchesSafely(String item) {
		return ProfileEditorControl.isAProfileEditorControl(item);
	}

	@Factory
	public static <T> Matcher<String> aProfileEditorControl() {
		return new IsAProfileEditorControl();
	}
}
