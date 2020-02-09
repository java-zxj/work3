package com.fh.controller;

import com.fh.common.ServerResponse;
import com.fh.model.Commodity;
import com.fh.model.Page;
import com.fh.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("commodity")
@CrossOrigin
public class CommodityController {

   @Autowired
  private CommodityService commodityService;

    @RequestMapping("queryList")
    public ServerResponse queryList(Page page){
        return commodityService.queryList(page);
    }

    @RequestMapping("addCommodity")
    public ServerResponse addCommodity(Commodity commodity){
        commodityService.addCommodity(commodity);
        return ServerResponse.success();
    }

    @RequestMapping("deleteCommodity")
    public ServerResponse deleteCommodity(Integer id){
        return commodityService.deleteCommodity(id);
    }

    @RequestMapping("getCommodityById")
    public ServerResponse getCommodityById(Integer id){
        return commodityService.getCommodityById(id);
    }

    @RequestMapping("updateCommodity")
    public ServerResponse updateCommodity(Commodity commodity){
        commodityService.updateCommodity(commodity);
        return ServerResponse.success();
    }
}
