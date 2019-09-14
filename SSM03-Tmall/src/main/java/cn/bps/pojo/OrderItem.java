package cn.bps.pojo;

public class OrderItem {
    private Integer id;

    private String order_code;

    private Integer product_item_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrder_code() {
        return order_code;
    }

    public void setOrder_code(String order_code) {
        this.order_code = order_code == null ? null : order_code.trim();
    }

    public Integer getProduct_item_id() {
        return product_item_id;
    }

    public void setProduct_item_id(Integer product_item_id) {
        this.product_item_id = product_item_id;
    }
}