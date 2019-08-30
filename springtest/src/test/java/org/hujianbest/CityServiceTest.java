package org.hujianbest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class CityServiceTest {

    @Resource
    CityDao cityDao;


    /**
     * 主要是spring里面的mybatis配置得写对，然后使用spring-test和junit操作数据库
     * 包含spring.xml的配置和数据库链接信息的配置
     */
    @Test
    public void findCityByName() {
        Assert.assertEquals("武汉",cityDao.findByName("wuhan").getDescription());
    }
}