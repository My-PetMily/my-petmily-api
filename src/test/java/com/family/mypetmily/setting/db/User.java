package com.family.mypetmily.setting.db;

import lombok.Getter;
import lombok.Setter;

/**
 description      : DB 연결에 사용할 임시 유저 클래스
 packageName      : com.family.mypetmily.setting.db
 date             : 2023-02-19
 author           : SuJeong Gong
 ================================================================
 DATE             AUTHOR              NOTE
 ----------------------------------------------------------------
 2023-02-19       SuJeong Gong        최초작성
 */
@Getter @Setter
public class User {
    String nickname;
    String userType;
}