package com.mshoes.mshoesApi.models.DTO;

import lombok.Data;

@Data
public class RequestedCategory {
    private String categoryTitle;

    private String categoryDescription;

    private String categoryCreatedDate;

    private String categoryLastModified;

    private int categoryStatus;
}
