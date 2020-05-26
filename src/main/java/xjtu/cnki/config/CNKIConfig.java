package xjtu.cnki.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import xjtu.cnki.dao.ItemMapper;
import xjtu.cnki.dao.URLMapper;
import xjtu.cnki.pipeline.CNKIPipeLine;
import xjtu.cnki.processor.CNKIProcessor;
import xjtu.cnki.scheduler.ArrayListDuplicateRemover;
import xjtu.cnki.scheduler.CNKIScheduler;

/**
 * @基本功能:
 * @program:cnki
 * @author:peicc
 * @create:2020-05-25 16:22:09
 **/
@Configuration
public class CNKIConfig {
    @Autowired
    ItemMapper itemMapper;
    @Autowired
    URLMapper urlMapper;
    @Autowired
    CNKIPipeLine cnkiPipeLine;
    @Bean(name="cnkiSpider")
    public Spider cnkiSpider(){
        return Spider.create(new CNKIProcessor())
                .addPipeline(cnkiPipeLine)
                .setScheduler(new CNKIScheduler(urlMapper).setDuplicateRemover(new ArrayListDuplicateRemover()))
                .thread(1);
    }
}
