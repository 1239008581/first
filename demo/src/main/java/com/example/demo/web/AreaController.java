package com.example.demo.web;

import com.example.demo.entity.Area;
import com.example.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/superadmin")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/arealist",method = RequestMethod.GET)
    public Map<String, Object> getArealist(){
        Map<String, Object> mapModel = new HashMap<>();
        List<Area> areas = areaService.getArealist();
        mapModel.put("areas",areas);
        return mapModel;
    }

    @RequestMapping(value = "/addarea", method = RequestMethod.POST)
    public Map<String, Object> addArea(@RequestBody Area area){
        Map<String, Object> mapModel = new HashMap<>();
        mapModel.put("success",areaService.addArea(area));
        return mapModel;
    }

    @GetMapping(value = "/deletearea")
    public Map<String, Object> removeArea(Integer areaId){
        Map<String, Object> mapModel = new HashMap<>();
        mapModel.put("success",areaService.removeArea(areaId));
        return mapModel;
    }

    @PostMapping(value = "/modifyarea")
    public Map<String, Object> modifyArea(@RequestBody Area area){
        Map<String, Object> mapModel = new HashMap<>();
        mapModel.put("success",areaService.modifyArea(area));
        return mapModel;
    }

    @GetMapping(value = "/getarea")
    public Map<String, Object> getArea(int areaId ){
        Map<String, Object> mapModel = new HashMap<>();
        mapModel.put("area",areaService.getArea(areaId));
        return mapModel;
    }

}
