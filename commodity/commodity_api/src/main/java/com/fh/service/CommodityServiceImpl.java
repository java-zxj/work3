package com.fh.service;

import com.fh.common.ServerResponse;
import com.fh.mapper.CommodityMapper;
import com.fh.model.Commodity;
import com.fh.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommodityServiceImpl implements CommodityService {
    @Resource
    private CommodityMapper commodityMapper;


    @Override
    public ServerResponse queryList(Page page) {

        long totalCount = commodityMapper.queryCount(page);
        List list  = commodityMapper.queryList(page);
        Map map= new HashMap();
        map.put("draw",page.getDraw());
        map.put("recordsTotal",totalCount);
        map.put("recordsFiltered",totalCount);
        map.put("data",list);
        return ServerResponse.success(map);
    }

    @Override
    public void addCommodity(Commodity commodity) {
        commodityMapper.addCommodity(commodity);
    }

    @Override
    public ServerResponse deleteCommodity(Integer id) {
      commodityMapper.deleteCommodity(id);
      return ServerResponse.success();
    }

    @Override
    public ServerResponse getCommodityById(Integer id) {
       Commodity commodity =  commodityMapper.getCommodityById(id);
        return ServerResponse.success(commodity);
    }

    @Override
    public void updateCommodity(Commodity commodity) {
        commodityMapper.updateCommodity(commodity);
    }


}
