package com.vn.ssl_be.controller;


import com.vn.ssl_be.domain.lesson.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users/")
public class LessonWebController {
    private final LessonService lessonService;






}