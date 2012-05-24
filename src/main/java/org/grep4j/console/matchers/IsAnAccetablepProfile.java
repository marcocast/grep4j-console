package org.grep4j.console.matchers;

import static org.grep4j.console.persistence.profiles.ProfileConfiguration.profileConfiguration;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class IsAnAccetablepProfile extends TypeSafeMatcher<String> {

	@Override
	public void describeTo(Description description) {
		description.appendText("not an acceptable profile");
	}

	@Override
	public boolean matchesSafely(String item) {
		return profileConfiguration().getProfileBy(item) != null;
	}

	@Factory
	public static <T> Matcher<String> anAccetableProfile() {
		return new IsAnAccetablepProfile();
	}

}
