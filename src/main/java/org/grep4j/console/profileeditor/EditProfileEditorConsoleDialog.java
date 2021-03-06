package org.grep4j.console.profileeditor;

import org.grep4j.console.persistence.profiles.ConsoleProfile;
import org.grep4j.console.persistence.profiles.ConsoleServerDetails;

public class EditProfileEditorConsoleDialog extends ProfileEditorConsoleDialog {

	@Override
	public void handleRequest(String profileName) {
		if (console != null) {

			ConsoleProfile profile = retrieveProfile(generateProfile(profileName));

			String input = console
					.readLine("Please enter the file Path ["
							+ profile.getFilePath() + "] ");
			if (input != null && !input.isEmpty()) {
				profile.setFilePath(input.trim());
			}

			input = console.readLine("Please enter the wildcard ["
					+ profile.getWildcard() + "] ");
			if (input != null && !input.isEmpty()) {
				profile.setWildcard(input.trim());
			}

			ConsoleServerDetails serverDetails = profile.getServerDetails();

			input = console.readLine("Please enter the host ["
					+ serverDetails.getHost() + "] ");
			if (input != null && !input.isEmpty()) {
				serverDetails.setHost(input.trim());
			}

			input = console.readLine("Please enter the user ["
					+ serverDetails.getUser() + "] ");
			if (input != null && !input.isEmpty()) {
				serverDetails.setUser(input.trim());
			}

			input = console.readLine("Please enter the password ["
					+ serverDetails.getPassword() + "] ");
			if (input != null && !input.isEmpty()) {
				serverDetails.setPassword(input.trim());
			}

			updateProfile(profile);

			console.printf("profile " + profileName + " has been UPDATED");
			console.writer().println();

		}
	}
}
