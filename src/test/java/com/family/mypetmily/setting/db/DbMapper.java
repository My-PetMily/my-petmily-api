package com.family.mypetmily.setting.db;

import org.apache.ibatis.annotations.Mapper;

/**
 description      : DB 연결 테스트 매퍼
 packageName      : com.family.mypetmily.setting.db
 date             : 2023-02-19
 author           : SuJeong Gong
 ================================================================
 DATE             AUTHOR              NOTE
 ----------------------------------------------------------------
 2023-02-19       SuJeong Gong        최초작성
 */
@Mapper
public interface DbMapper {
    User selectUserByOne();
}