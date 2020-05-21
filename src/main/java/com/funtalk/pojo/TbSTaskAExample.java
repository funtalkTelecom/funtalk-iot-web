package com.funtalk.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbSTaskAExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbSTaskAExample() {
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

        public Criteria andTaskSourceIsNull() {
            addCriterion("task_source is null");
            return (Criteria) this;
        }

        public Criteria andTaskSourceIsNotNull() {
            addCriterion("task_source is not null");
            return (Criteria) this;
        }

        public Criteria andTaskSourceEqualTo(String value) {
            addCriterion("task_source =", value, "taskSource");
            return (Criteria) this;
        }

        public Criteria andTaskSourceNotEqualTo(String value) {
            addCriterion("task_source <>", value, "taskSource");
            return (Criteria) this;
        }

        public Criteria andTaskSourceGreaterThan(String value) {
            addCriterion("task_source >", value, "taskSource");
            return (Criteria) this;
        }

        public Criteria andTaskSourceGreaterThanOrEqualTo(String value) {
            addCriterion("task_source >=", value, "taskSource");
            return (Criteria) this;
        }

        public Criteria andTaskSourceLessThan(String value) {
            addCriterion("task_source <", value, "taskSource");
            return (Criteria) this;
        }

        public Criteria andTaskSourceLessThanOrEqualTo(String value) {
            addCriterion("task_source <=", value, "taskSource");
            return (Criteria) this;
        }

        public Criteria andTaskSourceLike(String value) {
            addCriterion("task_source like", value, "taskSource");
            return (Criteria) this;
        }

        public Criteria andTaskSourceNotLike(String value) {
            addCriterion("task_source not like", value, "taskSource");
            return (Criteria) this;
        }

        public Criteria andTaskSourceIn(List<String> values) {
            addCriterion("task_source in", values, "taskSource");
            return (Criteria) this;
        }

        public Criteria andTaskSourceNotIn(List<String> values) {
            addCriterion("task_source not in", values, "taskSource");
            return (Criteria) this;
        }

        public Criteria andTaskSourceBetween(String value1, String value2) {
            addCriterion("task_source between", value1, value2, "taskSource");
            return (Criteria) this;
        }

        public Criteria andTaskSourceNotBetween(String value1, String value2) {
            addCriterion("task_source not between", value1, value2, "taskSource");
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

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("order_no like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("order_no not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andCardIdIsNull() {
            addCriterion("card_id is null");
            return (Criteria) this;
        }

        public Criteria andCardIdIsNotNull() {
            addCriterion("card_id is not null");
            return (Criteria) this;
        }

        public Criteria andCardIdEqualTo(String value) {
            addCriterion("card_id =", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotEqualTo(String value) {
            addCriterion("card_id <>", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdGreaterThan(String value) {
            addCriterion("card_id >", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdGreaterThanOrEqualTo(String value) {
            addCriterion("card_id >=", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdLessThan(String value) {
            addCriterion("card_id <", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdLessThanOrEqualTo(String value) {
            addCriterion("card_id <=", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdLike(String value) {
            addCriterion("card_id like", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotLike(String value) {
            addCriterion("card_id not like", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdIn(List<String> values) {
            addCriterion("card_id in", values, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotIn(List<String> values) {
            addCriterion("card_id not in", values, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdBetween(String value1, String value2) {
            addCriterion("card_id between", value1, value2, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotBetween(String value1, String value2) {
            addCriterion("card_id not between", value1, value2, "cardId");
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

        public Criteria andIccidIsNull() {
            addCriterion("iccid is null");
            return (Criteria) this;
        }

        public Criteria andIccidIsNotNull() {
            addCriterion("iccid is not null");
            return (Criteria) this;
        }

        public Criteria andIccidEqualTo(String value) {
            addCriterion("iccid =", value, "iccid");
            return (Criteria) this;
        }

        public Criteria andIccidNotEqualTo(String value) {
            addCriterion("iccid <>", value, "iccid");
            return (Criteria) this;
        }

        public Criteria andIccidGreaterThan(String value) {
            addCriterion("iccid >", value, "iccid");
            return (Criteria) this;
        }

        public Criteria andIccidGreaterThanOrEqualTo(String value) {
            addCriterion("iccid >=", value, "iccid");
            return (Criteria) this;
        }

        public Criteria andIccidLessThan(String value) {
            addCriterion("iccid <", value, "iccid");
            return (Criteria) this;
        }

        public Criteria andIccidLessThanOrEqualTo(String value) {
            addCriterion("iccid <=", value, "iccid");
            return (Criteria) this;
        }

        public Criteria andIccidLike(String value) {
            addCriterion("iccid like", value, "iccid");
            return (Criteria) this;
        }

        public Criteria andIccidNotLike(String value) {
            addCriterion("iccid not like", value, "iccid");
            return (Criteria) this;
        }

        public Criteria andIccidIn(List<String> values) {
            addCriterion("iccid in", values, "iccid");
            return (Criteria) this;
        }

        public Criteria andIccidNotIn(List<String> values) {
            addCriterion("iccid not in", values, "iccid");
            return (Criteria) this;
        }

        public Criteria andIccidBetween(String value1, String value2) {
            addCriterion("iccid between", value1, value2, "iccid");
            return (Criteria) this;
        }

        public Criteria andIccidNotBetween(String value1, String value2) {
            addCriterion("iccid not between", value1, value2, "iccid");
            return (Criteria) this;
        }

        public Criteria andServiceKindIsNull() {
            addCriterion("service_kind is null");
            return (Criteria) this;
        }

        public Criteria andServiceKindIsNotNull() {
            addCriterion("service_kind is not null");
            return (Criteria) this;
        }

        public Criteria andServiceKindEqualTo(String value) {
            addCriterion("service_kind =", value, "serviceKind");
            return (Criteria) this;
        }

        public Criteria andServiceKindNotEqualTo(String value) {
            addCriterion("service_kind <>", value, "serviceKind");
            return (Criteria) this;
        }

        public Criteria andServiceKindGreaterThan(String value) {
            addCriterion("service_kind >", value, "serviceKind");
            return (Criteria) this;
        }

        public Criteria andServiceKindGreaterThanOrEqualTo(String value) {
            addCriterion("service_kind >=", value, "serviceKind");
            return (Criteria) this;
        }

        public Criteria andServiceKindLessThan(String value) {
            addCriterion("service_kind <", value, "serviceKind");
            return (Criteria) this;
        }

        public Criteria andServiceKindLessThanOrEqualTo(String value) {
            addCriterion("service_kind <=", value, "serviceKind");
            return (Criteria) this;
        }

        public Criteria andServiceKindLike(String value) {
            addCriterion("service_kind like", value, "serviceKind");
            return (Criteria) this;
        }

        public Criteria andServiceKindNotLike(String value) {
            addCriterion("service_kind not like", value, "serviceKind");
            return (Criteria) this;
        }

        public Criteria andServiceKindIn(List<String> values) {
            addCriterion("service_kind in", values, "serviceKind");
            return (Criteria) this;
        }

        public Criteria andServiceKindNotIn(List<String> values) {
            addCriterion("service_kind not in", values, "serviceKind");
            return (Criteria) this;
        }

        public Criteria andServiceKindBetween(String value1, String value2) {
            addCriterion("service_kind between", value1, value2, "serviceKind");
            return (Criteria) this;
        }

        public Criteria andServiceKindNotBetween(String value1, String value2) {
            addCriterion("service_kind not between", value1, value2, "serviceKind");
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

        public Criteria andReqSeqIsNull() {
            addCriterion("req_seq is null");
            return (Criteria) this;
        }

        public Criteria andReqSeqIsNotNull() {
            addCriterion("req_seq is not null");
            return (Criteria) this;
        }

        public Criteria andReqSeqEqualTo(String value) {
            addCriterion("req_seq =", value, "reqSeq");
            return (Criteria) this;
        }

        public Criteria andReqSeqNotEqualTo(String value) {
            addCriterion("req_seq <>", value, "reqSeq");
            return (Criteria) this;
        }

        public Criteria andReqSeqGreaterThan(String value) {
            addCriterion("req_seq >", value, "reqSeq");
            return (Criteria) this;
        }

        public Criteria andReqSeqGreaterThanOrEqualTo(String value) {
            addCriterion("req_seq >=", value, "reqSeq");
            return (Criteria) this;
        }

        public Criteria andReqSeqLessThan(String value) {
            addCriterion("req_seq <", value, "reqSeq");
            return (Criteria) this;
        }

        public Criteria andReqSeqLessThanOrEqualTo(String value) {
            addCriterion("req_seq <=", value, "reqSeq");
            return (Criteria) this;
        }

        public Criteria andReqSeqLike(String value) {
            addCriterion("req_seq like", value, "reqSeq");
            return (Criteria) this;
        }

        public Criteria andReqSeqNotLike(String value) {
            addCriterion("req_seq not like", value, "reqSeq");
            return (Criteria) this;
        }

        public Criteria andReqSeqIn(List<String> values) {
            addCriterion("req_seq in", values, "reqSeq");
            return (Criteria) this;
        }

        public Criteria andReqSeqNotIn(List<String> values) {
            addCriterion("req_seq not in", values, "reqSeq");
            return (Criteria) this;
        }

        public Criteria andReqSeqBetween(String value1, String value2) {
            addCriterion("req_seq between", value1, value2, "reqSeq");
            return (Criteria) this;
        }

        public Criteria andReqSeqNotBetween(String value1, String value2) {
            addCriterion("req_seq not between", value1, value2, "reqSeq");
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

        public Criteria andSendBeginTimeIsNull() {
            addCriterion("send_begin_time is null");
            return (Criteria) this;
        }

        public Criteria andSendBeginTimeIsNotNull() {
            addCriterion("send_begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andSendBeginTimeEqualTo(Date value) {
            addCriterion("send_begin_time =", value, "sendBeginTime");
            return (Criteria) this;
        }

        public Criteria andSendBeginTimeNotEqualTo(Date value) {
            addCriterion("send_begin_time <>", value, "sendBeginTime");
            return (Criteria) this;
        }

        public Criteria andSendBeginTimeGreaterThan(Date value) {
            addCriterion("send_begin_time >", value, "sendBeginTime");
            return (Criteria) this;
        }

        public Criteria andSendBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("send_begin_time >=", value, "sendBeginTime");
            return (Criteria) this;
        }

        public Criteria andSendBeginTimeLessThan(Date value) {
            addCriterion("send_begin_time <", value, "sendBeginTime");
            return (Criteria) this;
        }

        public Criteria andSendBeginTimeLessThanOrEqualTo(Date value) {
            addCriterion("send_begin_time <=", value, "sendBeginTime");
            return (Criteria) this;
        }

        public Criteria andSendBeginTimeIn(List<Date> values) {
            addCriterion("send_begin_time in", values, "sendBeginTime");
            return (Criteria) this;
        }

        public Criteria andSendBeginTimeNotIn(List<Date> values) {
            addCriterion("send_begin_time not in", values, "sendBeginTime");
            return (Criteria) this;
        }

        public Criteria andSendBeginTimeBetween(Date value1, Date value2) {
            addCriterion("send_begin_time between", value1, value2, "sendBeginTime");
            return (Criteria) this;
        }

        public Criteria andSendBeginTimeNotBetween(Date value1, Date value2) {
            addCriterion("send_begin_time not between", value1, value2, "sendBeginTime");
            return (Criteria) this;
        }

        public Criteria andSendEndTimeIsNull() {
            addCriterion("send_end_time is null");
            return (Criteria) this;
        }

        public Criteria andSendEndTimeIsNotNull() {
            addCriterion("send_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andSendEndTimeEqualTo(Date value) {
            addCriterion("send_end_time =", value, "sendEndTime");
            return (Criteria) this;
        }

        public Criteria andSendEndTimeNotEqualTo(Date value) {
            addCriterion("send_end_time <>", value, "sendEndTime");
            return (Criteria) this;
        }

        public Criteria andSendEndTimeGreaterThan(Date value) {
            addCriterion("send_end_time >", value, "sendEndTime");
            return (Criteria) this;
        }

        public Criteria andSendEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("send_end_time >=", value, "sendEndTime");
            return (Criteria) this;
        }

        public Criteria andSendEndTimeLessThan(Date value) {
            addCriterion("send_end_time <", value, "sendEndTime");
            return (Criteria) this;
        }

        public Criteria andSendEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("send_end_time <=", value, "sendEndTime");
            return (Criteria) this;
        }

        public Criteria andSendEndTimeIn(List<Date> values) {
            addCriterion("send_end_time in", values, "sendEndTime");
            return (Criteria) this;
        }

        public Criteria andSendEndTimeNotIn(List<Date> values) {
            addCriterion("send_end_time not in", values, "sendEndTime");
            return (Criteria) this;
        }

        public Criteria andSendEndTimeBetween(Date value1, Date value2) {
            addCriterion("send_end_time between", value1, value2, "sendEndTime");
            return (Criteria) this;
        }

        public Criteria andSendEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("send_end_time not between", value1, value2, "sendEndTime");
            return (Criteria) this;
        }

        public Criteria andSendMarkIsNull() {
            addCriterion("send_mark is null");
            return (Criteria) this;
        }

        public Criteria andSendMarkIsNotNull() {
            addCriterion("send_mark is not null");
            return (Criteria) this;
        }

        public Criteria andSendMarkEqualTo(String value) {
            addCriterion("send_mark =", value, "sendMark");
            return (Criteria) this;
        }

        public Criteria andSendMarkNotEqualTo(String value) {
            addCriterion("send_mark <>", value, "sendMark");
            return (Criteria) this;
        }

        public Criteria andSendMarkGreaterThan(String value) {
            addCriterion("send_mark >", value, "sendMark");
            return (Criteria) this;
        }

        public Criteria andSendMarkGreaterThanOrEqualTo(String value) {
            addCriterion("send_mark >=", value, "sendMark");
            return (Criteria) this;
        }

        public Criteria andSendMarkLessThan(String value) {
            addCriterion("send_mark <", value, "sendMark");
            return (Criteria) this;
        }

        public Criteria andSendMarkLessThanOrEqualTo(String value) {
            addCriterion("send_mark <=", value, "sendMark");
            return (Criteria) this;
        }

        public Criteria andSendMarkLike(String value) {
            addCriterion("send_mark like", value, "sendMark");
            return (Criteria) this;
        }

        public Criteria andSendMarkNotLike(String value) {
            addCriterion("send_mark not like", value, "sendMark");
            return (Criteria) this;
        }

        public Criteria andSendMarkIn(List<String> values) {
            addCriterion("send_mark in", values, "sendMark");
            return (Criteria) this;
        }

        public Criteria andSendMarkNotIn(List<String> values) {
            addCriterion("send_mark not in", values, "sendMark");
            return (Criteria) this;
        }

        public Criteria andSendMarkBetween(String value1, String value2) {
            addCriterion("send_mark between", value1, value2, "sendMark");
            return (Criteria) this;
        }

        public Criteria andSendMarkNotBetween(String value1, String value2) {
            addCriterion("send_mark not between", value1, value2, "sendMark");
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

        public Criteria andEmployeeIdIsNull() {
            addCriterion("employee_id is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdIsNotNull() {
            addCriterion("employee_id is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdEqualTo(Integer value) {
            addCriterion("employee_id =", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotEqualTo(Integer value) {
            addCriterion("employee_id <>", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdGreaterThan(Integer value) {
            addCriterion("employee_id >", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("employee_id >=", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdLessThan(Integer value) {
            addCriterion("employee_id <", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdLessThanOrEqualTo(Integer value) {
            addCriterion("employee_id <=", value, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdIn(List<Integer> values) {
            addCriterion("employee_id in", values, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotIn(List<Integer> values) {
            addCriterion("employee_id not in", values, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdBetween(Integer value1, Integer value2) {
            addCriterion("employee_id between", value1, value2, "employeeId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("employee_id not between", value1, value2, "employeeId");
            return (Criteria) this;
        }

        public Criteria andNoticeUrlIsNull() {
            addCriterion("notice_url is null");
            return (Criteria) this;
        }

        public Criteria andNoticeUrlIsNotNull() {
            addCriterion("notice_url is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeUrlEqualTo(String value) {
            addCriterion("notice_url =", value, "noticeUrl");
            return (Criteria) this;
        }

        public Criteria andNoticeUrlNotEqualTo(String value) {
            addCriterion("notice_url <>", value, "noticeUrl");
            return (Criteria) this;
        }

        public Criteria andNoticeUrlGreaterThan(String value) {
            addCriterion("notice_url >", value, "noticeUrl");
            return (Criteria) this;
        }

        public Criteria andNoticeUrlGreaterThanOrEqualTo(String value) {
            addCriterion("notice_url >=", value, "noticeUrl");
            return (Criteria) this;
        }

        public Criteria andNoticeUrlLessThan(String value) {
            addCriterion("notice_url <", value, "noticeUrl");
            return (Criteria) this;
        }

        public Criteria andNoticeUrlLessThanOrEqualTo(String value) {
            addCriterion("notice_url <=", value, "noticeUrl");
            return (Criteria) this;
        }

        public Criteria andNoticeUrlLike(String value) {
            addCriterion("notice_url like", value, "noticeUrl");
            return (Criteria) this;
        }

        public Criteria andNoticeUrlNotLike(String value) {
            addCriterion("notice_url not like", value, "noticeUrl");
            return (Criteria) this;
        }

        public Criteria andNoticeUrlIn(List<String> values) {
            addCriterion("notice_url in", values, "noticeUrl");
            return (Criteria) this;
        }

        public Criteria andNoticeUrlNotIn(List<String> values) {
            addCriterion("notice_url not in", values, "noticeUrl");
            return (Criteria) this;
        }

        public Criteria andNoticeUrlBetween(String value1, String value2) {
            addCriterion("notice_url between", value1, value2, "noticeUrl");
            return (Criteria) this;
        }

        public Criteria andNoticeUrlNotBetween(String value1, String value2) {
            addCriterion("notice_url not between", value1, value2, "noticeUrl");
            return (Criteria) this;
        }

        public Criteria andNoticeSeqIsNull() {
            addCriterion("notice_seq is null");
            return (Criteria) this;
        }

        public Criteria andNoticeSeqIsNotNull() {
            addCriterion("notice_seq is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeSeqEqualTo(String value) {
            addCriterion("notice_seq =", value, "noticeSeq");
            return (Criteria) this;
        }

        public Criteria andNoticeSeqNotEqualTo(String value) {
            addCriterion("notice_seq <>", value, "noticeSeq");
            return (Criteria) this;
        }

        public Criteria andNoticeSeqGreaterThan(String value) {
            addCriterion("notice_seq >", value, "noticeSeq");
            return (Criteria) this;
        }

        public Criteria andNoticeSeqGreaterThanOrEqualTo(String value) {
            addCriterion("notice_seq >=", value, "noticeSeq");
            return (Criteria) this;
        }

        public Criteria andNoticeSeqLessThan(String value) {
            addCriterion("notice_seq <", value, "noticeSeq");
            return (Criteria) this;
        }

        public Criteria andNoticeSeqLessThanOrEqualTo(String value) {
            addCriterion("notice_seq <=", value, "noticeSeq");
            return (Criteria) this;
        }

        public Criteria andNoticeSeqLike(String value) {
            addCriterion("notice_seq like", value, "noticeSeq");
            return (Criteria) this;
        }

        public Criteria andNoticeSeqNotLike(String value) {
            addCriterion("notice_seq not like", value, "noticeSeq");
            return (Criteria) this;
        }

        public Criteria andNoticeSeqIn(List<String> values) {
            addCriterion("notice_seq in", values, "noticeSeq");
            return (Criteria) this;
        }

        public Criteria andNoticeSeqNotIn(List<String> values) {
            addCriterion("notice_seq not in", values, "noticeSeq");
            return (Criteria) this;
        }

        public Criteria andNoticeSeqBetween(String value1, String value2) {
            addCriterion("notice_seq between", value1, value2, "noticeSeq");
            return (Criteria) this;
        }

        public Criteria andNoticeSeqNotBetween(String value1, String value2) {
            addCriterion("notice_seq not between", value1, value2, "noticeSeq");
            return (Criteria) this;
        }

        public Criteria andNoticeStateIsNull() {
            addCriterion("notice_state is null");
            return (Criteria) this;
        }

        public Criteria andNoticeStateIsNotNull() {
            addCriterion("notice_state is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeStateEqualTo(String value) {
            addCriterion("notice_state =", value, "noticeState");
            return (Criteria) this;
        }

        public Criteria andNoticeStateNotEqualTo(String value) {
            addCriterion("notice_state <>", value, "noticeState");
            return (Criteria) this;
        }

        public Criteria andNoticeStateGreaterThan(String value) {
            addCriterion("notice_state >", value, "noticeState");
            return (Criteria) this;
        }

        public Criteria andNoticeStateGreaterThanOrEqualTo(String value) {
            addCriterion("notice_state >=", value, "noticeState");
            return (Criteria) this;
        }

        public Criteria andNoticeStateLessThan(String value) {
            addCriterion("notice_state <", value, "noticeState");
            return (Criteria) this;
        }

        public Criteria andNoticeStateLessThanOrEqualTo(String value) {
            addCriterion("notice_state <=", value, "noticeState");
            return (Criteria) this;
        }

        public Criteria andNoticeStateLike(String value) {
            addCriterion("notice_state like", value, "noticeState");
            return (Criteria) this;
        }

        public Criteria andNoticeStateNotLike(String value) {
            addCriterion("notice_state not like", value, "noticeState");
            return (Criteria) this;
        }

        public Criteria andNoticeStateIn(List<String> values) {
            addCriterion("notice_state in", values, "noticeState");
            return (Criteria) this;
        }

        public Criteria andNoticeStateNotIn(List<String> values) {
            addCriterion("notice_state not in", values, "noticeState");
            return (Criteria) this;
        }

        public Criteria andNoticeStateBetween(String value1, String value2) {
            addCriterion("notice_state between", value1, value2, "noticeState");
            return (Criteria) this;
        }

        public Criteria andNoticeStateNotBetween(String value1, String value2) {
            addCriterion("notice_state not between", value1, value2, "noticeState");
            return (Criteria) this;
        }

        public Criteria andNoticeTimeIsNull() {
            addCriterion("notice_time is null");
            return (Criteria) this;
        }

        public Criteria andNoticeTimeIsNotNull() {
            addCriterion("notice_time is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeTimeEqualTo(Date value) {
            addCriterion("notice_time =", value, "noticeTime");
            return (Criteria) this;
        }

        public Criteria andNoticeTimeNotEqualTo(Date value) {
            addCriterion("notice_time <>", value, "noticeTime");
            return (Criteria) this;
        }

        public Criteria andNoticeTimeGreaterThan(Date value) {
            addCriterion("notice_time >", value, "noticeTime");
            return (Criteria) this;
        }

        public Criteria andNoticeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("notice_time >=", value, "noticeTime");
            return (Criteria) this;
        }

        public Criteria andNoticeTimeLessThan(Date value) {
            addCriterion("notice_time <", value, "noticeTime");
            return (Criteria) this;
        }

        public Criteria andNoticeTimeLessThanOrEqualTo(Date value) {
            addCriterion("notice_time <=", value, "noticeTime");
            return (Criteria) this;
        }

        public Criteria andNoticeTimeIn(List<Date> values) {
            addCriterion("notice_time in", values, "noticeTime");
            return (Criteria) this;
        }

        public Criteria andNoticeTimeNotIn(List<Date> values) {
            addCriterion("notice_time not in", values, "noticeTime");
            return (Criteria) this;
        }

        public Criteria andNoticeTimeBetween(Date value1, Date value2) {
            addCriterion("notice_time between", value1, value2, "noticeTime");
            return (Criteria) this;
        }

        public Criteria andNoticeTimeNotBetween(Date value1, Date value2) {
            addCriterion("notice_time not between", value1, value2, "noticeTime");
            return (Criteria) this;
        }

        public Criteria andNoticeBackIsNull() {
            addCriterion("notice_back is null");
            return (Criteria) this;
        }

        public Criteria andNoticeBackIsNotNull() {
            addCriterion("notice_back is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeBackEqualTo(String value) {
            addCriterion("notice_back =", value, "noticeBack");
            return (Criteria) this;
        }

        public Criteria andNoticeBackNotEqualTo(String value) {
            addCriterion("notice_back <>", value, "noticeBack");
            return (Criteria) this;
        }

        public Criteria andNoticeBackGreaterThan(String value) {
            addCriterion("notice_back >", value, "noticeBack");
            return (Criteria) this;
        }

        public Criteria andNoticeBackGreaterThanOrEqualTo(String value) {
            addCriterion("notice_back >=", value, "noticeBack");
            return (Criteria) this;
        }

        public Criteria andNoticeBackLessThan(String value) {
            addCriterion("notice_back <", value, "noticeBack");
            return (Criteria) this;
        }

        public Criteria andNoticeBackLessThanOrEqualTo(String value) {
            addCriterion("notice_back <=", value, "noticeBack");
            return (Criteria) this;
        }

        public Criteria andNoticeBackLike(String value) {
            addCriterion("notice_back like", value, "noticeBack");
            return (Criteria) this;
        }

        public Criteria andNoticeBackNotLike(String value) {
            addCriterion("notice_back not like", value, "noticeBack");
            return (Criteria) this;
        }

        public Criteria andNoticeBackIn(List<String> values) {
            addCriterion("notice_back in", values, "noticeBack");
            return (Criteria) this;
        }

        public Criteria andNoticeBackNotIn(List<String> values) {
            addCriterion("notice_back not in", values, "noticeBack");
            return (Criteria) this;
        }

        public Criteria andNoticeBackBetween(String value1, String value2) {
            addCriterion("notice_back between", value1, value2, "noticeBack");
            return (Criteria) this;
        }

        public Criteria andNoticeBackNotBetween(String value1, String value2) {
            addCriterion("notice_back not between", value1, value2, "noticeBack");
            return (Criteria) this;
        }

        public Criteria andDealMarkIsNull() {
            addCriterion("deal_mark is null");
            return (Criteria) this;
        }

        public Criteria andDealMarkIsNotNull() {
            addCriterion("deal_mark is not null");
            return (Criteria) this;
        }

        public Criteria andDealMarkEqualTo(String value) {
            addCriterion("deal_mark =", value, "dealMark");
            return (Criteria) this;
        }

        public Criteria andDealMarkNotEqualTo(String value) {
            addCriterion("deal_mark <>", value, "dealMark");
            return (Criteria) this;
        }

        public Criteria andDealMarkGreaterThan(String value) {
            addCriterion("deal_mark >", value, "dealMark");
            return (Criteria) this;
        }

        public Criteria andDealMarkGreaterThanOrEqualTo(String value) {
            addCriterion("deal_mark >=", value, "dealMark");
            return (Criteria) this;
        }

        public Criteria andDealMarkLessThan(String value) {
            addCriterion("deal_mark <", value, "dealMark");
            return (Criteria) this;
        }

        public Criteria andDealMarkLessThanOrEqualTo(String value) {
            addCriterion("deal_mark <=", value, "dealMark");
            return (Criteria) this;
        }

        public Criteria andDealMarkLike(String value) {
            addCriterion("deal_mark like", value, "dealMark");
            return (Criteria) this;
        }

        public Criteria andDealMarkNotLike(String value) {
            addCriterion("deal_mark not like", value, "dealMark");
            return (Criteria) this;
        }

        public Criteria andDealMarkIn(List<String> values) {
            addCriterion("deal_mark in", values, "dealMark");
            return (Criteria) this;
        }

        public Criteria andDealMarkNotIn(List<String> values) {
            addCriterion("deal_mark not in", values, "dealMark");
            return (Criteria) this;
        }

        public Criteria andDealMarkBetween(String value1, String value2) {
            addCriterion("deal_mark between", value1, value2, "dealMark");
            return (Criteria) this;
        }

        public Criteria andDealMarkNotBetween(String value1, String value2) {
            addCriterion("deal_mark not between", value1, value2, "dealMark");
            return (Criteria) this;
        }

        public Criteria andBillIdIsNull() {
            addCriterion("bill_id is null");
            return (Criteria) this;
        }

        public Criteria andBillIdIsNotNull() {
            addCriterion("bill_id is not null");
            return (Criteria) this;
        }

        public Criteria andBillIdEqualTo(Integer value) {
            addCriterion("bill_id =", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotEqualTo(Integer value) {
            addCriterion("bill_id <>", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThan(Integer value) {
            addCriterion("bill_id >", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("bill_id >=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThan(Integer value) {
            addCriterion("bill_id <", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdLessThanOrEqualTo(Integer value) {
            addCriterion("bill_id <=", value, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdIn(List<Integer> values) {
            addCriterion("bill_id in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotIn(List<Integer> values) {
            addCriterion("bill_id not in", values, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdBetween(Integer value1, Integer value2) {
            addCriterion("bill_id between", value1, value2, "billId");
            return (Criteria) this;
        }

        public Criteria andBillIdNotBetween(Integer value1, Integer value2) {
            addCriterion("bill_id not between", value1, value2, "billId");
            return (Criteria) this;
        }

        public Criteria andRepeatCountIsNull() {
            addCriterion("repeat_count is null");
            return (Criteria) this;
        }

        public Criteria andRepeatCountIsNotNull() {
            addCriterion("repeat_count is not null");
            return (Criteria) this;
        }

        public Criteria andRepeatCountEqualTo(Integer value) {
            addCriterion("repeat_count =", value, "repeatCount");
            return (Criteria) this;
        }

        public Criteria andRepeatCountNotEqualTo(Integer value) {
            addCriterion("repeat_count <>", value, "repeatCount");
            return (Criteria) this;
        }

        public Criteria andRepeatCountGreaterThan(Integer value) {
            addCriterion("repeat_count >", value, "repeatCount");
            return (Criteria) this;
        }

        public Criteria andRepeatCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("repeat_count >=", value, "repeatCount");
            return (Criteria) this;
        }

        public Criteria andRepeatCountLessThan(Integer value) {
            addCriterion("repeat_count <", value, "repeatCount");
            return (Criteria) this;
        }

        public Criteria andRepeatCountLessThanOrEqualTo(Integer value) {
            addCriterion("repeat_count <=", value, "repeatCount");
            return (Criteria) this;
        }

        public Criteria andRepeatCountIn(List<Integer> values) {
            addCriterion("repeat_count in", values, "repeatCount");
            return (Criteria) this;
        }

        public Criteria andRepeatCountNotIn(List<Integer> values) {
            addCriterion("repeat_count not in", values, "repeatCount");
            return (Criteria) this;
        }

        public Criteria andRepeatCountBetween(Integer value1, Integer value2) {
            addCriterion("repeat_count between", value1, value2, "repeatCount");
            return (Criteria) this;
        }

        public Criteria andRepeatCountNotBetween(Integer value1, Integer value2) {
            addCriterion("repeat_count not between", value1, value2, "repeatCount");
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