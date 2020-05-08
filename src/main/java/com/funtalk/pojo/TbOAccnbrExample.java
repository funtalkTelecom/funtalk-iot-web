package com.funtalk.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbOAccnbrExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbOAccnbrExample() {
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

        public Criteria andAccOrderIdIsNull() {
            addCriterion("acc_order_id is null");
            return (Criteria) this;
        }

        public Criteria andAccOrderIdIsNotNull() {
            addCriterion("acc_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccOrderIdEqualTo(Integer value) {
            addCriterion("acc_order_id =", value, "accOrderId");
            return (Criteria) this;
        }

        public Criteria andAccOrderIdNotEqualTo(Integer value) {
            addCriterion("acc_order_id <>", value, "accOrderId");
            return (Criteria) this;
        }

        public Criteria andAccOrderIdGreaterThan(Integer value) {
            addCriterion("acc_order_id >", value, "accOrderId");
            return (Criteria) this;
        }

        public Criteria andAccOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("acc_order_id >=", value, "accOrderId");
            return (Criteria) this;
        }

        public Criteria andAccOrderIdLessThan(Integer value) {
            addCriterion("acc_order_id <", value, "accOrderId");
            return (Criteria) this;
        }

        public Criteria andAccOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("acc_order_id <=", value, "accOrderId");
            return (Criteria) this;
        }

        public Criteria andAccOrderIdIn(List<Integer> values) {
            addCriterion("acc_order_id in", values, "accOrderId");
            return (Criteria) this;
        }

        public Criteria andAccOrderIdNotIn(List<Integer> values) {
            addCriterion("acc_order_id not in", values, "accOrderId");
            return (Criteria) this;
        }

        public Criteria andAccOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("acc_order_id between", value1, value2, "accOrderId");
            return (Criteria) this;
        }

        public Criteria andAccOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("acc_order_id not between", value1, value2, "accOrderId");
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

        public Criteria andStateTimeIsNull() {
            addCriterion("state_time is null");
            return (Criteria) this;
        }

        public Criteria andStateTimeIsNotNull() {
            addCriterion("state_time is not null");
            return (Criteria) this;
        }

        public Criteria andStateTimeEqualTo(Date value) {
            addCriterion("state_time =", value, "stateTime");
            return (Criteria) this;
        }

        public Criteria andStateTimeNotEqualTo(Date value) {
            addCriterion("state_time <>", value, "stateTime");
            return (Criteria) this;
        }

        public Criteria andStateTimeGreaterThan(Date value) {
            addCriterion("state_time >", value, "stateTime");
            return (Criteria) this;
        }

        public Criteria andStateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("state_time >=", value, "stateTime");
            return (Criteria) this;
        }

        public Criteria andStateTimeLessThan(Date value) {
            addCriterion("state_time <", value, "stateTime");
            return (Criteria) this;
        }

        public Criteria andStateTimeLessThanOrEqualTo(Date value) {
            addCriterion("state_time <=", value, "stateTime");
            return (Criteria) this;
        }

        public Criteria andStateTimeIn(List<Date> values) {
            addCriterion("state_time in", values, "stateTime");
            return (Criteria) this;
        }

        public Criteria andStateTimeNotIn(List<Date> values) {
            addCriterion("state_time not in", values, "stateTime");
            return (Criteria) this;
        }

        public Criteria andStateTimeBetween(Date value1, Date value2) {
            addCriterion("state_time between", value1, value2, "stateTime");
            return (Criteria) this;
        }

        public Criteria andStateTimeNotBetween(Date value1, Date value2) {
            addCriterion("state_time not between", value1, value2, "stateTime");
            return (Criteria) this;
        }

        public Criteria andIfValidIsNull() {
            addCriterion("if_valid is null");
            return (Criteria) this;
        }

        public Criteria andIfValidIsNotNull() {
            addCriterion("if_valid is not null");
            return (Criteria) this;
        }

        public Criteria andIfValidEqualTo(String value) {
            addCriterion("if_valid =", value, "ifValid");
            return (Criteria) this;
        }

        public Criteria andIfValidNotEqualTo(String value) {
            addCriterion("if_valid <>", value, "ifValid");
            return (Criteria) this;
        }

        public Criteria andIfValidGreaterThan(String value) {
            addCriterion("if_valid >", value, "ifValid");
            return (Criteria) this;
        }

        public Criteria andIfValidGreaterThanOrEqualTo(String value) {
            addCriterion("if_valid >=", value, "ifValid");
            return (Criteria) this;
        }

        public Criteria andIfValidLessThan(String value) {
            addCriterion("if_valid <", value, "ifValid");
            return (Criteria) this;
        }

        public Criteria andIfValidLessThanOrEqualTo(String value) {
            addCriterion("if_valid <=", value, "ifValid");
            return (Criteria) this;
        }

        public Criteria andIfValidLike(String value) {
            addCriterion("if_valid like", value, "ifValid");
            return (Criteria) this;
        }

        public Criteria andIfValidNotLike(String value) {
            addCriterion("if_valid not like", value, "ifValid");
            return (Criteria) this;
        }

        public Criteria andIfValidIn(List<String> values) {
            addCriterion("if_valid in", values, "ifValid");
            return (Criteria) this;
        }

        public Criteria andIfValidNotIn(List<String> values) {
            addCriterion("if_valid not in", values, "ifValid");
            return (Criteria) this;
        }

        public Criteria andIfValidBetween(String value1, String value2) {
            addCriterion("if_valid between", value1, value2, "ifValid");
            return (Criteria) this;
        }

        public Criteria andIfValidNotBetween(String value1, String value2) {
            addCriterion("if_valid not between", value1, value2, "ifValid");
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

        public Criteria andValidTimeIsNull() {
            addCriterion("valid_time is null");
            return (Criteria) this;
        }

        public Criteria andValidTimeIsNotNull() {
            addCriterion("valid_time is not null");
            return (Criteria) this;
        }

        public Criteria andValidTimeEqualTo(Date value) {
            addCriterion("valid_time =", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeNotEqualTo(Date value) {
            addCriterion("valid_time <>", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeGreaterThan(Date value) {
            addCriterion("valid_time >", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("valid_time >=", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeLessThan(Date value) {
            addCriterion("valid_time <", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeLessThanOrEqualTo(Date value) {
            addCriterion("valid_time <=", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeIn(List<Date> values) {
            addCriterion("valid_time in", values, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeNotIn(List<Date> values) {
            addCriterion("valid_time not in", values, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeBetween(Date value1, Date value2) {
            addCriterion("valid_time between", value1, value2, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeNotBetween(Date value1, Date value2) {
            addCriterion("valid_time not between", value1, value2, "validTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeIsNull() {
            addCriterion("invalid_time is null");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeIsNotNull() {
            addCriterion("invalid_time is not null");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeEqualTo(Date value) {
            addCriterion("invalid_time =", value, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeNotEqualTo(Date value) {
            addCriterion("invalid_time <>", value, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeGreaterThan(Date value) {
            addCriterion("invalid_time >", value, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("invalid_time >=", value, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeLessThan(Date value) {
            addCriterion("invalid_time <", value, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeLessThanOrEqualTo(Date value) {
            addCriterion("invalid_time <=", value, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeIn(List<Date> values) {
            addCriterion("invalid_time in", values, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeNotIn(List<Date> values) {
            addCriterion("invalid_time not in", values, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeBetween(Date value1, Date value2) {
            addCriterion("invalid_time between", value1, value2, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andInvalidTimeNotBetween(Date value1, Date value2) {
            addCriterion("invalid_time not between", value1, value2, "invalidTime");
            return (Criteria) this;
        }

        public Criteria andPakIdIsNull() {
            addCriterion("pak_id is null");
            return (Criteria) this;
        }

        public Criteria andPakIdIsNotNull() {
            addCriterion("pak_id is not null");
            return (Criteria) this;
        }

        public Criteria andPakIdEqualTo(String value) {
            addCriterion("pak_id =", value, "pakId");
            return (Criteria) this;
        }

        public Criteria andPakIdNotEqualTo(String value) {
            addCriterion("pak_id <>", value, "pakId");
            return (Criteria) this;
        }

        public Criteria andPakIdGreaterThan(String value) {
            addCriterion("pak_id >", value, "pakId");
            return (Criteria) this;
        }

        public Criteria andPakIdGreaterThanOrEqualTo(String value) {
            addCriterion("pak_id >=", value, "pakId");
            return (Criteria) this;
        }

        public Criteria andPakIdLessThan(String value) {
            addCriterion("pak_id <", value, "pakId");
            return (Criteria) this;
        }

        public Criteria andPakIdLessThanOrEqualTo(String value) {
            addCriterion("pak_id <=", value, "pakId");
            return (Criteria) this;
        }

        public Criteria andPakIdLike(String value) {
            addCriterion("pak_id like", value, "pakId");
            return (Criteria) this;
        }

        public Criteria andPakIdNotLike(String value) {
            addCriterion("pak_id not like", value, "pakId");
            return (Criteria) this;
        }

        public Criteria andPakIdIn(List<String> values) {
            addCriterion("pak_id in", values, "pakId");
            return (Criteria) this;
        }

        public Criteria andPakIdNotIn(List<String> values) {
            addCriterion("pak_id not in", values, "pakId");
            return (Criteria) this;
        }

        public Criteria andPakIdBetween(String value1, String value2) {
            addCriterion("pak_id between", value1, value2, "pakId");
            return (Criteria) this;
        }

        public Criteria andPakIdNotBetween(String value1, String value2) {
            addCriterion("pak_id not between", value1, value2, "pakId");
            return (Criteria) this;
        }

        public Criteria andPakPriceIsNull() {
            addCriterion("pak_price is null");
            return (Criteria) this;
        }

        public Criteria andPakPriceIsNotNull() {
            addCriterion("pak_price is not null");
            return (Criteria) this;
        }

        public Criteria andPakPriceEqualTo(BigDecimal value) {
            addCriterion("pak_price =", value, "pakPrice");
            return (Criteria) this;
        }

        public Criteria andPakPriceNotEqualTo(BigDecimal value) {
            addCriterion("pak_price <>", value, "pakPrice");
            return (Criteria) this;
        }

        public Criteria andPakPriceGreaterThan(BigDecimal value) {
            addCriterion("pak_price >", value, "pakPrice");
            return (Criteria) this;
        }

        public Criteria andPakPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pak_price >=", value, "pakPrice");
            return (Criteria) this;
        }

        public Criteria andPakPriceLessThan(BigDecimal value) {
            addCriterion("pak_price <", value, "pakPrice");
            return (Criteria) this;
        }

        public Criteria andPakPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pak_price <=", value, "pakPrice");
            return (Criteria) this;
        }

        public Criteria andPakPriceIn(List<BigDecimal> values) {
            addCriterion("pak_price in", values, "pakPrice");
            return (Criteria) this;
        }

        public Criteria andPakPriceNotIn(List<BigDecimal> values) {
            addCriterion("pak_price not in", values, "pakPrice");
            return (Criteria) this;
        }

        public Criteria andPakPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pak_price between", value1, value2, "pakPrice");
            return (Criteria) this;
        }

        public Criteria andPakPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pak_price not between", value1, value2, "pakPrice");
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