package com.cqcfsw.databatch.job;


import com.cqcfsw.databatch.job.decider.MyDecider;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * 入门案例
 * @author baofengxueque
 * @create 2020-05-18-11:57
 */
//@Component
public class FirstJobDemo {

    @Resource
    public JobBuilderFactory jobBuilderFactory;
    @Resource
    public StepBuilderFactory stepBuilderFactory;
    @Resource
    private MyDecider myDecider;

    /*
     @Bean
     public Job multiStepJob() {
         //并行任务
         return jobBuilderFactory.get("splitJob")
                 .start(flow1())
                 .split(new SimpleAsyncTaskExecutor()).add(flow2())
                 .end()
                 .build();
     }*/

    @Bean
    public Job deciderJob() {
        //决策器
        return jobBuilderFactory.get("deciderJob")
                .start(step1())
                .next(myDecider)
                .from(myDecider).on("weekend").to(step2())
                .from(myDecider).on("workingDay").to(step3())
                .from(step3()).on("*").to(step4())
                .end()
                .build();
    }

    private Step step1() {
        return stepBuilderFactory.get("step1")
                .tasklet((stepContribution, chunkContext) -> {
                    System.out.println("执行步骤一操作。。。");
                    return RepeatStatus.FINISHED;
                }).build();
    }

    private Step step2() {
        return stepBuilderFactory.get("step2")
                .tasklet((stepContribution, chunkContext) -> {
                    System.out.println("执行步骤二操作。。。");
                    return RepeatStatus.FINISHED;
                }).build();
    }

    private Step step3() {
        return stepBuilderFactory.get("step3")
                .tasklet((stepContribution, chunkContext) -> {
                    System.out.println("执行步骤三操作。。。");
                    return RepeatStatus.FINISHED;
                }).build();
    }

    private Step step4() {
        return stepBuilderFactory.get("step4")
                .tasklet((stepContribution, chunkContext) -> {
                    System.out.println("执行步骤四操作。。。");
                    return RepeatStatus.FINISHED;
                }).build();
    }

    // 创建一个flow对象，包含若干个step
    private Flow flow1() {
        return new FlowBuilder<Flow>("flow1")
                .start(step1())
                .next(step2())
                .build();
    }

    private Flow flow2() {
        return new FlowBuilder<Flow>("flow2")
                .start(step3())
                .build();
    }
}