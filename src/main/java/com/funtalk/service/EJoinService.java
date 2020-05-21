package com.funtalk.service;


import com.funtalk.mapper.TbSChangeiccidMapper;
import com.funtalk.pojo.TbPIpMap;
import com.funtalk.pojo.TbSChangeiccid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class EJoinService {
    @Autowired
    TbSChangeiccidMapper tbSChangeiccidMapper;


    public List<TbSChangeiccid> getDetail(String cust_id,int statu,int cardsNum){
        try {
            return tbSChangeiccidMapper.getDetail(cust_id,statu,cardsNum);
        }catch (NullPointerException e) {
            System.out.println("all resource has been consumed");
            return null;
        }
    }

    public boolean fetchCard(String ip,List<TbSChangeiccid> cardList){
        return tbSChangeiccidMapper.fetchCard(ip,cardList);
    }

    public boolean portUp(String port,String iccid,String ip){
        return tbSChangeiccidMapper.portUp(port,iccid,ip);
    }

    public boolean statusUp(int statu,List<TbSChangeiccid> cardList){
        return tbSChangeiccidMapper.statusUp(statu,cardList);
    }

    public boolean statuUp(int statu,String iccid){
        return tbSChangeiccidMapper.statuUp(statu,iccid);
    }

    public boolean reportUp(double day_dur,double mon_dur,String iccid){
        return tbSChangeiccidMapper.reportUp(day_dur,mon_dur,iccid);
    }

    public TbSChangeiccid getReady(String port,String ip){
        return tbSChangeiccidMapper.getReady(port,ip);
    }

    public List<TbSChangeiccid> queryAll(String cust_id){
        return tbSChangeiccidMapper.queryAll1(cust_id);
    }

    public List<TbSChangeiccid> queryAll(int statu,String cust_id){
        return tbSChangeiccidMapper.queryAll2(statu,cust_id);
    }

    public List<TbSChangeiccid> queryAll(int statu,String cust_id,String ip){
        return tbSChangeiccidMapper.queryAll3(statu,cust_id,ip);
    }

    public List<String> getIp(String cust_id){
        return tbSChangeiccidMapper.getIp(cust_id);
    }

    public boolean name(String cust_id,String port,String ip){
        return tbSChangeiccidMapper.name1(cust_id,port,ip);
    }

    public boolean name(String cust_id,String iccid){
        return tbSChangeiccidMapper.name2(cust_id,iccid);
    }

    public List<TbSChangeiccid> portCards(String port,String ip){
        return tbSChangeiccidMapper.portCards1(port,ip);
    }

    public List<TbSChangeiccid> portCards(String port,String ip,int statu){
        return tbSChangeiccidMapper.portCards2(port,ip,statu);
    }

//    public TbSChangeiccid getFree(String cust_id){
//        return tbSChangeiccidMapper.getFree(cust_id);
//    }

    public boolean recover(String cust_id){
        return tbSChangeiccidMapper.recover(cust_id);
    }

    public List<TbSChangeiccid> cards(){return tbSChangeiccidMapper.cards();}

    public boolean ipUp(String ip,String iccid){return tbSChangeiccidMapper.ipUp(ip,iccid);}

    public TbSChangeiccid findByIccid(String iccid){return tbSChangeiccidMapper.findByIccid(iccid);}

    public TbPIpMap localMap(String local){return tbSChangeiccidMapper.localMap(local);}

    public TbPIpMap public_Map(String public_){return tbSChangeiccidMapper.public_Map(public_);}

    public boolean upByIccid(String ip,String port,int statu,String iccid){return tbSChangeiccidMapper.upByIccid(statu,port,ip,iccid);}
}
