package com.contactapp.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@JsonPropertyOrder({
    "id",
    "name",
    "phone",
    "email",
    "favorite",
})

public class ContactDTO {

	private Long id;
	
	@NotBlank(message = "Name is required")
	@Size(min=2, max=50, message="Name must be between 2 and 50 characters")
	private String name;
	
	@NotBlank(message = "Phone is required")
	@Pattern(regexp = "^[6-9][0-9]{9}$", message="phone no must be exactly 10 digits")
	private String phone;
	
	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	private String email;
	
	@NotBlank(message = "Address is required")
	private String address;
	
	private boolean favorite;

	public ContactDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public boolean isFavorite() {
	    return favorite;
	}

	public void setFavorite(boolean favorite) {
	    this.favorite = favorite;
	}
}