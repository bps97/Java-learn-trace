package cn.bps.heam.service;

import cn.bps.enums.CompositeMode;
import cn.bps.heam.domain.model.Authentication;
import cn.bps.heam.domain.result.AuthenticationResult;

import java.util.List;

public interface AuthenticationService {

    List<AuthenticationResult> listAuthentications();

    List<AuthenticationResult> listAuthentications(CompositeMode mode);

    Authentication getAuthentication(String id);

    List<Authentication> getChildren(String parentId);

}
