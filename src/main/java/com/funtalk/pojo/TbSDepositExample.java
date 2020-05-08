package com.funtalk.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbSDepositExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbSDepositExample() {
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

        public Criteria andDepositIdIsNull() {
            addCriterion("deposit_id is null");
            return (Criteria) this;
        }

        public Criteria andDepositIdIsNotNull() {
            addCriterion("deposit_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepositIdEqualTo(Integer value) {
            addCriterion("deposit_id =", value, "depositId");
            return (Criteria) this;
        }

        public Criteria andDepositIdNotEqualTo(Integer value) {
            addCriterion("deposit_id <>", value, "depositId");
            return (Criteria) this;
        }

        public Criteria andDepositIdGreaterThan(Integer value) {
            addCriterion("deposit_id >", value, "depositId");
            return (Criteria) this;
        }

        public Criteria andDepositIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("deposit_id >=", value, "depositId");
            return (Criteria) this;
        }

        public Criteria andDepositIdLessThan(Integer value) {
            addCriterion("deposit_id <", value, "depositId");
            return (Criteria) this;
        }

        public Criteria andDepositIdLessThanOrEqualTo(Integer value) {
            addCriterion("deposit_id <=", value, "depositId");
            return (Criteria) this;
        }

        public Criteria andDepositIdIn(List<Integer> values) {
            addCriterion("deposit_id in", values, "depositId");
            return (Criteria) this;
        }

        public Criteria andDepositIdNotIn(List<Integer> values) {
            addCriterion("deposit_id not in", values, "depositId");
            return (Criteria) this;
        }

        public Criteria andDepositIdBetween(Integer value1, Integer value2) {
            addCriterion("deposit_id between", value1, value2, "depositId");
            return (Criteria) this;
        }

        public Criteria andDepositIdNotBetween(Integer value1, Integer value2) {
            addCriterion("deposit_id not between", value1, value2, "depositId");
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

        public Criteria andAcctIdIsNull() {
            addCriterion("acct_id is null");
            return (Criteria) this;
        }

        public Criteria andAcctIdIsNotNull() {
            addCriterion("acct_id is not null");
            return (Criteria) this;
        }

        public Criteria andAcctIdEqualTo(Integer value) {
            addCriterion("acct_id =", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdNotEqualTo(Integer value) {
            addCriterion("acct_id <>", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdGreaterThan(Integer value) {
            addCriterion("acct_id >", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("acct_id >=", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdLessThan(Integer value) {
            addCriterion("acct_id <", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdLessThanOrEqualTo(Integer value) {
            addCriterion("acct_id <=", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdIn(List<Integer> values) {
            addCriterion("acct_id in", values, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdNotIn(List<Integer> values) {
            addCriterion("acct_id not in", values, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdBetween(Integer value1, Integer value2) {
            addCriterion("acct_id between", value1, value2, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdNotBetween(Integer value1, Integer value2) {
            addCriterion("acct_id not between", value1, value2, "acctId");
            return (Criteria) this;
        }

        public Criteria andDeCodeIsNull() {
            addCriterion("de_code is null");
            return (Criteria) this;
        }

        public Criteria andDeCodeIsNotNull() {
            addCriterion("de_code is not null");
            return (Criteria) this;
        }

        public Criteria andDeCodeEqualTo(String value) {
            addCriterion("de_code =", value, "deCode");
            return (Criteria) this;
        }

        public Criteria andDeCodeNotEqualTo(String value) {
            addCriterion("de_code <>", value, "deCode");
            return (Criteria) this;
        }

        public Criteria andDeCodeGreaterThan(String value) {
            addCriterion("de_code >", value, "deCode");
            return (Criteria) this;
        }

        public Criteria andDeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("de_code >=", value, "deCode");
            return (Criteria) this;
        }

        public Criteria andDeCodeLessThan(String value) {
            addCriterion("de_code <", value, "deCode");
            return (Criteria) this;
        }

        public Criteria andDeCodeLessThanOrEqualTo(String value) {
            addCriterion("de_code <=", value, "deCode");
            return (Criteria) this;
        }

        public Criteria andDeCodeLike(String value) {
            addCriterion("de_code like", value, "deCode");
            return (Criteria) this;
        }

        public Criteria andDeCodeNotLike(String value) {
            addCriterion("de_code not like", value, "deCode");
            return (Criteria) this;
        }

        public Criteria andDeCodeIn(List<String> values) {
            addCriterion("de_code in", values, "deCode");
            return (Criteria) this;
        }

        public Criteria andDeCodeNotIn(List<String> values) {
            addCriterion("de_code not in", values, "deCode");
            return (Criteria) this;
        }

        public Criteria andDeCodeBetween(String value1, String value2) {
            addCriterion("de_code between", value1, value2, "deCode");
            return (Criteria) this;
        }

        public Criteria andDeCodeNotBetween(String value1, String value2) {
            addCriterion("de_code not between", value1, value2, "deCode");
            return (Criteria) this;
        }

        public Criteria andLimitMoneyIsNull() {
            addCriterion("limit_money is null");
            return (Criteria) this;
        }

        public Criteria andLimitMoneyIsNotNull() {
            addCriterion("limit_money is not null");
            return (Criteria) this;
        }

        public Criteria andLimitMoneyEqualTo(Integer value) {
            addCriterion("limit_money =", value, "limitMoney");
            return (Criteria) this;
        }

        public Criteria andLimitMoneyNotEqualTo(Integer value) {
            addCriterion("limit_money <>", value, "limitMoney");
            return (Criteria) this;
        }

        public Criteria andLimitMoneyGreaterThan(Integer value) {
            addCriterion("limit_money >", value, "limitMoney");
            return (Criteria) this;
        }

        public Criteria andLimitMoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("limit_money >=", value, "limitMoney");
            return (Criteria) this;
        }

        public Criteria andLimitMoneyLessThan(Integer value) {
            addCriterion("limit_money <", value, "limitMoney");
            return (Criteria) this;
        }

        public Criteria andLimitMoneyLessThanOrEqualTo(Integer value) {
            addCriterion("limit_money <=", value, "limitMoney");
            return (Criteria) this;
        }

        public Criteria andLimitMoneyIn(List<Integer> values) {
            addCriterion("limit_money in", values, "limitMoney");
            return (Criteria) this;
        }

        public Criteria andLimitMoneyNotIn(List<Integer> values) {
            addCriterion("limit_money not in", values, "limitMoney");
            return (Criteria) this;
        }

        public Criteria andLimitMoneyBetween(Integer value1, Integer value2) {
            addCriterion("limit_money between", value1, value2, "limitMoney");
            return (Criteria) this;
        }

        public Criteria andLimitMoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("limit_money not between", value1, value2, "limitMoney");
            return (Criteria) this;
        }

        public Criteria andAvailMoneyIsNull() {
            addCriterion("avail_money is null");
            return (Criteria) this;
        }

        public Criteria andAvailMoneyIsNotNull() {
            addCriterion("avail_money is not null");
            return (Criteria) this;
        }

        public Criteria andAvailMoneyEqualTo(Integer value) {
            addCriterion("avail_money =", value, "availMoney");
            return (Criteria) this;
        }

        public Criteria andAvailMoneyNotEqualTo(Integer value) {
            addCriterion("avail_money <>", value, "availMoney");
            return (Criteria) this;
        }

        public Criteria andAvailMoneyGreaterThan(Integer value) {
            addCriterion("avail_money >", value, "availMoney");
            return (Criteria) this;
        }

        public Criteria andAvailMoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("avail_money >=", value, "availMoney");
            return (Criteria) this;
        }

        public Criteria andAvailMoneyLessThan(Integer value) {
            addCriterion("avail_money <", value, "availMoney");
            return (Criteria) this;
        }

        public Criteria andAvailMoneyLessThanOrEqualTo(Integer value) {
            addCriterion("avail_money <=", value, "availMoney");
            return (Criteria) this;
        }

        public Criteria andAvailMoneyIn(List<Integer> values) {
            addCriterion("avail_money in", values, "availMoney");
            return (Criteria) this;
        }

        public Criteria andAvailMoneyNotIn(List<Integer> values) {
            addCriterion("avail_money not in", values, "availMoney");
            return (Criteria) this;
        }

        public Criteria andAvailMoneyBetween(Integer value1, Integer value2) {
            addCriterion("avail_money between", value1, value2, "availMoney");
            return (Criteria) this;
        }

        public Criteria andAvailMoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("avail_money not between", value1, value2, "availMoney");
            return (Criteria) this;
        }

        public Criteria andReInfo1IsNull() {
            addCriterion("re_info1 is null");
            return (Criteria) this;
        }

        public Criteria andReInfo1IsNotNull() {
            addCriterion("re_info1 is not null");
            return (Criteria) this;
        }

        public Criteria andReInfo1EqualTo(String value) {
            addCriterion("re_info1 =", value, "reInfo1");
            return (Criteria) this;
        }

        public Criteria andReInfo1NotEqualTo(String value) {
            addCriterion("re_info1 <>", value, "reInfo1");
            return (Criteria) this;
        }

        public Criteria andReInfo1GreaterThan(String value) {
            addCriterion("re_info1 >", value, "reInfo1");
            return (Criteria) this;
        }

        public Criteria andReInfo1GreaterThanOrEqualTo(String value) {
            addCriterion("re_info1 >=", value, "reInfo1");
            return (Criteria) this;
        }

        public Criteria andReInfo1LessThan(String value) {
            addCriterion("re_info1 <", value, "reInfo1");
            return (Criteria) this;
        }

        public Criteria andReInfo1LessThanOrEqualTo(String value) {
            addCriterion("re_info1 <=", value, "reInfo1");
            return (Criteria) this;
        }

        public Criteria andReInfo1Like(String value) {
            addCriterion("re_info1 like", value, "reInfo1");
            return (Criteria) this;
        }

        public Criteria andReInfo1NotLike(String value) {
            addCriterion("re_info1 not like", value, "reInfo1");
            return (Criteria) this;
        }

        public Criteria andReInfo1In(List<String> values) {
            addCriterion("re_info1 in", values, "reInfo1");
            return (Criteria) this;
        }

        public Criteria andReInfo1NotIn(List<String> values) {
            addCriterion("re_info1 not in", values, "reInfo1");
            return (Criteria) this;
        }

        public Criteria andReInfo1Between(String value1, String value2) {
            addCriterion("re_info1 between", value1, value2, "reInfo1");
            return (Criteria) this;
        }

        public Criteria andReInfo1NotBetween(String value1, String value2) {
            addCriterion("re_info1 not between", value1, value2, "reInfo1");
            return (Criteria) this;
        }

        public Criteria andReInfo2IsNull() {
            addCriterion("re_info2 is null");
            return (Criteria) this;
        }

        public Criteria andReInfo2IsNotNull() {
            addCriterion("re_info2 is not null");
            return (Criteria) this;
        }

        public Criteria andReInfo2EqualTo(String value) {
            addCriterion("re_info2 =", value, "reInfo2");
            return (Criteria) this;
        }

        public Criteria andReInfo2NotEqualTo(String value) {
            addCriterion("re_info2 <>", value, "reInfo2");
            return (Criteria) this;
        }

        public Criteria andReInfo2GreaterThan(String value) {
            addCriterion("re_info2 >", value, "reInfo2");
            return (Criteria) this;
        }

        public Criteria andReInfo2GreaterThanOrEqualTo(String value) {
            addCriterion("re_info2 >=", value, "reInfo2");
            return (Criteria) this;
        }

        public Criteria andReInfo2LessThan(String value) {
            addCriterion("re_info2 <", value, "reInfo2");
            return (Criteria) this;
        }

        public Criteria andReInfo2LessThanOrEqualTo(String value) {
            addCriterion("re_info2 <=", value, "reInfo2");
            return (Criteria) this;
        }

        public Criteria andReInfo2Like(String value) {
            addCriterion("re_info2 like", value, "reInfo2");
            return (Criteria) this;
        }

        public Criteria andReInfo2NotLike(String value) {
            addCriterion("re_info2 not like", value, "reInfo2");
            return (Criteria) this;
        }

        public Criteria andReInfo2In(List<String> values) {
            addCriterion("re_info2 in", values, "reInfo2");
            return (Criteria) this;
        }

        public Criteria andReInfo2NotIn(List<String> values) {
            addCriterion("re_info2 not in", values, "reInfo2");
            return (Criteria) this;
        }

        public Criteria andReInfo2Between(String value1, String value2) {
            addCriterion("re_info2 between", value1, value2, "reInfo2");
            return (Criteria) this;
        }

        public Criteria andReInfo2NotBetween(String value1, String value2) {
            addCriterion("re_info2 not between", value1, value2, "reInfo2");
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

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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