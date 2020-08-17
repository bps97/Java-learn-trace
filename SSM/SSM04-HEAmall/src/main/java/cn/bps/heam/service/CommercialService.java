package cn.bps.heam.service;

import cn.bps.heam.domain.model.Commercial;
import cn.bps.heam.domain.result.CommercialResult;

import java.util.List;

public interface CommercialService {

    List<CommercialResult> listCommercials();

    int updateCommercial(Commercial commercial);

    int saveCommercial(Commercial commercial); /*未编写*/

    Commercial getCommercial(String id);

    Commercial getCommercial(Integer index);

}
