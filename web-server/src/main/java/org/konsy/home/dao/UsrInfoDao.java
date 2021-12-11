package org.konsy.home.dao;

import org.apache.ibatis.annotations.Param;

public interface UsrInfoDao {
    int signUpUsr(@Param("usrName") String usrName, @Param("passWord") String passWord);

    int isUsrExist(@Param("usrName") String usrName);
}
