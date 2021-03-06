package cn.bps.service;


import cn.bps.mapper.ScrollAdMapper;
import cn.bps.pojo.ScrollAd;
import cn.bps.pojo.ScrollAdExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScrollAdServiceImp implements ScrollAdService {

    @Autowired
    ScrollAdMapper scrollAdMapper;

    @Override
    public List<String> getAds() {

        ScrollAdExample scrollAdExample = new ScrollAdExample();

        List<ScrollAd> scrollAds = scrollAdMapper.selectByExample(scrollAdExample);

        return scrollAds.stream().map(ScrollAd::getLink).collect(Collectors.toList());
    }

	@Override
    public List<ScrollAd> getAdObjectList() {

        ScrollAdExample scrollAdExample = new ScrollAdExample();

        List<ScrollAd> scrollAds = scrollAdMapper.selectByExample(scrollAdExample);

        return scrollAds;
    }

	@Override
    public ScrollAd getAdById(int id) {

        ScrollAd scrollAd = scrollAdMapper.selectByPrimaryKey(id);
        if (scrollAd!=null)
            return scrollAd;
        return null;
    }

	@Override
    public ScrollAd updateScrollAd(ScrollAd scrollAd) {

        scrollAdMapper.updateByPrimaryKey(scrollAd);
        return scrollAdMapper.selectByPrimaryKey(scrollAd.getId());
    }

	@Override
    public Integer removeScrollAd(ScrollAd scrollAd) {

        return scrollAdMapper.deleteByPrimaryKey(scrollAd.getId());
    }

	@Override
    public int addNewScrollAd(ScrollAd scrollAd) {

        return scrollAdMapper.insert(scrollAd);
    }
}
