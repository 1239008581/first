package com.example.demo.service;

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
public class AreaServiceTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AreaService areaService;

    @Test
    public void getArealist() {
        List<Area> areas = areaService.getArealist();
        logger.info("areas:{}",areas);
    }

    @Test
    public void addArea() {
        Area area = new Area();
        area.setAreaName("西苑");
        area.setPriority(3);
        boolean result = areaService.addArea(area);
        logger.info("result:{}",result);
    }

    @Test
    public void removeArea() {
        boolean result = areaService.removeArea(6);
        logger.info("result:{}",result);
    }

    @Test
    public void modifyArea() {
        Area area = new Area();
        area.setAreaId(2);
        area.setAreaName("北苑");
        boolean result = areaService.modifyArea(area);
        logger.info("result:{}",result);
    }

    @Test
    public void getArea() {
        Area area = areaService.getArea(2);
        logger.info("area:{}",area);
    }
}