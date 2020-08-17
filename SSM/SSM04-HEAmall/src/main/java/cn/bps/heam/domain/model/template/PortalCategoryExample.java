package cn.bps.heam.domain.model.template;

import java.util.ArrayList;
import java.util.List;

public class PortalCategoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PortalCategoryExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRefCategoryIdIsNull() {
            addCriterion("ref_category_id is null");
            return (Criteria) this;
        }

        public Criteria andRefCategoryIdIsNotNull() {
            addCriterion("ref_category_id is not null");
            return (Criteria) this;
        }

        public Criteria andRefCategoryIdEqualTo(String value) {
            addCriterion("ref_category_id =", value, "refCategoryId");
            return (Criteria) this;
        }

        public Criteria andRefCategoryIdNotEqualTo(String value) {
            addCriterion("ref_category_id <>", value, "refCategoryId");
            return (Criteria) this;
        }

        public Criteria andRefCategoryIdGreaterThan(String value) {
            addCriterion("ref_category_id >", value, "refCategoryId");
            return (Criteria) this;
        }

        public Criteria andRefCategoryIdGreaterThanOrEqualTo(String value) {
            addCriterion("ref_category_id >=", value, "refCategoryId");
            return (Criteria) this;
        }

        public Criteria andRefCategoryIdLessThan(String value) {
            addCriterion("ref_category_id <", value, "refCategoryId");
            return (Criteria) this;
        }

        public Criteria andRefCategoryIdLessThanOrEqualTo(String value) {
            addCriterion("ref_category_id <=", value, "refCategoryId");
            return (Criteria) this;
        }

        public Criteria andRefCategoryIdLike(String value) {
            addCriterion("ref_category_id like", value, "refCategoryId");
            return (Criteria) this;
        }

        public Criteria andRefCategoryIdNotLike(String value) {
            addCriterion("ref_category_id not like", value, "refCategoryId");
            return (Criteria) this;
        }

        public Criteria andRefCategoryIdIn(List<String> values) {
            addCriterion("ref_category_id in", values, "refCategoryId");
            return (Criteria) this;
        }

        public Criteria andRefCategoryIdNotIn(List<String> values) {
            addCriterion("ref_category_id not in", values, "refCategoryId");
            return (Criteria) this;
        }

        public Criteria andRefCategoryIdBetween(String value1, String value2) {
            addCriterion("ref_category_id between", value1, value2, "refCategoryId");
            return (Criteria) this;
        }

        public Criteria andRefCategoryIdNotBetween(String value1, String value2) {
            addCriterion("ref_category_id not between", value1, value2, "refCategoryId");
            return (Criteria) this;
        }

        public Criteria andPortalIndexIsNull() {
            addCriterion("portal_index is null");
            return (Criteria) this;
        }

        public Criteria andPortalIndexIsNotNull() {
            addCriterion("portal_index is not null");
            return (Criteria) this;
        }

        public Criteria andPortalIndexEqualTo(Integer value) {
            addCriterion("portal_index =", value, "portalIndex");
            return (Criteria) this;
        }

        public Criteria andPortalIndexNotEqualTo(Integer value) {
            addCriterion("portal_index <>", value, "portalIndex");
            return (Criteria) this;
        }

        public Criteria andPortalIndexGreaterThan(Integer value) {
            addCriterion("portal_index >", value, "portalIndex");
            return (Criteria) this;
        }

        public Criteria andPortalIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("portal_index >=", value, "portalIndex");
            return (Criteria) this;
        }

        public Criteria andPortalIndexLessThan(Integer value) {
            addCriterion("portal_index <", value, "portalIndex");
            return (Criteria) this;
        }

        public Criteria andPortalIndexLessThanOrEqualTo(Integer value) {
            addCriterion("portal_index <=", value, "portalIndex");
            return (Criteria) this;
        }

        public Criteria andPortalIndexIn(List<Integer> values) {
            addCriterion("portal_index in", values, "portalIndex");
            return (Criteria) this;
        }

        public Criteria andPortalIndexNotIn(List<Integer> values) {
            addCriterion("portal_index not in", values, "portalIndex");
            return (Criteria) this;
        }

        public Criteria andPortalIndexBetween(Integer value1, Integer value2) {
            addCriterion("portal_index between", value1, value2, "portalIndex");
            return (Criteria) this;
        }

        public Criteria andPortalIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("portal_index not between", value1, value2, "portalIndex");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIsNull() {
            addCriterion("category_name is null");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIsNotNull() {
            addCriterion("category_name is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryNameEqualTo(String value) {
            addCriterion("category_name =", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotEqualTo(String value) {
            addCriterion("category_name <>", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameGreaterThan(String value) {
            addCriterion("category_name >", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("category_name >=", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLessThan(String value) {
            addCriterion("category_name <", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLessThanOrEqualTo(String value) {
            addCriterion("category_name <=", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLike(String value) {
            addCriterion("category_name like", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotLike(String value) {
            addCriterion("category_name not like", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIn(List<String> values) {
            addCriterion("category_name in", values, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotIn(List<String> values) {
            addCriterion("category_name not in", values, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameBetween(String value1, String value2) {
            addCriterion("category_name between", value1, value2, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotBetween(String value1, String value2) {
            addCriterion("category_name not between", value1, value2, "categoryName");
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