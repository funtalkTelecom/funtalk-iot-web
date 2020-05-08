package com.funtalk.oraclemapper;

import com.funtalk.pojo.BfCdmaSmCallT;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BfCdmaSmCallTMapper {


    List<BfCdmaSmCallT> selectSmsDispatch(@Param("bfCdmaSmCallT") BfCdmaSmCallT bfCdmaSmCallT);

}