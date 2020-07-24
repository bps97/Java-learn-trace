package cn.bps.mms.service;

import cn.bps.mms.domain.vo.ApplicationItemVo;
import cn.bps.mms.entity.Account;
import cn.bps.mms.entity.AppFormItem;
import cn.bps.mms.entity.AppForm;
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

    void closeItems(AppForm appForm);

    List<AppFormItem> list(AppForm appForm);



    /* 导入EXCEL相关 */

    AppForm initBatchImport(Account account);

    List<AppFormItem> initName2Id(List<AppFormItem> appFormItems);

    IPage<AppFormItem> pageMaterials(Page<AppFormItem> page, String token);

    IPage<AppFormItem> pageMaterials(Page<AppFormItem> page, Account account);

    IPage<AppFormItem> handleExcelStream(MultipartFile file, String token) throws IOException;

}