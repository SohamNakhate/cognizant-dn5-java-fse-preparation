package com.exampleRESTAPIs.youtubeAnujSharma.Learning.RESTAPIs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentDto {
    private Long id;
    private String name;
    private String email;

//    All of these constructors and gettes and setters can be replaced by using one single Annotation named @Data
//
//    //Constructor
//    public StudentDto(Long id, String name, String email) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//    }
//
//    public StudentDto(){
//    }
//    //getters and setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
}
