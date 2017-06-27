package com.digihealth.anesthesia.research.utils;

import java.util.Comparator;

import com.digihealth.anesthesia.research.formbean.WorkingTimeFormBean;

public class WorkingTimeComparator implements Comparator<WorkingTimeFormBean>{

	@Override
	public int compare(WorkingTimeFormBean o1, WorkingTimeFormBean o2) {
		if(Integer.parseInt(o1.getMonth())>Integer.parseInt(o2.getMonth()))
			   return 1;
			 
			  else
			   return -1;
			 }

}
