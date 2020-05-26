package xjtu.cnki.pipeline;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import xjtu.cnki.dao.ItemMapper;
import xjtu.cnki.entity.Item;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @基本功能:
 * @program:cnki
 * @author:peicc
 * @create:2020-05-25 16:05:09
 **/
@Component
public class CNKIPipeLine implements Pipeline {
    private Logger LOGGER = LoggerFactory.getLogger(getClass());
    @Autowired
    ItemMapper itemMapper;
    @Override
    public void process(ResultItems resultItems, Task task) {
        List<Item> itemList=resultItems.get("item");
        LOGGER.info("爬虫列表"+itemList);
        itemList.forEach(item -> {
            itemMapper.addItem(item);
            LOGGER.info(item+"存入数据库");
        });

    }
}
