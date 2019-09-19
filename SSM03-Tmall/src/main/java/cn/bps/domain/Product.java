package cn.bps.domain;

import org.springframework.web.multipart.MultipartFile;

public class Product {
    private String name;
    private String sub_title;
    private int category;
    private float price;
    private int stock;
    private MultipartFile image;

    public MultipartFile getMultipartFile() {
        return image;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.image = multipartFile;
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

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public cn.bps.pojo.Product toProduct(Integer id){
        cn.bps.pojo.Product product = new cn.bps.pojo.Product();
        product.setCategory_id(category);
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        product.setStock(stock);
        product.setSub_title(sub_title);
        product.setUndercarriage(0);
        return product;
    }
}

