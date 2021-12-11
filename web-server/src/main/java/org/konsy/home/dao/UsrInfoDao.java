package org.konsy.home.dao;

import org.apache.ibatis.annotations.Param;
import org.konsy.home.model.NasUsrInfo;

public interface UsrInfoDao {
    int signUpUsr(NasUsrInfo nasUsrInfo);

    int isUsrExist(@Param("usrName") String usrName);
}
