package cn.bps.mms.service;

import cn.bps.mms.domain.vo.ApplicationItemVo;
import cn.bps.mms.entity.Account;
import cn.bps.mms.entity.AppFormItem;
import cn.bps.mms.entity.AppForm;
import cn.bps.mms.enums.AppFormType;
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
public interface AppFormItemService extends IService<AppFormItem> {

    void addItem(AppFormItem item, String tokenValue);

    List<ApplicationItemVo> list(String tokenValue);

    List<ApplicationItemVo> list(String tokenValue, AppFormType type);

    void closeItems(AppForm appForm);

    List<AppFormItem> list(AppForm appForm);



    /* 导入EXCEL相关 */

    AppForm initBatchImport(Account account, String type);

    List<AppFormItem> initName2Id(List<AppFormItem> appFormItems);

    IPage<AppFormItem> pageMaterials(Page<AppFormItem> page, Account account);

    IPage<AppFormItem> pageMaterials(Page<AppFormItem> page, String token, AppFormType type);

    IPage<AppFormItem> pageMaterials(Page<AppFormItem> page, Account account, AppFormType type);

    IPage<AppFormItem> handleExcelStream(MultipartFile file, String token, AppForm form) throws IOException;

}