package com.adu.springboot.controller;

import com.adu.springboot.dao.EsDao;
import com.adu.springboot.pojo.TestBean;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

/**
 * @program: springboot
 * @Date: 2019/10/24 16:59
 * @Author: Mr.Deng
 * @Description:
 */
@RestController
@RequestMapping("/es")
public class EsController {

    @Autowired
    private EsDao esDao;

    @Autowired
    private RestHighLevelClient restHighLevelClient;


    @RequestMapping("/add/{id}")
    public String addTestBean(@PathVariable("id")String id){
        TestBean testBean = new TestBean();
        testBean.setId(id);
        testBean.setAge("18");
        testBean.setName("阿康");
        esDao.save(testBean);
        return "success";
    }

    @RequestMapping("/delete/{id}")
    public void deleteTestBean(@PathVariable("id")String id){

        esDao.deleteById(id);
    }

    @RequestMapping("/getTestBean/{id}")
    public Object getTestBean(@PathVariable("id")String id){
        Optional<TestBean> byId = esDao.findById(id);
        System.err.println(byId);

        return byId;
    }



    @GetMapping("queryByCondition")
    public Object queryByCondition(){
        SearchRequest testBean1 = new SearchRequest("my_index");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().
                query(QueryBuilders.matchAllQuery())
                .from(0)
                .size(10);
        testBean1.source(searchSourceBuilder);

        try {
            SearchHits hits = restHighLevelClient.search(testBean1, RequestOptions.DEFAULT).getHits();
            System.err.println(hits);
            ArrayList<Object> objects = new ArrayList<>();
            Iterator<SearchHit> iterator = hits.iterator();
            while (iterator.hasNext()){
                System.err.println(iterator.next().getSourceAsMap().toString());
            }
            return hits;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }



}
