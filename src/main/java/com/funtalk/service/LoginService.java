package com.funtalk.service;

import com.funtalk.mapper.TbSEmployeeMapper;
import com.funtalk.mapper.TbSMenuMapper;
import com.funtalk.pojo.TbSEmployee;
import com.funtalk.pojo.TbSMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoginService {

    @Autowired
    private TbSEmployeeMapper userMapper;

    @Autowired
    private TbSMenuMapper menuMapper;


    public TbSEmployee getUser(String userName){

      return   userMapper.getUserByName(userName);

    }

    public List<TbSMenu> getUserMenu(String userName){

        return  menuMapper.getMenuByUserName(userName);

    }

}
