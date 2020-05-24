package cn.bps.heam.domain;

import cn.bps.common.lang.annotation.Label;
import org.apache.ibatis.session.RowBounds;

import javax.validation.constraints.NotNull;

@Label("分页请求")
public class PageRequest {

    @NotNull
    @Label("页码")private int page;

    @NotNull
    @Label("页大小")private int size;

    public PageRequest() {
        this(0, 10);
    }

    public PageRequest(int page, int size) {
        this.page = page;
        this.size = size;
    }

    /**
     * get current page first item index
     * @return index
     */
    public int getIndex() {
        int offset = (this.page - 1) * this.size;
        return offset + 1;
    }

    /**
     * 适配mybatis RowBounds对象
     * @return
     */
    public RowBounds rowBounds(){
        int first = this.getIndex() - 1; /* (first, first+size ] */
        return new RowBounds(first, first + this.size);
    }


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
