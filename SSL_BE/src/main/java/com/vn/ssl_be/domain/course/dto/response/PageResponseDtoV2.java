package com.vn.ssl_be.domain.course.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResponseDtoV2<T> {
    private List<T> data;
    private Integer totalPage;
    private Integer pageNumber;
    private Integer size;
    private String sort;
}
