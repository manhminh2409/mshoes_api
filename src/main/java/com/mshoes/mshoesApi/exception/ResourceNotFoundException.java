package com.mshoes.mshoesApi.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ResourceNotFoundException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private final String resourceName;
	private final String fieldName;
	private final Long fieldValue;

	public ResourceNotFoundException(String resourceName, String fieldName, Long fieldValue) {
		super(String.format("%s not found with %s: %s", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	public Long getFieldValue() {
		return fieldValue;
	}

	public String getFieldName() {
		return fieldName;
	}

	public String getResourceName() {
		return resourceName;
	}

}
