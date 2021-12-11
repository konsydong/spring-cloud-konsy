package org.konsy.home.service;

import org.konsy.home.dao.UsrInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * usrInfo
 *
 * @author : konsy
 * @date : 2021-12-11 02:02
 **/
@Service
public class UsrInfoService {
    @Autowired
    private UsrInfoDao usrInfoDao;

    /**
     * 首页用户登录
     *
     * @author konsy
     * @date 2021/12/11 23:44
     */
    public int signUpUsr(String usrName, String passWord) {
        return usrInfoDao.signUpUsr(usrName, passWord);
    }

    /**
     * 校验用户名是否存在
     *
     * @author konsy
     * @date 2021/12/11 23:37
     */
    public int isUsrExist(String usrName) {
        return usrInfoDao.isUsrExist(usrName);
    }
}
