package com.funtalk.service;

import com.funtalk.mapper.TbSBillModeMapper;
import com.funtalk.pojo.TbSBillMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ModeService {

    @Autowired
    TbSBillModeMapper tbSBillModeMapper;

    public void insertMode(TbSBillMode tbSBillMode){
        try {
            tbSBillModeMapper.insert(tbSBillMode);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateMode(TbSBillMode tbSBillMode){


        try {
            tbSBillModeMapper.updateBillMode(tbSBillMode);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<TbSBillMode> selectEPMode(String employeeId){
        return tbSBillModeMapper.selectEPMode(employeeId);
    }

}
