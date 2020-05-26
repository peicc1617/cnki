package xjtu.cnki.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import xjtu.cnki.entity.Item;

import java.util.List;

/**
 * @基本功能:
 * @program:cnki
 * @author:peicc
 * @create:2020-05-25 16:07:26
 **/
@Repository
@Mapper
public interface ItemMapper {
    @Select("REPLACE INTO cnki (id,name,price) VALUES(#{id},#{name},#{price})")
    public void addItem(Item item);
    @Select("SELECT * FROM  cnki WHERE name=#{name} ORDER BY spidertime ASC")
    public List<Item> getAllByName(@Param("name")String name);
}
