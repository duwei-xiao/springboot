package com.adu.springboot.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

/**
 * @program: springboot
 * @Date: 2019/10/24 17:02
 * @Author: Mr.Deng
 * @Description:
 */
@Document(indexName = "my_index",type="testBean")
public class TestBean implements Serializable {

    @Id
    private String id;
    @Field
    private String name;
    @Field
    private String age;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
