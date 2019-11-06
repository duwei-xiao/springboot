package com.adu.springboot.service;

import com.adu.springboot.dao.EsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: springboot
 * @Date: 2019/10/24 19:23
 * @Author: Mr.Deng
 * @Description:
 */
@Service
public class EsServiceImpl implements EsService {

    @Autowired
    private EsDao esDao;


}
