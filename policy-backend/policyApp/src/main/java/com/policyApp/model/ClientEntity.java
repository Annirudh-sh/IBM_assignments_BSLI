package com.policyApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "policy_details")
@Data
@NoArgsConstructor
public class ClientEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int clientId;
	@Column(name = "f_name")
	private String firstName;
	@Column(name = "l_name")
	private String lastName;
	@Column(name = "email")
	private String email;
	@Column(name = "age")
	private int age;
	@Column(name = "sex")
	private String gender;
	@Column(name = "con_num")
	private long contactNo;
	@Column(name = "p_no.")
	private String policyNo;
	
	
	
	@Override
	public String toString() {
		return "ClientEntity [clientId=" + clientId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", age=" + age + ", gender=" + gender + ", contactNo=" + contactNo + ", policyNo=" + policyNo
				+ "]";
	}



	public ClientEntity(String firstName, String lastName, String email, int age, String gender, long contactNo,
			String policyNo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
		this.gender = gender;
		this.contactNo = contactNo;
		this.policyNo = policyNo;
	}
	
	
}
