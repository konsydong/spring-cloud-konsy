package org.konsy.home.dao;

import org.apache.ibatis.annotations.Param;
import org.konsy.home.model.CustInfo;

public interface CustInfoDao {
    CustInfo getCustInfoById(@Param("id") String id);
}
