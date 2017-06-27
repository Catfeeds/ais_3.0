package com.digihealth.anesthesia.research.utils;

import java.util.Comparator;

import com.digihealth.anesthesia.research.formbean.WorkingTimeFormBean;

public class AllWorkingTimeComparator implements Comparator<WorkingTimeFormBean>{

	@Override
	public int compare(WorkingTimeFormBean o1, WorkingTimeFormBean o2) {
		if(Integer.parseInt(o1.getYear()+(o1.getMonth().length() == 1?"0"+o1.getMonth():o1.getMonth()))>Integer.parseInt(o2.getYear()+(o2.getMonth().length() == 1?"0"+o2.getMonth():o2.getMonth())))
			   return 1;
			 
			  else
			   return -1;
			 }

}
