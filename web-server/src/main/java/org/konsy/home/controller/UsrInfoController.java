package org.konsy.home.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.konsy.common.model.CommonResult;
import org.konsy.home.service.UsrInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
            @ApiImplicitParam(name = "usrName", value = "用户名", required = true, paramType = "query", example = "konsy"),
            @ApiImplicitParam(name = "passWord", value = "密码", required = true, paramType = "query", example = "123456")
    })
    public CommonResult SignUpUsr(@RequestParam("usrName") String usrName, @RequestParam("passWord") String passWord) {
        int result = 0;
        //1.校验用户名是否存在
        if (isUsrExist(usrName)) {
            return new CommonResult(401, usrName + "用户已存在");
        }
        try {
            result = usrInfoService.signUpUsr(usrName, passWord);
        } catch (Exception e) {
            log.info("注册用户错误", e);
        }
        if (result > 0) {
            log.info("注册用户成功usrName:{}，passWord:{}", usrName, passWord);
            return new CommonResult(200, "注册用户:" + usrName);
        } else {
            return new CommonResult(444, "注册用户错误:" + usrName);
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
