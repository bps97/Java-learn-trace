package cn.bps.pojo;

public class OrderProductItem {
    private Integer id;

    private Integer order_id;

    private Integer product_item_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getProduct_item_id() {
        return product_item_id;
    }

    public void setProduct_item_id(Integer product_item_id) {
        this.product_item_id = product_item_id;
    }
}