package com.example.demo.dao;

import com.example.demo.entity.Area;

import java.util.List;

public interface AreaDao {
    /**
     * All
     * @return
     */
    List<Area> queryAllArea();

    /**
     * insert
     * @param area
     * @return
     */
    int insertArea(Area area);

    /**
     * delete
     * @param areaId
     * @return
     */
    int deleteAreaById(int areaId);

    /**
     * update
     * @param area
     * @return
     */
    int updateArea(Area area);

    /**
     * query
     * @param areaId
     * @return
     */
    Area queryAreaById(int areaId);
}
