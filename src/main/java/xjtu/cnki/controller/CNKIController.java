package xjtu.cnki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import us.codecraft.webmagic.Spider;
import xjtu.cnki.dao.ItemMapper;
import xjtu.cnki.dao.URLMapper;
import xjtu.cnki.entity.Item;
import xjtu.cnki.entity.URL;
import xjtu.cnki.pipeline.CNKIPipeLine;
import xjtu.cnki.processor.CNKIProcessor;

import java.util.List;

/**
 * @基本功能:
 * @program:cnki
 * @author:peicc
 * @create:2020-05-25 14:45:59
 **/
@RestController
public class CNKIController {
    @Autowired
    ItemMapper itemMapper;
    @RequestMapping("/getAllByName")
    public List<Item> getAllByName(String name){
        return itemMapper.getAllByName(name);
    }
}
