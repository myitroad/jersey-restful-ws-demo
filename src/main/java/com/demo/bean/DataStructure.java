package com.demo.bean;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Map;

/**
 * Created by LTN on 2016/9/6.
 */
@XmlRootElement
public class DataStructure {
    public List<Map<String,String>> nodeList;

    public  DataStructure(List<Map<String, String>> nodeList) {
        this.nodeList=nodeList;
    }
}
