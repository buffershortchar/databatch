package com.cqcfsw.databatch.controller;

import cn.hutool.core.date.DateUtil;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;

/**
 * @author baofengxueque
 * @create 2020-05-18-15:15
 */
@CrossOrigin
@RestController
@RequestMapping("job")
public class JobController {
    @Resource
    private Job job;
    @Resource
    private Job multiFileItemReaderJob;
    @Resource
    private Job dataSourceItemReaderJob;
    @Resource
    private JobLauncher jobLauncher;

    @Resource
    private JobOperator jobOperator;

    /**
     * launcher调度
     * 测试链接 http://localhost:8080/job/launcher/hello3
     * @param message
     * @return
     * @throws Exception
     */
    @GetMapping("launcher/{message}")
    public String launcher(@PathVariable String message) throws Exception {
        JobParameters parameters = new JobParametersBuilder()
                .addString("message", message)
                .addDate("runDay", new Date())
                .toJobParameters();
        // 将参数传递给任务
        jobLauncher.run(job, parameters);
        return "success";
    }

    /**
     * operator调度
     * 测试链接 http://localhost:8080/job/operator/mrbird
     * 不可重复参数提交
     * @param message
     * @return
     * @throws Exception
     */
    @GetMapping("operator/{message}")
    public String operator(@PathVariable String message) throws Exception {
        // 传递任务名称，参数使用 kv方式
        jobOperator.start("job", "message=" + message +",runDay=" + new Date().getTime());
        return "success";
    }

    /**
     * mySimpleItemReaderJob
     * 测试链接 http://localhost:8080/job/reader/reader4
     * 不可重复参数提交
     * @param message
     * @return
     * @throws Exception
     */
    @GetMapping("reader/{message}")
    public String reader(@PathVariable String message) throws Exception {
        // 传递任务名称，参数使用 kv方式
        jobOperator.start("mySimpleItemReaderJob", "message=" + message);
        return message;
    }


    /**
     * multiFileItemReaderJob
     * 测试链接 http://localhost:8080/job/multiFileItemReader/multiFileItemReader
     * 不可重复参数提交
     * @param message
     * @return
     * @throws Exception
     */
    @GetMapping("multiFileItemReader/{message}")
    public String multiFileItemReader(@PathVariable String message) throws Exception {
        // 传递任务名称，参数使用 kv方式
        jobOperator.start("multiFileItemReaderJob", "message=" + message);
        return message;
    }

    /**
     * multiFileItemReaderJob
     * 测试链接 http://localhost:8080/job/multiFileItemReader2/multiFileItemReader
     * @param message
     * @return
     * @throws Exception
     */
    @GetMapping("multiFileItemReader2/{message}")
    public String multiFileItemReader2(@PathVariable String message) throws Exception {
        JobParameters parameters = new JobParametersBuilder()
                .addString("message", message)
                .addDate("runDay", new Date())
                .toJobParameters();
        // 将参数传递给任务
        jobLauncher.run(multiFileItemReaderJob, parameters);
        return message;
    }
    /**
     * dataSourceItemReaderJob
     * 测试链接 http://localhost:8080/job/dataSourceItemReader/dataSourceItemReader
     * @param message
     * @return
     * @throws Exception
     */
    @GetMapping("dataSourceItemReader/{message}")
    public String dataSourceItemReader(@PathVariable String message) throws Exception {
        JobParameters parameters = new JobParametersBuilder()
                .addString("message", message)
                .addDate("runDay", new Date())
                .toJobParameters();
        // 将参数传递给任务
        jobLauncher.run(dataSourceItemReaderJob, parameters);
        return message;
    }
}
