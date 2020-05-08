package com.funtalk.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbPDealerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbPDealerExample() {
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

        public Criteria andDealerIdIsNull() {
            addCriterion("DEALER_ID is null");
            return (Criteria) this;
        }

        public Criteria andDealerIdIsNotNull() {
            addCriterion("DEALER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDealerIdEqualTo(Integer value) {
            addCriterion("DEALER_ID =", value, "dealerId");
            return (Criteria) this;
        }

        public Criteria andDealerIdNotEqualTo(Integer value) {
            addCriterion("DEALER_ID <>", value, "dealerId");
            return (Criteria) this;
        }

        public Criteria andDealerIdGreaterThan(Integer value) {
            addCriterion("DEALER_ID >", value, "dealerId");
            return (Criteria) this;
        }

        public Criteria andDealerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("DEALER_ID >=", value, "dealerId");
            return (Criteria) this;
        }

        public Criteria andDealerIdLessThan(Integer value) {
            addCriterion("DEALER_ID <", value, "dealerId");
            return (Criteria) this;
        }

        public Criteria andDealerIdLessThanOrEqualTo(Integer value) {
            addCriterion("DEALER_ID <=", value, "dealerId");
            return (Criteria) this;
        }

        public Criteria andDealerIdIn(List<Integer> values) {
            addCriterion("DEALER_ID in", values, "dealerId");
            return (Criteria) this;
        }

        public Criteria andDealerIdNotIn(List<Integer> values) {
            addCriterion("DEALER_ID not in", values, "dealerId");
            return (Criteria) this;
        }

        public Criteria andDealerIdBetween(Integer value1, Integer value2) {
            addCriterion("DEALER_ID between", value1, value2, "dealerId");
            return (Criteria) this;
        }

        public Criteria andDealerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("DEALER_ID not between", value1, value2, "dealerId");
            return (Criteria) this;
        }

        public Criteria andDealerNameIsNull() {
            addCriterion("DEALER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDealerNameIsNotNull() {
            addCriterion("DEALER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDealerNameEqualTo(String value) {
            addCriterion("DEALER_NAME =", value, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameNotEqualTo(String value) {
            addCriterion("DEALER_NAME <>", value, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameGreaterThan(String value) {
            addCriterion("DEALER_NAME >", value, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameGreaterThanOrEqualTo(String value) {
            addCriterion("DEALER_NAME >=", value, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameLessThan(String value) {
            addCriterion("DEALER_NAME <", value, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameLessThanOrEqualTo(String value) {
            addCriterion("DEALER_NAME <=", value, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameLike(String value) {
            addCriterion("DEALER_NAME like", value, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameNotLike(String value) {
            addCriterion("DEALER_NAME not like", value, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameIn(List<String> values) {
            addCriterion("DEALER_NAME in", values, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameNotIn(List<String> values) {
            addCriterion("DEALER_NAME not in", values, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameBetween(String value1, String value2) {
            addCriterion("DEALER_NAME between", value1, value2, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameNotBetween(String value1, String value2) {
            addCriterion("DEALER_NAME not between", value1, value2, "dealerName");
            return (Criteria) this;
        }

        public Criteria andCityCodeIsNull() {
            addCriterion("CITY_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCityCodeIsNotNull() {
            addCriterion("CITY_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCityCodeEqualTo(String value) {
            addCriterion("CITY_CODE =", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotEqualTo(String value) {
            addCriterion("CITY_CODE <>", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeGreaterThan(String value) {
            addCriterion("CITY_CODE >", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CITY_CODE >=", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLessThan(String value) {
            addCriterion("CITY_CODE <", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLessThanOrEqualTo(String value) {
            addCriterion("CITY_CODE <=", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLike(String value) {
            addCriterion("CITY_CODE like", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotLike(String value) {
            addCriterion("CITY_CODE not like", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeIn(List<String> values) {
            addCriterion("CITY_CODE in", values, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotIn(List<String> values) {
            addCriterion("CITY_CODE not in", values, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeBetween(String value1, String value2) {
            addCriterion("CITY_CODE between", value1, value2, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotBetween(String value1, String value2) {
            addCriterion("CITY_CODE not between", value1, value2, "cityCode");
            return (Criteria) this;
        }

        public Criteria andDealerTypeIsNull() {
            addCriterion("DEALER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andDealerTypeIsNotNull() {
            addCriterion("DEALER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andDealerTypeEqualTo(String value) {
            addCriterion("DEALER_TYPE =", value, "dealerType");
            return (Criteria) this;
        }

        public Criteria andDealerTypeNotEqualTo(String value) {
            addCriterion("DEALER_TYPE <>", value, "dealerType");
            return (Criteria) this;
        }

        public Criteria andDealerTypeGreaterThan(String value) {
            addCriterion("DEALER_TYPE >", value, "dealerType");
            return (Criteria) this;
        }

        public Criteria andDealerTypeGreaterThanOrEqualTo(String value) {
            addCriterion("DEALER_TYPE >=", value, "dealerType");
            return (Criteria) this;
        }

        public Criteria andDealerTypeLessThan(String value) {
            addCriterion("DEALER_TYPE <", value, "dealerType");
            return (Criteria) this;
        }

        public Criteria andDealerTypeLessThanOrEqualTo(String value) {
            addCriterion("DEALER_TYPE <=", value, "dealerType");
            return (Criteria) this;
        }

        public Criteria andDealerTypeLike(String value) {
            addCriterion("DEALER_TYPE like", value, "dealerType");
            return (Criteria) this;
        }

        public Criteria andDealerTypeNotLike(String value) {
            addCriterion("DEALER_TYPE not like", value, "dealerType");
            return (Criteria) this;
        }

        public Criteria andDealerTypeIn(List<String> values) {
            addCriterion("DEALER_TYPE in", values, "dealerType");
            return (Criteria) this;
        }

        public Criteria andDealerTypeNotIn(List<String> values) {
            addCriterion("DEALER_TYPE not in", values, "dealerType");
            return (Criteria) this;
        }

        public Criteria andDealerTypeBetween(String value1, String value2) {
            addCriterion("DEALER_TYPE between", value1, value2, "dealerType");
            return (Criteria) this;
        }

        public Criteria andDealerTypeNotBetween(String value1, String value2) {
            addCriterion("DEALER_TYPE not between", value1, value2, "dealerType");
            return (Criteria) this;
        }

        public Criteria andIdCodeIsNull() {
            addCriterion("ID_CODE is null");
            return (Criteria) this;
        }

        public Criteria andIdCodeIsNotNull() {
            addCriterion("ID_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andIdCodeEqualTo(String value) {
            addCriterion("ID_CODE =", value, "idCode");
            return (Criteria) this;
        }

        public Criteria andIdCodeNotEqualTo(String value) {
            addCriterion("ID_CODE <>", value, "idCode");
            return (Criteria) this;
        }

        public Criteria andIdCodeGreaterThan(String value) {
            addCriterion("ID_CODE >", value, "idCode");
            return (Criteria) this;
        }

        public Criteria andIdCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ID_CODE >=", value, "idCode");
            return (Criteria) this;
        }

        public Criteria andIdCodeLessThan(String value) {
            addCriterion("ID_CODE <", value, "idCode");
            return (Criteria) this;
        }

        public Criteria andIdCodeLessThanOrEqualTo(String value) {
            addCriterion("ID_CODE <=", value, "idCode");
            return (Criteria) this;
        }

        public Criteria andIdCodeLike(String value) {
            addCriterion("ID_CODE like", value, "idCode");
            return (Criteria) this;
        }

        public Criteria andIdCodeNotLike(String value) {
            addCriterion("ID_CODE not like", value, "idCode");
            return (Criteria) this;
        }

        public Criteria andIdCodeIn(List<String> values) {
            addCriterion("ID_CODE in", values, "idCode");
            return (Criteria) this;
        }

        public Criteria andIdCodeNotIn(List<String> values) {
            addCriterion("ID_CODE not in", values, "idCode");
            return (Criteria) this;
        }

        public Criteria andIdCodeBetween(String value1, String value2) {
            addCriterion("ID_CODE between", value1, value2, "idCode");
            return (Criteria) this;
        }

        public Criteria andIdCodeNotBetween(String value1, String value2) {
            addCriterion("ID_CODE not between", value1, value2, "idCode");
            return (Criteria) this;
        }

        public Criteria andIdAddressIsNull() {
            addCriterion("ID_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andIdAddressIsNotNull() {
            addCriterion("ID_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andIdAddressEqualTo(String value) {
            addCriterion("ID_ADDRESS =", value, "idAddress");
            return (Criteria) this;
        }

        public Criteria andIdAddressNotEqualTo(String value) {
            addCriterion("ID_ADDRESS <>", value, "idAddress");
            return (Criteria) this;
        }

        public Criteria andIdAddressGreaterThan(String value) {
            addCriterion("ID_ADDRESS >", value, "idAddress");
            return (Criteria) this;
        }

        public Criteria andIdAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ID_ADDRESS >=", value, "idAddress");
            return (Criteria) this;
        }

        public Criteria andIdAddressLessThan(String value) {
            addCriterion("ID_ADDRESS <", value, "idAddress");
            return (Criteria) this;
        }

        public Criteria andIdAddressLessThanOrEqualTo(String value) {
            addCriterion("ID_ADDRESS <=", value, "idAddress");
            return (Criteria) this;
        }

        public Criteria andIdAddressLike(String value) {
            addCriterion("ID_ADDRESS like", value, "idAddress");
            return (Criteria) this;
        }

        public Criteria andIdAddressNotLike(String value) {
            addCriterion("ID_ADDRESS not like", value, "idAddress");
            return (Criteria) this;
        }

        public Criteria andIdAddressIn(List<String> values) {
            addCriterion("ID_ADDRESS in", values, "idAddress");
            return (Criteria) this;
        }

        public Criteria andIdAddressNotIn(List<String> values) {
            addCriterion("ID_ADDRESS not in", values, "idAddress");
            return (Criteria) this;
        }

        public Criteria andIdAddressBetween(String value1, String value2) {
            addCriterion("ID_ADDRESS between", value1, value2, "idAddress");
            return (Criteria) this;
        }

        public Criteria andIdAddressNotBetween(String value1, String value2) {
            addCriterion("ID_ADDRESS not between", value1, value2, "idAddress");
            return (Criteria) this;
        }

        public Criteria andCreateWorknoIsNull() {
            addCriterion("CREATE_WORKNO is null");
            return (Criteria) this;
        }

        public Criteria andCreateWorknoIsNotNull() {
            addCriterion("CREATE_WORKNO is not null");
            return (Criteria) this;
        }

        public Criteria andCreateWorknoEqualTo(String value) {
            addCriterion("CREATE_WORKNO =", value, "createWorkno");
            return (Criteria) this;
        }

        public Criteria andCreateWorknoNotEqualTo(String value) {
            addCriterion("CREATE_WORKNO <>", value, "createWorkno");
            return (Criteria) this;
        }

        public Criteria andCreateWorknoGreaterThan(String value) {
            addCriterion("CREATE_WORKNO >", value, "createWorkno");
            return (Criteria) this;
        }

        public Criteria andCreateWorknoGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_WORKNO >=", value, "createWorkno");
            return (Criteria) this;
        }

        public Criteria andCreateWorknoLessThan(String value) {
            addCriterion("CREATE_WORKNO <", value, "createWorkno");
            return (Criteria) this;
        }

        public Criteria andCreateWorknoLessThanOrEqualTo(String value) {
            addCriterion("CREATE_WORKNO <=", value, "createWorkno");
            return (Criteria) this;
        }

        public Criteria andCreateWorknoLike(String value) {
            addCriterion("CREATE_WORKNO like", value, "createWorkno");
            return (Criteria) this;
        }

        public Criteria andCreateWorknoNotLike(String value) {
            addCriterion("CREATE_WORKNO not like", value, "createWorkno");
            return (Criteria) this;
        }

        public Criteria andCreateWorknoIn(List<String> values) {
            addCriterion("CREATE_WORKNO in", values, "createWorkno");
            return (Criteria) this;
        }

        public Criteria andCreateWorknoNotIn(List<String> values) {
            addCriterion("CREATE_WORKNO not in", values, "createWorkno");
            return (Criteria) this;
        }

        public Criteria andCreateWorknoBetween(String value1, String value2) {
            addCriterion("CREATE_WORKNO between", value1, value2, "createWorkno");
            return (Criteria) this;
        }

        public Criteria andCreateWorknoNotBetween(String value1, String value2) {
            addCriterion("CREATE_WORKNO not between", value1, value2, "createWorkno");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIsNull() {
            addCriterion("CONTACT_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIsNotNull() {
            addCriterion("CONTACT_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andContactPhoneEqualTo(String value) {
            addCriterion("CONTACT_PHONE =", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotEqualTo(String value) {
            addCriterion("CONTACT_PHONE <>", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneGreaterThan(String value) {
            addCriterion("CONTACT_PHONE >", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("CONTACT_PHONE >=", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLessThan(String value) {
            addCriterion("CONTACT_PHONE <", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLessThanOrEqualTo(String value) {
            addCriterion("CONTACT_PHONE <=", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLike(String value) {
            addCriterion("CONTACT_PHONE like", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotLike(String value) {
            addCriterion("CONTACT_PHONE not like", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIn(List<String> values) {
            addCriterion("CONTACT_PHONE in", values, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotIn(List<String> values) {
            addCriterion("CONTACT_PHONE not in", values, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneBetween(String value1, String value2) {
            addCriterion("CONTACT_PHONE between", value1, value2, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotBetween(String value1, String value2) {
            addCriterion("CONTACT_PHONE not between", value1, value2, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("CREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("CREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("CREATE_DATE =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("CREATE_DATE <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("CREATE_DATE >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("CREATE_DATE <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("CREATE_DATE in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("CREATE_DATE not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andIfValidIsNull() {
            addCriterion("IF_VALID is null");
            return (Criteria) this;
        }

        public Criteria andIfValidIsNotNull() {
            addCriterion("IF_VALID is not null");
            return (Criteria) this;
        }

        public Criteria andIfValidEqualTo(String value) {
            addCriterion("IF_VALID =", value, "ifValid");
            return (Criteria) this;
        }

        public Criteria andIfValidNotEqualTo(String value) {
            addCriterion("IF_VALID <>", value, "ifValid");
            return (Criteria) this;
        }

        public Criteria andIfValidGreaterThan(String value) {
            addCriterion("IF_VALID >", value, "ifValid");
            return (Criteria) this;
        }

        public Criteria andIfValidGreaterThanOrEqualTo(String value) {
            addCriterion("IF_VALID >=", value, "ifValid");
            return (Criteria) this;
        }

        public Criteria andIfValidLessThan(String value) {
            addCriterion("IF_VALID <", value, "ifValid");
            return (Criteria) this;
        }

        public Criteria andIfValidLessThanOrEqualTo(String value) {
            addCriterion("IF_VALID <=", value, "ifValid");
            return (Criteria) this;
        }

        public Criteria andIfValidLike(String value) {
            addCriterion("IF_VALID like", value, "ifValid");
            return (Criteria) this;
        }

        public Criteria andIfValidNotLike(String value) {
            addCriterion("IF_VALID not like", value, "ifValid");
            return (Criteria) this;
        }

        public Criteria andIfValidIn(List<String> values) {
            addCriterion("IF_VALID in", values, "ifValid");
            return (Criteria) this;
        }

        public Criteria andIfValidNotIn(List<String> values) {
            addCriterion("IF_VALID not in", values, "ifValid");
            return (Criteria) this;
        }

        public Criteria andIfValidBetween(String value1, String value2) {
            addCriterion("IF_VALID between", value1, value2, "ifValid");
            return (Criteria) this;
        }

        public Criteria andIfValidNotBetween(String value1, String value2) {
            addCriterion("IF_VALID not between", value1, value2, "ifValid");
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