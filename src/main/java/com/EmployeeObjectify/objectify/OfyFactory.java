package com.EmployeeObjectify.objectify;

import com.EmployeeObjectify.model.EmployeeModel;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;

public class OfyFactory extends ObjectifyFactory
{
	 
	public static Objectify init() 
	{
		return new OfyFactory().begin();
	}

	public OfyFactory() 
	{
		register(EmployeeModel.class);
	}

	@Override
	public Objectify begin() 
	{
		return super.begin();
	}

}
