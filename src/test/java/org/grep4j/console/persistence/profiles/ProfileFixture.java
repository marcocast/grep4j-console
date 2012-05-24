package org.grep4j.console.persistence.profiles;

import org.grep4j.core.model.Profile;
import org.grep4j.core.model.ServerDetails;

public class ProfileFixture {

	private ProfileFixture() {
	}

	public static Profile aSimpleProfile() {
		Profile profile = new Profile();

		profile.setId(new Integer(1));
		profile.setName("profile name");
		profile.setFileLocation("target location/");
		profile.setFileName("target name");

		ServerDetails serverDetails = new ServerDetails();
		serverDetails.setHost("hostname");
		serverDetails.setUser("username");
		serverDetails.setPassword("password");

		profile.setServerDetails(serverDetails);
		return profile;
	}

}
