package com.family.mypetmily.user.mapper;

import com.family.mypetmily.user.model.User;
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

	/** email의 개수 조회 */
	int selectCountEmail(String Email);

	/**
	 * 유저 추가
	 *
	 * @param user 추가할 유저
	 * @return 추가된 유저의 수
	 */
	int insertUser(User user);
}