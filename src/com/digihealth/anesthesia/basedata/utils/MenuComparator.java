package com.digihealth.anesthesia.basedata.utils;

import java.util.Comparator;

import com.digihealth.anesthesia.sysMng.po.BasMenu;

public class MenuComparator implements Comparator<BasMenu> {

	@Override
	public int compare(BasMenu o1, BasMenu o2) {
		if (o1.getSort() > o2.getSort())
			return 1;

		else
			return -1;
	}

}
