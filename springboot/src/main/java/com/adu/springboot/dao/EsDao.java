package com.adu.springboot.dao;

import com.adu.springboot.pojo.TestBean;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface EsDao extends ElasticsearchRepository<TestBean,String> {
}
