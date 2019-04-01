package com.zfax.scaffold.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zfax.core.domain.Subject;
import com.zfax.event.entity.approval.EndFlowEvent;
import com.zfax.event.entity.approval.LoanAfterEvent;
import com.zfax.rabbitmq.EventPublisher;
import com.zfax.scaffold.api.dto.AdminDTO;
import com.zfax.scaffold.api.service.AdminService;
import com.zfax.scaffold.controller.Urls.Admins;
import com.zfax.scaffold.controller.ro.AdminRO;
import com.zfax.scaffold.controller.vo.AdminVO;
import com.zfax.scaffold.service.ScaffoldService;
import com.zfax.scaffold.transfer.AdminTransfer;
import com.zyxr.event.entity.ExampleEvent;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Born
 * @create: 2018/6/13
 **/
@RestController
@Api(description = "用户相关接口")
public class AdminController {

    @Reference
    private AdminService adminService;
    @Autowired
    private ScaffoldService scaffoldService;
    @Autowired
    private EventPublisher eventPublisher;


    @GetMapping(Admins.ONE)
    @ApiOperation("根据Id查询用户信息")
    public AdminVO selectById(@PathVariable("id") Long id) {
        AdminDTO adminDTO = adminService.selectById(id);
        AdminVO adminVO = AdminTransfer.INSTANCE.mapDTOToVO(adminDTO);
        return adminVO;
    }


    @PostMapping(Admins.ROOT)
    @ApiOperation("添加用户信息")
    public Long insertAdmin(@Valid @RequestBody AdminRO adminRO) {
        AdminDTO adminDTO = AdminTransfer.INSTANCE.mapROToDTO(adminRO);
        long id = adminService.insert(adminDTO);
        return id;
    }


    @GetMapping(Admins.EVENT_MESSAGE)
    @ApiOperation("发送事件测试")
    @Transactional
    public String sendEvent(String type) {
        switch (type) {
            case "1": {
                EndFlowEvent event = new EndFlowEvent();
                event.setApplicationId("xx959584");
                event.setPayload("asdfgjfudsafdsajfdsahfdsf");
                eventPublisher.publishEvent(event);
                break;
            }
            case "2": {
                LoanAfterEvent event = new LoanAfterEvent();
                event.setPayload("asdasdas");
                eventPublisher.publishEvent(event);
                break;
            }
            case "3": {
                ExampleEvent event = new ExampleEvent();
                event.setA("aaaaaaa");
                eventPublisher.publishEvent(event);
                break;
            }

        }

        return "success";
    }

    @GetMapping(Admins.CURRENT_ADMIN)
    @ApiOperation("获取当前登录用户信息,逻辑是从requestHeader里面取出X-User-Id,X-User-Mobile."
            + "本地调试的时候可以模拟登录用户.正式环境是在网关层拦截解析")
    public Subject currentAdminInfo(Subject subject) {
        return subject;
    }

}
