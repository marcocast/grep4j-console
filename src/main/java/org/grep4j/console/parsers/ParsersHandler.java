package org.grep4j.console.parsers;

import static ch.lambdaj.Lambda.convert;
import static ch.lambdaj.Lambda.selectDistinct;

import java.util.List;

import org.grep4j.console.ProfileEditorControl;
import org.grep4j.console.converters.ProfileConverter;
import org.grep4j.core.model.Profile;

public class ParsersHandler {

	/**
	 * Interface, this should be injected by a Springs
	 */
	private final InputParser<String> expressionParser;
	private final InputParser<List<String>> profileParser;
	private final InputParser<List<String>> contextControllerParser;
	private final InputParser<String> wildcardParser;
	private final InputParser<ProfileEditorControl> profileEditorControllerParser;
	private final InputParser<String> profileToCRUDParser;
	private final String[] args;

	public ParsersHandler(String[] args) {
		this.args = args.clone();
		this.expressionParser = new ExpressionParser();
		this.profileParser = new ProfileParser();
		this.contextControllerParser = new ContextControlParser();
		this.wildcardParser = new WildcardParser();
		this.profileEditorControllerParser = new ProfileEditorControlParser();
		this.profileToCRUDParser = new ProfileToCRUDParser();
	}

	public String getExpression() {
		return expressionParser.parse(args);
	}

	public String getProfileToCRUD() {
		return profileToCRUDParser.parse(args);
	}

	private List<String> profiles() {
		return profileParser.parse(args);
	}

	public List<Profile> getProfiles() {
		return convert(selectDistinct(profiles()), new ProfileConverter("server name"));
	}

	public List<String> getContextControls() {
		return contextControllerParser.parse(args);
	}

	public String getWildcard() {
		return wildcardParser.parse(args);
	}

	public ProfileEditorControl getProfileEditorController() {
		return profileEditorControllerParser.parse(args);
	}

}
