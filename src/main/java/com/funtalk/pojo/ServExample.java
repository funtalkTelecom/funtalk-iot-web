package com.funtalk.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ServExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ServExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andServIdIsNull() {
            addCriterion("SERV_ID is null");
            return (Criteria) this;
        }

        public Criteria andServIdIsNotNull() {
            addCriterion("SERV_ID is not null");
            return (Criteria) this;
        }

        public Criteria andServIdEqualTo(Long value) {
            addCriterion("SERV_ID =", value, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdNotEqualTo(Long value) {
            addCriterion("SERV_ID <>", value, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdGreaterThan(Long value) {
            addCriterion("SERV_ID >", value, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdGreaterThanOrEqualTo(Long value) {
            addCriterion("SERV_ID >=", value, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdLessThan(Long value) {
            addCriterion("SERV_ID <", value, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdLessThanOrEqualTo(Long value) {
            addCriterion("SERV_ID <=", value, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdIn(List<Long> values) {
            addCriterion("SERV_ID in", values, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdNotIn(List<Long> values) {
            addCriterion("SERV_ID not in", values, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdBetween(Long value1, Long value2) {
            addCriterion("SERV_ID between", value1, value2, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdNotBetween(Long value1, Long value2) {
            addCriterion("SERV_ID not between", value1, value2, "servId");
            return (Criteria) this;
        }

        public Criteria andAgreementIdIsNull() {
            addCriterion("AGREEMENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andAgreementIdIsNotNull() {
            addCriterion("AGREEMENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAgreementIdEqualTo(BigDecimal value) {
            addCriterion("AGREEMENT_ID =", value, "agreementId");
            return (Criteria) this;
        }

        public Criteria andAgreementIdNotEqualTo(BigDecimal value) {
            addCriterion("AGREEMENT_ID <>", value, "agreementId");
            return (Criteria) this;
        }

        public Criteria andAgreementIdGreaterThan(BigDecimal value) {
            addCriterion("AGREEMENT_ID >", value, "agreementId");
            return (Criteria) this;
        }

        public Criteria andAgreementIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AGREEMENT_ID >=", value, "agreementId");
            return (Criteria) this;
        }

        public Criteria andAgreementIdLessThan(BigDecimal value) {
            addCriterion("AGREEMENT_ID <", value, "agreementId");
            return (Criteria) this;
        }

        public Criteria andAgreementIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AGREEMENT_ID <=", value, "agreementId");
            return (Criteria) this;
        }

        public Criteria andAgreementIdIn(List<BigDecimal> values) {
            addCriterion("AGREEMENT_ID in", values, "agreementId");
            return (Criteria) this;
        }

        public Criteria andAgreementIdNotIn(List<BigDecimal> values) {
            addCriterion("AGREEMENT_ID not in", values, "agreementId");
            return (Criteria) this;
        }

        public Criteria andAgreementIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AGREEMENT_ID between", value1, value2, "agreementId");
            return (Criteria) this;
        }

        public Criteria andAgreementIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AGREEMENT_ID not between", value1, value2, "agreementId");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNull() {
            addCriterion("CUST_ID is null");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNotNull() {
            addCriterion("CUST_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCustIdEqualTo(Long value) {
            addCriterion("CUST_ID =", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotEqualTo(Long value) {
            addCriterion("CUST_ID <>", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThan(Long value) {
            addCriterion("CUST_ID >", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThanOrEqualTo(Long value) {
            addCriterion("CUST_ID >=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThan(Long value) {
            addCriterion("CUST_ID <", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThanOrEqualTo(Long value) {
            addCriterion("CUST_ID <=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdIn(List<Long> values) {
            addCriterion("CUST_ID in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotIn(List<Long> values) {
            addCriterion("CUST_ID not in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdBetween(Long value1, Long value2) {
            addCriterion("CUST_ID between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotBetween(Long value1, Long value2) {
            addCriterion("CUST_ID not between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("PRODUCT_ID is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("PRODUCT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Integer value) {
            addCriterion("PRODUCT_ID =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Integer value) {
            addCriterion("PRODUCT_ID <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Integer value) {
            addCriterion("PRODUCT_ID >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PRODUCT_ID >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Integer value) {
            addCriterion("PRODUCT_ID <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Integer value) {
            addCriterion("PRODUCT_ID <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Integer> values) {
            addCriterion("PRODUCT_ID in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Integer> values) {
            addCriterion("PRODUCT_ID not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Integer value1, Integer value2) {
            addCriterion("PRODUCT_ID between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PRODUCT_ID not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andBillingCycleTypeIdIsNull() {
            addCriterion("BILLING_CYCLE_TYPE_ID is null");
            return (Criteria) this;
        }

        public Criteria andBillingCycleTypeIdIsNotNull() {
            addCriterion("BILLING_CYCLE_TYPE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBillingCycleTypeIdEqualTo(Integer value) {
            addCriterion("BILLING_CYCLE_TYPE_ID =", value, "billingCycleTypeId");
            return (Criteria) this;
        }

        public Criteria andBillingCycleTypeIdNotEqualTo(Integer value) {
            addCriterion("BILLING_CYCLE_TYPE_ID <>", value, "billingCycleTypeId");
            return (Criteria) this;
        }

        public Criteria andBillingCycleTypeIdGreaterThan(Integer value) {
            addCriterion("BILLING_CYCLE_TYPE_ID >", value, "billingCycleTypeId");
            return (Criteria) this;
        }

        public Criteria andBillingCycleTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("BILLING_CYCLE_TYPE_ID >=", value, "billingCycleTypeId");
            return (Criteria) this;
        }

        public Criteria andBillingCycleTypeIdLessThan(Integer value) {
            addCriterion("BILLING_CYCLE_TYPE_ID <", value, "billingCycleTypeId");
            return (Criteria) this;
        }

        public Criteria andBillingCycleTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("BILLING_CYCLE_TYPE_ID <=", value, "billingCycleTypeId");
            return (Criteria) this;
        }

        public Criteria andBillingCycleTypeIdIn(List<Integer> values) {
            addCriterion("BILLING_CYCLE_TYPE_ID in", values, "billingCycleTypeId");
            return (Criteria) this;
        }

        public Criteria andBillingCycleTypeIdNotIn(List<Integer> values) {
            addCriterion("BILLING_CYCLE_TYPE_ID not in", values, "billingCycleTypeId");
            return (Criteria) this;
        }

        public Criteria andBillingCycleTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("BILLING_CYCLE_TYPE_ID between", value1, value2, "billingCycleTypeId");
            return (Criteria) this;
        }

        public Criteria andBillingCycleTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("BILLING_CYCLE_TYPE_ID not between", value1, value2, "billingCycleTypeId");
            return (Criteria) this;
        }

        public Criteria andProductFamilyIdIsNull() {
            addCriterion("PRODUCT_FAMILY_ID is null");
            return (Criteria) this;
        }

        public Criteria andProductFamilyIdIsNotNull() {
            addCriterion("PRODUCT_FAMILY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProductFamilyIdEqualTo(Integer value) {
            addCriterion("PRODUCT_FAMILY_ID =", value, "productFamilyId");
            return (Criteria) this;
        }

        public Criteria andProductFamilyIdNotEqualTo(Integer value) {
            addCriterion("PRODUCT_FAMILY_ID <>", value, "productFamilyId");
            return (Criteria) this;
        }

        public Criteria andProductFamilyIdGreaterThan(Integer value) {
            addCriterion("PRODUCT_FAMILY_ID >", value, "productFamilyId");
            return (Criteria) this;
        }

        public Criteria andProductFamilyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PRODUCT_FAMILY_ID >=", value, "productFamilyId");
            return (Criteria) this;
        }

        public Criteria andProductFamilyIdLessThan(Integer value) {
            addCriterion("PRODUCT_FAMILY_ID <", value, "productFamilyId");
            return (Criteria) this;
        }

        public Criteria andProductFamilyIdLessThanOrEqualTo(Integer value) {
            addCriterion("PRODUCT_FAMILY_ID <=", value, "productFamilyId");
            return (Criteria) this;
        }

        public Criteria andProductFamilyIdIn(List<Integer> values) {
            addCriterion("PRODUCT_FAMILY_ID in", values, "productFamilyId");
            return (Criteria) this;
        }

        public Criteria andProductFamilyIdNotIn(List<Integer> values) {
            addCriterion("PRODUCT_FAMILY_ID not in", values, "productFamilyId");
            return (Criteria) this;
        }

        public Criteria andProductFamilyIdBetween(Integer value1, Integer value2) {
            addCriterion("PRODUCT_FAMILY_ID between", value1, value2, "productFamilyId");
            return (Criteria) this;
        }

        public Criteria andProductFamilyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PRODUCT_FAMILY_ID not between", value1, value2, "productFamilyId");
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
            addCriterionForJDBCDate("CREATE_DATE =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_DATE <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("CREATE_DATE >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_DATE >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterionForJDBCDate("CREATE_DATE <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_DATE <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterionForJDBCDate("CREATE_DATE in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("CREATE_DATE not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATE_DATE between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATE_DATE not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andRentDateIsNull() {
            addCriterion("RENT_DATE is null");
            return (Criteria) this;
        }

        public Criteria andRentDateIsNotNull() {
            addCriterion("RENT_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andRentDateEqualTo(Date value) {
            addCriterionForJDBCDate("RENT_DATE =", value, "rentDate");
            return (Criteria) this;
        }

        public Criteria andRentDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("RENT_DATE <>", value, "rentDate");
            return (Criteria) this;
        }

        public Criteria andRentDateGreaterThan(Date value) {
            addCriterionForJDBCDate("RENT_DATE >", value, "rentDate");
            return (Criteria) this;
        }

        public Criteria andRentDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("RENT_DATE >=", value, "rentDate");
            return (Criteria) this;
        }

        public Criteria andRentDateLessThan(Date value) {
            addCriterionForJDBCDate("RENT_DATE <", value, "rentDate");
            return (Criteria) this;
        }

        public Criteria andRentDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("RENT_DATE <=", value, "rentDate");
            return (Criteria) this;
        }

        public Criteria andRentDateIn(List<Date> values) {
            addCriterionForJDBCDate("RENT_DATE in", values, "rentDate");
            return (Criteria) this;
        }

        public Criteria andRentDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("RENT_DATE not in", values, "rentDate");
            return (Criteria) this;
        }

        public Criteria andRentDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("RENT_DATE between", value1, value2, "rentDate");
            return (Criteria) this;
        }

        public Criteria andRentDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("RENT_DATE not between", value1, value2, "rentDate");
            return (Criteria) this;
        }

        public Criteria andCompletedDateIsNull() {
            addCriterion("COMPLETED_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCompletedDateIsNotNull() {
            addCriterion("COMPLETED_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCompletedDateEqualTo(Date value) {
            addCriterionForJDBCDate("COMPLETED_DATE =", value, "completedDate");
            return (Criteria) this;
        }

        public Criteria andCompletedDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("COMPLETED_DATE <>", value, "completedDate");
            return (Criteria) this;
        }

        public Criteria andCompletedDateGreaterThan(Date value) {
            addCriterionForJDBCDate("COMPLETED_DATE >", value, "completedDate");
            return (Criteria) this;
        }

        public Criteria andCompletedDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("COMPLETED_DATE >=", value, "completedDate");
            return (Criteria) this;
        }

        public Criteria andCompletedDateLessThan(Date value) {
            addCriterionForJDBCDate("COMPLETED_DATE <", value, "completedDate");
            return (Criteria) this;
        }

        public Criteria andCompletedDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("COMPLETED_DATE <=", value, "completedDate");
            return (Criteria) this;
        }

        public Criteria andCompletedDateIn(List<Date> values) {
            addCriterionForJDBCDate("COMPLETED_DATE in", values, "completedDate");
            return (Criteria) this;
        }

        public Criteria andCompletedDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("COMPLETED_DATE not in", values, "completedDate");
            return (Criteria) this;
        }

        public Criteria andCompletedDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("COMPLETED_DATE between", value1, value2, "completedDate");
            return (Criteria) this;
        }

        public Criteria andCompletedDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("COMPLETED_DATE not between", value1, value2, "completedDate");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("STATE like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("STATE not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateDateIsNull() {
            addCriterion("STATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andStateDateIsNotNull() {
            addCriterion("STATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateDateEqualTo(Date value) {
            addCriterionForJDBCDate("STATE_DATE =", value, "stateDate");
            return (Criteria) this;
        }

        public Criteria andStateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("STATE_DATE <>", value, "stateDate");
            return (Criteria) this;
        }

        public Criteria andStateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("STATE_DATE >", value, "stateDate");
            return (Criteria) this;
        }

        public Criteria andStateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("STATE_DATE >=", value, "stateDate");
            return (Criteria) this;
        }

        public Criteria andStateDateLessThan(Date value) {
            addCriterionForJDBCDate("STATE_DATE <", value, "stateDate");
            return (Criteria) this;
        }

        public Criteria andStateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("STATE_DATE <=", value, "stateDate");
            return (Criteria) this;
        }

        public Criteria andStateDateIn(List<Date> values) {
            addCriterionForJDBCDate("STATE_DATE in", values, "stateDate");
            return (Criteria) this;
        }

        public Criteria andStateDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("STATE_DATE not in", values, "stateDate");
            return (Criteria) this;
        }

        public Criteria andStateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("STATE_DATE between", value1, value2, "stateDate");
            return (Criteria) this;
        }

        public Criteria andStateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("STATE_DATE not between", value1, value2, "stateDate");
            return (Criteria) this;
        }

        public Criteria andRegionCodeIsNull() {
            addCriterion("REGION_CODE is null");
            return (Criteria) this;
        }

        public Criteria andRegionCodeIsNotNull() {
            addCriterion("REGION_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andRegionCodeEqualTo(String value) {
            addCriterion("REGION_CODE =", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeNotEqualTo(String value) {
            addCriterion("REGION_CODE <>", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeGreaterThan(String value) {
            addCriterion("REGION_CODE >", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeGreaterThanOrEqualTo(String value) {
            addCriterion("REGION_CODE >=", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeLessThan(String value) {
            addCriterion("REGION_CODE <", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeLessThanOrEqualTo(String value) {
            addCriterion("REGION_CODE <=", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeLike(String value) {
            addCriterion("REGION_CODE like", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeNotLike(String value) {
            addCriterion("REGION_CODE not like", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeIn(List<String> values) {
            addCriterion("REGION_CODE in", values, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeNotIn(List<String> values) {
            addCriterion("REGION_CODE not in", values, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeBetween(String value1, String value2) {
            addCriterion("REGION_CODE between", value1, value2, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeNotBetween(String value1, String value2) {
            addCriterion("REGION_CODE not between", value1, value2, "regionCode");
            return (Criteria) this;
        }

        public Criteria andBelongCodeIsNull() {
            addCriterion("BELONG_CODE is null");
            return (Criteria) this;
        }

        public Criteria andBelongCodeIsNotNull() {
            addCriterion("BELONG_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andBelongCodeEqualTo(String value) {
            addCriterion("BELONG_CODE =", value, "belongCode");
            return (Criteria) this;
        }

        public Criteria andBelongCodeNotEqualTo(String value) {
            addCriterion("BELONG_CODE <>", value, "belongCode");
            return (Criteria) this;
        }

        public Criteria andBelongCodeGreaterThan(String value) {
            addCriterion("BELONG_CODE >", value, "belongCode");
            return (Criteria) this;
        }

        public Criteria andBelongCodeGreaterThanOrEqualTo(String value) {
            addCriterion("BELONG_CODE >=", value, "belongCode");
            return (Criteria) this;
        }

        public Criteria andBelongCodeLessThan(String value) {
            addCriterion("BELONG_CODE <", value, "belongCode");
            return (Criteria) this;
        }

        public Criteria andBelongCodeLessThanOrEqualTo(String value) {
            addCriterion("BELONG_CODE <=", value, "belongCode");
            return (Criteria) this;
        }

        public Criteria andBelongCodeLike(String value) {
            addCriterion("BELONG_CODE like", value, "belongCode");
            return (Criteria) this;
        }

        public Criteria andBelongCodeNotLike(String value) {
            addCriterion("BELONG_CODE not like", value, "belongCode");
            return (Criteria) this;
        }

        public Criteria andBelongCodeIn(List<String> values) {
            addCriterion("BELONG_CODE in", values, "belongCode");
            return (Criteria) this;
        }

        public Criteria andBelongCodeNotIn(List<String> values) {
            addCriterion("BELONG_CODE not in", values, "belongCode");
            return (Criteria) this;
        }

        public Criteria andBelongCodeBetween(String value1, String value2) {
            addCriterion("BELONG_CODE between", value1, value2, "belongCode");
            return (Criteria) this;
        }

        public Criteria andBelongCodeNotBetween(String value1, String value2) {
            addCriterion("BELONG_CODE not between", value1, value2, "belongCode");
            return (Criteria) this;
        }

        public Criteria andAccNbrIsNull() {
            addCriterion("ACC_NBR is null");
            return (Criteria) this;
        }

        public Criteria andAccNbrIsNotNull() {
            addCriterion("ACC_NBR is not null");
            return (Criteria) this;
        }

        public Criteria andAccNbrEqualTo(String value) {
            addCriterion("ACC_NBR =", value, "accNbr");
            return (Criteria) this;
        }

        public Criteria andAccNbrNotEqualTo(String value) {
            addCriterion("ACC_NBR <>", value, "accNbr");
            return (Criteria) this;
        }

        public Criteria andAccNbrGreaterThan(String value) {
            addCriterion("ACC_NBR >", value, "accNbr");
            return (Criteria) this;
        }

        public Criteria andAccNbrGreaterThanOrEqualTo(String value) {
            addCriterion("ACC_NBR >=", value, "accNbr");
            return (Criteria) this;
        }

        public Criteria andAccNbrLessThan(String value) {
            addCriterion("ACC_NBR <", value, "accNbr");
            return (Criteria) this;
        }

        public Criteria andAccNbrLessThanOrEqualTo(String value) {
            addCriterion("ACC_NBR <=", value, "accNbr");
            return (Criteria) this;
        }

        public Criteria andAccNbrLike(String value) {
            addCriterion("ACC_NBR like", value, "accNbr");
            return (Criteria) this;
        }

        public Criteria andAccNbrNotLike(String value) {
            addCriterion("ACC_NBR not like", value, "accNbr");
            return (Criteria) this;
        }

        public Criteria andAccNbrIn(List<String> values) {
            addCriterion("ACC_NBR in", values, "accNbr");
            return (Criteria) this;
        }

        public Criteria andAccNbrNotIn(List<String> values) {
            addCriterion("ACC_NBR not in", values, "accNbr");
            return (Criteria) this;
        }

        public Criteria andAccNbrBetween(String value1, String value2) {
            addCriterion("ACC_NBR between", value1, value2, "accNbr");
            return (Criteria) this;
        }

        public Criteria andAccNbrNotBetween(String value1, String value2) {
            addCriterion("ACC_NBR not between", value1, value2, "accNbr");
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

        public Criteria andIfValidEqualTo(Short value) {
            addCriterion("IF_VALID =", value, "ifValid");
            return (Criteria) this;
        }

        public Criteria andIfValidNotEqualTo(Short value) {
            addCriterion("IF_VALID <>", value, "ifValid");
            return (Criteria) this;
        }

        public Criteria andIfValidGreaterThan(Short value) {
            addCriterion("IF_VALID >", value, "ifValid");
            return (Criteria) this;
        }

        public Criteria andIfValidGreaterThanOrEqualTo(Short value) {
            addCriterion("IF_VALID >=", value, "ifValid");
            return (Criteria) this;
        }

        public Criteria andIfValidLessThan(Short value) {
            addCriterion("IF_VALID <", value, "ifValid");
            return (Criteria) this;
        }

        public Criteria andIfValidLessThanOrEqualTo(Short value) {
            addCriterion("IF_VALID <=", value, "ifValid");
            return (Criteria) this;
        }

        public Criteria andIfValidIn(List<Short> values) {
            addCriterion("IF_VALID in", values, "ifValid");
            return (Criteria) this;
        }

        public Criteria andIfValidNotIn(List<Short> values) {
            addCriterion("IF_VALID not in", values, "ifValid");
            return (Criteria) this;
        }

        public Criteria andIfValidBetween(Short value1, Short value2) {
            addCriterion("IF_VALID between", value1, value2, "ifValid");
            return (Criteria) this;
        }

        public Criteria andIfValidNotBetween(Short value1, Short value2) {
            addCriterion("IF_VALID not between", value1, value2, "ifValid");
            return (Criteria) this;
        }

        public Criteria andServiceKindIsNull() {
            addCriterion("SERVICE_KIND is null");
            return (Criteria) this;
        }

        public Criteria andServiceKindIsNotNull() {
            addCriterion("SERVICE_KIND is not null");
            return (Criteria) this;
        }

        public Criteria andServiceKindEqualTo(Short value) {
            addCriterion("SERVICE_KIND =", value, "serviceKind");
            return (Criteria) this;
        }

        public Criteria andServiceKindNotEqualTo(Short value) {
            addCriterion("SERVICE_KIND <>", value, "serviceKind");
            return (Criteria) this;
        }

        public Criteria andServiceKindGreaterThan(Short value) {
            addCriterion("SERVICE_KIND >", value, "serviceKind");
            return (Criteria) this;
        }

        public Criteria andServiceKindGreaterThanOrEqualTo(Short value) {
            addCriterion("SERVICE_KIND >=", value, "serviceKind");
            return (Criteria) this;
        }

        public Criteria andServiceKindLessThan(Short value) {
            addCriterion("SERVICE_KIND <", value, "serviceKind");
            return (Criteria) this;
        }

        public Criteria andServiceKindLessThanOrEqualTo(Short value) {
            addCriterion("SERVICE_KIND <=", value, "serviceKind");
            return (Criteria) this;
        }

        public Criteria andServiceKindIn(List<Short> values) {
            addCriterion("SERVICE_KIND in", values, "serviceKind");
            return (Criteria) this;
        }

        public Criteria andServiceKindNotIn(List<Short> values) {
            addCriterion("SERVICE_KIND not in", values, "serviceKind");
            return (Criteria) this;
        }

        public Criteria andServiceKindBetween(Short value1, Short value2) {
            addCriterion("SERVICE_KIND between", value1, value2, "serviceKind");
            return (Criteria) this;
        }

        public Criteria andServiceKindNotBetween(Short value1, Short value2) {
            addCriterion("SERVICE_KIND not between", value1, value2, "serviceKind");
            return (Criteria) this;
        }

        public Criteria andInnetMethodIsNull() {
            addCriterion("INNET_METHOD is null");
            return (Criteria) this;
        }

        public Criteria andInnetMethodIsNotNull() {
            addCriterion("INNET_METHOD is not null");
            return (Criteria) this;
        }

        public Criteria andInnetMethodEqualTo(Short value) {
            addCriterion("INNET_METHOD =", value, "innetMethod");
            return (Criteria) this;
        }

        public Criteria andInnetMethodNotEqualTo(Short value) {
            addCriterion("INNET_METHOD <>", value, "innetMethod");
            return (Criteria) this;
        }

        public Criteria andInnetMethodGreaterThan(Short value) {
            addCriterion("INNET_METHOD >", value, "innetMethod");
            return (Criteria) this;
        }

        public Criteria andInnetMethodGreaterThanOrEqualTo(Short value) {
            addCriterion("INNET_METHOD >=", value, "innetMethod");
            return (Criteria) this;
        }

        public Criteria andInnetMethodLessThan(Short value) {
            addCriterion("INNET_METHOD <", value, "innetMethod");
            return (Criteria) this;
        }

        public Criteria andInnetMethodLessThanOrEqualTo(Short value) {
            addCriterion("INNET_METHOD <=", value, "innetMethod");
            return (Criteria) this;
        }

        public Criteria andInnetMethodIn(List<Short> values) {
            addCriterion("INNET_METHOD in", values, "innetMethod");
            return (Criteria) this;
        }

        public Criteria andInnetMethodNotIn(List<Short> values) {
            addCriterion("INNET_METHOD not in", values, "innetMethod");
            return (Criteria) this;
        }

        public Criteria andInnetMethodBetween(Short value1, Short value2) {
            addCriterion("INNET_METHOD between", value1, value2, "innetMethod");
            return (Criteria) this;
        }

        public Criteria andInnetMethodNotBetween(Short value1, Short value2) {
            addCriterion("INNET_METHOD not between", value1, value2, "innetMethod");
            return (Criteria) this;
        }

        public Criteria andBillingModeIsNull() {
            addCriterion("BILLING_MODE is null");
            return (Criteria) this;
        }

        public Criteria andBillingModeIsNotNull() {
            addCriterion("BILLING_MODE is not null");
            return (Criteria) this;
        }

        public Criteria andBillingModeEqualTo(String value) {
            addCriterion("BILLING_MODE =", value, "billingMode");
            return (Criteria) this;
        }

        public Criteria andBillingModeNotEqualTo(String value) {
            addCriterion("BILLING_MODE <>", value, "billingMode");
            return (Criteria) this;
        }

        public Criteria andBillingModeGreaterThan(String value) {
            addCriterion("BILLING_MODE >", value, "billingMode");
            return (Criteria) this;
        }

        public Criteria andBillingModeGreaterThanOrEqualTo(String value) {
            addCriterion("BILLING_MODE >=", value, "billingMode");
            return (Criteria) this;
        }

        public Criteria andBillingModeLessThan(String value) {
            addCriterion("BILLING_MODE <", value, "billingMode");
            return (Criteria) this;
        }

        public Criteria andBillingModeLessThanOrEqualTo(String value) {
            addCriterion("BILLING_MODE <=", value, "billingMode");
            return (Criteria) this;
        }

        public Criteria andBillingModeLike(String value) {
            addCriterion("BILLING_MODE like", value, "billingMode");
            return (Criteria) this;
        }

        public Criteria andBillingModeNotLike(String value) {
            addCriterion("BILLING_MODE not like", value, "billingMode");
            return (Criteria) this;
        }

        public Criteria andBillingModeIn(List<String> values) {
            addCriterion("BILLING_MODE in", values, "billingMode");
            return (Criteria) this;
        }

        public Criteria andBillingModeNotIn(List<String> values) {
            addCriterion("BILLING_MODE not in", values, "billingMode");
            return (Criteria) this;
        }

        public Criteria andBillingModeBetween(String value1, String value2) {
            addCriterion("BILLING_MODE between", value1, value2, "billingMode");
            return (Criteria) this;
        }

        public Criteria andBillingModeNotBetween(String value1, String value2) {
            addCriterion("BILLING_MODE not between", value1, value2, "billingMode");
            return (Criteria) this;
        }

        public Criteria andBillingTypeIdIsNull() {
            addCriterion("BILLING_TYPE_ID is null");
            return (Criteria) this;
        }

        public Criteria andBillingTypeIdIsNotNull() {
            addCriterion("BILLING_TYPE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBillingTypeIdEqualTo(Short value) {
            addCriterion("BILLING_TYPE_ID =", value, "billingTypeId");
            return (Criteria) this;
        }

        public Criteria andBillingTypeIdNotEqualTo(Short value) {
            addCriterion("BILLING_TYPE_ID <>", value, "billingTypeId");
            return (Criteria) this;
        }

        public Criteria andBillingTypeIdGreaterThan(Short value) {
            addCriterion("BILLING_TYPE_ID >", value, "billingTypeId");
            return (Criteria) this;
        }

        public Criteria andBillingTypeIdGreaterThanOrEqualTo(Short value) {
            addCriterion("BILLING_TYPE_ID >=", value, "billingTypeId");
            return (Criteria) this;
        }

        public Criteria andBillingTypeIdLessThan(Short value) {
            addCriterion("BILLING_TYPE_ID <", value, "billingTypeId");
            return (Criteria) this;
        }

        public Criteria andBillingTypeIdLessThanOrEqualTo(Short value) {
            addCriterion("BILLING_TYPE_ID <=", value, "billingTypeId");
            return (Criteria) this;
        }

        public Criteria andBillingTypeIdIn(List<Short> values) {
            addCriterion("BILLING_TYPE_ID in", values, "billingTypeId");
            return (Criteria) this;
        }

        public Criteria andBillingTypeIdNotIn(List<Short> values) {
            addCriterion("BILLING_TYPE_ID not in", values, "billingTypeId");
            return (Criteria) this;
        }

        public Criteria andBillingTypeIdBetween(Short value1, Short value2) {
            addCriterion("BILLING_TYPE_ID between", value1, value2, "billingTypeId");
            return (Criteria) this;
        }

        public Criteria andBillingTypeIdNotBetween(Short value1, Short value2) {
            addCriterion("BILLING_TYPE_ID not between", value1, value2, "billingTypeId");
            return (Criteria) this;
        }

        public Criteria andCreditControlIsNull() {
            addCriterion("CREDIT_CONTROL is null");
            return (Criteria) this;
        }

        public Criteria andCreditControlIsNotNull() {
            addCriterion("CREDIT_CONTROL is not null");
            return (Criteria) this;
        }

        public Criteria andCreditControlEqualTo(Short value) {
            addCriterion("CREDIT_CONTROL =", value, "creditControl");
            return (Criteria) this;
        }

        public Criteria andCreditControlNotEqualTo(Short value) {
            addCriterion("CREDIT_CONTROL <>", value, "creditControl");
            return (Criteria) this;
        }

        public Criteria andCreditControlGreaterThan(Short value) {
            addCriterion("CREDIT_CONTROL >", value, "creditControl");
            return (Criteria) this;
        }

        public Criteria andCreditControlGreaterThanOrEqualTo(Short value) {
            addCriterion("CREDIT_CONTROL >=", value, "creditControl");
            return (Criteria) this;
        }

        public Criteria andCreditControlLessThan(Short value) {
            addCriterion("CREDIT_CONTROL <", value, "creditControl");
            return (Criteria) this;
        }

        public Criteria andCreditControlLessThanOrEqualTo(Short value) {
            addCriterion("CREDIT_CONTROL <=", value, "creditControl");
            return (Criteria) this;
        }

        public Criteria andCreditControlIn(List<Short> values) {
            addCriterion("CREDIT_CONTROL in", values, "creditControl");
            return (Criteria) this;
        }

        public Criteria andCreditControlNotIn(List<Short> values) {
            addCriterion("CREDIT_CONTROL not in", values, "creditControl");
            return (Criteria) this;
        }

        public Criteria andCreditControlBetween(Short value1, Short value2) {
            addCriterion("CREDIT_CONTROL between", value1, value2, "creditControl");
            return (Criteria) this;
        }

        public Criteria andCreditControlNotBetween(Short value1, Short value2) {
            addCriterion("CREDIT_CONTROL not between", value1, value2, "creditControl");
            return (Criteria) this;
        }

        public Criteria andCreditSolutionIsNull() {
            addCriterion("CREDIT_SOLUTION is null");
            return (Criteria) this;
        }

        public Criteria andCreditSolutionIsNotNull() {
            addCriterion("CREDIT_SOLUTION is not null");
            return (Criteria) this;
        }

        public Criteria andCreditSolutionEqualTo(Short value) {
            addCriterion("CREDIT_SOLUTION =", value, "creditSolution");
            return (Criteria) this;
        }

        public Criteria andCreditSolutionNotEqualTo(Short value) {
            addCriterion("CREDIT_SOLUTION <>", value, "creditSolution");
            return (Criteria) this;
        }

        public Criteria andCreditSolutionGreaterThan(Short value) {
            addCriterion("CREDIT_SOLUTION >", value, "creditSolution");
            return (Criteria) this;
        }

        public Criteria andCreditSolutionGreaterThanOrEqualTo(Short value) {
            addCriterion("CREDIT_SOLUTION >=", value, "creditSolution");
            return (Criteria) this;
        }

        public Criteria andCreditSolutionLessThan(Short value) {
            addCriterion("CREDIT_SOLUTION <", value, "creditSolution");
            return (Criteria) this;
        }

        public Criteria andCreditSolutionLessThanOrEqualTo(Short value) {
            addCriterion("CREDIT_SOLUTION <=", value, "creditSolution");
            return (Criteria) this;
        }

        public Criteria andCreditSolutionIn(List<Short> values) {
            addCriterion("CREDIT_SOLUTION in", values, "creditSolution");
            return (Criteria) this;
        }

        public Criteria andCreditSolutionNotIn(List<Short> values) {
            addCriterion("CREDIT_SOLUTION not in", values, "creditSolution");
            return (Criteria) this;
        }

        public Criteria andCreditSolutionBetween(Short value1, Short value2) {
            addCriterion("CREDIT_SOLUTION between", value1, value2, "creditSolution");
            return (Criteria) this;
        }

        public Criteria andCreditSolutionNotBetween(Short value1, Short value2) {
            addCriterion("CREDIT_SOLUTION not between", value1, value2, "creditSolution");
            return (Criteria) this;
        }

        public Criteria andIfSelfControlIsNull() {
            addCriterion("IF_SELF_CONTROL is null");
            return (Criteria) this;
        }

        public Criteria andIfSelfControlIsNotNull() {
            addCriterion("IF_SELF_CONTROL is not null");
            return (Criteria) this;
        }

        public Criteria andIfSelfControlEqualTo(Short value) {
            addCriterion("IF_SELF_CONTROL =", value, "ifSelfControl");
            return (Criteria) this;
        }

        public Criteria andIfSelfControlNotEqualTo(Short value) {
            addCriterion("IF_SELF_CONTROL <>", value, "ifSelfControl");
            return (Criteria) this;
        }

        public Criteria andIfSelfControlGreaterThan(Short value) {
            addCriterion("IF_SELF_CONTROL >", value, "ifSelfControl");
            return (Criteria) this;
        }

        public Criteria andIfSelfControlGreaterThanOrEqualTo(Short value) {
            addCriterion("IF_SELF_CONTROL >=", value, "ifSelfControl");
            return (Criteria) this;
        }

        public Criteria andIfSelfControlLessThan(Short value) {
            addCriterion("IF_SELF_CONTROL <", value, "ifSelfControl");
            return (Criteria) this;
        }

        public Criteria andIfSelfControlLessThanOrEqualTo(Short value) {
            addCriterion("IF_SELF_CONTROL <=", value, "ifSelfControl");
            return (Criteria) this;
        }

        public Criteria andIfSelfControlIn(List<Short> values) {
            addCriterion("IF_SELF_CONTROL in", values, "ifSelfControl");
            return (Criteria) this;
        }

        public Criteria andIfSelfControlNotIn(List<Short> values) {
            addCriterion("IF_SELF_CONTROL not in", values, "ifSelfControl");
            return (Criteria) this;
        }

        public Criteria andIfSelfControlBetween(Short value1, Short value2) {
            addCriterion("IF_SELF_CONTROL between", value1, value2, "ifSelfControl");
            return (Criteria) this;
        }

        public Criteria andIfSelfControlNotBetween(Short value1, Short value2) {
            addCriterion("IF_SELF_CONTROL not between", value1, value2, "ifSelfControl");
            return (Criteria) this;
        }

        public Criteria andSourceIdIsNull() {
            addCriterion("SOURCE_ID is null");
            return (Criteria) this;
        }

        public Criteria andSourceIdIsNotNull() {
            addCriterion("SOURCE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSourceIdEqualTo(String value) {
            addCriterion("SOURCE_ID =", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotEqualTo(String value) {
            addCriterion("SOURCE_ID <>", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdGreaterThan(String value) {
            addCriterion("SOURCE_ID >", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdGreaterThanOrEqualTo(String value) {
            addCriterion("SOURCE_ID >=", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLessThan(String value) {
            addCriterion("SOURCE_ID <", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLessThanOrEqualTo(String value) {
            addCriterion("SOURCE_ID <=", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLike(String value) {
            addCriterion("SOURCE_ID like", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotLike(String value) {
            addCriterion("SOURCE_ID not like", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdIn(List<String> values) {
            addCriterion("SOURCE_ID in", values, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotIn(List<String> values) {
            addCriterion("SOURCE_ID not in", values, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdBetween(String value1, String value2) {
            addCriterion("SOURCE_ID between", value1, value2, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotBetween(String value1, String value2) {
            addCriterion("SOURCE_ID not between", value1, value2, "sourceId");
            return (Criteria) this;
        }

        public Criteria andDeveloperDealerIsNull() {
            addCriterion("DEVELOPER_DEALER is null");
            return (Criteria) this;
        }

        public Criteria andDeveloperDealerIsNotNull() {
            addCriterion("DEVELOPER_DEALER is not null");
            return (Criteria) this;
        }

        public Criteria andDeveloperDealerEqualTo(String value) {
            addCriterion("DEVELOPER_DEALER =", value, "developerDealer");
            return (Criteria) this;
        }

        public Criteria andDeveloperDealerNotEqualTo(String value) {
            addCriterion("DEVELOPER_DEALER <>", value, "developerDealer");
            return (Criteria) this;
        }

        public Criteria andDeveloperDealerGreaterThan(String value) {
            addCriterion("DEVELOPER_DEALER >", value, "developerDealer");
            return (Criteria) this;
        }

        public Criteria andDeveloperDealerGreaterThanOrEqualTo(String value) {
            addCriterion("DEVELOPER_DEALER >=", value, "developerDealer");
            return (Criteria) this;
        }

        public Criteria andDeveloperDealerLessThan(String value) {
            addCriterion("DEVELOPER_DEALER <", value, "developerDealer");
            return (Criteria) this;
        }

        public Criteria andDeveloperDealerLessThanOrEqualTo(String value) {
            addCriterion("DEVELOPER_DEALER <=", value, "developerDealer");
            return (Criteria) this;
        }

        public Criteria andDeveloperDealerLike(String value) {
            addCriterion("DEVELOPER_DEALER like", value, "developerDealer");
            return (Criteria) this;
        }

        public Criteria andDeveloperDealerNotLike(String value) {
            addCriterion("DEVELOPER_DEALER not like", value, "developerDealer");
            return (Criteria) this;
        }

        public Criteria andDeveloperDealerIn(List<String> values) {
            addCriterion("DEVELOPER_DEALER in", values, "developerDealer");
            return (Criteria) this;
        }

        public Criteria andDeveloperDealerNotIn(List<String> values) {
            addCriterion("DEVELOPER_DEALER not in", values, "developerDealer");
            return (Criteria) this;
        }

        public Criteria andDeveloperDealerBetween(String value1, String value2) {
            addCriterion("DEVELOPER_DEALER between", value1, value2, "developerDealer");
            return (Criteria) this;
        }

        public Criteria andDeveloperDealerNotBetween(String value1, String value2) {
            addCriterion("DEVELOPER_DEALER not between", value1, value2, "developerDealer");
            return (Criteria) this;
        }

        public Criteria andBusFavourIdIsNull() {
            addCriterion("BUS_FAVOUR_ID is null");
            return (Criteria) this;
        }

        public Criteria andBusFavourIdIsNotNull() {
            addCriterion("BUS_FAVOUR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBusFavourIdEqualTo(Short value) {
            addCriterion("BUS_FAVOUR_ID =", value, "busFavourId");
            return (Criteria) this;
        }

        public Criteria andBusFavourIdNotEqualTo(Short value) {
            addCriterion("BUS_FAVOUR_ID <>", value, "busFavourId");
            return (Criteria) this;
        }

        public Criteria andBusFavourIdGreaterThan(Short value) {
            addCriterion("BUS_FAVOUR_ID >", value, "busFavourId");
            return (Criteria) this;
        }

        public Criteria andBusFavourIdGreaterThanOrEqualTo(Short value) {
            addCriterion("BUS_FAVOUR_ID >=", value, "busFavourId");
            return (Criteria) this;
        }

        public Criteria andBusFavourIdLessThan(Short value) {
            addCriterion("BUS_FAVOUR_ID <", value, "busFavourId");
            return (Criteria) this;
        }

        public Criteria andBusFavourIdLessThanOrEqualTo(Short value) {
            addCriterion("BUS_FAVOUR_ID <=", value, "busFavourId");
            return (Criteria) this;
        }

        public Criteria andBusFavourIdIn(List<Short> values) {
            addCriterion("BUS_FAVOUR_ID in", values, "busFavourId");
            return (Criteria) this;
        }

        public Criteria andBusFavourIdNotIn(List<Short> values) {
            addCriterion("BUS_FAVOUR_ID not in", values, "busFavourId");
            return (Criteria) this;
        }

        public Criteria andBusFavourIdBetween(Short value1, Short value2) {
            addCriterion("BUS_FAVOUR_ID between", value1, value2, "busFavourId");
            return (Criteria) this;
        }

        public Criteria andBusFavourIdNotBetween(Short value1, Short value2) {
            addCriterion("BUS_FAVOUR_ID not between", value1, value2, "busFavourId");
            return (Criteria) this;
        }

        public Criteria andServiceFavourIdIsNull() {
            addCriterion("SERVICE_FAVOUR_ID is null");
            return (Criteria) this;
        }

        public Criteria andServiceFavourIdIsNotNull() {
            addCriterion("SERVICE_FAVOUR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andServiceFavourIdEqualTo(Integer value) {
            addCriterion("SERVICE_FAVOUR_ID =", value, "serviceFavourId");
            return (Criteria) this;
        }

        public Criteria andServiceFavourIdNotEqualTo(Integer value) {
            addCriterion("SERVICE_FAVOUR_ID <>", value, "serviceFavourId");
            return (Criteria) this;
        }

        public Criteria andServiceFavourIdGreaterThan(Integer value) {
            addCriterion("SERVICE_FAVOUR_ID >", value, "serviceFavourId");
            return (Criteria) this;
        }

        public Criteria andServiceFavourIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("SERVICE_FAVOUR_ID >=", value, "serviceFavourId");
            return (Criteria) this;
        }

        public Criteria andServiceFavourIdLessThan(Integer value) {
            addCriterion("SERVICE_FAVOUR_ID <", value, "serviceFavourId");
            return (Criteria) this;
        }

        public Criteria andServiceFavourIdLessThanOrEqualTo(Integer value) {
            addCriterion("SERVICE_FAVOUR_ID <=", value, "serviceFavourId");
            return (Criteria) this;
        }

        public Criteria andServiceFavourIdIn(List<Integer> values) {
            addCriterion("SERVICE_FAVOUR_ID in", values, "serviceFavourId");
            return (Criteria) this;
        }

        public Criteria andServiceFavourIdNotIn(List<Integer> values) {
            addCriterion("SERVICE_FAVOUR_ID not in", values, "serviceFavourId");
            return (Criteria) this;
        }

        public Criteria andServiceFavourIdBetween(Integer value1, Integer value2) {
            addCriterion("SERVICE_FAVOUR_ID between", value1, value2, "serviceFavourId");
            return (Criteria) this;
        }

        public Criteria andServiceFavourIdNotBetween(Integer value1, Integer value2) {
            addCriterion("SERVICE_FAVOUR_ID not between", value1, value2, "serviceFavourId");
            return (Criteria) this;
        }

        public Criteria andServiceGroupIdIsNull() {
            addCriterion("SERVICE_GROUP_ID is null");
            return (Criteria) this;
        }

        public Criteria andServiceGroupIdIsNotNull() {
            addCriterion("SERVICE_GROUP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andServiceGroupIdEqualTo(Integer value) {
            addCriterion("SERVICE_GROUP_ID =", value, "serviceGroupId");
            return (Criteria) this;
        }

        public Criteria andServiceGroupIdNotEqualTo(Integer value) {
            addCriterion("SERVICE_GROUP_ID <>", value, "serviceGroupId");
            return (Criteria) this;
        }

        public Criteria andServiceGroupIdGreaterThan(Integer value) {
            addCriterion("SERVICE_GROUP_ID >", value, "serviceGroupId");
            return (Criteria) this;
        }

        public Criteria andServiceGroupIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("SERVICE_GROUP_ID >=", value, "serviceGroupId");
            return (Criteria) this;
        }

        public Criteria andServiceGroupIdLessThan(Integer value) {
            addCriterion("SERVICE_GROUP_ID <", value, "serviceGroupId");
            return (Criteria) this;
        }

        public Criteria andServiceGroupIdLessThanOrEqualTo(Integer value) {
            addCriterion("SERVICE_GROUP_ID <=", value, "serviceGroupId");
            return (Criteria) this;
        }

        public Criteria andServiceGroupIdIn(List<Integer> values) {
            addCriterion("SERVICE_GROUP_ID in", values, "serviceGroupId");
            return (Criteria) this;
        }

        public Criteria andServiceGroupIdNotIn(List<Integer> values) {
            addCriterion("SERVICE_GROUP_ID not in", values, "serviceGroupId");
            return (Criteria) this;
        }

        public Criteria andServiceGroupIdBetween(Integer value1, Integer value2) {
            addCriterion("SERVICE_GROUP_ID between", value1, value2, "serviceGroupId");
            return (Criteria) this;
        }

        public Criteria andServiceGroupIdNotBetween(Integer value1, Integer value2) {
            addCriterion("SERVICE_GROUP_ID not between", value1, value2, "serviceGroupId");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("PASSWORD =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("PASSWORD <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("PASSWORD >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("PASSWORD >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("PASSWORD <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("PASSWORD <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("PASSWORD like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("PASSWORD not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("PASSWORD in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("PASSWORD not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("PASSWORD between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("PASSWORD not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andBundleKindIsNull() {
            addCriterion("BUNDLE_KIND is null");
            return (Criteria) this;
        }

        public Criteria andBundleKindIsNotNull() {
            addCriterion("BUNDLE_KIND is not null");
            return (Criteria) this;
        }

        public Criteria andBundleKindEqualTo(Short value) {
            addCriterion("BUNDLE_KIND =", value, "bundleKind");
            return (Criteria) this;
        }

        public Criteria andBundleKindNotEqualTo(Short value) {
            addCriterion("BUNDLE_KIND <>", value, "bundleKind");
            return (Criteria) this;
        }

        public Criteria andBundleKindGreaterThan(Short value) {
            addCriterion("BUNDLE_KIND >", value, "bundleKind");
            return (Criteria) this;
        }

        public Criteria andBundleKindGreaterThanOrEqualTo(Short value) {
            addCriterion("BUNDLE_KIND >=", value, "bundleKind");
            return (Criteria) this;
        }

        public Criteria andBundleKindLessThan(Short value) {
            addCriterion("BUNDLE_KIND <", value, "bundleKind");
            return (Criteria) this;
        }

        public Criteria andBundleKindLessThanOrEqualTo(Short value) {
            addCriterion("BUNDLE_KIND <=", value, "bundleKind");
            return (Criteria) this;
        }

        public Criteria andBundleKindIn(List<Short> values) {
            addCriterion("BUNDLE_KIND in", values, "bundleKind");
            return (Criteria) this;
        }

        public Criteria andBundleKindNotIn(List<Short> values) {
            addCriterion("BUNDLE_KIND not in", values, "bundleKind");
            return (Criteria) this;
        }

        public Criteria andBundleKindBetween(Short value1, Short value2) {
            addCriterion("BUNDLE_KIND between", value1, value2, "bundleKind");
            return (Criteria) this;
        }

        public Criteria andBundleKindNotBetween(Short value1, Short value2) {
            addCriterion("BUNDLE_KIND not between", value1, value2, "bundleKind");
            return (Criteria) this;
        }

        public Criteria andBegRegIsNull() {
            addCriterion("BEG_REG is null");
            return (Criteria) this;
        }

        public Criteria andBegRegIsNotNull() {
            addCriterion("BEG_REG is not null");
            return (Criteria) this;
        }

        public Criteria andBegRegEqualTo(String value) {
            addCriterion("BEG_REG =", value, "begReg");
            return (Criteria) this;
        }

        public Criteria andBegRegNotEqualTo(String value) {
            addCriterion("BEG_REG <>", value, "begReg");
            return (Criteria) this;
        }

        public Criteria andBegRegGreaterThan(String value) {
            addCriterion("BEG_REG >", value, "begReg");
            return (Criteria) this;
        }

        public Criteria andBegRegGreaterThanOrEqualTo(String value) {
            addCriterion("BEG_REG >=", value, "begReg");
            return (Criteria) this;
        }

        public Criteria andBegRegLessThan(String value) {
            addCriterion("BEG_REG <", value, "begReg");
            return (Criteria) this;
        }

        public Criteria andBegRegLessThanOrEqualTo(String value) {
            addCriterion("BEG_REG <=", value, "begReg");
            return (Criteria) this;
        }

        public Criteria andBegRegLike(String value) {
            addCriterion("BEG_REG like", value, "begReg");
            return (Criteria) this;
        }

        public Criteria andBegRegNotLike(String value) {
            addCriterion("BEG_REG not like", value, "begReg");
            return (Criteria) this;
        }

        public Criteria andBegRegIn(List<String> values) {
            addCriterion("BEG_REG in", values, "begReg");
            return (Criteria) this;
        }

        public Criteria andBegRegNotIn(List<String> values) {
            addCriterion("BEG_REG not in", values, "begReg");
            return (Criteria) this;
        }

        public Criteria andBegRegBetween(String value1, String value2) {
            addCriterion("BEG_REG between", value1, value2, "begReg");
            return (Criteria) this;
        }

        public Criteria andBegRegNotBetween(String value1, String value2) {
            addCriterion("BEG_REG not between", value1, value2, "begReg");
            return (Criteria) this;
        }

        public Criteria andEndRegIsNull() {
            addCriterion("END_REG is null");
            return (Criteria) this;
        }

        public Criteria andEndRegIsNotNull() {
            addCriterion("END_REG is not null");
            return (Criteria) this;
        }

        public Criteria andEndRegEqualTo(String value) {
            addCriterion("END_REG =", value, "endReg");
            return (Criteria) this;
        }

        public Criteria andEndRegNotEqualTo(String value) {
            addCriterion("END_REG <>", value, "endReg");
            return (Criteria) this;
        }

        public Criteria andEndRegGreaterThan(String value) {
            addCriterion("END_REG >", value, "endReg");
            return (Criteria) this;
        }

        public Criteria andEndRegGreaterThanOrEqualTo(String value) {
            addCriterion("END_REG >=", value, "endReg");
            return (Criteria) this;
        }

        public Criteria andEndRegLessThan(String value) {
            addCriterion("END_REG <", value, "endReg");
            return (Criteria) this;
        }

        public Criteria andEndRegLessThanOrEqualTo(String value) {
            addCriterion("END_REG <=", value, "endReg");
            return (Criteria) this;
        }

        public Criteria andEndRegLike(String value) {
            addCriterion("END_REG like", value, "endReg");
            return (Criteria) this;
        }

        public Criteria andEndRegNotLike(String value) {
            addCriterion("END_REG not like", value, "endReg");
            return (Criteria) this;
        }

        public Criteria andEndRegIn(List<String> values) {
            addCriterion("END_REG in", values, "endReg");
            return (Criteria) this;
        }

        public Criteria andEndRegNotIn(List<String> values) {
            addCriterion("END_REG not in", values, "endReg");
            return (Criteria) this;
        }

        public Criteria andEndRegBetween(String value1, String value2) {
            addCriterion("END_REG between", value1, value2, "endReg");
            return (Criteria) this;
        }

        public Criteria andEndRegNotBetween(String value1, String value2) {
            addCriterion("END_REG not between", value1, value2, "endReg");
            return (Criteria) this;
        }

        public Criteria andCallFlagIsNull() {
            addCriterion("CALL_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andCallFlagIsNotNull() {
            addCriterion("CALL_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andCallFlagEqualTo(Short value) {
            addCriterion("CALL_FLAG =", value, "callFlag");
            return (Criteria) this;
        }

        public Criteria andCallFlagNotEqualTo(Short value) {
            addCriterion("CALL_FLAG <>", value, "callFlag");
            return (Criteria) this;
        }

        public Criteria andCallFlagGreaterThan(Short value) {
            addCriterion("CALL_FLAG >", value, "callFlag");
            return (Criteria) this;
        }

        public Criteria andCallFlagGreaterThanOrEqualTo(Short value) {
            addCriterion("CALL_FLAG >=", value, "callFlag");
            return (Criteria) this;
        }

        public Criteria andCallFlagLessThan(Short value) {
            addCriterion("CALL_FLAG <", value, "callFlag");
            return (Criteria) this;
        }

        public Criteria andCallFlagLessThanOrEqualTo(Short value) {
            addCriterion("CALL_FLAG <=", value, "callFlag");
            return (Criteria) this;
        }

        public Criteria andCallFlagIn(List<Short> values) {
            addCriterion("CALL_FLAG in", values, "callFlag");
            return (Criteria) this;
        }

        public Criteria andCallFlagNotIn(List<Short> values) {
            addCriterion("CALL_FLAG not in", values, "callFlag");
            return (Criteria) this;
        }

        public Criteria andCallFlagBetween(Short value1, Short value2) {
            addCriterion("CALL_FLAG between", value1, value2, "callFlag");
            return (Criteria) this;
        }

        public Criteria andCallFlagNotBetween(Short value1, Short value2) {
            addCriterion("CALL_FLAG not between", value1, value2, "callFlag");
            return (Criteria) this;
        }

        public Criteria andFirstCallDateIsNull() {
            addCriterion("FIRST_CALL_DATE is null");
            return (Criteria) this;
        }

        public Criteria andFirstCallDateIsNotNull() {
            addCriterion("FIRST_CALL_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andFirstCallDateEqualTo(Date value) {
            addCriterionForJDBCDate("FIRST_CALL_DATE =", value, "firstCallDate");
            return (Criteria) this;
        }

        public Criteria andFirstCallDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("FIRST_CALL_DATE <>", value, "firstCallDate");
            return (Criteria) this;
        }

        public Criteria andFirstCallDateGreaterThan(Date value) {
            addCriterionForJDBCDate("FIRST_CALL_DATE >", value, "firstCallDate");
            return (Criteria) this;
        }

        public Criteria andFirstCallDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("FIRST_CALL_DATE >=", value, "firstCallDate");
            return (Criteria) this;
        }

        public Criteria andFirstCallDateLessThan(Date value) {
            addCriterionForJDBCDate("FIRST_CALL_DATE <", value, "firstCallDate");
            return (Criteria) this;
        }

        public Criteria andFirstCallDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("FIRST_CALL_DATE <=", value, "firstCallDate");
            return (Criteria) this;
        }

        public Criteria andFirstCallDateIn(List<Date> values) {
            addCriterionForJDBCDate("FIRST_CALL_DATE in", values, "firstCallDate");
            return (Criteria) this;
        }

        public Criteria andFirstCallDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("FIRST_CALL_DATE not in", values, "firstCallDate");
            return (Criteria) this;
        }

        public Criteria andFirstCallDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("FIRST_CALL_DATE between", value1, value2, "firstCallDate");
            return (Criteria) this;
        }

        public Criteria andFirstCallDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("FIRST_CALL_DATE not between", value1, value2, "firstCallDate");
            return (Criteria) this;
        }

        public Criteria andApplyStartDateIsNull() {
            addCriterion("APPLY_START_DATE is null");
            return (Criteria) this;
        }

        public Criteria andApplyStartDateIsNotNull() {
            addCriterion("APPLY_START_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andApplyStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("APPLY_START_DATE =", value, "applyStartDate");
            return (Criteria) this;
        }

        public Criteria andApplyStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("APPLY_START_DATE <>", value, "applyStartDate");
            return (Criteria) this;
        }

        public Criteria andApplyStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("APPLY_START_DATE >", value, "applyStartDate");
            return (Criteria) this;
        }

        public Criteria andApplyStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("APPLY_START_DATE >=", value, "applyStartDate");
            return (Criteria) this;
        }

        public Criteria andApplyStartDateLessThan(Date value) {
            addCriterionForJDBCDate("APPLY_START_DATE <", value, "applyStartDate");
            return (Criteria) this;
        }

        public Criteria andApplyStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("APPLY_START_DATE <=", value, "applyStartDate");
            return (Criteria) this;
        }

        public Criteria andApplyStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("APPLY_START_DATE in", values, "applyStartDate");
            return (Criteria) this;
        }

        public Criteria andApplyStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("APPLY_START_DATE not in", values, "applyStartDate");
            return (Criteria) this;
        }

        public Criteria andApplyStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("APPLY_START_DATE between", value1, value2, "applyStartDate");
            return (Criteria) this;
        }

        public Criteria andApplyStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("APPLY_START_DATE not between", value1, value2, "applyStartDate");
            return (Criteria) this;
        }

        public Criteria andServiceStartDateIsNull() {
            addCriterion("SERVICE_START_DATE is null");
            return (Criteria) this;
        }

        public Criteria andServiceStartDateIsNotNull() {
            addCriterion("SERVICE_START_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andServiceStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("SERVICE_START_DATE =", value, "serviceStartDate");
            return (Criteria) this;
        }

        public Criteria andServiceStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("SERVICE_START_DATE <>", value, "serviceStartDate");
            return (Criteria) this;
        }

        public Criteria andServiceStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("SERVICE_START_DATE >", value, "serviceStartDate");
            return (Criteria) this;
        }

        public Criteria andServiceStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SERVICE_START_DATE >=", value, "serviceStartDate");
            return (Criteria) this;
        }

        public Criteria andServiceStartDateLessThan(Date value) {
            addCriterionForJDBCDate("SERVICE_START_DATE <", value, "serviceStartDate");
            return (Criteria) this;
        }

        public Criteria andServiceStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SERVICE_START_DATE <=", value, "serviceStartDate");
            return (Criteria) this;
        }

        public Criteria andServiceStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("SERVICE_START_DATE in", values, "serviceStartDate");
            return (Criteria) this;
        }

        public Criteria andServiceStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("SERVICE_START_DATE not in", values, "serviceStartDate");
            return (Criteria) this;
        }

        public Criteria andServiceStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SERVICE_START_DATE between", value1, value2, "serviceStartDate");
            return (Criteria) this;
        }

        public Criteria andServiceStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SERVICE_START_DATE not between", value1, value2, "serviceStartDate");
            return (Criteria) this;
        }

        public Criteria andServiceStopDateIsNull() {
            addCriterion("SERVICE_STOP_DATE is null");
            return (Criteria) this;
        }

        public Criteria andServiceStopDateIsNotNull() {
            addCriterion("SERVICE_STOP_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andServiceStopDateEqualTo(Date value) {
            addCriterionForJDBCDate("SERVICE_STOP_DATE =", value, "serviceStopDate");
            return (Criteria) this;
        }

        public Criteria andServiceStopDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("SERVICE_STOP_DATE <>", value, "serviceStopDate");
            return (Criteria) this;
        }

        public Criteria andServiceStopDateGreaterThan(Date value) {
            addCriterionForJDBCDate("SERVICE_STOP_DATE >", value, "serviceStopDate");
            return (Criteria) this;
        }

        public Criteria andServiceStopDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SERVICE_STOP_DATE >=", value, "serviceStopDate");
            return (Criteria) this;
        }

        public Criteria andServiceStopDateLessThan(Date value) {
            addCriterionForJDBCDate("SERVICE_STOP_DATE <", value, "serviceStopDate");
            return (Criteria) this;
        }

        public Criteria andServiceStopDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SERVICE_STOP_DATE <=", value, "serviceStopDate");
            return (Criteria) this;
        }

        public Criteria andServiceStopDateIn(List<Date> values) {
            addCriterionForJDBCDate("SERVICE_STOP_DATE in", values, "serviceStopDate");
            return (Criteria) this;
        }

        public Criteria andServiceStopDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("SERVICE_STOP_DATE not in", values, "serviceStopDate");
            return (Criteria) this;
        }

        public Criteria andServiceStopDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SERVICE_STOP_DATE between", value1, value2, "serviceStopDate");
            return (Criteria) this;
        }

        public Criteria andServiceStopDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SERVICE_STOP_DATE not between", value1, value2, "serviceStopDate");
            return (Criteria) this;
        }

        public Criteria andServiceInvalidDateIsNull() {
            addCriterion("SERVICE_INVALID_DATE is null");
            return (Criteria) this;
        }

        public Criteria andServiceInvalidDateIsNotNull() {
            addCriterion("SERVICE_INVALID_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andServiceInvalidDateEqualTo(Date value) {
            addCriterionForJDBCDate("SERVICE_INVALID_DATE =", value, "serviceInvalidDate");
            return (Criteria) this;
        }

        public Criteria andServiceInvalidDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("SERVICE_INVALID_DATE <>", value, "serviceInvalidDate");
            return (Criteria) this;
        }

        public Criteria andServiceInvalidDateGreaterThan(Date value) {
            addCriterionForJDBCDate("SERVICE_INVALID_DATE >", value, "serviceInvalidDate");
            return (Criteria) this;
        }

        public Criteria andServiceInvalidDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SERVICE_INVALID_DATE >=", value, "serviceInvalidDate");
            return (Criteria) this;
        }

        public Criteria andServiceInvalidDateLessThan(Date value) {
            addCriterionForJDBCDate("SERVICE_INVALID_DATE <", value, "serviceInvalidDate");
            return (Criteria) this;
        }

        public Criteria andServiceInvalidDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SERVICE_INVALID_DATE <=", value, "serviceInvalidDate");
            return (Criteria) this;
        }

        public Criteria andServiceInvalidDateIn(List<Date> values) {
            addCriterionForJDBCDate("SERVICE_INVALID_DATE in", values, "serviceInvalidDate");
            return (Criteria) this;
        }

        public Criteria andServiceInvalidDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("SERVICE_INVALID_DATE not in", values, "serviceInvalidDate");
            return (Criteria) this;
        }

        public Criteria andServiceInvalidDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SERVICE_INVALID_DATE between", value1, value2, "serviceInvalidDate");
            return (Criteria) this;
        }

        public Criteria andServiceInvalidDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SERVICE_INVALID_DATE not between", value1, value2, "serviceInvalidDate");
            return (Criteria) this;
        }

        public Criteria andMonthFeeIsNull() {
            addCriterion("MONTH_FEE is null");
            return (Criteria) this;
        }

        public Criteria andMonthFeeIsNotNull() {
            addCriterion("MONTH_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andMonthFeeEqualTo(Long value) {
            addCriterion("MONTH_FEE =", value, "monthFee");
            return (Criteria) this;
        }

        public Criteria andMonthFeeNotEqualTo(Long value) {
            addCriterion("MONTH_FEE <>", value, "monthFee");
            return (Criteria) this;
        }

        public Criteria andMonthFeeGreaterThan(Long value) {
            addCriterion("MONTH_FEE >", value, "monthFee");
            return (Criteria) this;
        }

        public Criteria andMonthFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("MONTH_FEE >=", value, "monthFee");
            return (Criteria) this;
        }

        public Criteria andMonthFeeLessThan(Long value) {
            addCriterion("MONTH_FEE <", value, "monthFee");
            return (Criteria) this;
        }

        public Criteria andMonthFeeLessThanOrEqualTo(Long value) {
            addCriterion("MONTH_FEE <=", value, "monthFee");
            return (Criteria) this;
        }

        public Criteria andMonthFeeIn(List<Long> values) {
            addCriterion("MONTH_FEE in", values, "monthFee");
            return (Criteria) this;
        }

        public Criteria andMonthFeeNotIn(List<Long> values) {
            addCriterion("MONTH_FEE not in", values, "monthFee");
            return (Criteria) this;
        }

        public Criteria andMonthFeeBetween(Long value1, Long value2) {
            addCriterion("MONTH_FEE between", value1, value2, "monthFee");
            return (Criteria) this;
        }

        public Criteria andMonthFeeNotBetween(Long value1, Long value2) {
            addCriterion("MONTH_FEE not between", value1, value2, "monthFee");
            return (Criteria) this;
        }

        public Criteria andPreserve03IsNull() {
            addCriterion("PRESERVE03 is null");
            return (Criteria) this;
        }

        public Criteria andPreserve03IsNotNull() {
            addCriterion("PRESERVE03 is not null");
            return (Criteria) this;
        }

        public Criteria andPreserve03EqualTo(Short value) {
            addCriterion("PRESERVE03 =", value, "preserve03");
            return (Criteria) this;
        }

        public Criteria andPreserve03NotEqualTo(Short value) {
            addCriterion("PRESERVE03 <>", value, "preserve03");
            return (Criteria) this;
        }

        public Criteria andPreserve03GreaterThan(Short value) {
            addCriterion("PRESERVE03 >", value, "preserve03");
            return (Criteria) this;
        }

        public Criteria andPreserve03GreaterThanOrEqualTo(Short value) {
            addCriterion("PRESERVE03 >=", value, "preserve03");
            return (Criteria) this;
        }

        public Criteria andPreserve03LessThan(Short value) {
            addCriterion("PRESERVE03 <", value, "preserve03");
            return (Criteria) this;
        }

        public Criteria andPreserve03LessThanOrEqualTo(Short value) {
            addCriterion("PRESERVE03 <=", value, "preserve03");
            return (Criteria) this;
        }

        public Criteria andPreserve03In(List<Short> values) {
            addCriterion("PRESERVE03 in", values, "preserve03");
            return (Criteria) this;
        }

        public Criteria andPreserve03NotIn(List<Short> values) {
            addCriterion("PRESERVE03 not in", values, "preserve03");
            return (Criteria) this;
        }

        public Criteria andPreserve03Between(Short value1, Short value2) {
            addCriterion("PRESERVE03 between", value1, value2, "preserve03");
            return (Criteria) this;
        }

        public Criteria andPreserve03NotBetween(Short value1, Short value2) {
            addCriterion("PRESERVE03 not between", value1, value2, "preserve03");
            return (Criteria) this;
        }

        public Criteria andPreserve12IsNull() {
            addCriterion("PRESERVE12 is null");
            return (Criteria) this;
        }

        public Criteria andPreserve12IsNotNull() {
            addCriterion("PRESERVE12 is not null");
            return (Criteria) this;
        }

        public Criteria andPreserve12EqualTo(Short value) {
            addCriterion("PRESERVE12 =", value, "preserve12");
            return (Criteria) this;
        }

        public Criteria andPreserve12NotEqualTo(Short value) {
            addCriterion("PRESERVE12 <>", value, "preserve12");
            return (Criteria) this;
        }

        public Criteria andPreserve12GreaterThan(Short value) {
            addCriterion("PRESERVE12 >", value, "preserve12");
            return (Criteria) this;
        }

        public Criteria andPreserve12GreaterThanOrEqualTo(Short value) {
            addCriterion("PRESERVE12 >=", value, "preserve12");
            return (Criteria) this;
        }

        public Criteria andPreserve12LessThan(Short value) {
            addCriterion("PRESERVE12 <", value, "preserve12");
            return (Criteria) this;
        }

        public Criteria andPreserve12LessThanOrEqualTo(Short value) {
            addCriterion("PRESERVE12 <=", value, "preserve12");
            return (Criteria) this;
        }

        public Criteria andPreserve12In(List<Short> values) {
            addCriterion("PRESERVE12 in", values, "preserve12");
            return (Criteria) this;
        }

        public Criteria andPreserve12NotIn(List<Short> values) {
            addCriterion("PRESERVE12 not in", values, "preserve12");
            return (Criteria) this;
        }

        public Criteria andPreserve12Between(Short value1, Short value2) {
            addCriterion("PRESERVE12 between", value1, value2, "preserve12");
            return (Criteria) this;
        }

        public Criteria andPreserve12NotBetween(Short value1, Short value2) {
            addCriterion("PRESERVE12 not between", value1, value2, "preserve12");
            return (Criteria) this;
        }

        public Criteria andPreserve18IsNull() {
            addCriterion("PRESERVE18 is null");
            return (Criteria) this;
        }

        public Criteria andPreserve18IsNotNull() {
            addCriterion("PRESERVE18 is not null");
            return (Criteria) this;
        }

        public Criteria andPreserve18EqualTo(Short value) {
            addCriterion("PRESERVE18 =", value, "preserve18");
            return (Criteria) this;
        }

        public Criteria andPreserve18NotEqualTo(Short value) {
            addCriterion("PRESERVE18 <>", value, "preserve18");
            return (Criteria) this;
        }

        public Criteria andPreserve18GreaterThan(Short value) {
            addCriterion("PRESERVE18 >", value, "preserve18");
            return (Criteria) this;
        }

        public Criteria andPreserve18GreaterThanOrEqualTo(Short value) {
            addCriterion("PRESERVE18 >=", value, "preserve18");
            return (Criteria) this;
        }

        public Criteria andPreserve18LessThan(Short value) {
            addCriterion("PRESERVE18 <", value, "preserve18");
            return (Criteria) this;
        }

        public Criteria andPreserve18LessThanOrEqualTo(Short value) {
            addCriterion("PRESERVE18 <=", value, "preserve18");
            return (Criteria) this;
        }

        public Criteria andPreserve18In(List<Short> values) {
            addCriterion("PRESERVE18 in", values, "preserve18");
            return (Criteria) this;
        }

        public Criteria andPreserve18NotIn(List<Short> values) {
            addCriterion("PRESERVE18 not in", values, "preserve18");
            return (Criteria) this;
        }

        public Criteria andPreserve18Between(Short value1, Short value2) {
            addCriterion("PRESERVE18 between", value1, value2, "preserve18");
            return (Criteria) this;
        }

        public Criteria andPreserve18NotBetween(Short value1, Short value2) {
            addCriterion("PRESERVE18 not between", value1, value2, "preserve18");
            return (Criteria) this;
        }

        public Criteria andPreserve04IsNull() {
            addCriterion("PRESERVE04 is null");
            return (Criteria) this;
        }

        public Criteria andPreserve04IsNotNull() {
            addCriterion("PRESERVE04 is not null");
            return (Criteria) this;
        }

        public Criteria andPreserve04EqualTo(Short value) {
            addCriterion("PRESERVE04 =", value, "preserve04");
            return (Criteria) this;
        }

        public Criteria andPreserve04NotEqualTo(Short value) {
            addCriterion("PRESERVE04 <>", value, "preserve04");
            return (Criteria) this;
        }

        public Criteria andPreserve04GreaterThan(Short value) {
            addCriterion("PRESERVE04 >", value, "preserve04");
            return (Criteria) this;
        }

        public Criteria andPreserve04GreaterThanOrEqualTo(Short value) {
            addCriterion("PRESERVE04 >=", value, "preserve04");
            return (Criteria) this;
        }

        public Criteria andPreserve04LessThan(Short value) {
            addCriterion("PRESERVE04 <", value, "preserve04");
            return (Criteria) this;
        }

        public Criteria andPreserve04LessThanOrEqualTo(Short value) {
            addCriterion("PRESERVE04 <=", value, "preserve04");
            return (Criteria) this;
        }

        public Criteria andPreserve04In(List<Short> values) {
            addCriterion("PRESERVE04 in", values, "preserve04");
            return (Criteria) this;
        }

        public Criteria andPreserve04NotIn(List<Short> values) {
            addCriterion("PRESERVE04 not in", values, "preserve04");
            return (Criteria) this;
        }

        public Criteria andPreserve04Between(Short value1, Short value2) {
            addCriterion("PRESERVE04 between", value1, value2, "preserve04");
            return (Criteria) this;
        }

        public Criteria andPreserve04NotBetween(Short value1, Short value2) {
            addCriterion("PRESERVE04 not between", value1, value2, "preserve04");
            return (Criteria) this;
        }

        public Criteria andPresentFeeIsNull() {
            addCriterion("PRESENT_FEE is null");
            return (Criteria) this;
        }

        public Criteria andPresentFeeIsNotNull() {
            addCriterion("PRESENT_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andPresentFeeEqualTo(Long value) {
            addCriterion("PRESENT_FEE =", value, "presentFee");
            return (Criteria) this;
        }

        public Criteria andPresentFeeNotEqualTo(Long value) {
            addCriterion("PRESENT_FEE <>", value, "presentFee");
            return (Criteria) this;
        }

        public Criteria andPresentFeeGreaterThan(Long value) {
            addCriterion("PRESENT_FEE >", value, "presentFee");
            return (Criteria) this;
        }

        public Criteria andPresentFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("PRESENT_FEE >=", value, "presentFee");
            return (Criteria) this;
        }

        public Criteria andPresentFeeLessThan(Long value) {
            addCriterion("PRESENT_FEE <", value, "presentFee");
            return (Criteria) this;
        }

        public Criteria andPresentFeeLessThanOrEqualTo(Long value) {
            addCriterion("PRESENT_FEE <=", value, "presentFee");
            return (Criteria) this;
        }

        public Criteria andPresentFeeIn(List<Long> values) {
            addCriterion("PRESENT_FEE in", values, "presentFee");
            return (Criteria) this;
        }

        public Criteria andPresentFeeNotIn(List<Long> values) {
            addCriterion("PRESENT_FEE not in", values, "presentFee");
            return (Criteria) this;
        }

        public Criteria andPresentFeeBetween(Long value1, Long value2) {
            addCriterion("PRESENT_FEE between", value1, value2, "presentFee");
            return (Criteria) this;
        }

        public Criteria andPresentFeeNotBetween(Long value1, Long value2) {
            addCriterion("PRESENT_FEE not between", value1, value2, "presentFee");
            return (Criteria) this;
        }

        public Criteria andDealerInnetMethodIsNull() {
            addCriterion("DEALER_INNET_METHOD is null");
            return (Criteria) this;
        }

        public Criteria andDealerInnetMethodIsNotNull() {
            addCriterion("DEALER_INNET_METHOD is not null");
            return (Criteria) this;
        }

        public Criteria andDealerInnetMethodEqualTo(Short value) {
            addCriterion("DEALER_INNET_METHOD =", value, "dealerInnetMethod");
            return (Criteria) this;
        }

        public Criteria andDealerInnetMethodNotEqualTo(Short value) {
            addCriterion("DEALER_INNET_METHOD <>", value, "dealerInnetMethod");
            return (Criteria) this;
        }

        public Criteria andDealerInnetMethodGreaterThan(Short value) {
            addCriterion("DEALER_INNET_METHOD >", value, "dealerInnetMethod");
            return (Criteria) this;
        }

        public Criteria andDealerInnetMethodGreaterThanOrEqualTo(Short value) {
            addCriterion("DEALER_INNET_METHOD >=", value, "dealerInnetMethod");
            return (Criteria) this;
        }

        public Criteria andDealerInnetMethodLessThan(Short value) {
            addCriterion("DEALER_INNET_METHOD <", value, "dealerInnetMethod");
            return (Criteria) this;
        }

        public Criteria andDealerInnetMethodLessThanOrEqualTo(Short value) {
            addCriterion("DEALER_INNET_METHOD <=", value, "dealerInnetMethod");
            return (Criteria) this;
        }

        public Criteria andDealerInnetMethodIn(List<Short> values) {
            addCriterion("DEALER_INNET_METHOD in", values, "dealerInnetMethod");
            return (Criteria) this;
        }

        public Criteria andDealerInnetMethodNotIn(List<Short> values) {
            addCriterion("DEALER_INNET_METHOD not in", values, "dealerInnetMethod");
            return (Criteria) this;
        }

        public Criteria andDealerInnetMethodBetween(Short value1, Short value2) {
            addCriterion("DEALER_INNET_METHOD between", value1, value2, "dealerInnetMethod");
            return (Criteria) this;
        }

        public Criteria andDealerInnetMethodNotBetween(Short value1, Short value2) {
            addCriterion("DEALER_INNET_METHOD not between", value1, value2, "dealerInnetMethod");
            return (Criteria) this;
        }

        public Criteria andAcceptAddressIdIsNull() {
            addCriterion("ACCEPT_ADDRESS_ID is null");
            return (Criteria) this;
        }

        public Criteria andAcceptAddressIdIsNotNull() {
            addCriterion("ACCEPT_ADDRESS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptAddressIdEqualTo(String value) {
            addCriterion("ACCEPT_ADDRESS_ID =", value, "acceptAddressId");
            return (Criteria) this;
        }

        public Criteria andAcceptAddressIdNotEqualTo(String value) {
            addCriterion("ACCEPT_ADDRESS_ID <>", value, "acceptAddressId");
            return (Criteria) this;
        }

        public Criteria andAcceptAddressIdGreaterThan(String value) {
            addCriterion("ACCEPT_ADDRESS_ID >", value, "acceptAddressId");
            return (Criteria) this;
        }

        public Criteria andAcceptAddressIdGreaterThanOrEqualTo(String value) {
            addCriterion("ACCEPT_ADDRESS_ID >=", value, "acceptAddressId");
            return (Criteria) this;
        }

        public Criteria andAcceptAddressIdLessThan(String value) {
            addCriterion("ACCEPT_ADDRESS_ID <", value, "acceptAddressId");
            return (Criteria) this;
        }

        public Criteria andAcceptAddressIdLessThanOrEqualTo(String value) {
            addCriterion("ACCEPT_ADDRESS_ID <=", value, "acceptAddressId");
            return (Criteria) this;
        }

        public Criteria andAcceptAddressIdLike(String value) {
            addCriterion("ACCEPT_ADDRESS_ID like", value, "acceptAddressId");
            return (Criteria) this;
        }

        public Criteria andAcceptAddressIdNotLike(String value) {
            addCriterion("ACCEPT_ADDRESS_ID not like", value, "acceptAddressId");
            return (Criteria) this;
        }

        public Criteria andAcceptAddressIdIn(List<String> values) {
            addCriterion("ACCEPT_ADDRESS_ID in", values, "acceptAddressId");
            return (Criteria) this;
        }

        public Criteria andAcceptAddressIdNotIn(List<String> values) {
            addCriterion("ACCEPT_ADDRESS_ID not in", values, "acceptAddressId");
            return (Criteria) this;
        }

        public Criteria andAcceptAddressIdBetween(String value1, String value2) {
            addCriterion("ACCEPT_ADDRESS_ID between", value1, value2, "acceptAddressId");
            return (Criteria) this;
        }

        public Criteria andAcceptAddressIdNotBetween(String value1, String value2) {
            addCriterion("ACCEPT_ADDRESS_ID not between", value1, value2, "acceptAddressId");
            return (Criteria) this;
        }

        public Criteria andDeveloperIsNull() {
            addCriterion("DEVELOPER is null");
            return (Criteria) this;
        }

        public Criteria andDeveloperIsNotNull() {
            addCriterion("DEVELOPER is not null");
            return (Criteria) this;
        }

        public Criteria andDeveloperEqualTo(String value) {
            addCriterion("DEVELOPER =", value, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperNotEqualTo(String value) {
            addCriterion("DEVELOPER <>", value, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperGreaterThan(String value) {
            addCriterion("DEVELOPER >", value, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperGreaterThanOrEqualTo(String value) {
            addCriterion("DEVELOPER >=", value, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperLessThan(String value) {
            addCriterion("DEVELOPER <", value, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperLessThanOrEqualTo(String value) {
            addCriterion("DEVELOPER <=", value, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperLike(String value) {
            addCriterion("DEVELOPER like", value, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperNotLike(String value) {
            addCriterion("DEVELOPER not like", value, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperIn(List<String> values) {
            addCriterion("DEVELOPER in", values, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperNotIn(List<String> values) {
            addCriterion("DEVELOPER not in", values, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperBetween(String value1, String value2) {
            addCriterion("DEVELOPER between", value1, value2, "developer");
            return (Criteria) this;
        }

        public Criteria andDeveloperNotBetween(String value1, String value2) {
            addCriterion("DEVELOPER not between", value1, value2, "developer");
            return (Criteria) this;
        }

        public Criteria andDealerReturnDateIsNull() {
            addCriterion("DEALER_RETURN_DATE is null");
            return (Criteria) this;
        }

        public Criteria andDealerReturnDateIsNotNull() {
            addCriterion("DEALER_RETURN_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andDealerReturnDateEqualTo(Date value) {
            addCriterionForJDBCDate("DEALER_RETURN_DATE =", value, "dealerReturnDate");
            return (Criteria) this;
        }

        public Criteria andDealerReturnDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("DEALER_RETURN_DATE <>", value, "dealerReturnDate");
            return (Criteria) this;
        }

        public Criteria andDealerReturnDateGreaterThan(Date value) {
            addCriterionForJDBCDate("DEALER_RETURN_DATE >", value, "dealerReturnDate");
            return (Criteria) this;
        }

        public Criteria andDealerReturnDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("DEALER_RETURN_DATE >=", value, "dealerReturnDate");
            return (Criteria) this;
        }

        public Criteria andDealerReturnDateLessThan(Date value) {
            addCriterionForJDBCDate("DEALER_RETURN_DATE <", value, "dealerReturnDate");
            return (Criteria) this;
        }

        public Criteria andDealerReturnDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("DEALER_RETURN_DATE <=", value, "dealerReturnDate");
            return (Criteria) this;
        }

        public Criteria andDealerReturnDateIn(List<Date> values) {
            addCriterionForJDBCDate("DEALER_RETURN_DATE in", values, "dealerReturnDate");
            return (Criteria) this;
        }

        public Criteria andDealerReturnDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("DEALER_RETURN_DATE not in", values, "dealerReturnDate");
            return (Criteria) this;
        }

        public Criteria andDealerReturnDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("DEALER_RETURN_DATE between", value1, value2, "dealerReturnDate");
            return (Criteria) this;
        }

        public Criteria andDealerReturnDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("DEALER_RETURN_DATE not between", value1, value2, "dealerReturnDate");
            return (Criteria) this;
        }

        public Criteria andDataCreateWayIsNull() {
            addCriterion("DATA_CREATE_WAY is null");
            return (Criteria) this;
        }

        public Criteria andDataCreateWayIsNotNull() {
            addCriterion("DATA_CREATE_WAY is not null");
            return (Criteria) this;
        }

        public Criteria andDataCreateWayEqualTo(Short value) {
            addCriterion("DATA_CREATE_WAY =", value, "dataCreateWay");
            return (Criteria) this;
        }

        public Criteria andDataCreateWayNotEqualTo(Short value) {
            addCriterion("DATA_CREATE_WAY <>", value, "dataCreateWay");
            return (Criteria) this;
        }

        public Criteria andDataCreateWayGreaterThan(Short value) {
            addCriterion("DATA_CREATE_WAY >", value, "dataCreateWay");
            return (Criteria) this;
        }

        public Criteria andDataCreateWayGreaterThanOrEqualTo(Short value) {
            addCriterion("DATA_CREATE_WAY >=", value, "dataCreateWay");
            return (Criteria) this;
        }

        public Criteria andDataCreateWayLessThan(Short value) {
            addCriterion("DATA_CREATE_WAY <", value, "dataCreateWay");
            return (Criteria) this;
        }

        public Criteria andDataCreateWayLessThanOrEqualTo(Short value) {
            addCriterion("DATA_CREATE_WAY <=", value, "dataCreateWay");
            return (Criteria) this;
        }

        public Criteria andDataCreateWayIn(List<Short> values) {
            addCriterion("DATA_CREATE_WAY in", values, "dataCreateWay");
            return (Criteria) this;
        }

        public Criteria andDataCreateWayNotIn(List<Short> values) {
            addCriterion("DATA_CREATE_WAY not in", values, "dataCreateWay");
            return (Criteria) this;
        }

        public Criteria andDataCreateWayBetween(Short value1, Short value2) {
            addCriterion("DATA_CREATE_WAY between", value1, value2, "dataCreateWay");
            return (Criteria) this;
        }

        public Criteria andDataCreateWayNotBetween(Short value1, Short value2) {
            addCriterion("DATA_CREATE_WAY not between", value1, value2, "dataCreateWay");
            return (Criteria) this;
        }

        public Criteria andPreserve07IsNull() {
            addCriterion("PRESERVE07 is null");
            return (Criteria) this;
        }

        public Criteria andPreserve07IsNotNull() {
            addCriterion("PRESERVE07 is not null");
            return (Criteria) this;
        }

        public Criteria andPreserve07EqualTo(String value) {
            addCriterion("PRESERVE07 =", value, "preserve07");
            return (Criteria) this;
        }

        public Criteria andPreserve07NotEqualTo(String value) {
            addCriterion("PRESERVE07 <>", value, "preserve07");
            return (Criteria) this;
        }

        public Criteria andPreserve07GreaterThan(String value) {
            addCriterion("PRESERVE07 >", value, "preserve07");
            return (Criteria) this;
        }

        public Criteria andPreserve07GreaterThanOrEqualTo(String value) {
            addCriterion("PRESERVE07 >=", value, "preserve07");
            return (Criteria) this;
        }

        public Criteria andPreserve07LessThan(String value) {
            addCriterion("PRESERVE07 <", value, "preserve07");
            return (Criteria) this;
        }

        public Criteria andPreserve07LessThanOrEqualTo(String value) {
            addCriterion("PRESERVE07 <=", value, "preserve07");
            return (Criteria) this;
        }

        public Criteria andPreserve07Like(String value) {
            addCriterion("PRESERVE07 like", value, "preserve07");
            return (Criteria) this;
        }

        public Criteria andPreserve07NotLike(String value) {
            addCriterion("PRESERVE07 not like", value, "preserve07");
            return (Criteria) this;
        }

        public Criteria andPreserve07In(List<String> values) {
            addCriterion("PRESERVE07 in", values, "preserve07");
            return (Criteria) this;
        }

        public Criteria andPreserve07NotIn(List<String> values) {
            addCriterion("PRESERVE07 not in", values, "preserve07");
            return (Criteria) this;
        }

        public Criteria andPreserve07Between(String value1, String value2) {
            addCriterion("PRESERVE07 between", value1, value2, "preserve07");
            return (Criteria) this;
        }

        public Criteria andPreserve07NotBetween(String value1, String value2) {
            addCriterion("PRESERVE07 not between", value1, value2, "preserve07");
            return (Criteria) this;
        }

        public Criteria andPreserve15IsNull() {
            addCriterion("PRESERVE15 is null");
            return (Criteria) this;
        }

        public Criteria andPreserve15IsNotNull() {
            addCriterion("PRESERVE15 is not null");
            return (Criteria) this;
        }

        public Criteria andPreserve15EqualTo(String value) {
            addCriterion("PRESERVE15 =", value, "preserve15");
            return (Criteria) this;
        }

        public Criteria andPreserve15NotEqualTo(String value) {
            addCriterion("PRESERVE15 <>", value, "preserve15");
            return (Criteria) this;
        }

        public Criteria andPreserve15GreaterThan(String value) {
            addCriterion("PRESERVE15 >", value, "preserve15");
            return (Criteria) this;
        }

        public Criteria andPreserve15GreaterThanOrEqualTo(String value) {
            addCriterion("PRESERVE15 >=", value, "preserve15");
            return (Criteria) this;
        }

        public Criteria andPreserve15LessThan(String value) {
            addCriterion("PRESERVE15 <", value, "preserve15");
            return (Criteria) this;
        }

        public Criteria andPreserve15LessThanOrEqualTo(String value) {
            addCriterion("PRESERVE15 <=", value, "preserve15");
            return (Criteria) this;
        }

        public Criteria andPreserve15Like(String value) {
            addCriterion("PRESERVE15 like", value, "preserve15");
            return (Criteria) this;
        }

        public Criteria andPreserve15NotLike(String value) {
            addCriterion("PRESERVE15 not like", value, "preserve15");
            return (Criteria) this;
        }

        public Criteria andPreserve15In(List<String> values) {
            addCriterion("PRESERVE15 in", values, "preserve15");
            return (Criteria) this;
        }

        public Criteria andPreserve15NotIn(List<String> values) {
            addCriterion("PRESERVE15 not in", values, "preserve15");
            return (Criteria) this;
        }

        public Criteria andPreserve15Between(String value1, String value2) {
            addCriterion("PRESERVE15 between", value1, value2, "preserve15");
            return (Criteria) this;
        }

        public Criteria andPreserve15NotBetween(String value1, String value2) {
            addCriterion("PRESERVE15 not between", value1, value2, "preserve15");
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