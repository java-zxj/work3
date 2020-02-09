package com.fh.service;

import com.fh.common.ServerResponse;
import com.fh.model.Commodity;
import com.fh.model.Page;

public interface CommodityService {
    ServerResponse queryList(Page page);

    void addCommodity(Commodity commodity);

    ServerResponse deleteCommodity(Integer id);

    ServerResponse getCommodityById(Integer id);

    void updateCommodity(Commodity commodity);
}
