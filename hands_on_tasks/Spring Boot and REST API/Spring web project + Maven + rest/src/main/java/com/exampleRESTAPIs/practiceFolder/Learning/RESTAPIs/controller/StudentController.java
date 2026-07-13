package com.exampleRESTAPIs.youtubeAnujSharma.Learning.RESTAPIs.controller;

import com.exampleRESTAPIs.youtubeAnujSharma.Learning.RESTAPIs.dto.StudentDto;
import  org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @GetMapping("/student")
    public StudentDto getStudent(){
        return new StudentDto(101L, "Soham", "nakhatesv@rknec.edu" );
    }
}
