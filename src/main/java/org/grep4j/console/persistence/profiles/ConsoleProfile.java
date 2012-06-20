package org.grep4j.console.persistence.profiles;

import javax.xml.bind.annotation.XmlAttribute;

public class ConsoleProfile {

	private Integer id;
	private String name;
	private String filePath;
	private ConsoleServerDetails serverDetails;
	private String wildcard;

	@XmlAttribute
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@XmlAttribute
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public ConsoleServerDetails getServerDetails() {
		return serverDetails;
	}

	public void setServerDetails(ConsoleServerDetails serverDetails) {
		this.serverDetails = serverDetails;
	}

	public String getWildcard() {
		return wildcard;
	}

	public void setWildcard(String wildcard) {
		this.wildcard = wildcard;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsoleProfile other = (ConsoleProfile) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ConsoleProfile [name=" + name + ", filePath=" + filePath + ", wildcard=" + wildcard + ", serverDetails=" + serverDetails + "]";
	}

}
