package com.aaa.store08.service;

import com.aaa.store08.entity.Kind;
import com.aaa.store08.mapper.KindMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class KindServiceImpl implements KindService {
    @Resource
    private KindMapper km;

    @Override
    public List<Kind> SelKind() {
        return km.SelKind();
    }

    @Override
    public int InsertKind(Kind kind) {
        return km.InsertKind(kind);
    }
}
