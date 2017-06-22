package com.topone.dao;

import org.apache.ibatis.annotations.Param;

import com.topone.entry.Member;

public interface MemberDAO {
	/**
	 * 登陆
	 * 
	 * @param id
	 * @param password
	 * @return
	 */
	Integer login(@Param("id") String id, @Param("password") String password);

	Member getById(String id);

	Integer add(Member m);
}
