package org.grep4j.console.profileeditor;

import org.grep4j.core.profile.model.Profile;

public class RemoveProfileEditorConsoleDialog extends ProfileEditorConsoleDialog {

	@Override
	public void handleRequest(String profileName) {
		if (console != null) {
			Profile profile = generateProfile(profileName);
			removeProfile(profile);
			console.printf("Profile " + profileName + " has been REMOVED");
			console.writer().println();
		}
	}
}
