package com.topone.mode.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.topone.dao.DescriptionDAO;
import com.topone.entry.Description;
import com.topone.model.DescriptionModel;

public class DescriptionModelImpl implements DescriptionModel {
	@Autowired
	private DescriptionDAO descriptionDAO;

	public Integer add(Description ds) {

		return this.descriptionDAO.add(ds);
	}

	public Integer update(Description ds)  {
		return this.descriptionDAO.update(ds);
	}

	public Description getById(int id) {
		return this.descriptionDAO.getById(id);
	}

}
