package cn.bps.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOrder_codeIsNull() {
            addCriterion("order_code is null");
            return (Criteria) this;
        }

        public Criteria andOrder_codeIsNotNull() {
            addCriterion("order_code is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_codeEqualTo(String value) {
            addCriterion("order_code =", value, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeNotEqualTo(String value) {
            addCriterion("order_code <>", value, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeGreaterThan(String value) {
            addCriterion("order_code >", value, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeGreaterThanOrEqualTo(String value) {
            addCriterion("order_code >=", value, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeLessThan(String value) {
            addCriterion("order_code <", value, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeLessThanOrEqualTo(String value) {
            addCriterion("order_code <=", value, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeLike(String value) {
            addCriterion("order_code like", value, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeNotLike(String value) {
            addCriterion("order_code not like", value, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeIn(List<String> values) {
            addCriterion("order_code in", values, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeNotIn(List<String> values) {
            addCriterion("order_code not in", values, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeBetween(String value1, String value2) {
            addCriterion("order_code between", value1, value2, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeNotBetween(String value1, String value2) {
            addCriterion("order_code not between", value1, value2, "order_code");
            return (Criteria) this;
        }

        public Criteria andAddress_idIsNull() {
            addCriterion("address_id is null");
            return (Criteria) this;
        }

        public Criteria andAddress_idIsNotNull() {
            addCriterion("address_id is not null");
            return (Criteria) this;
        }

        public Criteria andAddress_idEqualTo(Integer value) {
            addCriterion("address_id =", value, "address_id");
            return (Criteria) this;
        }

        public Criteria andAddress_idNotEqualTo(Integer value) {
            addCriterion("address_id <>", value, "address_id");
            return (Criteria) this;
        }

        public Criteria andAddress_idGreaterThan(Integer value) {
            addCriterion("address_id >", value, "address_id");
            return (Criteria) this;
        }

        public Criteria andAddress_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("address_id >=", value, "address_id");
            return (Criteria) this;
        }

        public Criteria andAddress_idLessThan(Integer value) {
            addCriterion("address_id <", value, "address_id");
            return (Criteria) this;
        }

        public Criteria andAddress_idLessThanOrEqualTo(Integer value) {
            addCriterion("address_id <=", value, "address_id");
            return (Criteria) this;
        }

        public Criteria andAddress_idIn(List<Integer> values) {
            addCriterion("address_id in", values, "address_id");
            return (Criteria) this;
        }

        public Criteria andAddress_idNotIn(List<Integer> values) {
            addCriterion("address_id not in", values, "address_id");
            return (Criteria) this;
        }

        public Criteria andAddress_idBetween(Integer value1, Integer value2) {
            addCriterion("address_id between", value1, value2, "address_id");
            return (Criteria) this;
        }

        public Criteria andAddress_idNotBetween(Integer value1, Integer value2) {
            addCriterion("address_id not between", value1, value2, "address_id");
            return (Criteria) this;
        }

        public Criteria andUser_messageIsNull() {
            addCriterion("user_message is null");
            return (Criteria) this;
        }

        public Criteria andUser_messageIsNotNull() {
            addCriterion("user_message is not null");
            return (Criteria) this;
        }

        public Criteria andUser_messageEqualTo(String value) {
            addCriterion("user_message =", value, "user_message");
            return (Criteria) this;
        }

        public Criteria andUser_messageNotEqualTo(String value) {
            addCriterion("user_message <>", value, "user_message");
            return (Criteria) this;
        }

        public Criteria andUser_messageGreaterThan(String value) {
            addCriterion("user_message >", value, "user_message");
            return (Criteria) this;
        }

        public Criteria andUser_messageGreaterThanOrEqualTo(String value) {
            addCriterion("user_message >=", value, "user_message");
            return (Criteria) this;
        }

        public Criteria andUser_messageLessThan(String value) {
            addCriterion("user_message <", value, "user_message");
            return (Criteria) this;
        }

        public Criteria andUser_messageLessThanOrEqualTo(String value) {
            addCriterion("user_message <=", value, "user_message");
            return (Criteria) this;
        }

        public Criteria andUser_messageLike(String value) {
            addCriterion("user_message like", value, "user_message");
            return (Criteria) this;
        }

        public Criteria andUser_messageNotLike(String value) {
            addCriterion("user_message not like", value, "user_message");
            return (Criteria) this;
        }

        public Criteria andUser_messageIn(List<String> values) {
            addCriterion("user_message in", values, "user_message");
            return (Criteria) this;
        }

        public Criteria andUser_messageNotIn(List<String> values) {
            addCriterion("user_message not in", values, "user_message");
            return (Criteria) this;
        }

        public Criteria andUser_messageBetween(String value1, String value2) {
            addCriterion("user_message between", value1, value2, "user_message");
            return (Criteria) this;
        }

        public Criteria andUser_messageNotBetween(String value1, String value2) {
            addCriterion("user_message not between", value1, value2, "user_message");
            return (Criteria) this;
        }

        public Criteria andCreate_dateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreate_dateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreate_dateEqualTo(Date value) {
            addCriterion("create_date =", value, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateGreaterThan(Date value) {
            addCriterion("create_date >", value, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateLessThan(Date value) {
            addCriterion("create_date <", value, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateIn(List<Date> values) {
            addCriterion("create_date in", values, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "create_date");
            return (Criteria) this;
        }

        public Criteria andCreate_dateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "create_date");
            return (Criteria) this;
        }

        public Criteria andPay_dateIsNull() {
            addCriterion("pay_date is null");
            return (Criteria) this;
        }

        public Criteria andPay_dateIsNotNull() {
            addCriterion("pay_date is not null");
            return (Criteria) this;
        }

        public Criteria andPay_dateEqualTo(Date value) {
            addCriterion("pay_date =", value, "pay_date");
            return (Criteria) this;
        }

        public Criteria andPay_dateNotEqualTo(Date value) {
            addCriterion("pay_date <>", value, "pay_date");
            return (Criteria) this;
        }

        public Criteria andPay_dateGreaterThan(Date value) {
            addCriterion("pay_date >", value, "pay_date");
            return (Criteria) this;
        }

        public Criteria andPay_dateGreaterThanOrEqualTo(Date value) {
            addCriterion("pay_date >=", value, "pay_date");
            return (Criteria) this;
        }

        public Criteria andPay_dateLessThan(Date value) {
            addCriterion("pay_date <", value, "pay_date");
            return (Criteria) this;
        }

        public Criteria andPay_dateLessThanOrEqualTo(Date value) {
            addCriterion("pay_date <=", value, "pay_date");
            return (Criteria) this;
        }

        public Criteria andPay_dateIn(List<Date> values) {
            addCriterion("pay_date in", values, "pay_date");
            return (Criteria) this;
        }

        public Criteria andPay_dateNotIn(List<Date> values) {
            addCriterion("pay_date not in", values, "pay_date");
            return (Criteria) this;
        }

        public Criteria andPay_dateBetween(Date value1, Date value2) {
            addCriterion("pay_date between", value1, value2, "pay_date");
            return (Criteria) this;
        }

        public Criteria andPay_dateNotBetween(Date value1, Date value2) {
            addCriterion("pay_date not between", value1, value2, "pay_date");
            return (Criteria) this;
        }

        public Criteria andDelivery_dateIsNull() {
            addCriterion("delivery_date is null");
            return (Criteria) this;
        }

        public Criteria andDelivery_dateIsNotNull() {
            addCriterion("delivery_date is not null");
            return (Criteria) this;
        }

        public Criteria andDelivery_dateEqualTo(Date value) {
            addCriterion("delivery_date =", value, "delivery_date");
            return (Criteria) this;
        }

        public Criteria andDelivery_dateNotEqualTo(Date value) {
            addCriterion("delivery_date <>", value, "delivery_date");
            return (Criteria) this;
        }

        public Criteria andDelivery_dateGreaterThan(Date value) {
            addCriterion("delivery_date >", value, "delivery_date");
            return (Criteria) this;
        }

        public Criteria andDelivery_dateGreaterThanOrEqualTo(Date value) {
            addCriterion("delivery_date >=", value, "delivery_date");
            return (Criteria) this;
        }

        public Criteria andDelivery_dateLessThan(Date value) {
            addCriterion("delivery_date <", value, "delivery_date");
            return (Criteria) this;
        }

        public Criteria andDelivery_dateLessThanOrEqualTo(Date value) {
            addCriterion("delivery_date <=", value, "delivery_date");
            return (Criteria) this;
        }

        public Criteria andDelivery_dateIn(List<Date> values) {
            addCriterion("delivery_date in", values, "delivery_date");
            return (Criteria) this;
        }

        public Criteria andDelivery_dateNotIn(List<Date> values) {
            addCriterion("delivery_date not in", values, "delivery_date");
            return (Criteria) this;
        }

        public Criteria andDelivery_dateBetween(Date value1, Date value2) {
            addCriterion("delivery_date between", value1, value2, "delivery_date");
            return (Criteria) this;
        }

        public Criteria andDelivery_dateNotBetween(Date value1, Date value2) {
            addCriterion("delivery_date not between", value1, value2, "delivery_date");
            return (Criteria) this;
        }

        public Criteria andConfirm_dateIsNull() {
            addCriterion("confirm_date is null");
            return (Criteria) this;
        }

        public Criteria andConfirm_dateIsNotNull() {
            addCriterion("confirm_date is not null");
            return (Criteria) this;
        }

        public Criteria andConfirm_dateEqualTo(Date value) {
            addCriterion("confirm_date =", value, "confirm_date");
            return (Criteria) this;
        }

        public Criteria andConfirm_dateNotEqualTo(Date value) {
            addCriterion("confirm_date <>", value, "confirm_date");
            return (Criteria) this;
        }

        public Criteria andConfirm_dateGreaterThan(Date value) {
            addCriterion("confirm_date >", value, "confirm_date");
            return (Criteria) this;
        }

        public Criteria andConfirm_dateGreaterThanOrEqualTo(Date value) {
            addCriterion("confirm_date >=", value, "confirm_date");
            return (Criteria) this;
        }

        public Criteria andConfirm_dateLessThan(Date value) {
            addCriterion("confirm_date <", value, "confirm_date");
            return (Criteria) this;
        }

        public Criteria andConfirm_dateLessThanOrEqualTo(Date value) {
            addCriterion("confirm_date <=", value, "confirm_date");
            return (Criteria) this;
        }

        public Criteria andConfirm_dateIn(List<Date> values) {
            addCriterion("confirm_date in", values, "confirm_date");
            return (Criteria) this;
        }

        public Criteria andConfirm_dateNotIn(List<Date> values) {
            addCriterion("confirm_date not in", values, "confirm_date");
            return (Criteria) this;
        }

        public Criteria andConfirm_dateBetween(Date value1, Date value2) {
            addCriterion("confirm_date between", value1, value2, "confirm_date");
            return (Criteria) this;
        }

        public Criteria andConfirm_dateNotBetween(Date value1, Date value2) {
            addCriterion("confirm_date not between", value1, value2, "confirm_date");
            return (Criteria) this;
        }

        public Criteria andUser_idIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUser_idIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUser_idEqualTo(Integer value) {
            addCriterion("user_id =", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThan(Integer value) {
            addCriterion("user_id >", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThan(Integer value) {
            addCriterion("user_id <", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idIn(List<Integer> values) {
            addCriterion("user_id in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andActual_paymentIsNull() {
            addCriterion("actual_payment is null");
            return (Criteria) this;
        }

        public Criteria andActual_paymentIsNotNull() {
            addCriterion("actual_payment is not null");
            return (Criteria) this;
        }

        public Criteria andActual_paymentEqualTo(Float value) {
            addCriterion("actual_payment =", value, "actual_payment");
            return (Criteria) this;
        }

        public Criteria andActual_paymentNotEqualTo(Float value) {
            addCriterion("actual_payment <>", value, "actual_payment");
            return (Criteria) this;
        }

        public Criteria andActual_paymentGreaterThan(Float value) {
            addCriterion("actual_payment >", value, "actual_payment");
            return (Criteria) this;
        }

        public Criteria andActual_paymentGreaterThanOrEqualTo(Float value) {
            addCriterion("actual_payment >=", value, "actual_payment");
            return (Criteria) this;
        }

        public Criteria andActual_paymentLessThan(Float value) {
            addCriterion("actual_payment <", value, "actual_payment");
            return (Criteria) this;
        }

        public Criteria andActual_paymentLessThanOrEqualTo(Float value) {
            addCriterion("actual_payment <=", value, "actual_payment");
            return (Criteria) this;
        }

        public Criteria andActual_paymentIn(List<Float> values) {
            addCriterion("actual_payment in", values, "actual_payment");
            return (Criteria) this;
        }

        public Criteria andActual_paymentNotIn(List<Float> values) {
            addCriterion("actual_payment not in", values, "actual_payment");
            return (Criteria) this;
        }

        public Criteria andActual_paymentBetween(Float value1, Float value2) {
            addCriterion("actual_payment between", value1, value2, "actual_payment");
            return (Criteria) this;
        }

        public Criteria andActual_paymentNotBetween(Float value1, Float value2) {
            addCriterion("actual_payment not between", value1, value2, "actual_payment");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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