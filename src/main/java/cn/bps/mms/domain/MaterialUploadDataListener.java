package cn.bps.mms.domain;

import cn.bps.mms.entity.Account;
import cn.bps.mms.entity.AppForm;
import cn.bps.mms.entity.AppFormItem;
import cn.bps.mms.service.AppFormItemService;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MaterialUploadDataListener extends AnalysisEventListener<MaterialEo> {

    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 50;
    List<MaterialEo> list = new ArrayList<MaterialEo>();
    /**
     * 假设这个是一个DAO，当然有业务逻辑这个也可以是一个service。当然如果不用存储这个对象没用。
     */

    private AppFormItemService AppFormItemService;

    private Account account;

    private AppForm appForm;

    

    public MaterialUploadDataListener() {
        // 这里是demo，所以随便new一个。实际使用如果到了spring,请使用下面的有参构造函数
    }

    /**
     * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
     *
     * @param AppFormItemService
     */
    public MaterialUploadDataListener(AppFormItemService AppFormItemService) {
        this.AppFormItemService = AppFormItemService;
    }


    public MaterialUploadDataListener(AppFormItemService AppFormItemService, Account account) {
        this.AppFormItemService = AppFormItemService;
        this.account = account;
//        this.appForm = AppFormItemService.initBatchImport(account);
    }

    public MaterialUploadDataListener(AppFormItemService AppFormItemService, Account account, AppForm appForm) {
        this.AppFormItemService = AppFormItemService;
        this.account = account;
        this.appForm = AppFormItemService.initBatchImport(account, appForm.getType());
    }

    @Override
    public void invoke(MaterialEo material, AnalysisContext analysisContext) {
        list.add(material);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (list.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            list.clear();
        }
    }

    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        List<AppFormItem> AppFormItems = list.stream().map(this::eo2Model).collect(Collectors.toList());
        AppFormItems = AppFormItemService.initName2Id(AppFormItems);
        AppFormItemService.saveBatch(AppFormItems);
    }


    private AppFormItem eo2Model(MaterialEo eo){
        AppFormItem item = new AppFormItem();
        item.setMaterialName(eo.getName());
        item.setCategoryName(eo.getCategory());
        item.setRepositoryName(eo.getRepository());
        item.setCount(eo.getCount());
        item.setSpecialLine(eo.getSpecialLine());
        item.setStatus(eo.getStatus());
//        item = AppFormItemService.initName2Id(item);
        if(appForm != null)
            item.setAppFormId(appForm.getId());
        return item;
    }
}
