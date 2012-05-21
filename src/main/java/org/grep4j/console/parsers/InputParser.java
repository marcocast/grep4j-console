package org.grep4j.console.parsers;

import org.grep4j.console.exception.Grep4jConsoleIllegalArgumentException;

public abstract class InputParser<T> {

	abstract void validateInput(String[] arguments) throws Grep4jConsoleIllegalArgumentException;

	abstract T interpret(String[] arguments);

	public T parse(String[] arguments) {
		validateInput(arguments);
		return interpret(arguments);
	}
}
