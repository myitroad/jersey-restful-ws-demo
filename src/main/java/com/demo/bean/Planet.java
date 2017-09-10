package com.demo.bean;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by LTN on 2016/9/4.
 */
@XmlRootElement
public class Planet {
    public int id;
    public String name;
    public double radius;
}