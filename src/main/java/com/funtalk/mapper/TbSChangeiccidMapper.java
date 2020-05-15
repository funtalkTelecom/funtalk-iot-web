package com.funtalk.mapper;

import com.funtalk.pojo.TbPIpMap;
import com.funtalk.pojo.TbSChangeiccid;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbSChangeiccidMapper {

    int updateByPrimaryKeySelective(TbSChangeiccid record);

    int updateByPrimaryKey(TbSChangeiccid record);

    List<TbSChangeiccid> getDetail(@Param("cust_id")String cust_id,@Param("statu")int statu,@Param("cardsNum")int cardsNum);

    boolean fetchCard(@Param("ip")String ip,@Param("cardList")List<TbSChangeiccid> cardList);

    boolean portUp(@Param("port")String port,@Param("ip")String ip,@Param("iccid")String iccid);

    boolean statuUp(@Param("statu")int statu,@Param("iccid")String iccid);

    boolean reportUp(@Param("day_dur")double day_dur,@Param("mon_dur")double mon_dur,@Param("iccid")String iccid);

    TbSChangeiccid getReady(@Param("port")String port,@Param("ip")String ip);

    boolean statusUp(@Param("statu")int statu,@Param("cardList")List<TbSChangeiccid> cards);

    List<TbSChangeiccid> queryAll1(@Param("cust_id")String cust_id);

    List<TbSChangeiccid> queryAll2(@Param("statu")int statu,@Param("cust_id")String cust_id);

    List<TbSChangeiccid> queryAll3(@Param("statu")int statu,@Param("cust_id")String cust_id,@Param("ip")String ip);

    List<String> getIp(@Param("cust_id")String cust_id);

    boolean name1(@Param("cust_id")String cust_id,@Param("port")String port,@Param("ip")String ip);

    boolean name2(@Param("cust_id")String cust_id,@Param("iccid")String iccid);

    List<TbSChangeiccid> portCards1 (@Param("port")String port,@Param("ip")String ip);

    List<TbSChangeiccid> portCards2 (@Param("port")String port,@Param("ip")String ip,@Param("statu")int statu);

    boolean recover(@Param("cust_id")String cust_id);

    List<TbSChangeiccid> cards();

    boolean ipUp(@Param("ip")String ip,@Param("iccid")String iccid);

    TbSChangeiccid findByIccid(@Param("iccid")String iccid);

    TbPIpMap localMap(@Param("local")String local);

    TbPIpMap public_Map(@Param("public_")String public_);

    boolean upByIccid(@Param("statu")int statu,@Param("port")String port,@Param("ip")String ip,@Param("iccid")String iccid);
}