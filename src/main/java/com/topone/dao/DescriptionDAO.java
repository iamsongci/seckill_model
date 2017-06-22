package com.topone.dao;

import com.topone.entry.Description;

public interface DescriptionDAO {
	
	Integer add(Description sd);
	
	Integer update(Description sd);
	
	Description getById(int id);

}
