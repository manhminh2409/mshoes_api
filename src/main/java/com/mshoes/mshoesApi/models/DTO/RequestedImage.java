package com.mshoes.mshoesApi.models.DTO;

import lombok.Data;

@Data
public class RequestedImage {
    private String imageUrl;

    private long productId;
}
