package org.grep4j.console.persistence.profiles;

import static ch.lambdaj.Lambda.having;
import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.selectFirst;
import static ch.lambdaj.Lambda.selectMax;
import static org.grep4j.console.persistence.profiles.ProfileConfiguration.profileConfiguration;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.xml.bind.JAXB;

/**
 * This class consists exclusively of static methods used to add modify delete and retrieve @see Profile.
 * 
 * @author Marco Castigliego
 * @author Giovanni Gargiulo
 */
public class ProfileEditor {

	private ProfileEditor() {
	}

	public static final String SKIP_PERSIST_PROPERTY = "org.grep4j.skip.persist";

	/**
	 * @param profile
	 */
	public static void add(ConsoleProfile profile) {
		//check last separator
		if (profile.getId() == null) {
			if (profiles().size() == 0) {
				profile.setId(1);
			} else {
				Integer maxIndex = ((ConsoleProfile) selectMax(profiles(),
						on(ConsoleProfile.class).getId())).getId();
				profile.setId(maxIndex + 1);
			}
		}
		profiles().add(profile);
		persistProfileConfiguration();
	}

	/**
	 * @param profile
	 */
	public static void remove(ConsoleProfile profile) {
		profiles().remove(getProfile(profile));
		persistProfileConfiguration();
	}

	/**
	 * 
	 */
	public static void removeAll() {
		profiles().clear();
		persistProfileConfiguration();
	}

	/**
	 * @param profileToUpdate
	 */
	public static void update(ConsoleProfile profileToUpdate) {
		ConsoleProfile profile = getProfile(profileToUpdate);
		int index = profiles().indexOf(profile);
		remove(profile);
		profiles().add(index, profileToUpdate);
		persistProfileConfiguration();

	}

	/**
	 * @param profile
	 * @return
	 */
	public static ConsoleProfile getProfile(ConsoleProfile profile) {
		ConsoleProfile result = null;
		if (profile.getId() != null) {
			result = selectFirst(
					profiles(),
					having(on(ConsoleProfile.class).getId(),
							equalTo(profile.getId())));
		} else if (profile.getName() != null) {
			result = selectFirst(
					profiles(),
					having(on(ConsoleProfile.class).getName(),
							equalTo(profile.getName())));
		}

		return result;
	}

	public static List<ConsoleProfile> profiles() {
		return profileConfiguration().getProfiles();
	}

	protected static void persistProfileConfiguration() {

		JAXB.marshal(new Profiles(profileConfiguration()
				.getProfiles()), System.out);
		
		if (System.getProperty(ProfileEditor.SKIP_PERSIST_PROPERTY) != null) {
			return;
		}

		try {

			File configuration = new File(profileConfiguration()
					.getProfileFilename());

			if (configuration.exists()) {
				configuration.delete();
			}

			configuration.createNewFile();

			FileOutputStream fileOutputStream = new FileOutputStream(
					configuration);

			JAXB.marshal(new Profiles(profileConfiguration()
					.getProfiles()), fileOutputStream);

			fileOutputStream.flush();
			fileOutputStream.close();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
