package com.cqcfsw.databatch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 任务调度案例
 * @author baofengxueque
 * @create 2020-05-18-15:18
 */
@Component
public class MyJob{

    @Resource
    private JobBuilderFactory jobBuilderFactory;
    @Resource
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job job(){
        return jobBuilderFactory.get("job")
                .start(step())
                .build();
    }

    /**
     * 根据传来的 JobParameters 键值对 打印键为 message 的消息
     * @return
     */
    private Step step(){
        return stepBuilderFactory.get("step")
                .tasklet((stepContribution, chunkContext) -> {
                    StepExecution stepExecution = chunkContext.getStepContext().getStepExecution();
                    Map<String, JobParameter> parameters = stepExecution.getJobParameters().getParameters();
                    System.out.println(parameters.get("message").getValue());
                    return RepeatStatus.FINISHED;
                })
                .listener(this)
                .build();
    }
}