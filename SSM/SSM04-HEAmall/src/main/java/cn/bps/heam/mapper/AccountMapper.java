package cn.bps.heam.mapper;

import cn.bps.heam.domain.model.Account;
import cn.bps.heam.domain.model.template.AccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface AccountMapper {
    long countByExample(AccountExample example);

    int deleteByExample(AccountExample example);

    int deleteByPrimaryKey(String id);

    int insert(Account record);

    int insertSelective(Account record);

    List<Account> selectByExampleWithRowbounds(AccountExample example, RowBounds rowBounds);

    List<Account> selectByExample(AccountExample example);

    Account selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Account record, @Param("example") AccountExample example);

    int updateByExample(@Param("record") Account record, @Param("example") AccountExample example);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}