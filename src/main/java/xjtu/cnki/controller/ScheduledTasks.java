package xjtu.cnki.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import us.codecraft.webmagic.Spider;
import xjtu.cnki.dao.ItemMapper;
import xjtu.cnki.dao.URLMapper;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @基本功能:定时任务
 * @program:cnki
 * @author:peicc
 * @create:2020-05-26 10:31:43
 **/
@Component
public class ScheduledTasks {
    private Logger LOGGER = LoggerFactory.getLogger(getClass());
    @Autowired
    Spider cnkiSpider;
    @Autowired
    ItemMapper itemMapper;
    @Autowired
    URLMapper urlMapper;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    @Scheduled(fixedRate = 1000*60*60*12)
    public void spider(){
        LOGGER .info("当期抓取时间为 {}", dateFormat.format(new Date()));
        urlMapper.addOneURL();
        this.cnkiSpider.start();
    }
}
