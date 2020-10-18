package com.ljh.mongodb.dao.impl;

import com.ljh.mongodb.dao.IPublicDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;


@Repository
public class PublicDaoImpl<T> implements IPublicDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void update(Query query, Update update, Class t){
        mongoTemplate.updateMulti(query,update,t);
    }
}
