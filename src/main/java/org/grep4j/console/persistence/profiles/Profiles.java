package org.grep4j.console.persistence.profiles;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.grep4j.core.model.Profile;

@XmlRootElement
public class Profiles {

	private final List<Profile> profiles;

	public Profiles() {
		this.profiles = new ArrayList<Profile>();
	}

	public Profiles(List<Profile> profiles) {
		this.profiles = profiles;
	}

	@XmlElement(name = "profile")
	public List<Profile> getProfiles() {
		return profiles;
	}

}
