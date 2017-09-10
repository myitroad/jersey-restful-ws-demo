package com.demo.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Created by LTN on 2016/9/2.
 */
@XmlRootElement
public class MyJaxbBean {
    public String name;
    public int age;

    public MyJaxbBean() {} // JAXB needs this

    public MyJaxbBean(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
