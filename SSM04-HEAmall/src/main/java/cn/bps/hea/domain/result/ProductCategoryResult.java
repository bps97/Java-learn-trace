package cn.bps.hea.domain.result;

import java.io.Serializable;
import java.util.Date;

public class ProductCategoryResult implements Serializable {
    private String id;

    private String categoryName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }


}