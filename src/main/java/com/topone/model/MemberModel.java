package com.topone.model;

import com.topone.entry.Member;

public interface MemberModel {
	/**
	 * 添加一个用户
	 * 
	 * @param member
	 * 
	 * @return 1为插入成功
	 */
	Integer add(Member member);

	/**
	 * 按照ID获取一个用户
	 * 
	 * @param id
	 * @return
	 */
	Member getById(String id);

	/**
	 * 登录，返回ID
	 * @param id
	 * @param password
	 * @return
	 */
	Integer login(String id, String password);
}
