package com.project.instaclone.common;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {
    private Integer responseCode;
    private String responseMessage;
    private HttpStatus status;
    private T data;
}
