package com.funtalk.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbOBatchrechargeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbOBatchrechargeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andBatchIdIsNull() {
            addCriterion("batch_id is null");
            return (Criteria) this;
        }

        public Criteria andBatchIdIsNotNull() {
            addCriterion("batch_id is not null");
            return (Criteria) this;
        }

        public Criteria andBatchIdEqualTo(Integer value) {
            addCriterion("batch_id =", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdNotEqualTo(Integer value) {
            addCriterion("batch_id <>", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdGreaterThan(Integer value) {
            addCriterion("batch_id >", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("batch_id >=", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdLessThan(Integer value) {
            addCriterion("batch_id <", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdLessThanOrEqualTo(Integer value) {
            addCriterion("batch_id <=", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdIn(List<Integer> values) {
            addCriterion("batch_id in", values, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdNotIn(List<Integer> values) {
            addCriterion("batch_id not in", values, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdBetween(Integer value1, Integer value2) {
            addCriterion("batch_id between", value1, value2, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdNotBetween(Integer value1, Integer value2) {
            addCriterion("batch_id not between", value1, value2, "batchId");
            return (Criteria) this;
        }

        public Criteria andBelongTypeIsNull() {
            addCriterion("belong_type is null");
            return (Criteria) this;
        }

        public Criteria andBelongTypeIsNotNull() {
            addCriterion("belong_type is not null");
            return (Criteria) this;
        }

        public Criteria andBelongTypeEqualTo(String value) {
            addCriterion("belong_type =", value, "belongType");
            return (Criteria) this;
        }

        public Criteria andBelongTypeNotEqualTo(String value) {
            addCriterion("belong_type <>", value, "belongType");
            return (Criteria) this;
        }

        public Criteria andBelongTypeGreaterThan(String value) {
            addCriterion("belong_type >", value, "belongType");
            return (Criteria) this;
        }

        public Criteria andBelongTypeGreaterThanOrEqualTo(String value) {
            addCriterion("belong_type >=", value, "belongType");
            return (Criteria) this;
        }

        public Criteria andBelongTypeLessThan(String value) {
            addCriterion("belong_type <", value, "belongType");
            return (Criteria) this;
        }

        public Criteria andBelongTypeLessThanOrEqualTo(String value) {
            addCriterion("belong_type <=", value, "belongType");
            return (Criteria) this;
        }

        public Criteria andBelongTypeLike(String value) {
            addCriterion("belong_type like", value, "belongType");
            return (Criteria) this;
        }

        public Criteria andBelongTypeNotLike(String value) {
            addCriterion("belong_type not like", value, "belongType");
            return (Criteria) this;
        }

        public Criteria andBelongTypeIn(List<String> values) {
            addCriterion("belong_type in", values, "belongType");
            return (Criteria) this;
        }

        public Criteria andBelongTypeNotIn(List<String> values) {
            addCriterion("belong_type not in", values, "belongType");
            return (Criteria) this;
        }

        public Criteria andBelongTypeBetween(String value1, String value2) {
            addCriterion("belong_type between", value1, value2, "belongType");
            return (Criteria) this;
        }

        public Criteria andBelongTypeNotBetween(String value1, String value2) {
            addCriterion("belong_type not between", value1, value2, "belongType");
            return (Criteria) this;
        }

        public Criteria andBelongIdIsNull() {
            addCriterion("belong_id is null");
            return (Criteria) this;
        }

        public Criteria andBelongIdIsNotNull() {
            addCriterion("belong_id is not null");
            return (Criteria) this;
        }

        public Criteria andBelongIdEqualTo(String value) {
            addCriterion("belong_id =", value, "belongId");
            return (Criteria) this;
        }

        public Criteria andBelongIdNotEqualTo(String value) {
            addCriterion("belong_id <>", value, "belongId");
            return (Criteria) this;
        }

        public Criteria andBelongIdGreaterThan(String value) {
            addCriterion("belong_id >", value, "belongId");
            return (Criteria) this;
        }

        public Criteria andBelongIdGreaterThanOrEqualTo(String value) {
            addCriterion("belong_id >=", value, "belongId");
            return (Criteria) this;
        }

        public Criteria andBelongIdLessThan(String value) {
            addCriterion("belong_id <", value, "belongId");
            return (Criteria) this;
        }

        public Criteria andBelongIdLessThanOrEqualTo(String value) {
            addCriterion("belong_id <=", value, "belongId");
            return (Criteria) this;
        }

        public Criteria andBelongIdLike(String value) {
            addCriterion("belong_id like", value, "belongId");
            return (Criteria) this;
        }

        public Criteria andBelongIdNotLike(String value) {
            addCriterion("belong_id not like", value, "belongId");
            return (Criteria) this;
        }

        public Criteria andBelongIdIn(List<String> values) {
            addCriterion("belong_id in", values, "belongId");
            return (Criteria) this;
        }

        public Criteria andBelongIdNotIn(List<String> values) {
            addCriterion("belong_id not in", values, "belongId");
            return (Criteria) this;
        }

        public Criteria andBelongIdBetween(String value1, String value2) {
            addCriterion("belong_id between", value1, value2, "belongId");
            return (Criteria) this;
        }

        public Criteria andBelongIdNotBetween(String value1, String value2) {
            addCriterion("belong_id not between", value1, value2, "belongId");
            return (Criteria) this;
        }

        public Criteria andWorkNoIsNull() {
            addCriterion("work_no is null");
            return (Criteria) this;
        }

        public Criteria andWorkNoIsNotNull() {
            addCriterion("work_no is not null");
            return (Criteria) this;
        }

        public Criteria andWorkNoEqualTo(String value) {
            addCriterion("work_no =", value, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoNotEqualTo(String value) {
            addCriterion("work_no <>", value, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoGreaterThan(String value) {
            addCriterion("work_no >", value, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoGreaterThanOrEqualTo(String value) {
            addCriterion("work_no >=", value, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoLessThan(String value) {
            addCriterion("work_no <", value, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoLessThanOrEqualTo(String value) {
            addCriterion("work_no <=", value, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoLike(String value) {
            addCriterion("work_no like", value, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoNotLike(String value) {
            addCriterion("work_no not like", value, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoIn(List<String> values) {
            addCriterion("work_no in", values, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoNotIn(List<String> values) {
            addCriterion("work_no not in", values, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoBetween(String value1, String value2) {
            addCriterion("work_no between", value1, value2, "workNo");
            return (Criteria) this;
        }

        public Criteria andWorkNoNotBetween(String value1, String value2) {
            addCriterion("work_no not between", value1, value2, "workNo");
            return (Criteria) this;
        }

        public Criteria andFileDbNameIsNull() {
            addCriterion("file_db_name is null");
            return (Criteria) this;
        }

        public Criteria andFileDbNameIsNotNull() {
            addCriterion("file_db_name is not null");
            return (Criteria) this;
        }

        public Criteria andFileDbNameEqualTo(String value) {
            addCriterion("file_db_name =", value, "fileDbName");
            return (Criteria) this;
        }

        public Criteria andFileDbNameNotEqualTo(String value) {
            addCriterion("file_db_name <>", value, "fileDbName");
            return (Criteria) this;
        }

        public Criteria andFileDbNameGreaterThan(String value) {
            addCriterion("file_db_name >", value, "fileDbName");
            return (Criteria) this;
        }

        public Criteria andFileDbNameGreaterThanOrEqualTo(String value) {
            addCriterion("file_db_name >=", value, "fileDbName");
            return (Criteria) this;
        }

        public Criteria andFileDbNameLessThan(String value) {
            addCriterion("file_db_name <", value, "fileDbName");
            return (Criteria) this;
        }

        public Criteria andFileDbNameLessThanOrEqualTo(String value) {
            addCriterion("file_db_name <=", value, "fileDbName");
            return (Criteria) this;
        }

        public Criteria andFileDbNameLike(String value) {
            addCriterion("file_db_name like", value, "fileDbName");
            return (Criteria) this;
        }

        public Criteria andFileDbNameNotLike(String value) {
            addCriterion("file_db_name not like", value, "fileDbName");
            return (Criteria) this;
        }

        public Criteria andFileDbNameIn(List<String> values) {
            addCriterion("file_db_name in", values, "fileDbName");
            return (Criteria) this;
        }

        public Criteria andFileDbNameNotIn(List<String> values) {
            addCriterion("file_db_name not in", values, "fileDbName");
            return (Criteria) this;
        }

        public Criteria andFileDbNameBetween(String value1, String value2) {
            addCriterion("file_db_name between", value1, value2, "fileDbName");
            return (Criteria) this;
        }

        public Criteria andFileDbNameNotBetween(String value1, String value2) {
            addCriterion("file_db_name not between", value1, value2, "fileDbName");
            return (Criteria) this;
        }

        public Criteria andFilePathIsNull() {
            addCriterion("file_path is null");
            return (Criteria) this;
        }

        public Criteria andFilePathIsNotNull() {
            addCriterion("file_path is not null");
            return (Criteria) this;
        }

        public Criteria andFilePathEqualTo(String value) {
            addCriterion("file_path =", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotEqualTo(String value) {
            addCriterion("file_path <>", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThan(String value) {
            addCriterion("file_path >", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("file_path >=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThan(String value) {
            addCriterion("file_path <", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThanOrEqualTo(String value) {
            addCriterion("file_path <=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLike(String value) {
            addCriterion("file_path like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotLike(String value) {
            addCriterion("file_path not like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathIn(List<String> values) {
            addCriterion("file_path in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotIn(List<String> values) {
            addCriterion("file_path not in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathBetween(String value1, String value2) {
            addCriterion("file_path between", value1, value2, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotBetween(String value1, String value2) {
            addCriterion("file_path not between", value1, value2, "filePath");
            return (Criteria) this;
        }

        public Criteria andFileServerNameIsNull() {
            addCriterion("file_server_name is null");
            return (Criteria) this;
        }

        public Criteria andFileServerNameIsNotNull() {
            addCriterion("file_server_name is not null");
            return (Criteria) this;
        }

        public Criteria andFileServerNameEqualTo(String value) {
            addCriterion("file_server_name =", value, "fileServerName");
            return (Criteria) this;
        }

        public Criteria andFileServerNameNotEqualTo(String value) {
            addCriterion("file_server_name <>", value, "fileServerName");
            return (Criteria) this;
        }

        public Criteria andFileServerNameGreaterThan(String value) {
            addCriterion("file_server_name >", value, "fileServerName");
            return (Criteria) this;
        }

        public Criteria andFileServerNameGreaterThanOrEqualTo(String value) {
            addCriterion("file_server_name >=", value, "fileServerName");
            return (Criteria) this;
        }

        public Criteria andFileServerNameLessThan(String value) {
            addCriterion("file_server_name <", value, "fileServerName");
            return (Criteria) this;
        }

        public Criteria andFileServerNameLessThanOrEqualTo(String value) {
            addCriterion("file_server_name <=", value, "fileServerName");
            return (Criteria) this;
        }

        public Criteria andFileServerNameLike(String value) {
            addCriterion("file_server_name like", value, "fileServerName");
            return (Criteria) this;
        }

        public Criteria andFileServerNameNotLike(String value) {
            addCriterion("file_server_name not like", value, "fileServerName");
            return (Criteria) this;
        }

        public Criteria andFileServerNameIn(List<String> values) {
            addCriterion("file_server_name in", values, "fileServerName");
            return (Criteria) this;
        }

        public Criteria andFileServerNameNotIn(List<String> values) {
            addCriterion("file_server_name not in", values, "fileServerName");
            return (Criteria) this;
        }

        public Criteria andFileServerNameBetween(String value1, String value2) {
            addCriterion("file_server_name between", value1, value2, "fileServerName");
            return (Criteria) this;
        }

        public Criteria andFileServerNameNotBetween(String value1, String value2) {
            addCriterion("file_server_name not between", value1, value2, "fileServerName");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andPayStateIsNull() {
            addCriterion("pay_state is null");
            return (Criteria) this;
        }

        public Criteria andPayStateIsNotNull() {
            addCriterion("pay_state is not null");
            return (Criteria) this;
        }

        public Criteria andPayStateEqualTo(String value) {
            addCriterion("pay_state =", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateNotEqualTo(String value) {
            addCriterion("pay_state <>", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateGreaterThan(String value) {
            addCriterion("pay_state >", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateGreaterThanOrEqualTo(String value) {
            addCriterion("pay_state >=", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateLessThan(String value) {
            addCriterion("pay_state <", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateLessThanOrEqualTo(String value) {
            addCriterion("pay_state <=", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateLike(String value) {
            addCriterion("pay_state like", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateNotLike(String value) {
            addCriterion("pay_state not like", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateIn(List<String> values) {
            addCriterion("pay_state in", values, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateNotIn(List<String> values) {
            addCriterion("pay_state not in", values, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateBetween(String value1, String value2) {
            addCriterion("pay_state between", value1, value2, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateNotBetween(String value1, String value2) {
            addCriterion("pay_state not between", value1, value2, "payState");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNull() {
            addCriterion("pay_time is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(Date value) {
            addCriterion("pay_time =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(Date value) {
            addCriterion("pay_time <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(Date value) {
            addCriterion("pay_time >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pay_time >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(Date value) {
            addCriterion("pay_time <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(Date value) {
            addCriterion("pay_time <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(List<Date> values) {
            addCriterion("pay_time in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(List<Date> values) {
            addCriterion("pay_time not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(Date value1, Date value2) {
            addCriterion("pay_time between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(Date value1, Date value2) {
            addCriterion("pay_time not between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andSerNumIsNull() {
            addCriterion("ser_num is null");
            return (Criteria) this;
        }

        public Criteria andSerNumIsNotNull() {
            addCriterion("ser_num is not null");
            return (Criteria) this;
        }

        public Criteria andSerNumEqualTo(String value) {
            addCriterion("ser_num =", value, "serNum");
            return (Criteria) this;
        }

        public Criteria andSerNumNotEqualTo(String value) {
            addCriterion("ser_num <>", value, "serNum");
            return (Criteria) this;
        }

        public Criteria andSerNumGreaterThan(String value) {
            addCriterion("ser_num >", value, "serNum");
            return (Criteria) this;
        }

        public Criteria andSerNumGreaterThanOrEqualTo(String value) {
            addCriterion("ser_num >=", value, "serNum");
            return (Criteria) this;
        }

        public Criteria andSerNumLessThan(String value) {
            addCriterion("ser_num <", value, "serNum");
            return (Criteria) this;
        }

        public Criteria andSerNumLessThanOrEqualTo(String value) {
            addCriterion("ser_num <=", value, "serNum");
            return (Criteria) this;
        }

        public Criteria andSerNumLike(String value) {
            addCriterion("ser_num like", value, "serNum");
            return (Criteria) this;
        }

        public Criteria andSerNumNotLike(String value) {
            addCriterion("ser_num not like", value, "serNum");
            return (Criteria) this;
        }

        public Criteria andSerNumIn(List<String> values) {
            addCriterion("ser_num in", values, "serNum");
            return (Criteria) this;
        }

        public Criteria andSerNumNotIn(List<String> values) {
            addCriterion("ser_num not in", values, "serNum");
            return (Criteria) this;
        }

        public Criteria andSerNumBetween(String value1, String value2) {
            addCriterion("ser_num between", value1, value2, "serNum");
            return (Criteria) this;
        }

        public Criteria andSerNumNotBetween(String value1, String value2) {
            addCriterion("ser_num not between", value1, value2, "serNum");
            return (Criteria) this;
        }

        public Criteria andRechargeStateIsNull() {
            addCriterion("recharge_state is null");
            return (Criteria) this;
        }

        public Criteria andRechargeStateIsNotNull() {
            addCriterion("recharge_state is not null");
            return (Criteria) this;
        }

        public Criteria andRechargeStateEqualTo(String value) {
            addCriterion("recharge_state =", value, "rechargeState");
            return (Criteria) this;
        }

        public Criteria andRechargeStateNotEqualTo(String value) {
            addCriterion("recharge_state <>", value, "rechargeState");
            return (Criteria) this;
        }

        public Criteria andRechargeStateGreaterThan(String value) {
            addCriterion("recharge_state >", value, "rechargeState");
            return (Criteria) this;
        }

        public Criteria andRechargeStateGreaterThanOrEqualTo(String value) {
            addCriterion("recharge_state >=", value, "rechargeState");
            return (Criteria) this;
        }

        public Criteria andRechargeStateLessThan(String value) {
            addCriterion("recharge_state <", value, "rechargeState");
            return (Criteria) this;
        }

        public Criteria andRechargeStateLessThanOrEqualTo(String value) {
            addCriterion("recharge_state <=", value, "rechargeState");
            return (Criteria) this;
        }

        public Criteria andRechargeStateLike(String value) {
            addCriterion("recharge_state like", value, "rechargeState");
            return (Criteria) this;
        }

        public Criteria andRechargeStateNotLike(String value) {
            addCriterion("recharge_state not like", value, "rechargeState");
            return (Criteria) this;
        }

        public Criteria andRechargeStateIn(List<String> values) {
            addCriterion("recharge_state in", values, "rechargeState");
            return (Criteria) this;
        }

        public Criteria andRechargeStateNotIn(List<String> values) {
            addCriterion("recharge_state not in", values, "rechargeState");
            return (Criteria) this;
        }

        public Criteria andRechargeStateBetween(String value1, String value2) {
            addCriterion("recharge_state between", value1, value2, "rechargeState");
            return (Criteria) this;
        }

        public Criteria andRechargeStateNotBetween(String value1, String value2) {
            addCriterion("recharge_state not between", value1, value2, "rechargeState");
            return (Criteria) this;
        }

        public Criteria andRechargeTransIdIsNull() {
            addCriterion("recharge_trans_id is null");
            return (Criteria) this;
        }

        public Criteria andRechargeTransIdIsNotNull() {
            addCriterion("recharge_trans_id is not null");
            return (Criteria) this;
        }

        public Criteria andRechargeTransIdEqualTo(String value) {
            addCriterion("recharge_trans_id =", value, "rechargeTransId");
            return (Criteria) this;
        }

        public Criteria andRechargeTransIdNotEqualTo(String value) {
            addCriterion("recharge_trans_id <>", value, "rechargeTransId");
            return (Criteria) this;
        }

        public Criteria andRechargeTransIdGreaterThan(String value) {
            addCriterion("recharge_trans_id >", value, "rechargeTransId");
            return (Criteria) this;
        }

        public Criteria andRechargeTransIdGreaterThanOrEqualTo(String value) {
            addCriterion("recharge_trans_id >=", value, "rechargeTransId");
            return (Criteria) this;
        }

        public Criteria andRechargeTransIdLessThan(String value) {
            addCriterion("recharge_trans_id <", value, "rechargeTransId");
            return (Criteria) this;
        }

        public Criteria andRechargeTransIdLessThanOrEqualTo(String value) {
            addCriterion("recharge_trans_id <=", value, "rechargeTransId");
            return (Criteria) this;
        }

        public Criteria andRechargeTransIdLike(String value) {
            addCriterion("recharge_trans_id like", value, "rechargeTransId");
            return (Criteria) this;
        }

        public Criteria andRechargeTransIdNotLike(String value) {
            addCriterion("recharge_trans_id not like", value, "rechargeTransId");
            return (Criteria) this;
        }

        public Criteria andRechargeTransIdIn(List<String> values) {
            addCriterion("recharge_trans_id in", values, "rechargeTransId");
            return (Criteria) this;
        }

        public Criteria andRechargeTransIdNotIn(List<String> values) {
            addCriterion("recharge_trans_id not in", values, "rechargeTransId");
            return (Criteria) this;
        }

        public Criteria andRechargeTransIdBetween(String value1, String value2) {
            addCriterion("recharge_trans_id between", value1, value2, "rechargeTransId");
            return (Criteria) this;
        }

        public Criteria andRechargeTransIdNotBetween(String value1, String value2) {
            addCriterion("recharge_trans_id not between", value1, value2, "rechargeTransId");
            return (Criteria) this;
        }

        public Criteria andRechargeTimeIsNull() {
            addCriterion("recharge_time is null");
            return (Criteria) this;
        }

        public Criteria andRechargeTimeIsNotNull() {
            addCriterion("recharge_time is not null");
            return (Criteria) this;
        }

        public Criteria andRechargeTimeEqualTo(Date value) {
            addCriterion("recharge_time =", value, "rechargeTime");
            return (Criteria) this;
        }

        public Criteria andRechargeTimeNotEqualTo(Date value) {
            addCriterion("recharge_time <>", value, "rechargeTime");
            return (Criteria) this;
        }

        public Criteria andRechargeTimeGreaterThan(Date value) {
            addCriterion("recharge_time >", value, "rechargeTime");
            return (Criteria) this;
        }

        public Criteria andRechargeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("recharge_time >=", value, "rechargeTime");
            return (Criteria) this;
        }

        public Criteria andRechargeTimeLessThan(Date value) {
            addCriterion("recharge_time <", value, "rechargeTime");
            return (Criteria) this;
        }

        public Criteria andRechargeTimeLessThanOrEqualTo(Date value) {
            addCriterion("recharge_time <=", value, "rechargeTime");
            return (Criteria) this;
        }

        public Criteria andRechargeTimeIn(List<Date> values) {
            addCriterion("recharge_time in", values, "rechargeTime");
            return (Criteria) this;
        }

        public Criteria andRechargeTimeNotIn(List<Date> values) {
            addCriterion("recharge_time not in", values, "rechargeTime");
            return (Criteria) this;
        }

        public Criteria andRechargeTimeBetween(Date value1, Date value2) {
            addCriterion("recharge_time between", value1, value2, "rechargeTime");
            return (Criteria) this;
        }

        public Criteria andRechargeTimeNotBetween(Date value1, Date value2) {
            addCriterion("recharge_time not between", value1, value2, "rechargeTime");
            return (Criteria) this;
        }

        public Criteria andCheckStateIsNull() {
            addCriterion("check_state is null");
            return (Criteria) this;
        }

        public Criteria andCheckStateIsNotNull() {
            addCriterion("check_state is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStateEqualTo(String value) {
            addCriterion("check_state =", value, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateNotEqualTo(String value) {
            addCriterion("check_state <>", value, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateGreaterThan(String value) {
            addCriterion("check_state >", value, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateGreaterThanOrEqualTo(String value) {
            addCriterion("check_state >=", value, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateLessThan(String value) {
            addCriterion("check_state <", value, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateLessThanOrEqualTo(String value) {
            addCriterion("check_state <=", value, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateLike(String value) {
            addCriterion("check_state like", value, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateNotLike(String value) {
            addCriterion("check_state not like", value, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateIn(List<String> values) {
            addCriterion("check_state in", values, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateNotIn(List<String> values) {
            addCriterion("check_state not in", values, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateBetween(String value1, String value2) {
            addCriterion("check_state between", value1, value2, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateNotBetween(String value1, String value2) {
            addCriterion("check_state not between", value1, value2, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIsNull() {
            addCriterion("check_time is null");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIsNotNull() {
            addCriterion("check_time is not null");
            return (Criteria) this;
        }

        public Criteria andCheckTimeEqualTo(Date value) {
            addCriterion("check_time =", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotEqualTo(Date value) {
            addCriterion("check_time <>", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeGreaterThan(Date value) {
            addCriterion("check_time >", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("check_time >=", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeLessThan(Date value) {
            addCriterion("check_time <", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeLessThanOrEqualTo(Date value) {
            addCriterion("check_time <=", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIn(List<Date> values) {
            addCriterion("check_time in", values, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotIn(List<Date> values) {
            addCriterion("check_time not in", values, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeBetween(Date value1, Date value2) {
            addCriterion("check_time between", value1, value2, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotBetween(Date value1, Date value2) {
            addCriterion("check_time not between", value1, value2, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckMarkIsNull() {
            addCriterion("check_mark is null");
            return (Criteria) this;
        }

        public Criteria andCheckMarkIsNotNull() {
            addCriterion("check_mark is not null");
            return (Criteria) this;
        }

        public Criteria andCheckMarkEqualTo(String value) {
            addCriterion("check_mark =", value, "checkMark");
            return (Criteria) this;
        }

        public Criteria andCheckMarkNotEqualTo(String value) {
            addCriterion("check_mark <>", value, "checkMark");
            return (Criteria) this;
        }

        public Criteria andCheckMarkGreaterThan(String value) {
            addCriterion("check_mark >", value, "checkMark");
            return (Criteria) this;
        }

        public Criteria andCheckMarkGreaterThanOrEqualTo(String value) {
            addCriterion("check_mark >=", value, "checkMark");
            return (Criteria) this;
        }

        public Criteria andCheckMarkLessThan(String value) {
            addCriterion("check_mark <", value, "checkMark");
            return (Criteria) this;
        }

        public Criteria andCheckMarkLessThanOrEqualTo(String value) {
            addCriterion("check_mark <=", value, "checkMark");
            return (Criteria) this;
        }

        public Criteria andCheckMarkLike(String value) {
            addCriterion("check_mark like", value, "checkMark");
            return (Criteria) this;
        }

        public Criteria andCheckMarkNotLike(String value) {
            addCriterion("check_mark not like", value, "checkMark");
            return (Criteria) this;
        }

        public Criteria andCheckMarkIn(List<String> values) {
            addCriterion("check_mark in", values, "checkMark");
            return (Criteria) this;
        }

        public Criteria andCheckMarkNotIn(List<String> values) {
            addCriterion("check_mark not in", values, "checkMark");
            return (Criteria) this;
        }

        public Criteria andCheckMarkBetween(String value1, String value2) {
            addCriterion("check_mark between", value1, value2, "checkMark");
            return (Criteria) this;
        }

        public Criteria andCheckMarkNotBetween(String value1, String value2) {
            addCriterion("check_mark not between", value1, value2, "checkMark");
            return (Criteria) this;
        }

        public Criteria andRechargeAmountIsNull() {
            addCriterion("recharge_amount is null");
            return (Criteria) this;
        }

        public Criteria andRechargeAmountIsNotNull() {
            addCriterion("recharge_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRechargeAmountEqualTo(BigDecimal value) {
            addCriterion("recharge_amount =", value, "rechargeAmount");
            return (Criteria) this;
        }

        public Criteria andRechargeAmountNotEqualTo(BigDecimal value) {
            addCriterion("recharge_amount <>", value, "rechargeAmount");
            return (Criteria) this;
        }

        public Criteria andRechargeAmountGreaterThan(BigDecimal value) {
            addCriterion("recharge_amount >", value, "rechargeAmount");
            return (Criteria) this;
        }

        public Criteria andRechargeAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("recharge_amount >=", value, "rechargeAmount");
            return (Criteria) this;
        }

        public Criteria andRechargeAmountLessThan(BigDecimal value) {
            addCriterion("recharge_amount <", value, "rechargeAmount");
            return (Criteria) this;
        }

        public Criteria andRechargeAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("recharge_amount <=", value, "rechargeAmount");
            return (Criteria) this;
        }

        public Criteria andRechargeAmountIn(List<BigDecimal> values) {
            addCriterion("recharge_amount in", values, "rechargeAmount");
            return (Criteria) this;
        }

        public Criteria andRechargeAmountNotIn(List<BigDecimal> values) {
            addCriterion("recharge_amount not in", values, "rechargeAmount");
            return (Criteria) this;
        }

        public Criteria andRechargeAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("recharge_amount between", value1, value2, "rechargeAmount");
            return (Criteria) this;
        }

        public Criteria andRechargeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("recharge_amount not between", value1, value2, "rechargeAmount");
            return (Criteria) this;
        }

        public Criteria andRechargeNumIsNull() {
            addCriterion("recharge_num is null");
            return (Criteria) this;
        }

        public Criteria andRechargeNumIsNotNull() {
            addCriterion("recharge_num is not null");
            return (Criteria) this;
        }

        public Criteria andRechargeNumEqualTo(Integer value) {
            addCriterion("recharge_num =", value, "rechargeNum");
            return (Criteria) this;
        }

        public Criteria andRechargeNumNotEqualTo(Integer value) {
            addCriterion("recharge_num <>", value, "rechargeNum");
            return (Criteria) this;
        }

        public Criteria andRechargeNumGreaterThan(Integer value) {
            addCriterion("recharge_num >", value, "rechargeNum");
            return (Criteria) this;
        }

        public Criteria andRechargeNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("recharge_num >=", value, "rechargeNum");
            return (Criteria) this;
        }

        public Criteria andRechargeNumLessThan(Integer value) {
            addCriterion("recharge_num <", value, "rechargeNum");
            return (Criteria) this;
        }

        public Criteria andRechargeNumLessThanOrEqualTo(Integer value) {
            addCriterion("recharge_num <=", value, "rechargeNum");
            return (Criteria) this;
        }

        public Criteria andRechargeNumIn(List<Integer> values) {
            addCriterion("recharge_num in", values, "rechargeNum");
            return (Criteria) this;
        }

        public Criteria andRechargeNumNotIn(List<Integer> values) {
            addCriterion("recharge_num not in", values, "rechargeNum");
            return (Criteria) this;
        }

        public Criteria andRechargeNumBetween(Integer value1, Integer value2) {
            addCriterion("recharge_num between", value1, value2, "rechargeNum");
            return (Criteria) this;
        }

        public Criteria andRechargeNumNotBetween(Integer value1, Integer value2) {
            addCriterion("recharge_num not between", value1, value2, "rechargeNum");
            return (Criteria) this;
        }

        public Criteria andAlterBossIsNull() {
            addCriterion("alter_boss is null");
            return (Criteria) this;
        }

        public Criteria andAlterBossIsNotNull() {
            addCriterion("alter_boss is not null");
            return (Criteria) this;
        }

        public Criteria andAlterBossEqualTo(String value) {
            addCriterion("alter_boss =", value, "alterBoss");
            return (Criteria) this;
        }

        public Criteria andAlterBossNotEqualTo(String value) {
            addCriterion("alter_boss <>", value, "alterBoss");
            return (Criteria) this;
        }

        public Criteria andAlterBossGreaterThan(String value) {
            addCriterion("alter_boss >", value, "alterBoss");
            return (Criteria) this;
        }

        public Criteria andAlterBossGreaterThanOrEqualTo(String value) {
            addCriterion("alter_boss >=", value, "alterBoss");
            return (Criteria) this;
        }

        public Criteria andAlterBossLessThan(String value) {
            addCriterion("alter_boss <", value, "alterBoss");
            return (Criteria) this;
        }

        public Criteria andAlterBossLessThanOrEqualTo(String value) {
            addCriterion("alter_boss <=", value, "alterBoss");
            return (Criteria) this;
        }

        public Criteria andAlterBossLike(String value) {
            addCriterion("alter_boss like", value, "alterBoss");
            return (Criteria) this;
        }

        public Criteria andAlterBossNotLike(String value) {
            addCriterion("alter_boss not like", value, "alterBoss");
            return (Criteria) this;
        }

        public Criteria andAlterBossIn(List<String> values) {
            addCriterion("alter_boss in", values, "alterBoss");
            return (Criteria) this;
        }

        public Criteria andAlterBossNotIn(List<String> values) {
            addCriterion("alter_boss not in", values, "alterBoss");
            return (Criteria) this;
        }

        public Criteria andAlterBossBetween(String value1, String value2) {
            addCriterion("alter_boss between", value1, value2, "alterBoss");
            return (Criteria) this;
        }

        public Criteria andAlterBossNotBetween(String value1, String value2) {
            addCriterion("alter_boss not between", value1, value2, "alterBoss");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}