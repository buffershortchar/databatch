package com.cqcfsw.databatch.job.reader;

import org.springframework.batch.item.ItemReader;

import java.util.Iterator;
import java.util.List;

/**
 * @author baofengxueque
 * @create 2020-05-18-15:51
 */
public class MySimpleIteamReader implements ItemReader<String> {

    private Iterator<String> iterator;


    public MySimpleIteamReader(List<String> data) {
        this.iterator = data.iterator();
    }

    @Override
    public String read() {
        // 数据一个接着一个读取
        return iterator.hasNext() ? iterator.next() : null;
    }
}