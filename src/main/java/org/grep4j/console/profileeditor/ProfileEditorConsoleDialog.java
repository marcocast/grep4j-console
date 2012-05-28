package org.grep4j.console.profileeditor;

import static org.grep4j.console.persistence.profiles.ProfileEditor.add;
import static org.grep4j.console.persistence.profiles.ProfileEditor.getProfile;
import static org.grep4j.console.persistence.profiles.ProfileEditor.remove;
import static org.grep4j.console.persistence.profiles.ProfileEditor.update;

import java.io.Console;

import org.grep4j.console.persistence.profiles.ConsoleProfile;

public abstract class ProfileEditorConsoleDialog {

	protected final Console console = System.console();

	public abstract void handleRequest(String profileName);

	protected ConsoleProfile generateProfile(String profileName) {
		ConsoleProfile profile = new ConsoleProfile();
		profile.setName(profileName);
		return profile;
	}

	protected boolean persistProfile(ConsoleProfile profile) {
		add(profile);
		return true;
	}

	protected boolean removeProfile(ConsoleProfile profile) {
		remove(profile);
		return true;
	}

	protected boolean updateProfile(ConsoleProfile profile) {
		update(profile);
		return true;
	}

	protected ConsoleProfile retrieveProfile(ConsoleProfile profile) {
		return getProfile(profile);
	}

}
