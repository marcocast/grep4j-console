package org.grep4j.console.persistence.profiles;

public class ProfileFixture {

	private ProfileFixture() {
	}

	public static ConsoleProfile aSimpleProfile() {
		ConsoleProfile profile = new ConsoleProfile();

		profile.setId(new Integer(1));
		profile.setName("profile name");
		profile.setFilePath("target location/target name");

		ConsoleServerDetails serverDetails = new ConsoleServerDetails();
		serverDetails.setHost("hostname");
		serverDetails.setUser("username");
		serverDetails.setPassword("password");

		profile.setServerDetails(serverDetails);
		return profile;
	}

}
