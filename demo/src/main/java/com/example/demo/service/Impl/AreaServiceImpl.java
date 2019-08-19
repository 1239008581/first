package com.example.demo.service.Impl;

import com.example.demo.dao.AreaDao;
import com.example.demo.entity.Area;
import com.example.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getArealist() {
        return areaDao.queryAllArea();
    }

    @Transactional//默认接受RuntimeException并回滚
    @Override
    public boolean addArea(Area area) {
        if (area.getAreaName() == null) throw new RuntimeException("区域名称信息不能为空！");
        area.setCreateTime(new Date());
        area.setLastEditTime(new Date());
        int count = areaDao.insertArea(area);
        try{
            if (count == 1) return true;
            else throw new RuntimeException("插入失败");
        }catch(RuntimeException e){
            throw new RuntimeException("插入失败");
        }
    }

    @Transactional
    @Override
    public boolean removeArea(int areaId) {
        int count = areaDao.deleteAreaById(areaId);
        if(count == 1) return true;
        else return false;
    }

    @Transactional
    @Override
    public boolean modifyArea(Area area) {
        area.setLastEditTime(new Date());
        int count = areaDao.updateArea(area);
        if(count == 1) return true;
        else return false;
    }

    @Transactional
    @Override
    public Area getArea(int areaId) {
        return areaDao.queryAreaById(areaId);
    }
}
