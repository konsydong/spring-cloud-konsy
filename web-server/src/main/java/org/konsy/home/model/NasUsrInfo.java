package org.konsy.home.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * usrinfo
 *
 * @author : konsy
 * @date : 2021-12-11 02:07
 **/
@Data
@ApiModel(value = "NasUsrInfo", description = "nas用户信息")
public class NasUsrInfo {
    private Integer id;

    @ApiModelProperty(name = "usrName", value = "用户名", required = true, dataType = "String", example = "konsy")
    private String usrName;

    @ApiModelProperty(name = "passWord", value = "密码", required = true, dataType = "String", example = "123456")
    private String passWord;
}
