package org.grep4j.console;

import static org.grep4j.console.printer.ConsolePrinter.printResult;
import static org.grep4j.console.printer.UsagePrinter.printUsage;
import static org.grep4j.core.Grep4j.grep;
import static org.grep4j.core.fluent.Dictionary.on;

import java.util.List;

import org.grep4j.console.parsers.ParsersHandler;
import org.grep4j.console.profileeditor.ProfileEditorConsoleDialog;
import org.grep4j.core.model.Profile;
import org.grep4j.core.options.ExtraLines;

public class Grep4jConsole {

	/**
	 * Interface, this should be injected by a Springs
	 * 
	 * java -jar target/Grep4j-console-jar-with-dependencies.jar "'PP_OPENBET(.*)SELECTION(.*)CREATE(.*)54011274'" uat-phase-engine
	 * 
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
			printResult(grep(expression(), on(profiles()), getContextControls().toArray(new ExtraLines[] {})));
		}
	}

	private List<ExtraLines> getContextControls() {
		return parsersHandler.getContextControls();
	}

	private List<Profile> profiles() {
		return parsersHandler.getProfiles();
	}

	private String expression() {
		System.out.println(">>>>>>" + parsersHandler.getExpression() + "<<<<<<<<");
		return parsersHandler.getExpression();
	}

	private boolean isAProfileCRUDOperation() {
		if (parsersHandler.getProfileEditorController() == null) {
			return false;
		}

		return true;
	}
}
