package com.funtalk.controller;

import net.sf.json.JSONObject;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;


@RestController//相当于声明Controller - 提共restful 风格
@EnableAutoConfiguration//自动配置，不需要写spring的配置文件
class YiZhengController {

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式

    @RequestMapping("/deviceState")
    public String doDeviceState(@RequestBody JSONObject jsonParam){


        System.out.println("----time------>"+dateFormat.format(new Date()) +"----------"+jsonParam.toString());

        return "{state:ok}";

    }
}
