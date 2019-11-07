package com.aaa.store08.service;

import com.aaa.store08.entity.Kind;

import java.util.List;

public interface KindService {
    public List<Kind> SelKind();
    public int InsertKind(Kind kind);
}
