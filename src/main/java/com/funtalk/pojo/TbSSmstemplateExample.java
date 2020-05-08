package com.funtalk.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbSSmstemplateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbSSmstemplateExample() {
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

        public Criteria andTemIdIsNull() {
            addCriterion("tem_id is null");
            return (Criteria) this;
        }

        public Criteria andTemIdIsNotNull() {
            addCriterion("tem_id is not null");
            return (Criteria) this;
        }

        public Criteria andTemIdEqualTo(Integer value) {
            addCriterion("tem_id =", value, "temId");
            return (Criteria) this;
        }

        public Criteria andTemIdNotEqualTo(Integer value) {
            addCriterion("tem_id <>", value, "temId");
            return (Criteria) this;
        }

        public Criteria andTemIdGreaterThan(Integer value) {
            addCriterion("tem_id >", value, "temId");
            return (Criteria) this;
        }

        public Criteria andTemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("tem_id >=", value, "temId");
            return (Criteria) this;
        }

        public Criteria andTemIdLessThan(Integer value) {
            addCriterion("tem_id <", value, "temId");
            return (Criteria) this;
        }

        public Criteria andTemIdLessThanOrEqualTo(Integer value) {
            addCriterion("tem_id <=", value, "temId");
            return (Criteria) this;
        }

        public Criteria andTemIdIn(List<Integer> values) {
            addCriterion("tem_id in", values, "temId");
            return (Criteria) this;
        }

        public Criteria andTemIdNotIn(List<Integer> values) {
            addCriterion("tem_id not in", values, "temId");
            return (Criteria) this;
        }

        public Criteria andTemIdBetween(Integer value1, Integer value2) {
            addCriterion("tem_id between", value1, value2, "temId");
            return (Criteria) this;
        }

        public Criteria andTemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("tem_id not between", value1, value2, "temId");
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

        public Criteria andTemTypeIsNull() {
            addCriterion("tem_type is null");
            return (Criteria) this;
        }

        public Criteria andTemTypeIsNotNull() {
            addCriterion("tem_type is not null");
            return (Criteria) this;
        }

        public Criteria andTemTypeEqualTo(String value) {
            addCriterion("tem_type =", value, "temType");
            return (Criteria) this;
        }

        public Criteria andTemTypeNotEqualTo(String value) {
            addCriterion("tem_type <>", value, "temType");
            return (Criteria) this;
        }

        public Criteria andTemTypeGreaterThan(String value) {
            addCriterion("tem_type >", value, "temType");
            return (Criteria) this;
        }

        public Criteria andTemTypeGreaterThanOrEqualTo(String value) {
            addCriterion("tem_type >=", value, "temType");
            return (Criteria) this;
        }

        public Criteria andTemTypeLessThan(String value) {
            addCriterion("tem_type <", value, "temType");
            return (Criteria) this;
        }

        public Criteria andTemTypeLessThanOrEqualTo(String value) {
            addCriterion("tem_type <=", value, "temType");
            return (Criteria) this;
        }

        public Criteria andTemTypeLike(String value) {
            addCriterion("tem_type like", value, "temType");
            return (Criteria) this;
        }

        public Criteria andTemTypeNotLike(String value) {
            addCriterion("tem_type not like", value, "temType");
            return (Criteria) this;
        }

        public Criteria andTemTypeIn(List<String> values) {
            addCriterion("tem_type in", values, "temType");
            return (Criteria) this;
        }

        public Criteria andTemTypeNotIn(List<String> values) {
            addCriterion("tem_type not in", values, "temType");
            return (Criteria) this;
        }

        public Criteria andTemTypeBetween(String value1, String value2) {
            addCriterion("tem_type between", value1, value2, "temType");
            return (Criteria) this;
        }

        public Criteria andTemTypeNotBetween(String value1, String value2) {
            addCriterion("tem_type not between", value1, value2, "temType");
            return (Criteria) this;
        }

        public Criteria andTemContentIsNull() {
            addCriterion("tem_content is null");
            return (Criteria) this;
        }

        public Criteria andTemContentIsNotNull() {
            addCriterion("tem_content is not null");
            return (Criteria) this;
        }

        public Criteria andTemContentEqualTo(String value) {
            addCriterion("tem_content =", value, "temContent");
            return (Criteria) this;
        }

        public Criteria andTemContentNotEqualTo(String value) {
            addCriterion("tem_content <>", value, "temContent");
            return (Criteria) this;
        }

        public Criteria andTemContentGreaterThan(String value) {
            addCriterion("tem_content >", value, "temContent");
            return (Criteria) this;
        }

        public Criteria andTemContentGreaterThanOrEqualTo(String value) {
            addCriterion("tem_content >=", value, "temContent");
            return (Criteria) this;
        }

        public Criteria andTemContentLessThan(String value) {
            addCriterion("tem_content <", value, "temContent");
            return (Criteria) this;
        }

        public Criteria andTemContentLessThanOrEqualTo(String value) {
            addCriterion("tem_content <=", value, "temContent");
            return (Criteria) this;
        }

        public Criteria andTemContentLike(String value) {
            addCriterion("tem_content like", value, "temContent");
            return (Criteria) this;
        }

        public Criteria andTemContentNotLike(String value) {
            addCriterion("tem_content not like", value, "temContent");
            return (Criteria) this;
        }

        public Criteria andTemContentIn(List<String> values) {
            addCriterion("tem_content in", values, "temContent");
            return (Criteria) this;
        }

        public Criteria andTemContentNotIn(List<String> values) {
            addCriterion("tem_content not in", values, "temContent");
            return (Criteria) this;
        }

        public Criteria andTemContentBetween(String value1, String value2) {
            addCriterion("tem_content between", value1, value2, "temContent");
            return (Criteria) this;
        }

        public Criteria andTemContentNotBetween(String value1, String value2) {
            addCriterion("tem_content not between", value1, value2, "temContent");
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

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
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