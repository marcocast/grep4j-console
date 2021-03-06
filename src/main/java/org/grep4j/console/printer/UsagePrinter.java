package org.grep4j.console.printer;

import static org.grep4j.console.persistence.profiles.ProfileEditor.profiles;

import java.io.Console;
import java.io.PrintWriter;
import java.util.List;

import org.grep4j.console.persistence.profiles.ConsoleProfile;

public class UsagePrinter {

	public static void printUsage() {
		Console console = System.console();
		if (console != null) {
			PrintWriter out = console.writer();
			out.println("Usage: java -jar Grep4j-jar-with-dependencies.jar");
			out.println("\tExpression");
			out.println("\tProfiles[");
			out.println("\t\t where options include: ");
			List<ConsoleProfile> profiles = profiles();
			for (ConsoleProfile profile : profiles) {
				out.println("\t\t\t" + profile.getName());
			}
			out.println("\t\t ] ");
			out.println("\tcontext control[ ");
			out.println("\t\t where options include: ");
			out.println("\t\t\t -B, --before-context=NUM ");
			out.println("\t\t\t -A, --after-context=NUM ");
			out.println("\t\t ] ");
			out.println("\tEditing profiles[ ");
			out.println("\t\t where options include: ");
			out.println("\t\t\t -ADD profileName");
			out.println("\t\t\t -EDIT profileName");
			out.println("\t\t\t -REMOVE profileName");
			out.println("\t\t\t -VIEW profileName");
		}
	}
}
