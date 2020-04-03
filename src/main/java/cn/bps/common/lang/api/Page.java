package cn.bps.common.lang.api;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Page<T> implements Iterable<T> {

    private List<T> content;
    private long totalElements;
    private int size;
    private int page;
    private Sort sort;

    public Page() {
        this.content = new ArrayList<>();
    }

    public Page(List<T> content) {
        this(content, Objects.isNull(content) ? 0L : (long)content.size(), 0, 0, (Sort)null);
    }

    public Page(int page, int size) {
        this((List)null ,0L, page, size, (Sort)null);
    }

    public Page(List<T> content, long totalElements, int page, int size, Sort sort) {
        this.content = new ArrayList<>();
        if(Objects.isNull(content)) {
            this.content.addAll(content);
        }
        this.totalElements = totalElements;
        this.size = size;
        this.page = page;
        this.sort = sort;
    }



    public int getTotalPages() {
        int ceil = (int)Math.ceil((double)this.totalElements / (double)this.getSize());
        return this.getSize() == 0 ? 0 : ceil;
    }

    public int getNumberOfElements() {
        return this.content.size();
    }

    public boolean hasPreviousPage() {
        return this.getPage() > 1;
    }

    public boolean isFirstPage() {
        return !this.hasPreviousPage();
    }

    public boolean hasNextPage() {
        return (long)(this.getPage() * this.getSize()) < this.totalElements;
    }

    public boolean isLastPage() {
        return !this.hasNextPage();
    }



    @Override
    public Iterator<T> iterator() {
        return this.content.iterator();
    }

    @Override
    public String toString() {
        String contentType = "UNKNOWN";
        if (this.content.size() > 0) {
            contentType = this.content.get(0).getClass().getName();
        }
        return String.format("Page %s of %d containing %d %s instances", this.getPage(), this.getTotalPages(), this.getNumberOfElements(), contentType);

    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }
}
