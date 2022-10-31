package com.policyApp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;

}
