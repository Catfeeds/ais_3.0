package com.digihealth.anesthesia.basedata.utils;

import java.util.Comparator;

import com.digihealth.anesthesia.basedata.formbean.FindAllMenuFormBean;

public class MenuParentIdsComparator implements Comparator<FindAllMenuFormBean>{

	@Override
	public int compare(FindAllMenuFormBean o1, FindAllMenuFormBean o2) {
		if (o1.getParentIds().length() < o2.getParentIds().length())
			return 1;

		else if (o1.getParentIds().length() == o2.getParentIds().length())
			return 0;
		else
			return -1;
	}

}
