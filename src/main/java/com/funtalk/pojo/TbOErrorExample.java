package com.funtalk.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbOErrorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbOErrorExample() {
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

        public Criteria andErrIdIsNull() {
            addCriterion("err_id is null");
            return (Criteria) this;
        }

        public Criteria andErrIdIsNotNull() {
            addCriterion("err_id is not null");
            return (Criteria) this;
        }

        public Criteria andErrIdEqualTo(Integer value) {
            addCriterion("err_id =", value, "errId");
            return (Criteria) this;
        }

        public Criteria andErrIdNotEqualTo(Integer value) {
            addCriterion("err_id <>", value, "errId");
            return (Criteria) this;
        }

        public Criteria andErrIdGreaterThan(Integer value) {
            addCriterion("err_id >", value, "errId");
            return (Criteria) this;
        }

        public Criteria andErrIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("err_id >=", value, "errId");
            return (Criteria) this;
        }

        public Criteria andErrIdLessThan(Integer value) {
            addCriterion("err_id <", value, "errId");
            return (Criteria) this;
        }

        public Criteria andErrIdLessThanOrEqualTo(Integer value) {
            addCriterion("err_id <=", value, "errId");
            return (Criteria) this;
        }

        public Criteria andErrIdIn(List<Integer> values) {
            addCriterion("err_id in", values, "errId");
            return (Criteria) this;
        }

        public Criteria andErrIdNotIn(List<Integer> values) {
            addCriterion("err_id not in", values, "errId");
            return (Criteria) this;
        }

        public Criteria andErrIdBetween(Integer value1, Integer value2) {
            addCriterion("err_id between", value1, value2, "errId");
            return (Criteria) this;
        }

        public Criteria andErrIdNotBetween(Integer value1, Integer value2) {
            addCriterion("err_id not between", value1, value2, "errId");
            return (Criteria) this;
        }

        public Criteria andErrTypeIsNull() {
            addCriterion("err_type is null");
            return (Criteria) this;
        }

        public Criteria andErrTypeIsNotNull() {
            addCriterion("err_type is not null");
            return (Criteria) this;
        }

        public Criteria andErrTypeEqualTo(String value) {
            addCriterion("err_type =", value, "errType");
            return (Criteria) this;
        }

        public Criteria andErrTypeNotEqualTo(String value) {
            addCriterion("err_type <>", value, "errType");
            return (Criteria) this;
        }

        public Criteria andErrTypeGreaterThan(String value) {
            addCriterion("err_type >", value, "errType");
            return (Criteria) this;
        }

        public Criteria andErrTypeGreaterThanOrEqualTo(String value) {
            addCriterion("err_type >=", value, "errType");
            return (Criteria) this;
        }

        public Criteria andErrTypeLessThan(String value) {
            addCriterion("err_type <", value, "errType");
            return (Criteria) this;
        }

        public Criteria andErrTypeLessThanOrEqualTo(String value) {
            addCriterion("err_type <=", value, "errType");
            return (Criteria) this;
        }

        public Criteria andErrTypeLike(String value) {
            addCriterion("err_type like", value, "errType");
            return (Criteria) this;
        }

        public Criteria andErrTypeNotLike(String value) {
            addCriterion("err_type not like", value, "errType");
            return (Criteria) this;
        }

        public Criteria andErrTypeIn(List<String> values) {
            addCriterion("err_type in", values, "errType");
            return (Criteria) this;
        }

        public Criteria andErrTypeNotIn(List<String> values) {
            addCriterion("err_type not in", values, "errType");
            return (Criteria) this;
        }

        public Criteria andErrTypeBetween(String value1, String value2) {
            addCriterion("err_type between", value1, value2, "errType");
            return (Criteria) this;
        }

        public Criteria andErrTypeNotBetween(String value1, String value2) {
            addCriterion("err_type not between", value1, value2, "errType");
            return (Criteria) this;
        }

        public Criteria andTopicIsNull() {
            addCriterion("topic is null");
            return (Criteria) this;
        }

        public Criteria andTopicIsNotNull() {
            addCriterion("topic is not null");
            return (Criteria) this;
        }

        public Criteria andTopicEqualTo(String value) {
            addCriterion("topic =", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicNotEqualTo(String value) {
            addCriterion("topic <>", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicGreaterThan(String value) {
            addCriterion("topic >", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicGreaterThanOrEqualTo(String value) {
            addCriterion("topic >=", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicLessThan(String value) {
            addCriterion("topic <", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicLessThanOrEqualTo(String value) {
            addCriterion("topic <=", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicLike(String value) {
            addCriterion("topic like", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicNotLike(String value) {
            addCriterion("topic not like", value, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicIn(List<String> values) {
            addCriterion("topic in", values, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicNotIn(List<String> values) {
            addCriterion("topic not in", values, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicBetween(String value1, String value2) {
            addCriterion("topic between", value1, value2, "topic");
            return (Criteria) this;
        }

        public Criteria andTopicNotBetween(String value1, String value2) {
            addCriterion("topic not between", value1, value2, "topic");
            return (Criteria) this;
        }

        public Criteria andErrMessaeIsNull() {
            addCriterion("err_messae is null");
            return (Criteria) this;
        }

        public Criteria andErrMessaeIsNotNull() {
            addCriterion("err_messae is not null");
            return (Criteria) this;
        }

        public Criteria andErrMessaeEqualTo(String value) {
            addCriterion("err_messae =", value, "errMessae");
            return (Criteria) this;
        }

        public Criteria andErrMessaeNotEqualTo(String value) {
            addCriterion("err_messae <>", value, "errMessae");
            return (Criteria) this;
        }

        public Criteria andErrMessaeGreaterThan(String value) {
            addCriterion("err_messae >", value, "errMessae");
            return (Criteria) this;
        }

        public Criteria andErrMessaeGreaterThanOrEqualTo(String value) {
            addCriterion("err_messae >=", value, "errMessae");
            return (Criteria) this;
        }

        public Criteria andErrMessaeLessThan(String value) {
            addCriterion("err_messae <", value, "errMessae");
            return (Criteria) this;
        }

        public Criteria andErrMessaeLessThanOrEqualTo(String value) {
            addCriterion("err_messae <=", value, "errMessae");
            return (Criteria) this;
        }

        public Criteria andErrMessaeLike(String value) {
            addCriterion("err_messae like", value, "errMessae");
            return (Criteria) this;
        }

        public Criteria andErrMessaeNotLike(String value) {
            addCriterion("err_messae not like", value, "errMessae");
            return (Criteria) this;
        }

        public Criteria andErrMessaeIn(List<String> values) {
            addCriterion("err_messae in", values, "errMessae");
            return (Criteria) this;
        }

        public Criteria andErrMessaeNotIn(List<String> values) {
            addCriterion("err_messae not in", values, "errMessae");
            return (Criteria) this;
        }

        public Criteria andErrMessaeBetween(String value1, String value2) {
            addCriterion("err_messae between", value1, value2, "errMessae");
            return (Criteria) this;
        }

        public Criteria andErrMessaeNotBetween(String value1, String value2) {
            addCriterion("err_messae not between", value1, value2, "errMessae");
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

        public Criteria andMarkIsNull() {
            addCriterion("mark is null");
            return (Criteria) this;
        }

        public Criteria andMarkIsNotNull() {
            addCriterion("mark is not null");
            return (Criteria) this;
        }

        public Criteria andMarkEqualTo(String value) {
            addCriterion("mark =", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotEqualTo(String value) {
            addCriterion("mark <>", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThan(String value) {
            addCriterion("mark >", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThanOrEqualTo(String value) {
            addCriterion("mark >=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThan(String value) {
            addCriterion("mark <", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThanOrEqualTo(String value) {
            addCriterion("mark <=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLike(String value) {
            addCriterion("mark like", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotLike(String value) {
            addCriterion("mark not like", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkIn(List<String> values) {
            addCriterion("mark in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotIn(List<String> values) {
            addCriterion("mark not in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkBetween(String value1, String value2) {
            addCriterion("mark between", value1, value2, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotBetween(String value1, String value2) {
            addCriterion("mark not between", value1, value2, "mark");
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