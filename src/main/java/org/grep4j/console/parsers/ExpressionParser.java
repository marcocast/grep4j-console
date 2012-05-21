package org.grep4j.console.parsers;

import static ch.lambdaj.Lambda.aggregate;

import org.grep4j.console.exception.Grep4jConsoleIllegalArgumentException;
import org.grep4j.core.aggregator.AggregateMultitokensExpression;

public class ExpressionParser extends InputParser<String> {

	@Override
	void validateInput(String[] arguments) throws Grep4jConsoleIllegalArgumentException {
		if (arguments[0].isEmpty()) {
			throw new Grep4jConsoleIllegalArgumentException("Expression is empty");
		}
	}

	@Override
	String interpret(String[] arguments) {
		String expression = "";
		boolean multipleTokens = arguments[0]
				.startsWith(AggregateMultitokensExpression.MULITIPLE_TOKEN_DELIMITER) ? true
				: false;
		if (!multipleTokens) {
			expression = arguments[0];
		} else {
			expression = aggregate(arguments,
					new AggregateMultitokensExpression());
		}
		return expression;
	}

}
