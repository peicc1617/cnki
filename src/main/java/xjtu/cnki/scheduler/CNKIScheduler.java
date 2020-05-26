package xjtu.cnki.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.scheduler.DuplicateRemovedScheduler;
import xjtu.cnki.dao.URLMapper;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @基本功能:
 * @program:cnki
 * @author:peicc
 * @create:2020-05-25 18:31:47
 **/
public class CNKIScheduler extends DuplicateRemovedScheduler {
    private Logger LOGGER = LoggerFactory.getLogger(getClass()) ;
    URLMapper urlMapper;
    private BlockingQueue<Request> queue=new LinkedBlockingDeque<>();
    public CNKIScheduler(URLMapper urlMapper){
        this.urlMapper=urlMapper;
    }
    @Override
    public Request poll(Task task) {
        readDB();
        Request request = queue.poll();
        return request;
    }
    private void readDB(){
        List<String> urls=urlMapper.getURLSOfNoSpider();
        if (urls==null||urls.size()==0) {
            LOGGER.info("暂无待爬取链接");
        } else{
            urls.forEach(url->queue.add(new Request(url)));
            urlMapper.setFlag();
        }
    }
}
