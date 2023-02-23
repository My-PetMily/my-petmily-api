package com.family.mypetmily.user.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * description      : User 관련 Mapper
 * packageName      : com.family.mypetmily.user.mapper
 * date             : 2023-02-23
 * author           : SuJeong Gong
 * ================================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------------------
 * 2023-02-23       SuJeong Gong        최초작성
 */
@Mapper
public interface UserMapper {
	/** nickname의 개수 조회 */
	int selectCountNickname(String nickname);
}