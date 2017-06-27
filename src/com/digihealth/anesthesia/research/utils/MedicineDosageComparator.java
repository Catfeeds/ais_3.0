package com.digihealth.anesthesia.research.utils;

import java.util.Comparator;

import com.digihealth.anesthesia.research.formbean.SearchMedicineType;
import com.digihealth.anesthesia.research.formbean.WorkingTimeFormBean;

public class MedicineDosageComparator implements Comparator<SearchMedicineType>{

	@Override
	public int compare(SearchMedicineType o1, SearchMedicineType o2) {
		if(o1.getMedicineId()>o2.getMedicineId())
			   return 1;
			 
			  else
			   return -1;
			 }

}
