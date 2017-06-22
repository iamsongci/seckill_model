package com.topone.mode.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.topone.dao.MemberDAO;
import com.topone.entry.Member;
import com.topone.model.MemberModel;

public class MemberModelImpl implements MemberModel {
	@Autowired
	private MemberDAO memberDAO;

	public Integer add(Member member) {

		return new Integer(this.memberDAO.add(member));
	}

	public Member getById(String id) {
		return this.memberDAO.getById(id);

	}

	public Integer login(String id, String password) {

		Integer i = this.memberDAO.login(id, password);
		if (i == null || i.intValue() == 0) {
			return 0;
		} else {
			return i;
		}
	}

}
