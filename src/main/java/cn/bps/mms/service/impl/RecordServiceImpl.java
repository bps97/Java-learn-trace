package cn.bps.mms.service.impl;

import cn.bps.mms.entity.Account;
import cn.bps.mms.entity.Category;
import cn.bps.mms.entity.Record;
import cn.bps.mms.entity.Repository;
import cn.bps.mms.mapper.RecordMapper;
import cn.bps.mms.service.CategoryService;
import cn.bps.mms.service.MaterialService;
import cn.bps.mms.service.RecordService;
import cn.bps.mms.service.RepositoryService;
import cn.bps.security.server.service.TokenService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 账户基本信息 服务实现类
 * </p>
 *
 * @author bps
 * @since 2020-06-11
 */
@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements RecordService {

    @Resource
    private CategoryService categoryService;

    @Resource
    private MaterialService materialService;

    @Resource
    private RepositoryService repositoryService;

    @Resource
    private TokenService tokenService;

    @Override
    public void record(Record record, String tokenValue) {

        Account account = tokenService.getAccount(tokenValue);
        record.setUserId(account.getId());
        record.setUserName(account.getName());

        String categoryId = record.getCategoryId();
        String categoryName = categoryService.getById(categoryId).getName();
        record.setCategoryName(categoryName);

        String materialId = record.getMaterialId();
        String materialName = materialService.getById(materialId).getName();
        record.setMaterialName(materialName);

        String repositoryId  = record.getRepositoryId();
        String repositoryName = repositoryService.getById(repositoryId).getName();
        record.setRepositoryName(repositoryName);

        this.save(record);


        return;
    }
}
