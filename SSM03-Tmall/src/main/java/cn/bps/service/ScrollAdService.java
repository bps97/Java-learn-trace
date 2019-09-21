package cn.bps.service;

import cn.bps.pojo.ScrollAd;

import java.util.List;

public interface ScrollAdService {

    List<String> getAds();

    List<ScrollAd> getAdObjectList();

    ScrollAd getAdById(int id);

    ScrollAd updateScrollAd(ScrollAd scrollAd);

    Integer removeScrollAd(ScrollAd scrollAd);
}
