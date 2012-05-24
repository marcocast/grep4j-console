package org.grep4j.console.converters;

import static org.grep4j.console.persistence.profiles.ProfileConfiguration.profileConfiguration;

import org.grep4j.core.model.Profile;

import ch.lambdaj.function.convert.PropertyExtractor;

public class ProfileConverter extends PropertyExtractor<String, Profile> {

	public ProfileConverter(String propertyName) {
		super(propertyName);
	}

	@Override
	public Profile convert(String profileName) {
		return profileConfiguration().getProfileBy(profileName);
	}
}