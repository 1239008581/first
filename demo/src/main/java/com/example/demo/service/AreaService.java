package com.example.demo.service;

import com.example.demo.entity.Area;

import java.util.List;

public interface AreaService {

    /**
     *getAll
     * @return
     */
    List<Area> getArealist();

    /**
     * add
     * @param area
     * @return
     */
    boolean addArea(Area area);

    /**
     * delete
     * @param areaId
     * @return
     */
    boolean removeArea(int areaId);

    /**
     * update
     * @param area
     * @return
     */
    boolean modifyArea(Area area);

    /**
     * query
     * @param areaId
     * @return
     */
    Area getArea(int areaId);

}
