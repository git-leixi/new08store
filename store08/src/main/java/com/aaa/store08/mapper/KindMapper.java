package com.aaa.store08.mapper;

import com.aaa.store08.entity.Kind;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KindMapper {
    public List<Kind> SelKind();
    public int InsertKind(Kind kind);
}
