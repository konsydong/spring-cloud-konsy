package org.konsy.home.controller;

import lombok.extern.slf4j.Slf4j;
import org.konsy.common.model.CommonResult;
import org.konsy.home.model.CustInfo;
import org.konsy.home.service.CustInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * getUserInfo
 *
 * @author : konsy
 * @date : 2021-12-08 23:18
 **/
@RestController
@RequestMapping(value = "/home")
@Slf4j
public class CustInfoController {
    @Autowired
    private CustInfoService custInfoService;

    @GetMapping(value = "get-user-info")
    public CommonResult GetCustInfoById(@RequestParam("id") String id) {
        CustInfo custInfo = null;
        try {
            custInfo = custInfoService.getCustInfoById(id);
        } catch (Exception e) {
            log.info("查询客户信息错误", e);
        }
        if (custInfo != null) {
            log.info("查询客户成功:{}", custInfo);
            return new CommonResult(200, "查询客户,id:" + id, custInfo);
        } else {
            return new CommonResult(444, "没有对应记录,查询ID:" + id);
        }
    }
}
