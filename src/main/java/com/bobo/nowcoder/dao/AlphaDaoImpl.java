package com.bobo.nowcoder.dao;

import org.springframework.stereotype.Repository;

/**
 * @Author: bo
 * @DATE: 2023/3/11 3:06
 **/
@Repository
public class AlphaDaoImpl implements AlphaDao{
    @Override
    public String select() {
        return "wahaha";
    }
}
