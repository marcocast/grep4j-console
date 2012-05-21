package org.grep4j.console.profileeditor;

import org.grep4j.core.profile.model.Profile;
import org.grep4j.core.profile.model.ServerDetails;

public class AddProfileEditorConsoleDialog extends ProfileEditorConsoleDialog {

	@Override
	public void handleRequest(String profileName) {
		if (console != null) {

			Profile profile = generateProfile(profileName);

			profile.setFileLocation(console.readLine("Please enter the fileTargetLocation [Example: /opt/jboss/server/] "));

			profile.setFileName(console.readLine("Please enter the fileTargetName [Example: server.log] "));

			ServerDetails serverDetails = new ServerDetails();

			serverDetails.setHost(console.readLine("Please enter the host [Example: 172.xx.xx.xx] "));

			serverDetails.setUser(console.readLine("Please enter the user "));

			serverDetails.setPassword(console.readLine("Please enter the password "));

			profile.setServerDetails(serverDetails);

			persistProfile(profile);

			console.printf("profile " + profileName + " has been ADDED");
			console.writer().println();
		}
	}
}