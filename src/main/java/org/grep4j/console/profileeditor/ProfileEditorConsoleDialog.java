package org.grep4j.console.profileeditor;

import static org.grep4j.console.persistence.profiles.ProfileEditor.add;
import static org.grep4j.console.persistence.profiles.ProfileEditor.getProfile;
import static org.grep4j.console.persistence.profiles.ProfileEditor.remove;
import static org.grep4j.console.persistence.profiles.ProfileEditor.update;

import java.io.Console;

import org.grep4j.core.model.Profile;

public abstract class ProfileEditorConsoleDialog {

	protected final Console console = System.console();

	public abstract void handleRequest(String profileName);

	protected Profile generateProfile(String profileName) {
		Profile profile = new Profile();
		profile.setName(profileName);
		return profile;
	}

	protected boolean persistProfile(Profile profile) {
		add(profile);
		return true;
	}

	protected boolean removeProfile(Profile profile) {
		remove(profile);
		return true;
	}

	protected boolean updateProfile(Profile profile) {
		update(profile);
		return true;
	}

	protected Profile retrieveProfile(Profile profile) {
		return getProfile(profile);
	}

}
