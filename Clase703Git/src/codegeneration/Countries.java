// default package
// Generated 09-jun-2015 15:56:59 by Hibernate Tools 3.4.0.CR1
package codegeneration;

import java.util.HashSet;
import java.util.Set;

/**
 * Countries generated by hbm2java
 */
public class Countries implements java.io.Serializable {

	private String countryId;
	private Regions regions;
	private String countryName;
	private Set locationses = new HashSet(0);

	public Countries() {
	}

	public Countries(String countryId) {
		this.countryId = countryId;
	}

	public Countries(String countryId, Regions regions, String countryName,
			Set locationses) {
		this.countryId = countryId;
		this.regions = regions;
		this.countryName = countryName;
		this.locationses = locationses;
	}

	public String getCountryId() {
		return this.countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public Regions getRegions() {
		return this.regions;
	}

	public void setRegions(Regions regions) {
		this.regions = regions;
	}

	public String getCountryName() {
		return this.countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Set getLocationses() {
		return this.locationses;
	}

	public void setLocationses(Set locationses) {
		this.locationses = locationses;
	}

}
