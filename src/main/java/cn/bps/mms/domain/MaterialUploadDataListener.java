package cn.bps.mms.domain;

import cn.bps.mms.entity.Account;
import cn.bps.mms.entity.ApplicationForm;
import cn.bps.mms.entity.ApplicationFormItem;
import cn.bps.mms.service.ApplicationFormItemService;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MaterialUploadDataListener extends AnalysisEventListener<MaterialEo> {

    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 5;
    List<MaterialEo> list = new ArrayList<MaterialEo>();
    /**
     * 假设这个是一个DAO，当然有业务逻辑这个也可以是一个service。当然如果不用存储这个对象没用。
     */

    private ApplicationFormItemService applicationFormItemService;

    private Account account;

    private ApplicationForm applicationForm;

    

    public MaterialUploadDataListener() {
        // 这里是demo，所以随便new一个。实际使用如果到了spring,请使用下面的有参构造函数
    }

    /**
     * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
     *
     * @param applicationFormItemService
     */
    public MaterialUploadDataListener(ApplicationFormItemService applicationFormItemService) {
        this.applicationFormItemService = applicationFormItemService;
    }


    public MaterialUploadDataListener(ApplicationFormItemService applicationFormItemService, Account account) {
        this.applicationFormItemService = applicationFormItemService;
        this.account = account;
        this.applicationForm = applicationFormItemService.initBatchImport(account);
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
        applicationFormItemService.saveBatch(list.stream().map(this::eo2Model).collect(Collectors.toList()));
    }


    private ApplicationFormItem eo2Model(MaterialEo eo){
        ApplicationFormItem item = new ApplicationFormItem();
        item.setMaterialName(eo.getName());
        item.setCategoryName(eo.getCategory());
        item.setRepositoryName(eo.getRepository());
        item.setCount(eo.getCount());
        item.setSpecialLine(eo.getSpecialLine());
        item.setStatus(eo.getStatus());
        item = applicationFormItemService.initName2Id(item);
        if(applicationForm != null)
            item.setApplicationFormId(applicationForm.getId());
        return item;
    }
}
