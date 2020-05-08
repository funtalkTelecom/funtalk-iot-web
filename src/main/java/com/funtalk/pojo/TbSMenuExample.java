package com.funtalk.pojo;

import java.util.ArrayList;
import java.util.List;

public class TbSMenuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbSMenuExample() {
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

        public Criteria andMenuIdIsNull() {
            addCriterion("menu_id is null");
            return (Criteria) this;
        }

        public Criteria andMenuIdIsNotNull() {
            addCriterion("menu_id is not null");
            return (Criteria) this;
        }

        public Criteria andMenuIdEqualTo(String value) {
            addCriterion("menu_id =", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotEqualTo(String value) {
            addCriterion("menu_id <>", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThan(String value) {
            addCriterion("menu_id >", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThanOrEqualTo(String value) {
            addCriterion("menu_id >=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThan(String value) {
            addCriterion("menu_id <", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThanOrEqualTo(String value) {
            addCriterion("menu_id <=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLike(String value) {
            addCriterion("menu_id like", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotLike(String value) {
            addCriterion("menu_id not like", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdIn(List<String> values) {
            addCriterion("menu_id in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotIn(List<String> values) {
            addCriterion("menu_id not in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdBetween(String value1, String value2) {
            addCriterion("menu_id between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotBetween(String value1, String value2) {
            addCriterion("menu_id not between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNull() {
            addCriterion("menu_name is null");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNotNull() {
            addCriterion("menu_name is not null");
            return (Criteria) this;
        }

        public Criteria andMenuNameEqualTo(String value) {
            addCriterion("menu_name =", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotEqualTo(String value) {
            addCriterion("menu_name <>", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThan(String value) {
            addCriterion("menu_name >", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThanOrEqualTo(String value) {
            addCriterion("menu_name >=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThan(String value) {
            addCriterion("menu_name <", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThanOrEqualTo(String value) {
            addCriterion("menu_name <=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLike(String value) {
            addCriterion("menu_name like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotLike(String value) {
            addCriterion("menu_name not like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameIn(List<String> values) {
            addCriterion("menu_name in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotIn(List<String> values) {
            addCriterion("menu_name not in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameBetween(String value1, String value2) {
            addCriterion("menu_name between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotBetween(String value1, String value2) {
            addCriterion("menu_name not between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuTypeIsNull() {
            addCriterion("menu_type is null");
            return (Criteria) this;
        }

        public Criteria andMenuTypeIsNotNull() {
            addCriterion("menu_type is not null");
            return (Criteria) this;
        }

        public Criteria andMenuTypeEqualTo(String value) {
            addCriterion("menu_type =", value, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeNotEqualTo(String value) {
            addCriterion("menu_type <>", value, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeGreaterThan(String value) {
            addCriterion("menu_type >", value, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeGreaterThanOrEqualTo(String value) {
            addCriterion("menu_type >=", value, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeLessThan(String value) {
            addCriterion("menu_type <", value, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeLessThanOrEqualTo(String value) {
            addCriterion("menu_type <=", value, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeLike(String value) {
            addCriterion("menu_type like", value, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeNotLike(String value) {
            addCriterion("menu_type not like", value, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeIn(List<String> values) {
            addCriterion("menu_type in", values, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeNotIn(List<String> values) {
            addCriterion("menu_type not in", values, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeBetween(String value1, String value2) {
            addCriterion("menu_type between", value1, value2, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuTypeNotBetween(String value1, String value2) {
            addCriterion("menu_type not between", value1, value2, "menuType");
            return (Criteria) this;
        }

        public Criteria andMenuParentIsNull() {
            addCriterion("menu_parent is null");
            return (Criteria) this;
        }

        public Criteria andMenuParentIsNotNull() {
            addCriterion("menu_parent is not null");
            return (Criteria) this;
        }

        public Criteria andMenuParentEqualTo(String value) {
            addCriterion("menu_parent =", value, "menuParent");
            return (Criteria) this;
        }

        public Criteria andMenuParentNotEqualTo(String value) {
            addCriterion("menu_parent <>", value, "menuParent");
            return (Criteria) this;
        }

        public Criteria andMenuParentGreaterThan(String value) {
            addCriterion("menu_parent >", value, "menuParent");
            return (Criteria) this;
        }

        public Criteria andMenuParentGreaterThanOrEqualTo(String value) {
            addCriterion("menu_parent >=", value, "menuParent");
            return (Criteria) this;
        }

        public Criteria andMenuParentLessThan(String value) {
            addCriterion("menu_parent <", value, "menuParent");
            return (Criteria) this;
        }

        public Criteria andMenuParentLessThanOrEqualTo(String value) {
            addCriterion("menu_parent <=", value, "menuParent");
            return (Criteria) this;
        }

        public Criteria andMenuParentLike(String value) {
            addCriterion("menu_parent like", value, "menuParent");
            return (Criteria) this;
        }

        public Criteria andMenuParentNotLike(String value) {
            addCriterion("menu_parent not like", value, "menuParent");
            return (Criteria) this;
        }

        public Criteria andMenuParentIn(List<String> values) {
            addCriterion("menu_parent in", values, "menuParent");
            return (Criteria) this;
        }

        public Criteria andMenuParentNotIn(List<String> values) {
            addCriterion("menu_parent not in", values, "menuParent");
            return (Criteria) this;
        }

        public Criteria andMenuParentBetween(String value1, String value2) {
            addCriterion("menu_parent between", value1, value2, "menuParent");
            return (Criteria) this;
        }

        public Criteria andMenuParentNotBetween(String value1, String value2) {
            addCriterion("menu_parent not between", value1, value2, "menuParent");
            return (Criteria) this;
        }

        public Criteria andMenuOrderIsNull() {
            addCriterion("menu_order is null");
            return (Criteria) this;
        }

        public Criteria andMenuOrderIsNotNull() {
            addCriterion("menu_order is not null");
            return (Criteria) this;
        }

        public Criteria andMenuOrderEqualTo(String value) {
            addCriterion("menu_order =", value, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andMenuOrderNotEqualTo(String value) {
            addCriterion("menu_order <>", value, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andMenuOrderGreaterThan(String value) {
            addCriterion("menu_order >", value, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andMenuOrderGreaterThanOrEqualTo(String value) {
            addCriterion("menu_order >=", value, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andMenuOrderLessThan(String value) {
            addCriterion("menu_order <", value, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andMenuOrderLessThanOrEqualTo(String value) {
            addCriterion("menu_order <=", value, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andMenuOrderLike(String value) {
            addCriterion("menu_order like", value, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andMenuOrderNotLike(String value) {
            addCriterion("menu_order not like", value, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andMenuOrderIn(List<String> values) {
            addCriterion("menu_order in", values, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andMenuOrderNotIn(List<String> values) {
            addCriterion("menu_order not in", values, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andMenuOrderBetween(String value1, String value2) {
            addCriterion("menu_order between", value1, value2, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andMenuOrderNotBetween(String value1, String value2) {
            addCriterion("menu_order not between", value1, value2, "menuOrder");
            return (Criteria) this;
        }

        public Criteria andPageLinkIsNull() {
            addCriterion("page_link is null");
            return (Criteria) this;
        }

        public Criteria andPageLinkIsNotNull() {
            addCriterion("page_link is not null");
            return (Criteria) this;
        }

        public Criteria andPageLinkEqualTo(String value) {
            addCriterion("page_link =", value, "pageLink");
            return (Criteria) this;
        }

        public Criteria andPageLinkNotEqualTo(String value) {
            addCriterion("page_link <>", value, "pageLink");
            return (Criteria) this;
        }

        public Criteria andPageLinkGreaterThan(String value) {
            addCriterion("page_link >", value, "pageLink");
            return (Criteria) this;
        }

        public Criteria andPageLinkGreaterThanOrEqualTo(String value) {
            addCriterion("page_link >=", value, "pageLink");
            return (Criteria) this;
        }

        public Criteria andPageLinkLessThan(String value) {
            addCriterion("page_link <", value, "pageLink");
            return (Criteria) this;
        }

        public Criteria andPageLinkLessThanOrEqualTo(String value) {
            addCriterion("page_link <=", value, "pageLink");
            return (Criteria) this;
        }

        public Criteria andPageLinkLike(String value) {
            addCriterion("page_link like", value, "pageLink");
            return (Criteria) this;
        }

        public Criteria andPageLinkNotLike(String value) {
            addCriterion("page_link not like", value, "pageLink");
            return (Criteria) this;
        }

        public Criteria andPageLinkIn(List<String> values) {
            addCriterion("page_link in", values, "pageLink");
            return (Criteria) this;
        }

        public Criteria andPageLinkNotIn(List<String> values) {
            addCriterion("page_link not in", values, "pageLink");
            return (Criteria) this;
        }

        public Criteria andPageLinkBetween(String value1, String value2) {
            addCriterion("page_link between", value1, value2, "pageLink");
            return (Criteria) this;
        }

        public Criteria andPageLinkNotBetween(String value1, String value2) {
            addCriterion("page_link not between", value1, value2, "pageLink");
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