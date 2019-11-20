package com.aaa.store08.service;

import java.util.List;
import java.util.Map;

public interface StatService {
    public List<Map> findOdName(String aName);
    public int findMonthCount();
    public List<Map> AreaRanking();
    public List<Map> SelectaName(Integer aId);
}
