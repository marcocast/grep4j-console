package org.grep4j.console;

import org.grep4j.console.profileeditor.AddProfileEditorConsoleDialog;
import org.grep4j.console.profileeditor.EditProfileEditorConsoleDialog;
import org.grep4j.console.profileeditor.ProfileEditorConsoleDialog;
import org.grep4j.console.profileeditor.RemoveProfileEditorConsoleDialog;
import org.grep4j.console.profileeditor.ViewProfileEditorConsoleDialog;

public enum ProfileEditorControl {
	add("-ADD", new AddProfileEditorConsoleDialog()),
	edit("-EDIT", new EditProfileEditorConsoleDialog()),
	view("-VIEW", new ViewProfileEditorConsoleDialog()),
	remove("-REMOVE", new RemoveProfileEditorConsoleDialog());

	private final String profileEditorControl;
	private final ProfileEditorConsoleDialog profileEditorConsoleDialog;

	ProfileEditorControl(String profileEditorControl, ProfileEditorConsoleDialog profileEditorConsoleDialog) {
		this.profileEditorControl = profileEditorControl;
		this.profileEditorConsoleDialog = profileEditorConsoleDialog;
	}

	public String getProfileEditorControl() {
		return this.profileEditorControl;
	}

	public ProfileEditorConsoleDialog getProfileEditorConsoleDialog() {
		return this.profileEditorConsoleDialog;
	}

	public static boolean isAProfileEditorControl(String item) {
		for (ProfileEditorControl profileEditorControl : ProfileEditorControl.values()) {
			if (item.equalsIgnoreCase(profileEditorControl.getProfileEditorControl())) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(ProfileEditorControl.valueOf("add"));
	}
}
