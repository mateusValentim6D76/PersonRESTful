package br.com.erudio.restwithspringboot.vo.v1;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

@JsonPropertyOrder({ "id", "firstName", "lastName", "gender", "address" })
public class PersonVOV1 extends RepresentationModel<PersonVOV1> implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	@Mapping("id")
	private Long key;
	private String firstName;
	private String lastName;
	private String address;
	private String gender;
	private Boolean enable;

	public PersonVOV1() {

	}

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof PersonVOV1)) return false;
		if (!super.equals(o)) return false;
		PersonVOV1 personVOV1 = (PersonVOV1) o;
		return Objects.equals(getKey(), personVOV1.getKey()) && Objects.equals(getFirstName(), personVOV1.getFirstName()) && Objects.equals(getLastName(), personVOV1.getLastName()) && Objects.equals(getAddress(), personVOV1.getAddress()) && Objects.equals(getGender(), personVOV1.getGender()) && Objects.equals(getEnable(), personVOV1.getEnable());
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getKey(), getFirstName(), getLastName(), getAddress(), getGender(), getEnable());
	}
}
