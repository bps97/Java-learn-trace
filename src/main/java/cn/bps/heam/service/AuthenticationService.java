package cn.bps.heam.service;

import cn.bps.heam.domain.model.Authentication;
import cn.bps.heam.domain.result.AuthenticationResult;

import java.util.List;

public interface AuthenticationService {

    List<AuthenticationResult> listAuthentications();

    Authentication getAuthentication(String id);

    List<Authentication> getChildren(String parentId);

}
