package cn.bps.domain;

import cn.bps.pojo.ProductBindFilter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CompleteProduct {
    private String name;
    private String sub_title;
    private int category;
    private Set<Integer> associate_1;
    private Set<Integer> associate_2;
    private Set<Integer> associate_3;
    private Set<Integer> associate_4;
    private Set<Integer> associate_5;
    private Set<Integer> associate_6;
    private Set<Integer> concreteFilerIdList;

    private float price;
    private int stock;



    public Set<Integer> init() {
        try {
            concreteFilerIdList = new HashSet<>();
            concreteFilerIdList.addAll(associate_1);
            concreteFilerIdList.addAll(associate_2);
            concreteFilerIdList.addAll(associate_3);
            concreteFilerIdList.addAll(associate_4);
            concreteFilerIdList.addAll(associate_5);
            concreteFilerIdList.addAll(associate_6);
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        return concreteFilerIdList;
    }


    public cn.bps.pojo.Product generatorProduct(){
        cn.bps.pojo.Product product = new cn.bps.pojo.Product();
        product.setSub_title(sub_title);
        product.setStock(stock);
        product.setPrice(price);
        product.setName(name);
        product.setPrice(price);
        product.setCategory_id(category);

        return product;
    }

    public List<ProductBindFilter> generatorProductBindFilter(int productID){
        List<ProductBindFilter> list = new ArrayList<>();


        for(Integer filterId : concreteFilerIdList){
            ProductBindFilter productBindFilter = new ProductBindFilter();
            productBindFilter.setProduct_id(productID);
            productBindFilter.setFilter_value_id(filterId);
            list.add(productBindFilter);
        }

        return list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSub_title() {
        return sub_title;
    }

    public void setSub_title(String sub_title) {
        this.sub_title = sub_title;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public Set<Integer> getAssociate_1() {
        return associate_1;
    }

    public void setAssociate_1(Set<Integer> associate_1) {
        this.associate_1 = associate_1;
    }

    public Set<Integer> getAssociate_2() {
        return associate_2;
    }

    public void setAssociate_2(Set<Integer> associate_2) {
        this.associate_2 = associate_2;
    }

    public Set<Integer> getAssociate_3() {
        return associate_3;
    }

    public void setAssociate_3(Set<Integer> associate_3) {
        this.associate_3 = associate_3;
    }

    public Set<Integer> getAssociate_4() {
        return associate_4;
    }

    public void setAssociate_4(Set<Integer> associate_4) {
        this.associate_4 = associate_4;
    }

    public Set<Integer> getAssociate_5() {
        return associate_5;
    }

    public void setAssociate_5(Set<Integer> associate_5) {
        this.associate_5 = associate_5;
    }

    public Set<Integer> getAssociate_6() {
        return associate_6;
    }

    public void setAssociate_6(Set<Integer> associate_6) {
        this.associate_6 = associate_6;
    }

    public Set<Integer> getConcreteFilerIdList() {
        return concreteFilerIdList;
    }

    public void setConcreteFilerIdList(Set<Integer> concreteFilerIdList) {
        this.concreteFilerIdList = concreteFilerIdList;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
