package com.funtalk.service;

import com.funtalk.mapper.*;
import com.funtalk.pojo.*;
import com.funtalk.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Component
public class UserService {

    @Autowired  TbSEmployeeMapper  tbSEmployeeMapper;
    @Autowired  TbSMenuMapper  tbSMenuMapper;
    @Autowired  TbSCustMapper tbSCustMapper;
    @Autowired  TbSAcctMapper  tbSAcctMapper;
    @Autowired  TbRMenuEmployeeMapper tbRMenuEmployeeMapper;
    @Autowired  TbSBillModeMapper  tbSBillModeMapper;


    public Page queryPage(Map<String,Object> paramMap) {

        Page page = new Page(null,(Integer)paramMap.get("pageno"),(Integer)paramMap.get("pagesize"));

        Integer startIndex = page.getStartno();
        paramMap.put("startindex", startIndex);

        List<TbSEmployee> datas = tbSEmployeeMapper.queryList(paramMap);

        page.setData(datas);

        Integer totalsize = tbSEmployeeMapper.queryCount(paramMap);

        page.setTotalsize(totalsize);

        return page;
    }

    public List<TbSMenu> getMemu(){

        TbSMenuExample example = new TbSMenuExample();
        example.setOrderByClause("menu_id"); // 表字段名称
        TbSMenuExample.Criteria criteria = example.createCriteria();
        criteria.andIfValidEqualTo("1");
        return tbSMenuMapper.selectByExample(example);

    }

    public List<TbSCust> getCust(){

        TbSCustExample example = new TbSCustExample();
        TbSCustExample.Criteria criteria = example.createCriteria();
        criteria.andIfValidEqualTo("1");
        return tbSCustMapper.selectByExample(example);

    }


    public List<TbSEmployee> validateWorkNo(String workNo){

        TbSEmployeeExample  example= new TbSEmployeeExample();
        TbSEmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andWorkNoEqualTo(workNo);
        return tbSEmployeeMapper.selectByExample(example);

    }

    @Transactional
    public int saveWorkNo(TbSEmployee employee){

        String password =employee.getWorkPwd();
        employee.setWorkPwd(DigestUtils.md5DigestAsHex(password.trim().getBytes()));
        employee.setCreateTime(new Date());

        tbSEmployeeMapper.insertSelective(employee);

        String[] allowMenus=employee.getAllowMenu().split(",");

        TbRMenuEmployee tbRMenuEmployee= new TbRMenuEmployee();

        if (allowMenus!=null && allowMenus.length>0){

            for (int i=0;i<allowMenus.length; i++) {

                tbRMenuEmployee.setEmployeeId(employee.getEmployeeId());
                tbRMenuEmployee.setIfValid(employee.getIfValid());
                tbRMenuEmployee.setMenuId(allowMenus[i]);

                tbRMenuEmployeeMapper.insert(tbRMenuEmployee);
            }
        }

        if(employee.getBillMode()==2){

            TbSBillMode tbSBillMode=new TbSBillMode();
            tbSBillMode.setCustId(employee.getCustId());
            tbSBillMode.setEmployeeId(employee.getEmployeeId());
            tbSBillMode.setmType(employee.getBillMode());
            tbSBillMode.setBillType(3);  // 1:语音  2:流量 3:短信
            tbSBillMode.setBillUnit(3);  // 1:分钟  2:kb 3:条
            tbSBillMode.setBillPrice(employee.getBillPrice());
            tbSBillMode.setIfValid(employee.getIfValid());

            tbSBillModeMapper.insertMode(tbSBillMode);

        }

        TbSAcct  tbSAcct = new TbSAcct();
        tbSAcct.setBelongType("2");  //1:客户账户;2工号账户
        tbSAcct.setBelongId(String.valueOf(employee.getEmployeeId()));  //cust_id或者employee_id
        tbSAcct.setCreateDate(new Date());
        tbSAcct.setIfValid("1");

        return tbSAcctMapper.insertSelective(tbSAcct);
    }

    public TbSEmployee getById(String employee_id){
        try {

            return tbSEmployeeMapper.getUserById(employee_id);

        }catch (NullPointerException e){
            e.printStackTrace();
        }
        return null;
    }

    public int updateUserInfo(TbSEmployee tbSEmployee){

        TbRMenuEmployeeExample example= new TbRMenuEmployeeExample();
        TbRMenuEmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andEmployeeIdEqualTo(tbSEmployee.getEmployeeId());

        tbRMenuEmployeeMapper.deleteByExample(example);

        TbRMenuEmployee menuEmployee = new TbRMenuEmployee();
        menuEmployee.setIfValid(tbSEmployee.getIfValid());
        String[] allowMenus=tbSEmployee.getAllowMenu().split(",");


        if (allowMenus!=null && allowMenus.length>0){

            for (int x=0;x<allowMenus.length;x++) {
                menuEmployee.setEmployeeId(tbSEmployee.getEmployeeId());
                menuEmployee.setMenuId(allowMenus[x]);
                menuEmployee.setIfValid(tbSEmployee.getIfValid());
                tbRMenuEmployeeMapper.insert(menuEmployee);
            }
        }


        TbSBillMode tbSBillMode=new TbSBillMode();
        tbSBillMode.setCustId(tbSEmployee.getCustId());
        tbSBillMode.setEmployeeId(tbSEmployee.getEmployeeId());

        // billmode 1 按客户号计费  2  按工号计费
        if(tbSEmployee.getBillMode()==2){

            tbSBillMode.setIfValid(tbSEmployee.getIfValid());
            tbSBillMode.setmType(tbSEmployee.getBillMode());
            tbSBillMode.setBillType(3);  // 1:语音  2:流量 3:短信
            tbSBillMode.setBillUnit(3);  // 1:分钟  2:kb 3:条
            tbSBillMode.setBillPrice(tbSEmployee.getBillPrice());
            tbSBillModeMapper.updateBillMode(tbSBillMode);

        }else{

            TbSBillModeExample  tbSBillModeExample = new TbSBillModeExample();
            TbSBillModeExample.Criteria criteria1= tbSBillModeExample.createCriteria();
            criteria1.andCustIdEqualTo(tbSEmployee.getCustId());
            criteria1.andEmployeeIdEqualTo(tbSEmployee.getEmployeeId());
            tbSBillModeMapper.deleteByExample(tbSBillModeExample);
        }

        try {

            return tbSEmployeeMapper.updateByPrimaryKeySelective(tbSEmployee);

        }catch (NullPointerException e){
            e.printStackTrace();
        }
        return 0;
    }

    public List<String> selectIds(String employee_id){
        try {
            return tbRMenuEmployeeMapper.selectId(employee_id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
