package org.grep4j.console.persistence.profiles;

import static ch.lambdaj.Lambda.having;
import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.selectFirst;
import static org.grep4j.console.persistence.profiles.ProfileConfiguration.profileConfiguration;
import static org.grep4j.console.persistence.profiles.ProfileFixture.aSimpleProfile;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class ProfileEditorTest {

	private static final String NEW_PROFILE_NAME = "new profile name";

	private static final String PROFILE_NAME_TO_BE_DELETED = "profile to be deleted";

	private static final String PROFILE_NAME_TO_BE_UPDATED = "profile to be updated";

	private ConsoleProfile aProfile;

	@BeforeMethod
	public void createSimpleProfile() {

		System.setProperty(
				ProfileConfiguration.PROFILES_CONFIGURATION_PROPERTY,
				getClass().getResource("/profiles-editing-test.xml").getPath());

		System.setProperty(ProfileEditor.SKIP_PERSIST_PROPERTY, "true");

		ProfileConfigurationFacility.resetProfileConfiguration();

		aProfile = aSimpleProfile();
	}

	public void addProfileTest() {

		ProfileEditor.add(aProfile);

		assertThat(
				profileConfiguration().getProfileBy(
						aProfile.getName()), is(notNullValue()));

	}

	public void removeProfileTest() {

		ConsoleProfile profileToBeRemoved = selectFirst(
				profileConfiguration().getProfiles(),
				having(on(ConsoleProfile.class).getName(),
						equalTo(PROFILE_NAME_TO_BE_DELETED)));

		ProfileEditor.remove(profileToBeRemoved);

		assertThat(
				profileConfiguration().getProfileBy(
						PROFILE_NAME_TO_BE_DELETED), is(nullValue()));

	}

	public void updateProfileTest() {

		ConsoleProfile profileToBeUpdated = profileConfiguration()
				.getProfileBy(PROFILE_NAME_TO_BE_UPDATED);
		ConsoleProfile updatedProfile = new ConsoleProfile();

		updatedProfile.setName(NEW_PROFILE_NAME);
		updatedProfile.setId(profileToBeUpdated.getId());
		updatedProfile.setFilePath(profileToBeUpdated
				.getFilePath());
		updatedProfile.setServerDetails(profileToBeUpdated.getServerDetails());

		ProfileEditor.update(updatedProfile);

		assertThat(profileConfiguration().getProfileBy(updatedProfile.getId()).getName(),
				equalTo(NEW_PROFILE_NAME));

	}

}
