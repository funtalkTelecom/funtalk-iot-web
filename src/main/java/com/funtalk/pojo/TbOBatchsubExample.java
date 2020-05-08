package com.funtalk.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbOBatchsubExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbOBatchsubExample() {
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

        public Criteria andSubIdIsNull() {
            addCriterion("sub_id is null");
            return (Criteria) this;
        }

        public Criteria andSubIdIsNotNull() {
            addCriterion("sub_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubIdEqualTo(Integer value) {
            addCriterion("sub_id =", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdNotEqualTo(Integer value) {
            addCriterion("sub_id <>", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdGreaterThan(Integer value) {
            addCriterion("sub_id >", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sub_id >=", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdLessThan(Integer value) {
            addCriterion("sub_id <", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdLessThanOrEqualTo(Integer value) {
            addCriterion("sub_id <=", value, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdIn(List<Integer> values) {
            addCriterion("sub_id in", values, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdNotIn(List<Integer> values) {
            addCriterion("sub_id not in", values, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdBetween(Integer value1, Integer value2) {
            addCriterion("sub_id between", value1, value2, "subId");
            return (Criteria) this;
        }

        public Criteria andSubIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sub_id not between", value1, value2, "subId");
            return (Criteria) this;
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

        public Criteria andAccNbrIsNull() {
            addCriterion("acc_nbr is null");
            return (Criteria) this;
        }

        public Criteria andAccNbrIsNotNull() {
            addCriterion("acc_nbr is not null");
            return (Criteria) this;
        }

        public Criteria andAccNbrEqualTo(String value) {
            addCriterion("acc_nbr =", value, "accNbr");
            return (Criteria) this;
        }

        public Criteria andAccNbrNotEqualTo(String value) {
            addCriterion("acc_nbr <>", value, "accNbr");
            return (Criteria) this;
        }

        public Criteria andAccNbrGreaterThan(String value) {
            addCriterion("acc_nbr >", value, "accNbr");
            return (Criteria) this;
        }

        public Criteria andAccNbrGreaterThanOrEqualTo(String value) {
            addCriterion("acc_nbr >=", value, "accNbr");
            return (Criteria) this;
        }

        public Criteria andAccNbrLessThan(String value) {
            addCriterion("acc_nbr <", value, "accNbr");
            return (Criteria) this;
        }

        public Criteria andAccNbrLessThanOrEqualTo(String value) {
            addCriterion("acc_nbr <=", value, "accNbr");
            return (Criteria) this;
        }

        public Criteria andAccNbrLike(String value) {
            addCriterion("acc_nbr like", value, "accNbr");
            return (Criteria) this;
        }

        public Criteria andAccNbrNotLike(String value) {
            addCriterion("acc_nbr not like", value, "accNbr");
            return (Criteria) this;
        }

        public Criteria andAccNbrIn(List<String> values) {
            addCriterion("acc_nbr in", values, "accNbr");
            return (Criteria) this;
        }

        public Criteria andAccNbrNotIn(List<String> values) {
            addCriterion("acc_nbr not in", values, "accNbr");
            return (Criteria) this;
        }

        public Criteria andAccNbrBetween(String value1, String value2) {
            addCriterion("acc_nbr between", value1, value2, "accNbr");
            return (Criteria) this;
        }

        public Criteria andAccNbrNotBetween(String value1, String value2) {
            addCriterion("acc_nbr not between", value1, value2, "accNbr");
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

        public Criteria andRechargeMarkIsNull() {
            addCriterion("recharge_mark is null");
            return (Criteria) this;
        }

        public Criteria andRechargeMarkIsNotNull() {
            addCriterion("recharge_mark is not null");
            return (Criteria) this;
        }

        public Criteria andRechargeMarkEqualTo(String value) {
            addCriterion("recharge_mark =", value, "rechargeMark");
            return (Criteria) this;
        }

        public Criteria andRechargeMarkNotEqualTo(String value) {
            addCriterion("recharge_mark <>", value, "rechargeMark");
            return (Criteria) this;
        }

        public Criteria andRechargeMarkGreaterThan(String value) {
            addCriterion("recharge_mark >", value, "rechargeMark");
            return (Criteria) this;
        }

        public Criteria andRechargeMarkGreaterThanOrEqualTo(String value) {
            addCriterion("recharge_mark >=", value, "rechargeMark");
            return (Criteria) this;
        }

        public Criteria andRechargeMarkLessThan(String value) {
            addCriterion("recharge_mark <", value, "rechargeMark");
            return (Criteria) this;
        }

        public Criteria andRechargeMarkLessThanOrEqualTo(String value) {
            addCriterion("recharge_mark <=", value, "rechargeMark");
            return (Criteria) this;
        }

        public Criteria andRechargeMarkLike(String value) {
            addCriterion("recharge_mark like", value, "rechargeMark");
            return (Criteria) this;
        }

        public Criteria andRechargeMarkNotLike(String value) {
            addCriterion("recharge_mark not like", value, "rechargeMark");
            return (Criteria) this;
        }

        public Criteria andRechargeMarkIn(List<String> values) {
            addCriterion("recharge_mark in", values, "rechargeMark");
            return (Criteria) this;
        }

        public Criteria andRechargeMarkNotIn(List<String> values) {
            addCriterion("recharge_mark not in", values, "rechargeMark");
            return (Criteria) this;
        }

        public Criteria andRechargeMarkBetween(String value1, String value2) {
            addCriterion("recharge_mark between", value1, value2, "rechargeMark");
            return (Criteria) this;
        }

        public Criteria andRechargeMarkNotBetween(String value1, String value2) {
            addCriterion("recharge_mark not between", value1, value2, "rechargeMark");
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

        public Criteria andActivateStateIsNull() {
            addCriterion("activate_state is null");
            return (Criteria) this;
        }

        public Criteria andActivateStateIsNotNull() {
            addCriterion("activate_state is not null");
            return (Criteria) this;
        }

        public Criteria andActivateStateEqualTo(String value) {
            addCriterion("activate_state =", value, "activateState");
            return (Criteria) this;
        }

        public Criteria andActivateStateNotEqualTo(String value) {
            addCriterion("activate_state <>", value, "activateState");
            return (Criteria) this;
        }

        public Criteria andActivateStateGreaterThan(String value) {
            addCriterion("activate_state >", value, "activateState");
            return (Criteria) this;
        }

        public Criteria andActivateStateGreaterThanOrEqualTo(String value) {
            addCriterion("activate_state >=", value, "activateState");
            return (Criteria) this;
        }

        public Criteria andActivateStateLessThan(String value) {
            addCriterion("activate_state <", value, "activateState");
            return (Criteria) this;
        }

        public Criteria andActivateStateLessThanOrEqualTo(String value) {
            addCriterion("activate_state <=", value, "activateState");
            return (Criteria) this;
        }

        public Criteria andActivateStateLike(String value) {
            addCriterion("activate_state like", value, "activateState");
            return (Criteria) this;
        }

        public Criteria andActivateStateNotLike(String value) {
            addCriterion("activate_state not like", value, "activateState");
            return (Criteria) this;
        }

        public Criteria andActivateStateIn(List<String> values) {
            addCriterion("activate_state in", values, "activateState");
            return (Criteria) this;
        }

        public Criteria andActivateStateNotIn(List<String> values) {
            addCriterion("activate_state not in", values, "activateState");
            return (Criteria) this;
        }

        public Criteria andActivateStateBetween(String value1, String value2) {
            addCriterion("activate_state between", value1, value2, "activateState");
            return (Criteria) this;
        }

        public Criteria andActivateStateNotBetween(String value1, String value2) {
            addCriterion("activate_state not between", value1, value2, "activateState");
            return (Criteria) this;
        }

        public Criteria andLimitStateIsNull() {
            addCriterion("limit_state is null");
            return (Criteria) this;
        }

        public Criteria andLimitStateIsNotNull() {
            addCriterion("limit_state is not null");
            return (Criteria) this;
        }

        public Criteria andLimitStateEqualTo(String value) {
            addCriterion("limit_state =", value, "limitState");
            return (Criteria) this;
        }

        public Criteria andLimitStateNotEqualTo(String value) {
            addCriterion("limit_state <>", value, "limitState");
            return (Criteria) this;
        }

        public Criteria andLimitStateGreaterThan(String value) {
            addCriterion("limit_state >", value, "limitState");
            return (Criteria) this;
        }

        public Criteria andLimitStateGreaterThanOrEqualTo(String value) {
            addCriterion("limit_state >=", value, "limitState");
            return (Criteria) this;
        }

        public Criteria andLimitStateLessThan(String value) {
            addCriterion("limit_state <", value, "limitState");
            return (Criteria) this;
        }

        public Criteria andLimitStateLessThanOrEqualTo(String value) {
            addCriterion("limit_state <=", value, "limitState");
            return (Criteria) this;
        }

        public Criteria andLimitStateLike(String value) {
            addCriterion("limit_state like", value, "limitState");
            return (Criteria) this;
        }

        public Criteria andLimitStateNotLike(String value) {
            addCriterion("limit_state not like", value, "limitState");
            return (Criteria) this;
        }

        public Criteria andLimitStateIn(List<String> values) {
            addCriterion("limit_state in", values, "limitState");
            return (Criteria) this;
        }

        public Criteria andLimitStateNotIn(List<String> values) {
            addCriterion("limit_state not in", values, "limitState");
            return (Criteria) this;
        }

        public Criteria andLimitStateBetween(String value1, String value2) {
            addCriterion("limit_state between", value1, value2, "limitState");
            return (Criteria) this;
        }

        public Criteria andLimitStateNotBetween(String value1, String value2) {
            addCriterion("limit_state not between", value1, value2, "limitState");
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