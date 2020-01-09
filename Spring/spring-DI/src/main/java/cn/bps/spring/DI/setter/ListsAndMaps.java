package cn.bps.spring.DI.setter;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ListsAndMaps {

    private Integer[] arr;
    private List list;
    private Set set;
    private Map map;
    private Properties properties;

    public void setArr(Integer[] arr) {
        this.arr = arr;
    }

    public void setList(List list) {
        this.list = list;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }


    public String toString(){
        StringBuilder sb = new StringBuilder();
        System.out.println(list);
        System.out.println(set);
        System.out.println(map);
        System.out.println(properties);
        for(int i : arr) sb.append(i);

        return sb.toString();
    }
}
