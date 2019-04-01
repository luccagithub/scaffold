package com.zfax.scaffold.manager;

import com.zfax.scaffold.api.dto.AdminDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author: Born
 * @create: 2018/6/13
 **/
@Component
public class ThirdPartyManager {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 第三方调用使用restTemplate
     */
    public AdminDTO selectById(Long id) {
        AdminDTO adminDTO = restTemplate.getForObject("http://localhost:9001/admins/{1}", AdminDTO.class, id);
        return adminDTO;
    }
}
