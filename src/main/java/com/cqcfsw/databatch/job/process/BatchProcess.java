package com.cqcfsw.databatch.job.process;

import com.cqcfsw.databatch.entity.Pointdata;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * @author baofengxueque
 * @create 2020-05-20-9:21
 */
@Component
public class BatchProcess implements ItemProcessor {

    @Override
    public Object process(Object item) throws Exception {
        Pointdata pointdata = (Pointdata) item;
        pointdata.setId(null);
        return pointdata;
    }
}