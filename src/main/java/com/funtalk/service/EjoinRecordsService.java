package com.funtalk.service;

import com.funtalk.mapper.TbSEjoinrecordsMapper;
import com.funtalk.pojo.TbSEjoinrecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EjoinRecordsService {

    @Autowired
    TbSEjoinrecordsMapper tbSEjoinrecordsMapper;

    public void insertRecord(TbSEjoinrecords tbSEjoinrecords){
        tbSEjoinrecordsMapper.insert(tbSEjoinrecords);
    }

}
