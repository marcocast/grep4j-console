package org.grep4j.console.converters;

import static org.grep4j.console.persistence.profiles.ProfileConfiguration.profileConfiguration;

import org.grep4j.console.persistence.profiles.ConsoleProfile;
import org.grep4j.core.model.Profile;
import org.grep4j.core.model.ServerDetails;

import ch.lambdaj.function.convert.PropertyExtractor;

public class ProfileConverter extends PropertyExtractor<String, Profile> {

	public ProfileConverter() {
		super("ProfileConverter");
	}

	@Override
	public Profile convert(String profileName) {
		ConsoleProfile consoleProfile = profileConfiguration().getProfileBy(profileName);
		Profile profile = new Profile(consoleProfile.getName(), consoleProfile.getFilePath());
		ServerDetails serverDetails = new ServerDetails(consoleProfile.getServerDetails().getHost());
		serverDetails.setPassword(consoleProfile.getServerDetails().getPassword());
		serverDetails.setUser(consoleProfile.getServerDetails().getUser());
		profile.setServerDetails(serverDetails);
		return profile;
	}
}