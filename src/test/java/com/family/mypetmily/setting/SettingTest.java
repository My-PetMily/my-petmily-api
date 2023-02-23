package com.family.mypetmily.setting;

import com.family.mypetmily.setting.db.DbMapper;
import com.family.mypetmily.setting.db.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 description      : 환경설정 테스트 코드
 packageName      : com.family.mypetmily.setting
 date             : 2023-02-19
 author           : SuJeong Gong
 ================================================================
 DATE             AUTHOR              NOTE
 ----------------------------------------------------------------
 2023-02-19       SuJeong Gong        최초작성
 */
@SpringBootTest
public class SettingTest {

    @Autowired
    private  DbMapper dbMapper;

    @Test
    void 디비연결_테스트() {
        User user = dbMapper.selectUserByOne();
        Assertions.assertNotNull(user.getNickname());
    }
}