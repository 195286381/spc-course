package com.atguigu.springcloud.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestBean {
    private Integer age;
    private String name;
    private Boolean male;

    public static void main(String[] args) {
        TestBean testBean = new TestBean();
        testBean.setAge(12);
        testBean.setMale(false);
        testBean.setName("xz");
        testBean.getMale();
    }
}
