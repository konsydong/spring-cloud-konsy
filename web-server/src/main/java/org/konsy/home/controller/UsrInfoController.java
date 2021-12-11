package org.konsy.home.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.konsy.common.model.CommonResult;
import org.konsy.home.model.NasUsrInfo;
import org.konsy.home.service.UsrInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * usrInfo 首页用户登录注册
 *
 * @author : konsy
 * @date : 2021-12-11 02:00
 **/
@Slf4j
@RestController
@RequestMapping("/home/usrInfo")
@Api("首页用户登录注册")
public class UsrInfoController {
    @Autowired
    private UsrInfoService usrInfoService;

    @PostMapping(value = "signUpUsr")
    @ApiOperation(value = "首页用户注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "usrName", value = "用户名", required = true, paramType = "body", example = "konsy"),
            @ApiImplicitParam(name = "passWord", value = "密码", required = true, paramType = "body", example = "123456")
    })
    public CommonResult SignUpUsr(@ApiIgnore @RequestBody NasUsrInfo nasUsrInfo) {
        int result = 0;
        //1.校验用户名是否存在
        if (isUsrExist(nasUsrInfo.getUsrName())) {
            log.info(nasUsrInfo.getUsrName() + "用户已存在");
            return new CommonResult(401, nasUsrInfo.getUsrName() + "用户已存在");
        }
        try {
            result = usrInfoService.signUpUsr(nasUsrInfo);
        } catch (Exception e) {
            log.info("注册用户错误", e);
        }
        if (result > 0) {
            log.info("注册用户成功usrName:{}，passWord:{}", nasUsrInfo.getUsrName(), nasUsrInfo.getPassWord());
            return new CommonResult(200, "注册用户:" + nasUsrInfo.getUsrName());
        } else {
            return new CommonResult(444, "注册用户错误:" + nasUsrInfo.getUsrName());
        }
    }

    /**
     * 校验用户名是否存在
     *
     * @author konsy
     * @date 2021/12/11 23:37
     */
    private boolean isUsrExist(String usrName) {
        return usrInfoService.isUsrExist(usrName) > 0;
    }

}
