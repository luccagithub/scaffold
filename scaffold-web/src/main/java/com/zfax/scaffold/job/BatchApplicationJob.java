package com.zfax.scaffold.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.zfax.scaffold.service.ScaffoldService;
import com.zfax.starter.job.annotation.Job;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Job(cron = "0 0/2 * * * ? ", description = "填写该定时任务的功能")
public class BatchApplicationJob implements SimpleJob {

    @Autowired
    private ScaffoldService scaffoldService;

    @Override
    public void execute(ShardingContext shardingContext) {
        log.info("=============开始BatchApplicationJob==============");
        // DoSomething
        log.info("============= 结束BatchApplicationJob===============");
    }
}
