package org.grep4j.console.aggregators;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

@Test
public class AggregateMultitokensExpressionTest {

	public void testSingleToken() {
		String regex = "'SELECTION(.*)CREATE'";
		List<String> multitoken = Arrays.asList(regex);

		AggregateMultitokensExpression aggregateMultitokensExpression = new AggregateMultitokensExpression();
		String aggragation = aggregateMultitokensExpression.aggregate(multitoken.iterator());
		assertThat(aggragation, is(regex));
	}

	public void testMultiToken() {
		String regex = "'SELECTION(.*)     CREATE'";
		List<String> multitoken = Arrays.asList(regex);

		AggregateMultitokensExpression aggregateMultitokensExpression = new AggregateMultitokensExpression();
		String aggragation = aggregateMultitokensExpression.aggregate(multitoken.iterator());
		assertThat(aggragation, is(regex));
	}
}
