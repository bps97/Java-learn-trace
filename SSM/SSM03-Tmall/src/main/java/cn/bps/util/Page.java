package cn.bps.util;

public class Page {

    int start;
    int step;
    int total;

    public Page(int start, int step) {
        this.start = start;
        this.step = step;

    }


    /**
     * 判断是否有上一页
     * @return
     */
    public boolean isHasPreviouse(){
        if(start==0)
            return false;
        return true;

    }

    /**
     * 判断是否有下一页
     * @return
     */
    public boolean isHasNext(){
        if(start==getLast())
            return false;
        return true;
    }

    /**
     * 计算得到总页数
     * @return
     */
    public int getTotalPage(){
        int totalPage;
        // 假设总数是50，是能够被5整除的，那么就有10页
        if (0 == total % step)
            totalPage = total / step;
            // 假设总数是51，不能够被5整除的，那么就有11页
        else
            totalPage = total / step + 1;

        if(0==totalPage)
            totalPage = 1;
        return totalPage;
    }

    /**
     * 计算得到尾页
     * @return
     */
    public int getLast(){
        int last;
        // 假设总数是50，是能够被5整除的，那么最后一页的开始就是45
        if (0 == total % step)
            last = total - step;
            // 假设总数是51，不能够被5整除的，那么最后一页的开始就是50
        else
            last = total - total % step;

        last = last<0?0:last;
        return last;
    }

    /* getter and setter */

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
