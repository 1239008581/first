package com.example.demo.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    private Map<String, Object> execptionHandler(HttpServletRequest req, Exception e){
        Map<String, Object> mapModel = new HashMap<>();
        mapModel.put("success",false);
        mapModel.put("error",e.getMessage());
        return mapModel;
    }
}
