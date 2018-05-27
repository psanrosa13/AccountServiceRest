package com.paula.account.schema;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
	"id",
	"name",
	"email",
	"password"
})
public class Account {

	private Long id;
	
	@NotNull
	@NotBlank
	private String name;
	
	@NotNull
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	@NotNull
	@Min(value=5, message="Quantidade Minima de caracteres 5")
	private String password;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
