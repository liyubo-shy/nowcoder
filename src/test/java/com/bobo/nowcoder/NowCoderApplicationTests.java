package com.bobo.nowcoder;

import com.bobo.nowcoder.dao.AlphaDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = NowCoderApplication.class)
public class NowCoderApplicationTests implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
    @Test
    public void testApplicationContext(){
        System.out.println(applicationContext);
        AlphaDao alphaDao = applicationContext.getBean(AlphaDao.class);
        String select = alphaDao.select();
        System.out.println(select);
    }
}
