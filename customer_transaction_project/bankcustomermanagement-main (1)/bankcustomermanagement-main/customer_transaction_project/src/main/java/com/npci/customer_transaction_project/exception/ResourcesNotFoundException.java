package com.npci.customer_transaction_project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourcesNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 5534144714229379985L;

	public ResourcesNotFoundException(String message) {
		super(message);
	}
}
