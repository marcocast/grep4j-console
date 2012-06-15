package org.grep4j.console.printer;

import static org.grep4j.console.persistence.profiles.ProfileConfiguration.profileConfiguration;

import org.grep4j.core.result.GrepResult;
import org.grep4j.core.result.GrepResultsSet;

public class ConsolePrinter {

	private final static String AROUND_HEADER = "************************************************";
	private final static String AROUND_CONTENT = "					";

	public static void printResult(GrepResultsSet results) {
		for (GrepResult result : results) {
			System.out.println(AROUND_HEADER + AROUND_HEADER + AROUND_HEADER);
			System.out.println(AROUND_CONTENT + result.getProfileName() + " {" + result.getFileName() + " [" + hostFor(result) + "]}"
					+ AROUND_CONTENT);
			System.out.println(AROUND_HEADER + AROUND_HEADER + AROUND_HEADER);
			System.out.println(result.getText());
		}

	}

	private static String hostFor(GrepResult result) {
		return profileConfiguration().getProfileBy(result.getProfileName()).getServerDetails().getHost();
	}

}
