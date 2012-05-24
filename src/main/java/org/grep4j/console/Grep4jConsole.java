package org.grep4j.console;

import static org.grep4j.console.printer.ConsolePrinter.printResult;
import static org.grep4j.console.printer.UsagePrinter.printUsage;
import static org.grep4j.core.Grep4j.Builder.grep;
import static org.grep4j.core.Grep4j.Builder.on;

import java.util.List;

import org.grep4j.console.parsers.ParsersHandler;
import org.grep4j.console.profileeditor.ProfileEditorConsoleDialog;
import org.grep4j.core.Grep4j;
import org.grep4j.core.model.Profile;

public class Grep4jConsole {

	/**
	 * Interface, this should be injected by a Springs
	 */
	private final ParsersHandler parsersHandler;

	public static void main(String[] args) {
		try {
			if (args.length < 1) {
				printUsage();
			} else {
				new Grep4jConsole(args).run();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			printUsage();
		} finally {
			System.exit(0);
		}
	}

	public Grep4jConsole(String[] args) {
		this.parsersHandler = new ParsersHandler(args);
	}

	public void run() {

		if (isAProfileCRUDOperation()) {
			ProfileEditorConsoleDialog consoleDialog = parsersHandler.getProfileEditorController().getProfileEditorConsoleDialog();
			consoleDialog.handleRequest(parsersHandler.getProfileToCRUD());
		} else {
			Grep4j grep4j = grep(expression(), on(profiles()))
					.withContextControls(getContextControls())
					.withWildcard(getWildcard()).build();
			printResult(grep4j.execute().andGetResults());
		}

	}

	private String getWildcard() {
		return parsersHandler.getWildcard();
	}

	private List<String> getContextControls() {
		return parsersHandler.getContextControls();
	}

	private List<Profile> profiles() {
		return parsersHandler.getProfiles();
	}

	private String expression() {
		return parsersHandler.getExpression();
	}

	private boolean isAProfileCRUDOperation() {
		if (parsersHandler.getProfileEditorController() == null) {
			return false;
		}

		return true;
	}
}
