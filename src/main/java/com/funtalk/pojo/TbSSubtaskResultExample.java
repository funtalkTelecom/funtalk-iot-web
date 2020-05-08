package com.funtalk.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbSSubtaskResultExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbSSubtaskResultExample() {
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

        public Criteria andNidIsNull() {
            addCriterion("nid is null");
            return (Criteria) this;
        }

        public Criteria andNidIsNotNull() {
            addCriterion("nid is not null");
            return (Criteria) this;
        }

        public Criteria andNidEqualTo(Integer value) {
            addCriterion("nid =", value, "nid");
            return (Criteria) this;
        }

        public Criteria andNidNotEqualTo(Integer value) {
            addCriterion("nid <>", value, "nid");
            return (Criteria) this;
        }

        public Criteria andNidGreaterThan(Integer value) {
            addCriterion("nid >", value, "nid");
            return (Criteria) this;
        }

        public Criteria andNidGreaterThanOrEqualTo(Integer value) {
            addCriterion("nid >=", value, "nid");
            return (Criteria) this;
        }

        public Criteria andNidLessThan(Integer value) {
            addCriterion("nid <", value, "nid");
            return (Criteria) this;
        }

        public Criteria andNidLessThanOrEqualTo(Integer value) {
            addCriterion("nid <=", value, "nid");
            return (Criteria) this;
        }

        public Criteria andNidIn(List<Integer> values) {
            addCriterion("nid in", values, "nid");
            return (Criteria) this;
        }

        public Criteria andNidNotIn(List<Integer> values) {
            addCriterion("nid not in", values, "nid");
            return (Criteria) this;
        }

        public Criteria andNidBetween(Integer value1, Integer value2) {
            addCriterion("nid between", value1, value2, "nid");
            return (Criteria) this;
        }

        public Criteria andNidNotBetween(Integer value1, Integer value2) {
            addCriterion("nid not between", value1, value2, "nid");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(Integer value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(Integer value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(Integer value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(Integer value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(Integer value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<Integer> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<Integer> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(Integer value1, Integer value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(Integer value1, Integer value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNull() {
            addCriterion("cust_id is null");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNotNull() {
            addCriterion("cust_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustIdEqualTo(String value) {
            addCriterion("cust_id =", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotEqualTo(String value) {
            addCriterion("cust_id <>", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThan(String value) {
            addCriterion("cust_id >", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThanOrEqualTo(String value) {
            addCriterion("cust_id >=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThan(String value) {
            addCriterion("cust_id <", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThanOrEqualTo(String value) {
            addCriterion("cust_id <=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLike(String value) {
            addCriterion("cust_id like", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotLike(String value) {
            addCriterion("cust_id not like", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdIn(List<String> values) {
            addCriterion("cust_id in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotIn(List<String> values) {
            addCriterion("cust_id not in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdBetween(String value1, String value2) {
            addCriterion("cust_id between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotBetween(String value1, String value2) {
            addCriterion("cust_id not between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andOrdernoIsNull() {
            addCriterion("orderno is null");
            return (Criteria) this;
        }

        public Criteria andOrdernoIsNotNull() {
            addCriterion("orderno is not null");
            return (Criteria) this;
        }

        public Criteria andOrdernoEqualTo(String value) {
            addCriterion("orderno =", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotEqualTo(String value) {
            addCriterion("orderno <>", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoGreaterThan(String value) {
            addCriterion("orderno >", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoGreaterThanOrEqualTo(String value) {
            addCriterion("orderno >=", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoLessThan(String value) {
            addCriterion("orderno <", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoLessThanOrEqualTo(String value) {
            addCriterion("orderno <=", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoLike(String value) {
            addCriterion("orderno like", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotLike(String value) {
            addCriterion("orderno not like", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoIn(List<String> values) {
            addCriterion("orderno in", values, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotIn(List<String> values) {
            addCriterion("orderno not in", values, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoBetween(String value1, String value2) {
            addCriterion("orderno between", value1, value2, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotBetween(String value1, String value2) {
            addCriterion("orderno not between", value1, value2, "orderno");
            return (Criteria) this;
        }

        public Criteria andPhoneAIsNull() {
            addCriterion("phone_a is null");
            return (Criteria) this;
        }

        public Criteria andPhoneAIsNotNull() {
            addCriterion("phone_a is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneAEqualTo(String value) {
            addCriterion("phone_a =", value, "phoneA");
            return (Criteria) this;
        }

        public Criteria andPhoneANotEqualTo(String value) {
            addCriterion("phone_a <>", value, "phoneA");
            return (Criteria) this;
        }

        public Criteria andPhoneAGreaterThan(String value) {
            addCriterion("phone_a >", value, "phoneA");
            return (Criteria) this;
        }

        public Criteria andPhoneAGreaterThanOrEqualTo(String value) {
            addCriterion("phone_a >=", value, "phoneA");
            return (Criteria) this;
        }

        public Criteria andPhoneALessThan(String value) {
            addCriterion("phone_a <", value, "phoneA");
            return (Criteria) this;
        }

        public Criteria andPhoneALessThanOrEqualTo(String value) {
            addCriterion("phone_a <=", value, "phoneA");
            return (Criteria) this;
        }

        public Criteria andPhoneALike(String value) {
            addCriterion("phone_a like", value, "phoneA");
            return (Criteria) this;
        }

        public Criteria andPhoneANotLike(String value) {
            addCriterion("phone_a not like", value, "phoneA");
            return (Criteria) this;
        }

        public Criteria andPhoneAIn(List<String> values) {
            addCriterion("phone_a in", values, "phoneA");
            return (Criteria) this;
        }

        public Criteria andPhoneANotIn(List<String> values) {
            addCriterion("phone_a not in", values, "phoneA");
            return (Criteria) this;
        }

        public Criteria andPhoneABetween(String value1, String value2) {
            addCriterion("phone_a between", value1, value2, "phoneA");
            return (Criteria) this;
        }

        public Criteria andPhoneANotBetween(String value1, String value2) {
            addCriterion("phone_a not between", value1, value2, "phoneA");
            return (Criteria) this;
        }

        public Criteria andIccidAIsNull() {
            addCriterion("iccid_a is null");
            return (Criteria) this;
        }

        public Criteria andIccidAIsNotNull() {
            addCriterion("iccid_a is not null");
            return (Criteria) this;
        }

        public Criteria andIccidAEqualTo(String value) {
            addCriterion("iccid_a =", value, "iccidA");
            return (Criteria) this;
        }

        public Criteria andIccidANotEqualTo(String value) {
            addCriterion("iccid_a <>", value, "iccidA");
            return (Criteria) this;
        }

        public Criteria andIccidAGreaterThan(String value) {
            addCriterion("iccid_a >", value, "iccidA");
            return (Criteria) this;
        }

        public Criteria andIccidAGreaterThanOrEqualTo(String value) {
            addCriterion("iccid_a >=", value, "iccidA");
            return (Criteria) this;
        }

        public Criteria andIccidALessThan(String value) {
            addCriterion("iccid_a <", value, "iccidA");
            return (Criteria) this;
        }

        public Criteria andIccidALessThanOrEqualTo(String value) {
            addCriterion("iccid_a <=", value, "iccidA");
            return (Criteria) this;
        }

        public Criteria andIccidALike(String value) {
            addCriterion("iccid_a like", value, "iccidA");
            return (Criteria) this;
        }

        public Criteria andIccidANotLike(String value) {
            addCriterion("iccid_a not like", value, "iccidA");
            return (Criteria) this;
        }

        public Criteria andIccidAIn(List<String> values) {
            addCriterion("iccid_a in", values, "iccidA");
            return (Criteria) this;
        }

        public Criteria andIccidANotIn(List<String> values) {
            addCriterion("iccid_a not in", values, "iccidA");
            return (Criteria) this;
        }

        public Criteria andIccidABetween(String value1, String value2) {
            addCriterion("iccid_a between", value1, value2, "iccidA");
            return (Criteria) this;
        }

        public Criteria andIccidANotBetween(String value1, String value2) {
            addCriterion("iccid_a not between", value1, value2, "iccidA");
            return (Criteria) this;
        }

        public Criteria andServiceKindAIsNull() {
            addCriterion("service_kind_a is null");
            return (Criteria) this;
        }

        public Criteria andServiceKindAIsNotNull() {
            addCriterion("service_kind_a is not null");
            return (Criteria) this;
        }

        public Criteria andServiceKindAEqualTo(String value) {
            addCriterion("service_kind_a =", value, "serviceKindA");
            return (Criteria) this;
        }

        public Criteria andServiceKindANotEqualTo(String value) {
            addCriterion("service_kind_a <>", value, "serviceKindA");
            return (Criteria) this;
        }

        public Criteria andServiceKindAGreaterThan(String value) {
            addCriterion("service_kind_a >", value, "serviceKindA");
            return (Criteria) this;
        }

        public Criteria andServiceKindAGreaterThanOrEqualTo(String value) {
            addCriterion("service_kind_a >=", value, "serviceKindA");
            return (Criteria) this;
        }

        public Criteria andServiceKindALessThan(String value) {
            addCriterion("service_kind_a <", value, "serviceKindA");
            return (Criteria) this;
        }

        public Criteria andServiceKindALessThanOrEqualTo(String value) {
            addCriterion("service_kind_a <=", value, "serviceKindA");
            return (Criteria) this;
        }

        public Criteria andServiceKindALike(String value) {
            addCriterion("service_kind_a like", value, "serviceKindA");
            return (Criteria) this;
        }

        public Criteria andServiceKindANotLike(String value) {
            addCriterion("service_kind_a not like", value, "serviceKindA");
            return (Criteria) this;
        }

        public Criteria andServiceKindAIn(List<String> values) {
            addCriterion("service_kind_a in", values, "serviceKindA");
            return (Criteria) this;
        }

        public Criteria andServiceKindANotIn(List<String> values) {
            addCriterion("service_kind_a not in", values, "serviceKindA");
            return (Criteria) this;
        }

        public Criteria andServiceKindABetween(String value1, String value2) {
            addCriterion("service_kind_a between", value1, value2, "serviceKindA");
            return (Criteria) this;
        }

        public Criteria andServiceKindANotBetween(String value1, String value2) {
            addCriterion("service_kind_a not between", value1, value2, "serviceKindA");
            return (Criteria) this;
        }

        public Criteria andCityAIsNull() {
            addCriterion("city_a is null");
            return (Criteria) this;
        }

        public Criteria andCityAIsNotNull() {
            addCriterion("city_a is not null");
            return (Criteria) this;
        }

        public Criteria andCityAEqualTo(String value) {
            addCriterion("city_a =", value, "cityA");
            return (Criteria) this;
        }

        public Criteria andCityANotEqualTo(String value) {
            addCriterion("city_a <>", value, "cityA");
            return (Criteria) this;
        }

        public Criteria andCityAGreaterThan(String value) {
            addCriterion("city_a >", value, "cityA");
            return (Criteria) this;
        }

        public Criteria andCityAGreaterThanOrEqualTo(String value) {
            addCriterion("city_a >=", value, "cityA");
            return (Criteria) this;
        }

        public Criteria andCityALessThan(String value) {
            addCriterion("city_a <", value, "cityA");
            return (Criteria) this;
        }

        public Criteria andCityALessThanOrEqualTo(String value) {
            addCriterion("city_a <=", value, "cityA");
            return (Criteria) this;
        }

        public Criteria andCityALike(String value) {
            addCriterion("city_a like", value, "cityA");
            return (Criteria) this;
        }

        public Criteria andCityANotLike(String value) {
            addCriterion("city_a not like", value, "cityA");
            return (Criteria) this;
        }

        public Criteria andCityAIn(List<String> values) {
            addCriterion("city_a in", values, "cityA");
            return (Criteria) this;
        }

        public Criteria andCityANotIn(List<String> values) {
            addCriterion("city_a not in", values, "cityA");
            return (Criteria) this;
        }

        public Criteria andCityABetween(String value1, String value2) {
            addCriterion("city_a between", value1, value2, "cityA");
            return (Criteria) this;
        }

        public Criteria andCityANotBetween(String value1, String value2) {
            addCriterion("city_a not between", value1, value2, "cityA");
            return (Criteria) this;
        }

        public Criteria andPhoneBIsNull() {
            addCriterion("phone_b is null");
            return (Criteria) this;
        }

        public Criteria andPhoneBIsNotNull() {
            addCriterion("phone_b is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneBEqualTo(String value) {
            addCriterion("phone_b =", value, "phoneB");
            return (Criteria) this;
        }

        public Criteria andPhoneBNotEqualTo(String value) {
            addCriterion("phone_b <>", value, "phoneB");
            return (Criteria) this;
        }

        public Criteria andPhoneBGreaterThan(String value) {
            addCriterion("phone_b >", value, "phoneB");
            return (Criteria) this;
        }

        public Criteria andPhoneBGreaterThanOrEqualTo(String value) {
            addCriterion("phone_b >=", value, "phoneB");
            return (Criteria) this;
        }

        public Criteria andPhoneBLessThan(String value) {
            addCriterion("phone_b <", value, "phoneB");
            return (Criteria) this;
        }

        public Criteria andPhoneBLessThanOrEqualTo(String value) {
            addCriterion("phone_b <=", value, "phoneB");
            return (Criteria) this;
        }

        public Criteria andPhoneBLike(String value) {
            addCriterion("phone_b like", value, "phoneB");
            return (Criteria) this;
        }

        public Criteria andPhoneBNotLike(String value) {
            addCriterion("phone_b not like", value, "phoneB");
            return (Criteria) this;
        }

        public Criteria andPhoneBIn(List<String> values) {
            addCriterion("phone_b in", values, "phoneB");
            return (Criteria) this;
        }

        public Criteria andPhoneBNotIn(List<String> values) {
            addCriterion("phone_b not in", values, "phoneB");
            return (Criteria) this;
        }

        public Criteria andPhoneBBetween(String value1, String value2) {
            addCriterion("phone_b between", value1, value2, "phoneB");
            return (Criteria) this;
        }

        public Criteria andPhoneBNotBetween(String value1, String value2) {
            addCriterion("phone_b not between", value1, value2, "phoneB");
            return (Criteria) this;
        }

        public Criteria andMsgIsNull() {
            addCriterion("msg is null");
            return (Criteria) this;
        }

        public Criteria andMsgIsNotNull() {
            addCriterion("msg is not null");
            return (Criteria) this;
        }

        public Criteria andMsgEqualTo(String value) {
            addCriterion("msg =", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotEqualTo(String value) {
            addCriterion("msg <>", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgGreaterThan(String value) {
            addCriterion("msg >", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgGreaterThanOrEqualTo(String value) {
            addCriterion("msg >=", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgLessThan(String value) {
            addCriterion("msg <", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgLessThanOrEqualTo(String value) {
            addCriterion("msg <=", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgLike(String value) {
            addCriterion("msg like", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotLike(String value) {
            addCriterion("msg not like", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgIn(List<String> values) {
            addCriterion("msg in", values, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotIn(List<String> values) {
            addCriterion("msg not in", values, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgBetween(String value1, String value2) {
            addCriterion("msg between", value1, value2, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotBetween(String value1, String value2) {
            addCriterion("msg not between", value1, value2, "msg");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andSmsPhoneBIdIsNull() {
            addCriterion("sms_phone_b_id is null");
            return (Criteria) this;
        }

        public Criteria andSmsPhoneBIdIsNotNull() {
            addCriterion("sms_phone_b_id is not null");
            return (Criteria) this;
        }

        public Criteria andSmsPhoneBIdEqualTo(Integer value) {
            addCriterion("sms_phone_b_id =", value, "smsPhoneBId");
            return (Criteria) this;
        }

        public Criteria andSmsPhoneBIdNotEqualTo(Integer value) {
            addCriterion("sms_phone_b_id <>", value, "smsPhoneBId");
            return (Criteria) this;
        }

        public Criteria andSmsPhoneBIdGreaterThan(Integer value) {
            addCriterion("sms_phone_b_id >", value, "smsPhoneBId");
            return (Criteria) this;
        }

        public Criteria andSmsPhoneBIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sms_phone_b_id >=", value, "smsPhoneBId");
            return (Criteria) this;
        }

        public Criteria andSmsPhoneBIdLessThan(Integer value) {
            addCriterion("sms_phone_b_id <", value, "smsPhoneBId");
            return (Criteria) this;
        }

        public Criteria andSmsPhoneBIdLessThanOrEqualTo(Integer value) {
            addCriterion("sms_phone_b_id <=", value, "smsPhoneBId");
            return (Criteria) this;
        }

        public Criteria andSmsPhoneBIdIn(List<Integer> values) {
            addCriterion("sms_phone_b_id in", values, "smsPhoneBId");
            return (Criteria) this;
        }

        public Criteria andSmsPhoneBIdNotIn(List<Integer> values) {
            addCriterion("sms_phone_b_id not in", values, "smsPhoneBId");
            return (Criteria) this;
        }

        public Criteria andSmsPhoneBIdBetween(Integer value1, Integer value2) {
            addCriterion("sms_phone_b_id between", value1, value2, "smsPhoneBId");
            return (Criteria) this;
        }

        public Criteria andSmsPhoneBIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sms_phone_b_id not between", value1, value2, "smsPhoneBId");
            return (Criteria) this;
        }

        public Criteria andCardidIsNull() {
            addCriterion("cardid is null");
            return (Criteria) this;
        }

        public Criteria andCardidIsNotNull() {
            addCriterion("cardid is not null");
            return (Criteria) this;
        }

        public Criteria andCardidEqualTo(String value) {
            addCriterion("cardid =", value, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidNotEqualTo(String value) {
            addCriterion("cardid <>", value, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidGreaterThan(String value) {
            addCriterion("cardid >", value, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidGreaterThanOrEqualTo(String value) {
            addCriterion("cardid >=", value, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidLessThan(String value) {
            addCriterion("cardid <", value, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidLessThanOrEqualTo(String value) {
            addCriterion("cardid <=", value, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidLike(String value) {
            addCriterion("cardid like", value, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidNotLike(String value) {
            addCriterion("cardid not like", value, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidIn(List<String> values) {
            addCriterion("cardid in", values, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidNotIn(List<String> values) {
            addCriterion("cardid not in", values, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidBetween(String value1, String value2) {
            addCriterion("cardid between", value1, value2, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidNotBetween(String value1, String value2) {
            addCriterion("cardid not between", value1, value2, "cardid");
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

        public Criteria andSendTimeIsNull() {
            addCriterion("send_time is null");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNotNull() {
            addCriterion("send_time is not null");
            return (Criteria) this;
        }

        public Criteria andSendTimeEqualTo(Date value) {
            addCriterion("send_time =", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotEqualTo(Date value) {
            addCriterion("send_time <>", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThan(Date value) {
            addCriterion("send_time >", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("send_time >=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThan(Date value) {
            addCriterion("send_time <", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThanOrEqualTo(Date value) {
            addCriterion("send_time <=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeIn(List<Date> values) {
            addCriterion("send_time in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotIn(List<Date> values) {
            addCriterion("send_time not in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeBetween(Date value1, Date value2) {
            addCriterion("send_time between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotBetween(Date value1, Date value2) {
            addCriterion("send_time not between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendDateIsNull() {
            addCriterion("send_date is null");
            return (Criteria) this;
        }

        public Criteria andSendDateIsNotNull() {
            addCriterion("send_date is not null");
            return (Criteria) this;
        }

        public Criteria andSendDateEqualTo(Date value) {
            addCriterion("send_date =", value, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateNotEqualTo(Date value) {
            addCriterion("send_date <>", value, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateGreaterThan(Date value) {
            addCriterion("send_date >", value, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateGreaterThanOrEqualTo(Date value) {
            addCriterion("send_date >=", value, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateLessThan(Date value) {
            addCriterion("send_date <", value, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateLessThanOrEqualTo(Date value) {
            addCriterion("send_date <=", value, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateIn(List<Date> values) {
            addCriterion("send_date in", values, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateNotIn(List<Date> values) {
            addCriterion("send_date not in", values, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateBetween(Date value1, Date value2) {
            addCriterion("send_date between", value1, value2, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateNotBetween(Date value1, Date value2) {
            addCriterion("send_date not between", value1, value2, "sendDate");
            return (Criteria) this;
        }

        public Criteria andIfSendIsNull() {
            addCriterion("if_send is null");
            return (Criteria) this;
        }

        public Criteria andIfSendIsNotNull() {
            addCriterion("if_send is not null");
            return (Criteria) this;
        }

        public Criteria andIfSendEqualTo(String value) {
            addCriterion("if_send =", value, "ifSend");
            return (Criteria) this;
        }

        public Criteria andIfSendNotEqualTo(String value) {
            addCriterion("if_send <>", value, "ifSend");
            return (Criteria) this;
        }

        public Criteria andIfSendGreaterThan(String value) {
            addCriterion("if_send >", value, "ifSend");
            return (Criteria) this;
        }

        public Criteria andIfSendGreaterThanOrEqualTo(String value) {
            addCriterion("if_send >=", value, "ifSend");
            return (Criteria) this;
        }

        public Criteria andIfSendLessThan(String value) {
            addCriterion("if_send <", value, "ifSend");
            return (Criteria) this;
        }

        public Criteria andIfSendLessThanOrEqualTo(String value) {
            addCriterion("if_send <=", value, "ifSend");
            return (Criteria) this;
        }

        public Criteria andIfSendLike(String value) {
            addCriterion("if_send like", value, "ifSend");
            return (Criteria) this;
        }

        public Criteria andIfSendNotLike(String value) {
            addCriterion("if_send not like", value, "ifSend");
            return (Criteria) this;
        }

        public Criteria andIfSendIn(List<String> values) {
            addCriterion("if_send in", values, "ifSend");
            return (Criteria) this;
        }

        public Criteria andIfSendNotIn(List<String> values) {
            addCriterion("if_send not in", values, "ifSend");
            return (Criteria) this;
        }

        public Criteria andIfSendBetween(String value1, String value2) {
            addCriterion("if_send between", value1, value2, "ifSend");
            return (Criteria) this;
        }

        public Criteria andIfSendNotBetween(String value1, String value2) {
            addCriterion("if_send not between", value1, value2, "ifSend");
            return (Criteria) this;
        }

        public Criteria andErrMsgIsNull() {
            addCriterion("err_msg is null");
            return (Criteria) this;
        }

        public Criteria andErrMsgIsNotNull() {
            addCriterion("err_msg is not null");
            return (Criteria) this;
        }

        public Criteria andErrMsgEqualTo(String value) {
            addCriterion("err_msg =", value, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgNotEqualTo(String value) {
            addCriterion("err_msg <>", value, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgGreaterThan(String value) {
            addCriterion("err_msg >", value, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgGreaterThanOrEqualTo(String value) {
            addCriterion("err_msg >=", value, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgLessThan(String value) {
            addCriterion("err_msg <", value, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgLessThanOrEqualTo(String value) {
            addCriterion("err_msg <=", value, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgLike(String value) {
            addCriterion("err_msg like", value, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgNotLike(String value) {
            addCriterion("err_msg not like", value, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgIn(List<String> values) {
            addCriterion("err_msg in", values, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgNotIn(List<String> values) {
            addCriterion("err_msg not in", values, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgBetween(String value1, String value2) {
            addCriterion("err_msg between", value1, value2, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgNotBetween(String value1, String value2) {
            addCriterion("err_msg not between", value1, value2, "errMsg");
            return (Criteria) this;
        }

        public Criteria andIfDemoIsNull() {
            addCriterion("if_demo is null");
            return (Criteria) this;
        }

        public Criteria andIfDemoIsNotNull() {
            addCriterion("if_demo is not null");
            return (Criteria) this;
        }

        public Criteria andIfDemoEqualTo(Integer value) {
            addCriterion("if_demo =", value, "ifDemo");
            return (Criteria) this;
        }

        public Criteria andIfDemoNotEqualTo(Integer value) {
            addCriterion("if_demo <>", value, "ifDemo");
            return (Criteria) this;
        }

        public Criteria andIfDemoGreaterThan(Integer value) {
            addCriterion("if_demo >", value, "ifDemo");
            return (Criteria) this;
        }

        public Criteria andIfDemoGreaterThanOrEqualTo(Integer value) {
            addCriterion("if_demo >=", value, "ifDemo");
            return (Criteria) this;
        }

        public Criteria andIfDemoLessThan(Integer value) {
            addCriterion("if_demo <", value, "ifDemo");
            return (Criteria) this;
        }

        public Criteria andIfDemoLessThanOrEqualTo(Integer value) {
            addCriterion("if_demo <=", value, "ifDemo");
            return (Criteria) this;
        }

        public Criteria andIfDemoIn(List<Integer> values) {
            addCriterion("if_demo in", values, "ifDemo");
            return (Criteria) this;
        }

        public Criteria andIfDemoNotIn(List<Integer> values) {
            addCriterion("if_demo not in", values, "ifDemo");
            return (Criteria) this;
        }

        public Criteria andIfDemoBetween(Integer value1, Integer value2) {
            addCriterion("if_demo between", value1, value2, "ifDemo");
            return (Criteria) this;
        }

        public Criteria andIfDemoNotBetween(Integer value1, Integer value2) {
            addCriterion("if_demo not between", value1, value2, "ifDemo");
            return (Criteria) this;
        }

        public Criteria andIfRecordIsNull() {
            addCriterion("if_record is null");
            return (Criteria) this;
        }

        public Criteria andIfRecordIsNotNull() {
            addCriterion("if_record is not null");
            return (Criteria) this;
        }

        public Criteria andIfRecordEqualTo(String value) {
            addCriterion("if_record =", value, "ifRecord");
            return (Criteria) this;
        }

        public Criteria andIfRecordNotEqualTo(String value) {
            addCriterion("if_record <>", value, "ifRecord");
            return (Criteria) this;
        }

        public Criteria andIfRecordGreaterThan(String value) {
            addCriterion("if_record >", value, "ifRecord");
            return (Criteria) this;
        }

        public Criteria andIfRecordGreaterThanOrEqualTo(String value) {
            addCriterion("if_record >=", value, "ifRecord");
            return (Criteria) this;
        }

        public Criteria andIfRecordLessThan(String value) {
            addCriterion("if_record <", value, "ifRecord");
            return (Criteria) this;
        }

        public Criteria andIfRecordLessThanOrEqualTo(String value) {
            addCriterion("if_record <=", value, "ifRecord");
            return (Criteria) this;
        }

        public Criteria andIfRecordLike(String value) {
            addCriterion("if_record like", value, "ifRecord");
            return (Criteria) this;
        }

        public Criteria andIfRecordNotLike(String value) {
            addCriterion("if_record not like", value, "ifRecord");
            return (Criteria) this;
        }

        public Criteria andIfRecordIn(List<String> values) {
            addCriterion("if_record in", values, "ifRecord");
            return (Criteria) this;
        }

        public Criteria andIfRecordNotIn(List<String> values) {
            addCriterion("if_record not in", values, "ifRecord");
            return (Criteria) this;
        }

        public Criteria andIfRecordBetween(String value1, String value2) {
            addCriterion("if_record between", value1, value2, "ifRecord");
            return (Criteria) this;
        }

        public Criteria andIfRecordNotBetween(String value1, String value2) {
            addCriterion("if_record not between", value1, value2, "ifRecord");
            return (Criteria) this;
        }

        public Criteria andRepeatCntIsNull() {
            addCriterion("repeat_cnt is null");
            return (Criteria) this;
        }

        public Criteria andRepeatCntIsNotNull() {
            addCriterion("repeat_cnt is not null");
            return (Criteria) this;
        }

        public Criteria andRepeatCntEqualTo(Integer value) {
            addCriterion("repeat_cnt =", value, "repeatCnt");
            return (Criteria) this;
        }

        public Criteria andRepeatCntNotEqualTo(Integer value) {
            addCriterion("repeat_cnt <>", value, "repeatCnt");
            return (Criteria) this;
        }

        public Criteria andRepeatCntGreaterThan(Integer value) {
            addCriterion("repeat_cnt >", value, "repeatCnt");
            return (Criteria) this;
        }

        public Criteria andRepeatCntGreaterThanOrEqualTo(Integer value) {
            addCriterion("repeat_cnt >=", value, "repeatCnt");
            return (Criteria) this;
        }

        public Criteria andRepeatCntLessThan(Integer value) {
            addCriterion("repeat_cnt <", value, "repeatCnt");
            return (Criteria) this;
        }

        public Criteria andRepeatCntLessThanOrEqualTo(Integer value) {
            addCriterion("repeat_cnt <=", value, "repeatCnt");
            return (Criteria) this;
        }

        public Criteria andRepeatCntIn(List<Integer> values) {
            addCriterion("repeat_cnt in", values, "repeatCnt");
            return (Criteria) this;
        }

        public Criteria andRepeatCntNotIn(List<Integer> values) {
            addCriterion("repeat_cnt not in", values, "repeatCnt");
            return (Criteria) this;
        }

        public Criteria andRepeatCntBetween(Integer value1, Integer value2) {
            addCriterion("repeat_cnt between", value1, value2, "repeatCnt");
            return (Criteria) this;
        }

        public Criteria andRepeatCntNotBetween(Integer value1, Integer value2) {
            addCriterion("repeat_cnt not between", value1, value2, "repeatCnt");
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