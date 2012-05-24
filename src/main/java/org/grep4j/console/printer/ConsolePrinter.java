package org.grep4j.console.printer;

import static org.grep4j.console.persistence.profiles.ProfileConfiguration.profileConfiguration;

import java.util.Set;

import org.grep4j.core.task.GrepResult;

public class ConsolePrinter {

	private final static String AROUND_HEADER = "************************************************";
	private final static String AROUND_CONTENT = "					";

	public static void printResult(Set<GrepResult> results) {
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
