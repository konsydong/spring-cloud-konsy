package org.konsy.home.service;

import org.konsy.home.dao.CustInfoDao;
import org.konsy.home.model.CustInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * custInfo
 *
 * @author : konsy
 * @date : 2021-12-08 23:34
 **/
@Service
public class CustInfoService {
    @Autowired
    private CustInfoDao custInfoDao;

    public CustInfo getCustInfoById(String id) {
        return custInfoDao.getCustInfoById(id);
    }
}
