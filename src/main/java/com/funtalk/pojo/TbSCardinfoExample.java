package com.funtalk.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbSCardinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbSCardinfoExample() {
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

        public Criteria andSeqIdIsNull() {
            addCriterion("seq_id is null");
            return (Criteria) this;
        }

        public Criteria andSeqIdIsNotNull() {
            addCriterion("seq_id is not null");
            return (Criteria) this;
        }

        public Criteria andSeqIdEqualTo(Integer value) {
            addCriterion("seq_id =", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdNotEqualTo(Integer value) {
            addCriterion("seq_id <>", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdGreaterThan(Integer value) {
            addCriterion("seq_id >", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("seq_id >=", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdLessThan(Integer value) {
            addCriterion("seq_id <", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdLessThanOrEqualTo(Integer value) {
            addCriterion("seq_id <=", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdIn(List<Integer> values) {
            addCriterion("seq_id in", values, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdNotIn(List<Integer> values) {
            addCriterion("seq_id not in", values, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdBetween(Integer value1, Integer value2) {
            addCriterion("seq_id between", value1, value2, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdNotBetween(Integer value1, Integer value2) {
            addCriterion("seq_id not between", value1, value2, "seqId");
            return (Criteria) this;
        }

        public Criteria andServiceIdIsNull() {
            addCriterion("service_id is null");
            return (Criteria) this;
        }

        public Criteria andServiceIdIsNotNull() {
            addCriterion("service_id is not null");
            return (Criteria) this;
        }

        public Criteria andServiceIdEqualTo(String value) {
            addCriterion("service_id =", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotEqualTo(String value) {
            addCriterion("service_id <>", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdGreaterThan(String value) {
            addCriterion("service_id >", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdGreaterThanOrEqualTo(String value) {
            addCriterion("service_id >=", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLessThan(String value) {
            addCriterion("service_id <", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLessThanOrEqualTo(String value) {
            addCriterion("service_id <=", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLike(String value) {
            addCriterion("service_id like", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotLike(String value) {
            addCriterion("service_id not like", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdIn(List<String> values) {
            addCriterion("service_id in", values, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotIn(List<String> values) {
            addCriterion("service_id not in", values, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdBetween(String value1, String value2) {
            addCriterion("service_id between", value1, value2, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotBetween(String value1, String value2) {
            addCriterion("service_id not between", value1, value2, "serviceId");
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

        public Criteria andIccidMasterIsNull() {
            addCriterion("iccid_master is null");
            return (Criteria) this;
        }

        public Criteria andIccidMasterIsNotNull() {
            addCriterion("iccid_master is not null");
            return (Criteria) this;
        }

        public Criteria andIccidMasterEqualTo(String value) {
            addCriterion("iccid_master =", value, "iccidMaster");
            return (Criteria) this;
        }

        public Criteria andIccidMasterNotEqualTo(String value) {
            addCriterion("iccid_master <>", value, "iccidMaster");
            return (Criteria) this;
        }

        public Criteria andIccidMasterGreaterThan(String value) {
            addCriterion("iccid_master >", value, "iccidMaster");
            return (Criteria) this;
        }

        public Criteria andIccidMasterGreaterThanOrEqualTo(String value) {
            addCriterion("iccid_master >=", value, "iccidMaster");
            return (Criteria) this;
        }

        public Criteria andIccidMasterLessThan(String value) {
            addCriterion("iccid_master <", value, "iccidMaster");
            return (Criteria) this;
        }

        public Criteria andIccidMasterLessThanOrEqualTo(String value) {
            addCriterion("iccid_master <=", value, "iccidMaster");
            return (Criteria) this;
        }

        public Criteria andIccidMasterLike(String value) {
            addCriterion("iccid_master like", value, "iccidMaster");
            return (Criteria) this;
        }

        public Criteria andIccidMasterNotLike(String value) {
            addCriterion("iccid_master not like", value, "iccidMaster");
            return (Criteria) this;
        }

        public Criteria andIccidMasterIn(List<String> values) {
            addCriterion("iccid_master in", values, "iccidMaster");
            return (Criteria) this;
        }

        public Criteria andIccidMasterNotIn(List<String> values) {
            addCriterion("iccid_master not in", values, "iccidMaster");
            return (Criteria) this;
        }

        public Criteria andIccidMasterBetween(String value1, String value2) {
            addCriterion("iccid_master between", value1, value2, "iccidMaster");
            return (Criteria) this;
        }

        public Criteria andIccidMasterNotBetween(String value1, String value2) {
            addCriterion("iccid_master not between", value1, value2, "iccidMaster");
            return (Criteria) this;
        }

        public Criteria andIccidAssistantIsNull() {
            addCriterion("iccid_assistant is null");
            return (Criteria) this;
        }

        public Criteria andIccidAssistantIsNotNull() {
            addCriterion("iccid_assistant is not null");
            return (Criteria) this;
        }

        public Criteria andIccidAssistantEqualTo(String value) {
            addCriterion("iccid_assistant =", value, "iccidAssistant");
            return (Criteria) this;
        }

        public Criteria andIccidAssistantNotEqualTo(String value) {
            addCriterion("iccid_assistant <>", value, "iccidAssistant");
            return (Criteria) this;
        }

        public Criteria andIccidAssistantGreaterThan(String value) {
            addCriterion("iccid_assistant >", value, "iccidAssistant");
            return (Criteria) this;
        }

        public Criteria andIccidAssistantGreaterThanOrEqualTo(String value) {
            addCriterion("iccid_assistant >=", value, "iccidAssistant");
            return (Criteria) this;
        }

        public Criteria andIccidAssistantLessThan(String value) {
            addCriterion("iccid_assistant <", value, "iccidAssistant");
            return (Criteria) this;
        }

        public Criteria andIccidAssistantLessThanOrEqualTo(String value) {
            addCriterion("iccid_assistant <=", value, "iccidAssistant");
            return (Criteria) this;
        }

        public Criteria andIccidAssistantLike(String value) {
            addCriterion("iccid_assistant like", value, "iccidAssistant");
            return (Criteria) this;
        }

        public Criteria andIccidAssistantNotLike(String value) {
            addCriterion("iccid_assistant not like", value, "iccidAssistant");
            return (Criteria) this;
        }

        public Criteria andIccidAssistantIn(List<String> values) {
            addCriterion("iccid_assistant in", values, "iccidAssistant");
            return (Criteria) this;
        }

        public Criteria andIccidAssistantNotIn(List<String> values) {
            addCriterion("iccid_assistant not in", values, "iccidAssistant");
            return (Criteria) this;
        }

        public Criteria andIccidAssistantBetween(String value1, String value2) {
            addCriterion("iccid_assistant between", value1, value2, "iccidAssistant");
            return (Criteria) this;
        }

        public Criteria andIccidAssistantNotBetween(String value1, String value2) {
            addCriterion("iccid_assistant not between", value1, value2, "iccidAssistant");
            return (Criteria) this;
        }

        public Criteria andIfSeedIsNull() {
            addCriterion("if_seed is null");
            return (Criteria) this;
        }

        public Criteria andIfSeedIsNotNull() {
            addCriterion("if_seed is not null");
            return (Criteria) this;
        }

        public Criteria andIfSeedEqualTo(String value) {
            addCriterion("if_seed =", value, "ifSeed");
            return (Criteria) this;
        }

        public Criteria andIfSeedNotEqualTo(String value) {
            addCriterion("if_seed <>", value, "ifSeed");
            return (Criteria) this;
        }

        public Criteria andIfSeedGreaterThan(String value) {
            addCriterion("if_seed >", value, "ifSeed");
            return (Criteria) this;
        }

        public Criteria andIfSeedGreaterThanOrEqualTo(String value) {
            addCriterion("if_seed >=", value, "ifSeed");
            return (Criteria) this;
        }

        public Criteria andIfSeedLessThan(String value) {
            addCriterion("if_seed <", value, "ifSeed");
            return (Criteria) this;
        }

        public Criteria andIfSeedLessThanOrEqualTo(String value) {
            addCriterion("if_seed <=", value, "ifSeed");
            return (Criteria) this;
        }

        public Criteria andIfSeedLike(String value) {
            addCriterion("if_seed like", value, "ifSeed");
            return (Criteria) this;
        }

        public Criteria andIfSeedNotLike(String value) {
            addCriterion("if_seed not like", value, "ifSeed");
            return (Criteria) this;
        }

        public Criteria andIfSeedIn(List<String> values) {
            addCriterion("if_seed in", values, "ifSeed");
            return (Criteria) this;
        }

        public Criteria andIfSeedNotIn(List<String> values) {
            addCriterion("if_seed not in", values, "ifSeed");
            return (Criteria) this;
        }

        public Criteria andIfSeedBetween(String value1, String value2) {
            addCriterion("if_seed between", value1, value2, "ifSeed");
            return (Criteria) this;
        }

        public Criteria andIfSeedNotBetween(String value1, String value2) {
            addCriterion("if_seed not between", value1, value2, "ifSeed");
            return (Criteria) this;
        }

        public Criteria andSeedIccidIsNull() {
            addCriterion("seed_iccid is null");
            return (Criteria) this;
        }

        public Criteria andSeedIccidIsNotNull() {
            addCriterion("seed_iccid is not null");
            return (Criteria) this;
        }

        public Criteria andSeedIccidEqualTo(String value) {
            addCriterion("seed_iccid =", value, "seedIccid");
            return (Criteria) this;
        }

        public Criteria andSeedIccidNotEqualTo(String value) {
            addCriterion("seed_iccid <>", value, "seedIccid");
            return (Criteria) this;
        }

        public Criteria andSeedIccidGreaterThan(String value) {
            addCriterion("seed_iccid >", value, "seedIccid");
            return (Criteria) this;
        }

        public Criteria andSeedIccidGreaterThanOrEqualTo(String value) {
            addCriterion("seed_iccid >=", value, "seedIccid");
            return (Criteria) this;
        }

        public Criteria andSeedIccidLessThan(String value) {
            addCriterion("seed_iccid <", value, "seedIccid");
            return (Criteria) this;
        }

        public Criteria andSeedIccidLessThanOrEqualTo(String value) {
            addCriterion("seed_iccid <=", value, "seedIccid");
            return (Criteria) this;
        }

        public Criteria andSeedIccidLike(String value) {
            addCriterion("seed_iccid like", value, "seedIccid");
            return (Criteria) this;
        }

        public Criteria andSeedIccidNotLike(String value) {
            addCriterion("seed_iccid not like", value, "seedIccid");
            return (Criteria) this;
        }

        public Criteria andSeedIccidIn(List<String> values) {
            addCriterion("seed_iccid in", values, "seedIccid");
            return (Criteria) this;
        }

        public Criteria andSeedIccidNotIn(List<String> values) {
            addCriterion("seed_iccid not in", values, "seedIccid");
            return (Criteria) this;
        }

        public Criteria andSeedIccidBetween(String value1, String value2) {
            addCriterion("seed_iccid between", value1, value2, "seedIccid");
            return (Criteria) this;
        }

        public Criteria andSeedIccidNotBetween(String value1, String value2) {
            addCriterion("seed_iccid not between", value1, value2, "seedIccid");
            return (Criteria) this;
        }

        public Criteria andSeedDataIsNull() {
            addCriterion("seed_data is null");
            return (Criteria) this;
        }

        public Criteria andSeedDataIsNotNull() {
            addCriterion("seed_data is not null");
            return (Criteria) this;
        }

        public Criteria andSeedDataEqualTo(String value) {
            addCriterion("seed_data =", value, "seedData");
            return (Criteria) this;
        }

        public Criteria andSeedDataNotEqualTo(String value) {
            addCriterion("seed_data <>", value, "seedData");
            return (Criteria) this;
        }

        public Criteria andSeedDataGreaterThan(String value) {
            addCriterion("seed_data >", value, "seedData");
            return (Criteria) this;
        }

        public Criteria andSeedDataGreaterThanOrEqualTo(String value) {
            addCriterion("seed_data >=", value, "seedData");
            return (Criteria) this;
        }

        public Criteria andSeedDataLessThan(String value) {
            addCriterion("seed_data <", value, "seedData");
            return (Criteria) this;
        }

        public Criteria andSeedDataLessThanOrEqualTo(String value) {
            addCriterion("seed_data <=", value, "seedData");
            return (Criteria) this;
        }

        public Criteria andSeedDataLike(String value) {
            addCriterion("seed_data like", value, "seedData");
            return (Criteria) this;
        }

        public Criteria andSeedDataNotLike(String value) {
            addCriterion("seed_data not like", value, "seedData");
            return (Criteria) this;
        }

        public Criteria andSeedDataIn(List<String> values) {
            addCriterion("seed_data in", values, "seedData");
            return (Criteria) this;
        }

        public Criteria andSeedDataNotIn(List<String> values) {
            addCriterion("seed_data not in", values, "seedData");
            return (Criteria) this;
        }

        public Criteria andSeedDataBetween(String value1, String value2) {
            addCriterion("seed_data between", value1, value2, "seedData");
            return (Criteria) this;
        }

        public Criteria andSeedDataNotBetween(String value1, String value2) {
            addCriterion("seed_data not between", value1, value2, "seedData");
            return (Criteria) this;
        }

        public Criteria andData1IsNull() {
            addCriterion("data1 is null");
            return (Criteria) this;
        }

        public Criteria andData1IsNotNull() {
            addCriterion("data1 is not null");
            return (Criteria) this;
        }

        public Criteria andData1EqualTo(String value) {
            addCriterion("data1 =", value, "data1");
            return (Criteria) this;
        }

        public Criteria andData1NotEqualTo(String value) {
            addCriterion("data1 <>", value, "data1");
            return (Criteria) this;
        }

        public Criteria andData1GreaterThan(String value) {
            addCriterion("data1 >", value, "data1");
            return (Criteria) this;
        }

        public Criteria andData1GreaterThanOrEqualTo(String value) {
            addCriterion("data1 >=", value, "data1");
            return (Criteria) this;
        }

        public Criteria andData1LessThan(String value) {
            addCriterion("data1 <", value, "data1");
            return (Criteria) this;
        }

        public Criteria andData1LessThanOrEqualTo(String value) {
            addCriterion("data1 <=", value, "data1");
            return (Criteria) this;
        }

        public Criteria andData1Like(String value) {
            addCriterion("data1 like", value, "data1");
            return (Criteria) this;
        }

        public Criteria andData1NotLike(String value) {
            addCriterion("data1 not like", value, "data1");
            return (Criteria) this;
        }

        public Criteria andData1In(List<String> values) {
            addCriterion("data1 in", values, "data1");
            return (Criteria) this;
        }

        public Criteria andData1NotIn(List<String> values) {
            addCriterion("data1 not in", values, "data1");
            return (Criteria) this;
        }

        public Criteria andData1Between(String value1, String value2) {
            addCriterion("data1 between", value1, value2, "data1");
            return (Criteria) this;
        }

        public Criteria andData1NotBetween(String value1, String value2) {
            addCriterion("data1 not between", value1, value2, "data1");
            return (Criteria) this;
        }

        public Criteria andData2IsNull() {
            addCriterion("data2 is null");
            return (Criteria) this;
        }

        public Criteria andData2IsNotNull() {
            addCriterion("data2 is not null");
            return (Criteria) this;
        }

        public Criteria andData2EqualTo(String value) {
            addCriterion("data2 =", value, "data2");
            return (Criteria) this;
        }

        public Criteria andData2NotEqualTo(String value) {
            addCriterion("data2 <>", value, "data2");
            return (Criteria) this;
        }

        public Criteria andData2GreaterThan(String value) {
            addCriterion("data2 >", value, "data2");
            return (Criteria) this;
        }

        public Criteria andData2GreaterThanOrEqualTo(String value) {
            addCriterion("data2 >=", value, "data2");
            return (Criteria) this;
        }

        public Criteria andData2LessThan(String value) {
            addCriterion("data2 <", value, "data2");
            return (Criteria) this;
        }

        public Criteria andData2LessThanOrEqualTo(String value) {
            addCriterion("data2 <=", value, "data2");
            return (Criteria) this;
        }

        public Criteria andData2Like(String value) {
            addCriterion("data2 like", value, "data2");
            return (Criteria) this;
        }

        public Criteria andData2NotLike(String value) {
            addCriterion("data2 not like", value, "data2");
            return (Criteria) this;
        }

        public Criteria andData2In(List<String> values) {
            addCriterion("data2 in", values, "data2");
            return (Criteria) this;
        }

        public Criteria andData2NotIn(List<String> values) {
            addCriterion("data2 not in", values, "data2");
            return (Criteria) this;
        }

        public Criteria andData2Between(String value1, String value2) {
            addCriterion("data2 between", value1, value2, "data2");
            return (Criteria) this;
        }

        public Criteria andData2NotBetween(String value1, String value2) {
            addCriterion("data2 not between", value1, value2, "data2");
            return (Criteria) this;
        }

        public Criteria andData3IsNull() {
            addCriterion("data3 is null");
            return (Criteria) this;
        }

        public Criteria andData3IsNotNull() {
            addCriterion("data3 is not null");
            return (Criteria) this;
        }

        public Criteria andData3EqualTo(String value) {
            addCriterion("data3 =", value, "data3");
            return (Criteria) this;
        }

        public Criteria andData3NotEqualTo(String value) {
            addCriterion("data3 <>", value, "data3");
            return (Criteria) this;
        }

        public Criteria andData3GreaterThan(String value) {
            addCriterion("data3 >", value, "data3");
            return (Criteria) this;
        }

        public Criteria andData3GreaterThanOrEqualTo(String value) {
            addCriterion("data3 >=", value, "data3");
            return (Criteria) this;
        }

        public Criteria andData3LessThan(String value) {
            addCriterion("data3 <", value, "data3");
            return (Criteria) this;
        }

        public Criteria andData3LessThanOrEqualTo(String value) {
            addCriterion("data3 <=", value, "data3");
            return (Criteria) this;
        }

        public Criteria andData3Like(String value) {
            addCriterion("data3 like", value, "data3");
            return (Criteria) this;
        }

        public Criteria andData3NotLike(String value) {
            addCriterion("data3 not like", value, "data3");
            return (Criteria) this;
        }

        public Criteria andData3In(List<String> values) {
            addCriterion("data3 in", values, "data3");
            return (Criteria) this;
        }

        public Criteria andData3NotIn(List<String> values) {
            addCriterion("data3 not in", values, "data3");
            return (Criteria) this;
        }

        public Criteria andData3Between(String value1, String value2) {
            addCriterion("data3 between", value1, value2, "data3");
            return (Criteria) this;
        }

        public Criteria andData3NotBetween(String value1, String value2) {
            addCriterion("data3 not between", value1, value2, "data3");
            return (Criteria) this;
        }

        public Criteria andData4IsNull() {
            addCriterion("data4 is null");
            return (Criteria) this;
        }

        public Criteria andData4IsNotNull() {
            addCriterion("data4 is not null");
            return (Criteria) this;
        }

        public Criteria andData4EqualTo(String value) {
            addCriterion("data4 =", value, "data4");
            return (Criteria) this;
        }

        public Criteria andData4NotEqualTo(String value) {
            addCriterion("data4 <>", value, "data4");
            return (Criteria) this;
        }

        public Criteria andData4GreaterThan(String value) {
            addCriterion("data4 >", value, "data4");
            return (Criteria) this;
        }

        public Criteria andData4GreaterThanOrEqualTo(String value) {
            addCriterion("data4 >=", value, "data4");
            return (Criteria) this;
        }

        public Criteria andData4LessThan(String value) {
            addCriterion("data4 <", value, "data4");
            return (Criteria) this;
        }

        public Criteria andData4LessThanOrEqualTo(String value) {
            addCriterion("data4 <=", value, "data4");
            return (Criteria) this;
        }

        public Criteria andData4Like(String value) {
            addCriterion("data4 like", value, "data4");
            return (Criteria) this;
        }

        public Criteria andData4NotLike(String value) {
            addCriterion("data4 not like", value, "data4");
            return (Criteria) this;
        }

        public Criteria andData4In(List<String> values) {
            addCriterion("data4 in", values, "data4");
            return (Criteria) this;
        }

        public Criteria andData4NotIn(List<String> values) {
            addCriterion("data4 not in", values, "data4");
            return (Criteria) this;
        }

        public Criteria andData4Between(String value1, String value2) {
            addCriterion("data4 between", value1, value2, "data4");
            return (Criteria) this;
        }

        public Criteria andData4NotBetween(String value1, String value2) {
            addCriterion("data4 not between", value1, value2, "data4");
            return (Criteria) this;
        }

        public Criteria andData5IsNull() {
            addCriterion("data5 is null");
            return (Criteria) this;
        }

        public Criteria andData5IsNotNull() {
            addCriterion("data5 is not null");
            return (Criteria) this;
        }

        public Criteria andData5EqualTo(String value) {
            addCriterion("data5 =", value, "data5");
            return (Criteria) this;
        }

        public Criteria andData5NotEqualTo(String value) {
            addCriterion("data5 <>", value, "data5");
            return (Criteria) this;
        }

        public Criteria andData5GreaterThan(String value) {
            addCriterion("data5 >", value, "data5");
            return (Criteria) this;
        }

        public Criteria andData5GreaterThanOrEqualTo(String value) {
            addCriterion("data5 >=", value, "data5");
            return (Criteria) this;
        }

        public Criteria andData5LessThan(String value) {
            addCriterion("data5 <", value, "data5");
            return (Criteria) this;
        }

        public Criteria andData5LessThanOrEqualTo(String value) {
            addCriterion("data5 <=", value, "data5");
            return (Criteria) this;
        }

        public Criteria andData5Like(String value) {
            addCriterion("data5 like", value, "data5");
            return (Criteria) this;
        }

        public Criteria andData5NotLike(String value) {
            addCriterion("data5 not like", value, "data5");
            return (Criteria) this;
        }

        public Criteria andData5In(List<String> values) {
            addCriterion("data5 in", values, "data5");
            return (Criteria) this;
        }

        public Criteria andData5NotIn(List<String> values) {
            addCriterion("data5 not in", values, "data5");
            return (Criteria) this;
        }

        public Criteria andData5Between(String value1, String value2) {
            addCriterion("data5 between", value1, value2, "data5");
            return (Criteria) this;
        }

        public Criteria andData5NotBetween(String value1, String value2) {
            addCriterion("data5 not between", value1, value2, "data5");
            return (Criteria) this;
        }

        public Criteria andData6IsNull() {
            addCriterion("data6 is null");
            return (Criteria) this;
        }

        public Criteria andData6IsNotNull() {
            addCriterion("data6 is not null");
            return (Criteria) this;
        }

        public Criteria andData6EqualTo(String value) {
            addCriterion("data6 =", value, "data6");
            return (Criteria) this;
        }

        public Criteria andData6NotEqualTo(String value) {
            addCriterion("data6 <>", value, "data6");
            return (Criteria) this;
        }

        public Criteria andData6GreaterThan(String value) {
            addCriterion("data6 >", value, "data6");
            return (Criteria) this;
        }

        public Criteria andData6GreaterThanOrEqualTo(String value) {
            addCriterion("data6 >=", value, "data6");
            return (Criteria) this;
        }

        public Criteria andData6LessThan(String value) {
            addCriterion("data6 <", value, "data6");
            return (Criteria) this;
        }

        public Criteria andData6LessThanOrEqualTo(String value) {
            addCriterion("data6 <=", value, "data6");
            return (Criteria) this;
        }

        public Criteria andData6Like(String value) {
            addCriterion("data6 like", value, "data6");
            return (Criteria) this;
        }

        public Criteria andData6NotLike(String value) {
            addCriterion("data6 not like", value, "data6");
            return (Criteria) this;
        }

        public Criteria andData6In(List<String> values) {
            addCriterion("data6 in", values, "data6");
            return (Criteria) this;
        }

        public Criteria andData6NotIn(List<String> values) {
            addCriterion("data6 not in", values, "data6");
            return (Criteria) this;
        }

        public Criteria andData6Between(String value1, String value2) {
            addCriterion("data6 between", value1, value2, "data6");
            return (Criteria) this;
        }

        public Criteria andData6NotBetween(String value1, String value2) {
            addCriterion("data6 not between", value1, value2, "data6");
            return (Criteria) this;
        }

        public Criteria andData7IsNull() {
            addCriterion("data7 is null");
            return (Criteria) this;
        }

        public Criteria andData7IsNotNull() {
            addCriterion("data7 is not null");
            return (Criteria) this;
        }

        public Criteria andData7EqualTo(String value) {
            addCriterion("data7 =", value, "data7");
            return (Criteria) this;
        }

        public Criteria andData7NotEqualTo(String value) {
            addCriterion("data7 <>", value, "data7");
            return (Criteria) this;
        }

        public Criteria andData7GreaterThan(String value) {
            addCriterion("data7 >", value, "data7");
            return (Criteria) this;
        }

        public Criteria andData7GreaterThanOrEqualTo(String value) {
            addCriterion("data7 >=", value, "data7");
            return (Criteria) this;
        }

        public Criteria andData7LessThan(String value) {
            addCriterion("data7 <", value, "data7");
            return (Criteria) this;
        }

        public Criteria andData7LessThanOrEqualTo(String value) {
            addCriterion("data7 <=", value, "data7");
            return (Criteria) this;
        }

        public Criteria andData7Like(String value) {
            addCriterion("data7 like", value, "data7");
            return (Criteria) this;
        }

        public Criteria andData7NotLike(String value) {
            addCriterion("data7 not like", value, "data7");
            return (Criteria) this;
        }

        public Criteria andData7In(List<String> values) {
            addCriterion("data7 in", values, "data7");
            return (Criteria) this;
        }

        public Criteria andData7NotIn(List<String> values) {
            addCriterion("data7 not in", values, "data7");
            return (Criteria) this;
        }

        public Criteria andData7Between(String value1, String value2) {
            addCriterion("data7 between", value1, value2, "data7");
            return (Criteria) this;
        }

        public Criteria andData7NotBetween(String value1, String value2) {
            addCriterion("data7 not between", value1, value2, "data7");
            return (Criteria) this;
        }

        public Criteria andData8IsNull() {
            addCriterion("data8 is null");
            return (Criteria) this;
        }

        public Criteria andData8IsNotNull() {
            addCriterion("data8 is not null");
            return (Criteria) this;
        }

        public Criteria andData8EqualTo(String value) {
            addCriterion("data8 =", value, "data8");
            return (Criteria) this;
        }

        public Criteria andData8NotEqualTo(String value) {
            addCriterion("data8 <>", value, "data8");
            return (Criteria) this;
        }

        public Criteria andData8GreaterThan(String value) {
            addCriterion("data8 >", value, "data8");
            return (Criteria) this;
        }

        public Criteria andData8GreaterThanOrEqualTo(String value) {
            addCriterion("data8 >=", value, "data8");
            return (Criteria) this;
        }

        public Criteria andData8LessThan(String value) {
            addCriterion("data8 <", value, "data8");
            return (Criteria) this;
        }

        public Criteria andData8LessThanOrEqualTo(String value) {
            addCriterion("data8 <=", value, "data8");
            return (Criteria) this;
        }

        public Criteria andData8Like(String value) {
            addCriterion("data8 like", value, "data8");
            return (Criteria) this;
        }

        public Criteria andData8NotLike(String value) {
            addCriterion("data8 not like", value, "data8");
            return (Criteria) this;
        }

        public Criteria andData8In(List<String> values) {
            addCriterion("data8 in", values, "data8");
            return (Criteria) this;
        }

        public Criteria andData8NotIn(List<String> values) {
            addCriterion("data8 not in", values, "data8");
            return (Criteria) this;
        }

        public Criteria andData8Between(String value1, String value2) {
            addCriterion("data8 between", value1, value2, "data8");
            return (Criteria) this;
        }

        public Criteria andData8NotBetween(String value1, String value2) {
            addCriterion("data8 not between", value1, value2, "data8");
            return (Criteria) this;
        }

        public Criteria andData9IsNull() {
            addCriterion("data9 is null");
            return (Criteria) this;
        }

        public Criteria andData9IsNotNull() {
            addCriterion("data9 is not null");
            return (Criteria) this;
        }

        public Criteria andData9EqualTo(String value) {
            addCriterion("data9 =", value, "data9");
            return (Criteria) this;
        }

        public Criteria andData9NotEqualTo(String value) {
            addCriterion("data9 <>", value, "data9");
            return (Criteria) this;
        }

        public Criteria andData9GreaterThan(String value) {
            addCriterion("data9 >", value, "data9");
            return (Criteria) this;
        }

        public Criteria andData9GreaterThanOrEqualTo(String value) {
            addCriterion("data9 >=", value, "data9");
            return (Criteria) this;
        }

        public Criteria andData9LessThan(String value) {
            addCriterion("data9 <", value, "data9");
            return (Criteria) this;
        }

        public Criteria andData9LessThanOrEqualTo(String value) {
            addCriterion("data9 <=", value, "data9");
            return (Criteria) this;
        }

        public Criteria andData9Like(String value) {
            addCriterion("data9 like", value, "data9");
            return (Criteria) this;
        }

        public Criteria andData9NotLike(String value) {
            addCriterion("data9 not like", value, "data9");
            return (Criteria) this;
        }

        public Criteria andData9In(List<String> values) {
            addCriterion("data9 in", values, "data9");
            return (Criteria) this;
        }

        public Criteria andData9NotIn(List<String> values) {
            addCriterion("data9 not in", values, "data9");
            return (Criteria) this;
        }

        public Criteria andData9Between(String value1, String value2) {
            addCriterion("data9 between", value1, value2, "data9");
            return (Criteria) this;
        }

        public Criteria andData9NotBetween(String value1, String value2) {
            addCriterion("data9 not between", value1, value2, "data9");
            return (Criteria) this;
        }

        public Criteria andData10IsNull() {
            addCriterion("data10 is null");
            return (Criteria) this;
        }

        public Criteria andData10IsNotNull() {
            addCriterion("data10 is not null");
            return (Criteria) this;
        }

        public Criteria andData10EqualTo(String value) {
            addCriterion("data10 =", value, "data10");
            return (Criteria) this;
        }

        public Criteria andData10NotEqualTo(String value) {
            addCriterion("data10 <>", value, "data10");
            return (Criteria) this;
        }

        public Criteria andData10GreaterThan(String value) {
            addCriterion("data10 >", value, "data10");
            return (Criteria) this;
        }

        public Criteria andData10GreaterThanOrEqualTo(String value) {
            addCriterion("data10 >=", value, "data10");
            return (Criteria) this;
        }

        public Criteria andData10LessThan(String value) {
            addCriterion("data10 <", value, "data10");
            return (Criteria) this;
        }

        public Criteria andData10LessThanOrEqualTo(String value) {
            addCriterion("data10 <=", value, "data10");
            return (Criteria) this;
        }

        public Criteria andData10Like(String value) {
            addCriterion("data10 like", value, "data10");
            return (Criteria) this;
        }

        public Criteria andData10NotLike(String value) {
            addCriterion("data10 not like", value, "data10");
            return (Criteria) this;
        }

        public Criteria andData10In(List<String> values) {
            addCriterion("data10 in", values, "data10");
            return (Criteria) this;
        }

        public Criteria andData10NotIn(List<String> values) {
            addCriterion("data10 not in", values, "data10");
            return (Criteria) this;
        }

        public Criteria andData10Between(String value1, String value2) {
            addCriterion("data10 between", value1, value2, "data10");
            return (Criteria) this;
        }

        public Criteria andData10NotBetween(String value1, String value2) {
            addCriterion("data10 not between", value1, value2, "data10");
            return (Criteria) this;
        }

        public Criteria andChangeDataIsNull() {
            addCriterion("change_data is null");
            return (Criteria) this;
        }

        public Criteria andChangeDataIsNotNull() {
            addCriterion("change_data is not null");
            return (Criteria) this;
        }

        public Criteria andChangeDataEqualTo(String value) {
            addCriterion("change_data =", value, "changeData");
            return (Criteria) this;
        }

        public Criteria andChangeDataNotEqualTo(String value) {
            addCriterion("change_data <>", value, "changeData");
            return (Criteria) this;
        }

        public Criteria andChangeDataGreaterThan(String value) {
            addCriterion("change_data >", value, "changeData");
            return (Criteria) this;
        }

        public Criteria andChangeDataGreaterThanOrEqualTo(String value) {
            addCriterion("change_data >=", value, "changeData");
            return (Criteria) this;
        }

        public Criteria andChangeDataLessThan(String value) {
            addCriterion("change_data <", value, "changeData");
            return (Criteria) this;
        }

        public Criteria andChangeDataLessThanOrEqualTo(String value) {
            addCriterion("change_data <=", value, "changeData");
            return (Criteria) this;
        }

        public Criteria andChangeDataLike(String value) {
            addCriterion("change_data like", value, "changeData");
            return (Criteria) this;
        }

        public Criteria andChangeDataNotLike(String value) {
            addCriterion("change_data not like", value, "changeData");
            return (Criteria) this;
        }

        public Criteria andChangeDataIn(List<String> values) {
            addCriterion("change_data in", values, "changeData");
            return (Criteria) this;
        }

        public Criteria andChangeDataNotIn(List<String> values) {
            addCriterion("change_data not in", values, "changeData");
            return (Criteria) this;
        }

        public Criteria andChangeDataBetween(String value1, String value2) {
            addCriterion("change_data between", value1, value2, "changeData");
            return (Criteria) this;
        }

        public Criteria andChangeDataNotBetween(String value1, String value2) {
            addCriterion("change_data not between", value1, value2, "changeData");
            return (Criteria) this;
        }

        public Criteria andDeleteDataIsNull() {
            addCriterion("delete_data is null");
            return (Criteria) this;
        }

        public Criteria andDeleteDataIsNotNull() {
            addCriterion("delete_data is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteDataEqualTo(String value) {
            addCriterion("delete_data =", value, "deleteData");
            return (Criteria) this;
        }

        public Criteria andDeleteDataNotEqualTo(String value) {
            addCriterion("delete_data <>", value, "deleteData");
            return (Criteria) this;
        }

        public Criteria andDeleteDataGreaterThan(String value) {
            addCriterion("delete_data >", value, "deleteData");
            return (Criteria) this;
        }

        public Criteria andDeleteDataGreaterThanOrEqualTo(String value) {
            addCriterion("delete_data >=", value, "deleteData");
            return (Criteria) this;
        }

        public Criteria andDeleteDataLessThan(String value) {
            addCriterion("delete_data <", value, "deleteData");
            return (Criteria) this;
        }

        public Criteria andDeleteDataLessThanOrEqualTo(String value) {
            addCriterion("delete_data <=", value, "deleteData");
            return (Criteria) this;
        }

        public Criteria andDeleteDataLike(String value) {
            addCriterion("delete_data like", value, "deleteData");
            return (Criteria) this;
        }

        public Criteria andDeleteDataNotLike(String value) {
            addCriterion("delete_data not like", value, "deleteData");
            return (Criteria) this;
        }

        public Criteria andDeleteDataIn(List<String> values) {
            addCriterion("delete_data in", values, "deleteData");
            return (Criteria) this;
        }

        public Criteria andDeleteDataNotIn(List<String> values) {
            addCriterion("delete_data not in", values, "deleteData");
            return (Criteria) this;
        }

        public Criteria andDeleteDataBetween(String value1, String value2) {
            addCriterion("delete_data between", value1, value2, "deleteData");
            return (Criteria) this;
        }

        public Criteria andDeleteDataNotBetween(String value1, String value2) {
            addCriterion("delete_data not between", value1, value2, "deleteData");
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

        public Criteria andIfUseIsNull() {
            addCriterion("if_use is null");
            return (Criteria) this;
        }

        public Criteria andIfUseIsNotNull() {
            addCriterion("if_use is not null");
            return (Criteria) this;
        }

        public Criteria andIfUseEqualTo(String value) {
            addCriterion("if_use =", value, "ifUse");
            return (Criteria) this;
        }

        public Criteria andIfUseNotEqualTo(String value) {
            addCriterion("if_use <>", value, "ifUse");
            return (Criteria) this;
        }

        public Criteria andIfUseGreaterThan(String value) {
            addCriterion("if_use >", value, "ifUse");
            return (Criteria) this;
        }

        public Criteria andIfUseGreaterThanOrEqualTo(String value) {
            addCriterion("if_use >=", value, "ifUse");
            return (Criteria) this;
        }

        public Criteria andIfUseLessThan(String value) {
            addCriterion("if_use <", value, "ifUse");
            return (Criteria) this;
        }

        public Criteria andIfUseLessThanOrEqualTo(String value) {
            addCriterion("if_use <=", value, "ifUse");
            return (Criteria) this;
        }

        public Criteria andIfUseLike(String value) {
            addCriterion("if_use like", value, "ifUse");
            return (Criteria) this;
        }

        public Criteria andIfUseNotLike(String value) {
            addCriterion("if_use not like", value, "ifUse");
            return (Criteria) this;
        }

        public Criteria andIfUseIn(List<String> values) {
            addCriterion("if_use in", values, "ifUse");
            return (Criteria) this;
        }

        public Criteria andIfUseNotIn(List<String> values) {
            addCriterion("if_use not in", values, "ifUse");
            return (Criteria) this;
        }

        public Criteria andIfUseBetween(String value1, String value2) {
            addCriterion("if_use between", value1, value2, "ifUse");
            return (Criteria) this;
        }

        public Criteria andIfUseNotBetween(String value1, String value2) {
            addCriterion("if_use not between", value1, value2, "ifUse");
            return (Criteria) this;
        }

        public Criteria andDayUseIsNull() {
            addCriterion("day_use is null");
            return (Criteria) this;
        }

        public Criteria andDayUseIsNotNull() {
            addCriterion("day_use is not null");
            return (Criteria) this;
        }

        public Criteria andDayUseEqualTo(Integer value) {
            addCriterion("day_use =", value, "dayUse");
            return (Criteria) this;
        }

        public Criteria andDayUseNotEqualTo(Integer value) {
            addCriterion("day_use <>", value, "dayUse");
            return (Criteria) this;
        }

        public Criteria andDayUseGreaterThan(Integer value) {
            addCriterion("day_use >", value, "dayUse");
            return (Criteria) this;
        }

        public Criteria andDayUseGreaterThanOrEqualTo(Integer value) {
            addCriterion("day_use >=", value, "dayUse");
            return (Criteria) this;
        }

        public Criteria andDayUseLessThan(Integer value) {
            addCriterion("day_use <", value, "dayUse");
            return (Criteria) this;
        }

        public Criteria andDayUseLessThanOrEqualTo(Integer value) {
            addCriterion("day_use <=", value, "dayUse");
            return (Criteria) this;
        }

        public Criteria andDayUseIn(List<Integer> values) {
            addCriterion("day_use in", values, "dayUse");
            return (Criteria) this;
        }

        public Criteria andDayUseNotIn(List<Integer> values) {
            addCriterion("day_use not in", values, "dayUse");
            return (Criteria) this;
        }

        public Criteria andDayUseBetween(Integer value1, Integer value2) {
            addCriterion("day_use between", value1, value2, "dayUse");
            return (Criteria) this;
        }

        public Criteria andDayUseNotBetween(Integer value1, Integer value2) {
            addCriterion("day_use not between", value1, value2, "dayUse");
            return (Criteria) this;
        }

        public Criteria andDayTotalIsNull() {
            addCriterion("day_total is null");
            return (Criteria) this;
        }

        public Criteria andDayTotalIsNotNull() {
            addCriterion("day_total is not null");
            return (Criteria) this;
        }

        public Criteria andDayTotalEqualTo(Integer value) {
            addCriterion("day_total =", value, "dayTotal");
            return (Criteria) this;
        }

        public Criteria andDayTotalNotEqualTo(Integer value) {
            addCriterion("day_total <>", value, "dayTotal");
            return (Criteria) this;
        }

        public Criteria andDayTotalGreaterThan(Integer value) {
            addCriterion("day_total >", value, "dayTotal");
            return (Criteria) this;
        }

        public Criteria andDayTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("day_total >=", value, "dayTotal");
            return (Criteria) this;
        }

        public Criteria andDayTotalLessThan(Integer value) {
            addCriterion("day_total <", value, "dayTotal");
            return (Criteria) this;
        }

        public Criteria andDayTotalLessThanOrEqualTo(Integer value) {
            addCriterion("day_total <=", value, "dayTotal");
            return (Criteria) this;
        }

        public Criteria andDayTotalIn(List<Integer> values) {
            addCriterion("day_total in", values, "dayTotal");
            return (Criteria) this;
        }

        public Criteria andDayTotalNotIn(List<Integer> values) {
            addCriterion("day_total not in", values, "dayTotal");
            return (Criteria) this;
        }

        public Criteria andDayTotalBetween(Integer value1, Integer value2) {
            addCriterion("day_total between", value1, value2, "dayTotal");
            return (Criteria) this;
        }

        public Criteria andDayTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("day_total not between", value1, value2, "dayTotal");
            return (Criteria) this;
        }

        public Criteria andMonthUseIsNull() {
            addCriterion("month_use is null");
            return (Criteria) this;
        }

        public Criteria andMonthUseIsNotNull() {
            addCriterion("month_use is not null");
            return (Criteria) this;
        }

        public Criteria andMonthUseEqualTo(Integer value) {
            addCriterion("month_use =", value, "monthUse");
            return (Criteria) this;
        }

        public Criteria andMonthUseNotEqualTo(Integer value) {
            addCriterion("month_use <>", value, "monthUse");
            return (Criteria) this;
        }

        public Criteria andMonthUseGreaterThan(Integer value) {
            addCriterion("month_use >", value, "monthUse");
            return (Criteria) this;
        }

        public Criteria andMonthUseGreaterThanOrEqualTo(Integer value) {
            addCriterion("month_use >=", value, "monthUse");
            return (Criteria) this;
        }

        public Criteria andMonthUseLessThan(Integer value) {
            addCriterion("month_use <", value, "monthUse");
            return (Criteria) this;
        }

        public Criteria andMonthUseLessThanOrEqualTo(Integer value) {
            addCriterion("month_use <=", value, "monthUse");
            return (Criteria) this;
        }

        public Criteria andMonthUseIn(List<Integer> values) {
            addCriterion("month_use in", values, "monthUse");
            return (Criteria) this;
        }

        public Criteria andMonthUseNotIn(List<Integer> values) {
            addCriterion("month_use not in", values, "monthUse");
            return (Criteria) this;
        }

        public Criteria andMonthUseBetween(Integer value1, Integer value2) {
            addCriterion("month_use between", value1, value2, "monthUse");
            return (Criteria) this;
        }

        public Criteria andMonthUseNotBetween(Integer value1, Integer value2) {
            addCriterion("month_use not between", value1, value2, "monthUse");
            return (Criteria) this;
        }

        public Criteria andMonthTotalIsNull() {
            addCriterion("month_total is null");
            return (Criteria) this;
        }

        public Criteria andMonthTotalIsNotNull() {
            addCriterion("month_total is not null");
            return (Criteria) this;
        }

        public Criteria andMonthTotalEqualTo(Integer value) {
            addCriterion("month_total =", value, "monthTotal");
            return (Criteria) this;
        }

        public Criteria andMonthTotalNotEqualTo(Integer value) {
            addCriterion("month_total <>", value, "monthTotal");
            return (Criteria) this;
        }

        public Criteria andMonthTotalGreaterThan(Integer value) {
            addCriterion("month_total >", value, "monthTotal");
            return (Criteria) this;
        }

        public Criteria andMonthTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("month_total >=", value, "monthTotal");
            return (Criteria) this;
        }

        public Criteria andMonthTotalLessThan(Integer value) {
            addCriterion("month_total <", value, "monthTotal");
            return (Criteria) this;
        }

        public Criteria andMonthTotalLessThanOrEqualTo(Integer value) {
            addCriterion("month_total <=", value, "monthTotal");
            return (Criteria) this;
        }

        public Criteria andMonthTotalIn(List<Integer> values) {
            addCriterion("month_total in", values, "monthTotal");
            return (Criteria) this;
        }

        public Criteria andMonthTotalNotIn(List<Integer> values) {
            addCriterion("month_total not in", values, "monthTotal");
            return (Criteria) this;
        }

        public Criteria andMonthTotalBetween(Integer value1, Integer value2) {
            addCriterion("month_total between", value1, value2, "monthTotal");
            return (Criteria) this;
        }

        public Criteria andMonthTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("month_total not between", value1, value2, "monthTotal");
            return (Criteria) this;
        }

        public Criteria andBelongSeedIsNull() {
            addCriterion("belong_seed is null");
            return (Criteria) this;
        }

        public Criteria andBelongSeedIsNotNull() {
            addCriterion("belong_seed is not null");
            return (Criteria) this;
        }

        public Criteria andBelongSeedEqualTo(String value) {
            addCriterion("belong_seed =", value, "belongSeed");
            return (Criteria) this;
        }

        public Criteria andBelongSeedNotEqualTo(String value) {
            addCriterion("belong_seed <>", value, "belongSeed");
            return (Criteria) this;
        }

        public Criteria andBelongSeedGreaterThan(String value) {
            addCriterion("belong_seed >", value, "belongSeed");
            return (Criteria) this;
        }

        public Criteria andBelongSeedGreaterThanOrEqualTo(String value) {
            addCriterion("belong_seed >=", value, "belongSeed");
            return (Criteria) this;
        }

        public Criteria andBelongSeedLessThan(String value) {
            addCriterion("belong_seed <", value, "belongSeed");
            return (Criteria) this;
        }

        public Criteria andBelongSeedLessThanOrEqualTo(String value) {
            addCriterion("belong_seed <=", value, "belongSeed");
            return (Criteria) this;
        }

        public Criteria andBelongSeedLike(String value) {
            addCriterion("belong_seed like", value, "belongSeed");
            return (Criteria) this;
        }

        public Criteria andBelongSeedNotLike(String value) {
            addCriterion("belong_seed not like", value, "belongSeed");
            return (Criteria) this;
        }

        public Criteria andBelongSeedIn(List<String> values) {
            addCriterion("belong_seed in", values, "belongSeed");
            return (Criteria) this;
        }

        public Criteria andBelongSeedNotIn(List<String> values) {
            addCriterion("belong_seed not in", values, "belongSeed");
            return (Criteria) this;
        }

        public Criteria andBelongSeedBetween(String value1, String value2) {
            addCriterion("belong_seed between", value1, value2, "belongSeed");
            return (Criteria) this;
        }

        public Criteria andBelongSeedNotBetween(String value1, String value2) {
            addCriterion("belong_seed not between", value1, value2, "belongSeed");
            return (Criteria) this;
        }

        public Criteria andSignalLevelIsNull() {
            addCriterion("signal_level is null");
            return (Criteria) this;
        }

        public Criteria andSignalLevelIsNotNull() {
            addCriterion("signal_level is not null");
            return (Criteria) this;
        }

        public Criteria andSignalLevelEqualTo(String value) {
            addCriterion("signal_level =", value, "signalLevel");
            return (Criteria) this;
        }

        public Criteria andSignalLevelNotEqualTo(String value) {
            addCriterion("signal_level <>", value, "signalLevel");
            return (Criteria) this;
        }

        public Criteria andSignalLevelGreaterThan(String value) {
            addCriterion("signal_level >", value, "signalLevel");
            return (Criteria) this;
        }

        public Criteria andSignalLevelGreaterThanOrEqualTo(String value) {
            addCriterion("signal_level >=", value, "signalLevel");
            return (Criteria) this;
        }

        public Criteria andSignalLevelLessThan(String value) {
            addCriterion("signal_level <", value, "signalLevel");
            return (Criteria) this;
        }

        public Criteria andSignalLevelLessThanOrEqualTo(String value) {
            addCriterion("signal_level <=", value, "signalLevel");
            return (Criteria) this;
        }

        public Criteria andSignalLevelLike(String value) {
            addCriterion("signal_level like", value, "signalLevel");
            return (Criteria) this;
        }

        public Criteria andSignalLevelNotLike(String value) {
            addCriterion("signal_level not like", value, "signalLevel");
            return (Criteria) this;
        }

        public Criteria andSignalLevelIn(List<String> values) {
            addCriterion("signal_level in", values, "signalLevel");
            return (Criteria) this;
        }

        public Criteria andSignalLevelNotIn(List<String> values) {
            addCriterion("signal_level not in", values, "signalLevel");
            return (Criteria) this;
        }

        public Criteria andSignalLevelBetween(String value1, String value2) {
            addCriterion("signal_level between", value1, value2, "signalLevel");
            return (Criteria) this;
        }

        public Criteria andSignalLevelNotBetween(String value1, String value2) {
            addCriterion("signal_level not between", value1, value2, "signalLevel");
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