package org.grep4j.console.profileeditor;

import org.grep4j.console.persistence.profiles.ConsoleProfile;

public class ViewProfileEditorConsoleDialog extends ProfileEditorConsoleDialog {

	@Override
	public void handleRequest(String profileName) {
		if (console != null) {
			ConsoleProfile profile = generateProfile(profileName);
			console.printf(retrieveProfile(profile).toString());
			console.writer().println();
		}
	}
}
