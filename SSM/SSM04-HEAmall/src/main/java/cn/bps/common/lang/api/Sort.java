package cn.bps.common.lang.api;


import cn.bps.common.lang.annotation.Label;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@Label("排序情况")
public class Sort extends AbstractList<Sort.Order> {

    public static final Sort.Direction DEFAULT_DIRECTION;
    static {
        DEFAULT_DIRECTION = Direction.ASC;
    }

    @Valid
    @NotEmpty
    @Label("排序项列表") private List<Order> orderList = new ArrayList<>();

    private Sort(){}

    public static Sort condition() {
        return new Sort();
    }

    public Sort orderBy(Direction direction, String property) {
        this.add(new Order(direction, property));
        return this;
    }

    public Sort orderByAsc(String property) {
        return orderBy(Direction.ASC, property);
    }

    public Sort orderByDesc(String property) {
        return orderBy(Direction.DESC, property);
    }

    public Sort orderByCreateTimeAsc() {
        return orderBy(Direction.ASC, "createTime");
    }

    public Sort orderByCreateTimeDesc() {
        return orderBy(Direction.DESC, "createTime");
    }

    @Override
    public int size() {
        return this.orderList.size();
    }

    @Override
    public Order get(int index) {
        return this.orderList.get(index);
    }

    @Override
    public void add(int index, Order element){
        this.orderList.add(index, element);
    }

    @Override
    public Order remove(int index){
        return this.orderList.remove(index);
    }

    @Override
    public Iterator<Order> iterator(){
        return this.orderList.iterator();
    }

    @Override
    public String toString() {
        return "Sort{" + "orderList=" + this.orderList.toString() +'}';
    }


    public enum  Direction {
        ASC,
        DESC;

        Direction(){}

        public static Sort.Direction fromString(String value){
            try {
                return valueOf(value.toUpperCase(Locale.US));
            } catch (Exception e){
                throw new IllegalArgumentException(String.format("Invalid value %s for orders given! Has to be either 'desc' or 'asc' (case insensitive).", value), e);
            }
        }
    }

    @Label("排序项")
    public static class Order {

        @Label("方向") private Sort.Direction direction;

        @NotBlank
        @Label("属性/字段") private String property;

        public Order() {
            this.direction = Sort.DEFAULT_DIRECTION;
        }

        public Order(Direction direction, @NotBlank String property) {
            this.direction = direction;
            this.property = property;
        }

        public Order(@NotBlank String property) {
            this.property = property;
            this.direction = Sort.DEFAULT_DIRECTION;
        }

        public Direction getDirection() {
            return direction;
        }

        public void setDirection(Direction direction) {
            this.direction = direction;
        }

        public String getProperty() {
            return property;
        }

        public void setProperty(String property) {
            this.property = property;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + this.direction.hashCode();
            result = 31 * result + this.property.hashCode();
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            } else if (!(obj instanceof Sort.Order)) {
                return false;
            } else {
                Sort.Order that = (Sort.Order)obj;
                return this.direction.equals(that.direction) && this.property.equals(that.property);
            }
        }

        @Override
        public String toString() {
            return "Order{" +
                    "direction=" + direction +
                    ", property='" + property + '\'' +
                    '}';
        }
    }

}
