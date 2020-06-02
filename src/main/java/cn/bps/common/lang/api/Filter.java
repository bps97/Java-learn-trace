package cn.bps.common.lang.api;

import cn.bps.common.lang.annotation.Label;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.*;

@Label("属性过滤器")
public class Filter extends AbstractList<Filter.Property> {

    public static final Filter.Condition DEFAULT_CONDITION;
    static  {
        DEFAULT_CONDITION = Condition.EQUALS;
    }

    @Valid
    @NotEmpty
    @Label("排序项列表") private List<Property> propertyList = new ArrayList<>();

    private Filter(){}

    public static  Filter condition() {
        return new Filter();
    }

    public boolean isEmpty(){
        return propertyList.isEmpty();
    }

    public Filter addEqualTo(String value, String secondValue) {
        add(new Property(value, secondValue));
        return this;
    }

    public Filter addNotEqualTo(String value, String secondValue) {
        add(new Property(value, secondValue));
        return this;
    }

    public Filter addGreaterThan(String value, String secondValue) {
        add(new Property(Condition.DOES_NOT_EQUAL, value ,secondValue));
        return this;
    }

    public Filter addGreaterThanOrEqualTo(String value, String secondValue) {
        add(new Property(Condition.IS_GREATER_THAN_OR_EQUAL_TO, value, secondValue));
        return this;
    }

    public Filter addLessThan(String value, String secondValue) {
        add(new Property(Condition.IS_LESS_THAN, value, secondValue));
        return this;
    }

    public Filter addLessThanOrEqualTo(String value, String secondValue) {
        add(new Property(Condition.IS_LESS_THAN_OR_EQUAL_TO, value, secondValue));
        return this;
    }

    public Filter addContains(String value, String secondValue) {
        add(new Property(Condition.CONTAINS, value, secondValue));
        return this;
    }

    public Filter addNotContains(String value, String secondValue) {
        add(new Property(Condition.DOES_NOT_CONTAINS, value, secondValue));
        return this;
    }

    public Filter addBeginWith(String value, String secondValue) {
        add(new Property(Condition.BEGINS_WITH, value, secondValue));
        return this;
    }

    public Filter addNotBeginWith(String value, String secondValue) {
        add(new Property(Condition.DOES_NOT_BEGIN_WITH, value, secondValue));
        return this;
    }

    public Filter addEndWith(String value, String secondValue) {
        add(new Property(Condition.ENDS_WITH, value, secondValue));
        return this;
    }

    public Filter addNotEndWith(String value, String secondValue) {
        add(new Property(Condition.DOES_NOT_BEGIN_WITH, value, secondValue));
        return this;
    }





    @Override
    public int size() {
        return this.propertyList.size();
    }

    @Override
    public Property get(int index) {
        return this.propertyList.get(index);
    }

    @Override
    public void add(int index, Property element){
        this.propertyList.add(index, element);
    }

    @Override
    public Property remove(int index){
        return this.propertyList.remove(index);
    }

    @Override
    public Iterator<Property> iterator(){
        return this.propertyList.iterator();
    }

    @Override
    public String toString() {
        return "Sort{" + "PropertyList=" + this.propertyList.toString() +'}';
    }



    public enum Condition {
        EQUALS,                         // 等于
        DOES_NOT_EQUAL,                 // 不等于
        IS_GREATER_THAN,                // 大于
        IS_GREATER_THAN_OR_EQUAL_TO,    // 大于或等于
        IS_LESS_THAN,                   // 小于
        IS_LESS_THAN_OR_EQUAL_TO,       // 小于或等于
        BEGINS_WITH,                    // 开头是
        DOES_NOT_BEGIN_WITH,            // 开头不是
        ENDS_WITH,                      // 结尾是
        DOES_NOT_END_WITH,              // 结尾不是
        CONTAINS,                       // 包含
        DOES_NOT_CONTAINS;              // 不包含

        Condition(){}

        public static Filter.Condition fromString(String value){
            try {
                return valueOf(value.toUpperCase(Locale.US));
            } catch (Exception e){
                throw new IllegalArgumentException(String.format("Invalid value %s for conditions given!", value), e);
            }
        }
    }


    public static class Property {

        @Label("条件") private Filter.Condition condition;

        @NotBlank
        private String value;

        @NotBlank
        private String secondValue;


        public Property() {
            this.condition = Filter.DEFAULT_CONDITION;
        }

        public Property(Condition condition, @NotBlank String value, @NotBlank String secondValue) {
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
        }

        public Property(@NotBlank String value, @NotBlank String secondValue) {
            this.condition = Filter.DEFAULT_CONDITION;
            this.value = value;
            this.secondValue = secondValue;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getSecondValue() {
            return secondValue;
        }

        public void setSecondValue(String secondValue) {
            this.secondValue = secondValue;
        }

        public Condition getCondition() {
            return condition;
        }

        public void setCondition(Condition condition) {
            this.condition = condition;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + this.value.hashCode();
            result = 31 * result + this.secondValue.hashCode();
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            } else if (!(obj instanceof Property)) {
                return false;
            } else {
                Property that = (Property) obj;
                return this.condition.equals(that.condition) && this.value.equals(that.value) && this.secondValue.equals(that.secondValue);
            }
        }

        @Override
        public String toString() {
            return "Property{" +
                    "direction=" + value +
                    ", property='" + secondValue + '\'' +
                    '}';
        }

    }

}
