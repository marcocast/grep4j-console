package org.grep4j.console.persistence.profiles;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profiles {

	private final List<ConsoleProfile> profiles;

	public Profiles() {
		this.profiles = new ArrayList<ConsoleProfile>();
	}

	public Profiles(List<ConsoleProfile> profiles) {
		this.profiles = profiles;
	}

	@XmlElement(name = "profile")
	public List<ConsoleProfile> getProfiles() {
		return profiles;
	}

}
