package com.dbly.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Setter
@Getter
public class Student {
    private Integer sid;
    private String sname;
    private String ssex;
    private String className;
}
