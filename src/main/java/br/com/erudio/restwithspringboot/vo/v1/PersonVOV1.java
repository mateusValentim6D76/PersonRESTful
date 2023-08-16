package br.com.erudio.restwithspringboot.vo.v1;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

@JsonPropertyOrder({ "id", "firstName", "lastName", "address", "gender" })
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

	private Date registrationDate;

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

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof PersonVOV1)) return false;
		if (!super.equals(o)) return false;
		PersonVOV1 that = (PersonVOV1) o;
		return Objects.equals(getKey(), that.getKey()) && Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getLastName(), that.getLastName()) && Objects.equals(getAddress(), that.getAddress()) && Objects.equals(getGender(), that.getGender()) && Objects.equals(getEnable(), that.getEnable()) && Objects.equals(registrationDate, that.registrationDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getKey(), getFirstName(), getLastName(), getAddress(), getGender(), getEnable(), registrationDate);
	}
}
