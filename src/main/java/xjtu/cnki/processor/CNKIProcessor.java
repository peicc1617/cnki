package xjtu.cnki.processor;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import xjtu.cnki.entity.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @基本功能: 解析爬取的页面
 * @program:cnki
 * @author:peicc
 * @create:2020-05-25 14:47:23
 **/
public class CNKIProcessor implements PageProcessor {
    private Logger LOGGER = LoggerFactory.getLogger(getClass()) ;
    Site site = new Site()
            .me()
            .setTimeOut(10000)
            .setRetryTimes(3)
            .setSleepTime(3000)
            .setCycleRetryTimes(3)
            .setUserAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");
    @Override
    public void process(Page page) {
        LOGGER.info("解析爬取页面:"+page);
        /*List<String> list=new ArrayList<>();
        list.add("http://www.cnkicom.com/cnki/");
        page.addTargetRequests(list);*/
        //获取html
        Html html = page.getHtml();
        List<Item> itemList=html.css("li.xz-li").all().stream().map(a->{
            Item item=new Item();
            String name="";
            Element e =  Jsoup.parse(a).select("strong").first();//获取论文查重类型
            if (e!=null) {
                name=name+e.text()+"-";
            }
            e =  Jsoup.parse(a).select("em").first();//获取论文查重类型
            if (e!=null) {
                name=name+e.text();
            }
            item.setName(name);
            e =  Jsoup.parse(a).select("i").first();//获取论文查重价格
            if (e!=null) {
                item.setPrice(Double.parseDouble(e.text()));
            }
            return item;
        }).collect(Collectors.toList());
        page.putField("item",itemList);
    }

    @Override
    public Site getSite() {
        return site;
    }
}
