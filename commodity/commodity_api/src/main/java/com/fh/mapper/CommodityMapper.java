package com.fh.mapper;

import com.fh.common.ServerResponse;
import com.fh.model.Commodity;
import com.fh.model.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommodityMapper {
    long queryCount(Page page);

    List queryList(Page page);

    void addCommodity(Commodity commodity);

    ServerResponse deleteCommodity(Integer id);

    Commodity getCommodityById(Integer id);

    void updateCommodity(Commodity commodity);
}
