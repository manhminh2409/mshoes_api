package com.mshoes.mshoesApi.models.DTO;

import lombok.Data;

@Data
public class UserDTO {

	private long userId;

	private String userName;

	private String userPassword;

	private String userFullname;

	private String userEmail;

	private String userAddress;

	private String userPhone;

	private String userCreatedDate;

	private String userLastModified;

	private int userRole;

	private int userStatus;
}
