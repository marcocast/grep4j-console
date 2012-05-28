package org.grep4j.console.persistence.profiles;

import static ch.lambdaj.Lambda.having;
import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.selectFirst;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import javax.xml.bind.JAXB;

public class ProfileConfiguration {

	public static final String SEPARATOR = File.separator;

	public static final String PROFILES_CONFIGURATION_PROPERTY = "org.grep4j.profiles";

	private static final String DEFAULT_CONFIGURATION_FOLDER = System
			.getProperty("user.home") + SEPARATOR + ".grep4j";

	private static final String FULL_PATH_CONFIGURATION_FILE = DEFAULT_CONFIGURATION_FOLDER
			+ SEPARATOR + "profiles.xml";

	private final Profiles profiles;

	private final String profileFilename;

	protected static ProfileConfiguration profileConfiguration;

	public static ProfileConfiguration profileConfiguration() {
		if (profileConfiguration == null) {
			profileConfiguration = new ProfileConfiguration();
		}
		return profileConfiguration;
	}

	public String getProfileFilename() {
		return profileFilename;
	}

	public List<ConsoleProfile> getProfiles() {
		return profiles.getProfiles();
	}

	public ConsoleProfile getProfileBy(String name) {
		return selectFirst(profiles.getProfiles(),
				having(on(ConsoleProfile.class).getName(), equalTo(name)));
	}

	public ConsoleProfile getProfileBy(int id) {
		return selectFirst(
				profiles.getProfiles(),
				having(on(ConsoleProfile.class).getId(),
						equalTo(Integer.valueOf(id))));
	}

	private ProfileConfiguration() {

		verifyConfigFolder();

		profileFilename = getConfigurationFileName();

		if (fileExists()) {
			profiles = parseConfigurationFile();
		} else {
			profiles = createEmptyConfiguration();
		}

	}

	private void verifyConfigFolder() {
		File folder = new File(DEFAULT_CONFIGURATION_FOLDER);
		if (!folder.exists()) {
			folder.mkdir();
		}

	}

	private Profiles createEmptyConfiguration() {
		return new Profiles();
	}

	private Profiles parseConfigurationFile() {
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(profileFilename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return JAXB.unmarshal(fileInputStream, Profiles.class);
	}

	private boolean fileExists() {
		return new File(profileFilename).exists();
	}

	private String getConfigurationFileName() {
		if (System.getProperty(PROFILES_CONFIGURATION_PROPERTY) != null) {
			return System.getProperty(PROFILES_CONFIGURATION_PROPERTY);
		} else {
			return FULL_PATH_CONFIGURATION_FILE;
		}
	}

}
