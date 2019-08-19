package com.example.demo.dao;

import com.example.demo.entity.Area;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AreaDaoTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AreaDao areaDao;

    @Test
    public void queryAllArea() {
        List<Area> areas = areaDao.queryAllArea();
        for (Area area:areas) {
            logger.info("area:{}",area);
        }
    }

    @Test
    public void insertArea() {
        Area area = new Area();
        area.setAreaName("西苑");
        area.setPriority(5);
        int count = areaDao.insertArea(area);
        logger.info("count:{}",count);
    }

    @Test
    public void deleteAreaById() {
        int count = areaDao.deleteAreaById(5);
        logger.info("count:{}",count);
    }

    @Test
    public void updateArea() {
        Area area = new Area();
        area.setAreaName("南苑");
        area.setAreaId(2);
        int count = areaDao.updateArea(area);
        logger.info("count:{}",count);
    }

    @Test
    public void queryAreaById() {
        Area area = areaDao.queryAreaById(1);
        logger.info("arae:{}",area);
    }
}