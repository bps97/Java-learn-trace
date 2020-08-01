package cn.bps.mms.service;

import cn.bps.mms.domain.ao.ApplicationItemAo;
import cn.bps.mms.domain.vo.ApplicationItemVo;
import cn.bps.mms.entity.Account;
import cn.bps.mms.entity.ApplicationItem;
import cn.bps.mms.entity.Application;
import cn.bps.mms.domain.ApplicationType;
import cn.bps.mms.entity.Material;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 申请单项 服务类
 * </p>
 *
 * @author bps
 * @since 2020-06-21
 */
public interface ApplicationItemService extends IService<ApplicationItem> {

    void addItem(ApplicationItemAo ao, String tokenValue);

    List<ApplicationItemVo> list(String tokenValue);

    List<ApplicationItemVo> list(String tokenValue, ApplicationType type);

    void closeItems(Application application);

    List<ApplicationItem> list(Application application);



    /* 导入EXCEL相关 */

    Application initBatchImport(Account account, String type);

    List<ApplicationItem> initRelatedInfo(List<ApplicationItem> applicationItems);

    IPage<ApplicationItem> pageMaterials(Page<ApplicationItem> page, Account account);

    IPage<ApplicationItem> pageMaterials(Page<ApplicationItem> page, String token, ApplicationType type);

    IPage<ApplicationItem> pageMaterials(Page<ApplicationItem> page, Account account, ApplicationType type);

    IPage<ApplicationItem> handleExcelStream(MultipartFile file, String token, Application form) throws IOException;

    Material checkMaterial(ApplicationItemAo ao);
}