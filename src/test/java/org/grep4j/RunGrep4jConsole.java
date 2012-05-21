package org.grep4j;

import junit.framework.TestCase;

import org.grep4j.console.Grep4jConsole;

/**
 * Unit test for simple App.
 */
public class RunGrep4jConsole extends TestCase {

	public static void main(String[] args) {
		Grep4jConsole.main(new String[] { "java", "localbox" });
	}

}
