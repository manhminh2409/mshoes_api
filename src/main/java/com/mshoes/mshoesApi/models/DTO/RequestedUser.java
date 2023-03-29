package com.mshoes.mshoesApi.models.DTO;

import lombok.Data;

@Data
public class RequestedUser {
    private String userName;

    private String userPassword;

    private String userFullname;

    private String userEmail;

    private String userAddress;

    private String userPhone;
}
