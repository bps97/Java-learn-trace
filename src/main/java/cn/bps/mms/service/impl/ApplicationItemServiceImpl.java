package cn.bps.mms.service.impl;

import cn.bps.mms.entity.Account;
import cn.bps.mms.entity.Application;
import cn.bps.mms.entity.ApplicationItem;
import cn.bps.mms.mapper.ApplicationItemMapper;
import cn.bps.mms.service.*;
import cn.bps.mms.vo.ApplicationItemVo;
import cn.bps.security.server.service.TokenService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 账户基本信息 服务实现类
 * </p>
 *
 * @author bps
 * @since 2020-06-21
 */
@Service
public class ApplicationItemServiceImpl extends ServiceImpl<ApplicationItemMapper, ApplicationItem> implements ApplicationItemService {

    @Resource
    private CategoryService categoryService;

    @Resource
    private MaterialService materialService;

    @Resource
    private RepositoryService repositoryService;

    @Resource
    private TokenService tokenService;

    @Resource
    private ApplicationService applicationService;


    @Override
    public void addItem(ApplicationItem item, String tokenValue) {

        Application application = applicationService.getApplication(tokenValue);
        item.setApplicationId(application.getId());

        String categoryId = item.getCategoryId();
        String categoryName = categoryService.getById(categoryId).getName();
        item.setCategoryName(categoryName);

        String materialId = item.getMaterialId();
        String materialName = materialService.getById(materialId).getName();
        item.setMaterialName(materialName);

        String repositoryId  = item.getRepositoryId();
        String repositoryName = repositoryService.getById(repositoryId).getName();
        item.setRepositoryName(repositoryName);

        this.save(item);
    }

    @Override
    public List<ApplicationItemVo> list(String tokenValue) {

        Application application = applicationService.getApplication(tokenValue);

        QueryWrapper<ApplicationItem> wrapper = new QueryWrapper<>();
        wrapper
                .eq("available", true)
                .eq("application_id",application.getId());
        List<ApplicationItem> items = this.list(wrapper);

        return items.stream().map(this::model2Vo).collect(Collectors.toList());
    }

    @Override
    public void closeItems(Application application) {
        ApplicationItem item = new ApplicationItem();
        item.setAvailable(false);
        QueryWrapper<ApplicationItem> wrapper = new QueryWrapper<>();
        wrapper
                .eq("available", true)
                .eq("application_id", application.getId());
        this.update(item,wrapper);
    }

    private ApplicationItemVo model2Vo(ApplicationItem item){
        ApplicationItemVo vo = new ApplicationItemVo();
        vo.setMaterialName(item.getMaterialName());
        vo.setCategoryName(item.getCategoryName());
        vo.setRepositoryName(item.getRepositoryName());
        vo.setCount(item.getCount());
        vo.setSpecialLine(materialService.getById(item.getMaterialId()).getSpecialLine());
        return vo;
    }
}
