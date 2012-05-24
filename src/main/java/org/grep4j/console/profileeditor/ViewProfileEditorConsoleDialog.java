package org.grep4j.console.profileeditor;

import org.grep4j.core.model.Profile;

public class ViewProfileEditorConsoleDialog extends ProfileEditorConsoleDialog {

	@Override
	public void handleRequest(String profileName) {
		if (console != null) {
			Profile profile = generateProfile(profileName);
			console.printf(retrieveProfile(profile).toString());
			console.writer().println();
		}
	}
}
