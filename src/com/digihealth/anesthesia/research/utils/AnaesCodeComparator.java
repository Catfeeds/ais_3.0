package com.digihealth.anesthesia.research.utils;

import java.util.Comparator;

import com.digihealth.anesthesia.research.formbean.AnaesCntByAnaesMethod;

public class AnaesCodeComparator implements Comparator<AnaesCntByAnaesMethod>{

	@Override
	public int compare(AnaesCntByAnaesMethod o1, AnaesCntByAnaesMethod o2) {
		
		if(Integer.parseInt(o1.getAnaMed())>Integer.parseInt(o2.getAnaMed()))
			   return 1;
			 
			  else
			   return -1;
			 }

}
