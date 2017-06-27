package com.digihealth.anesthesia.basedata.config;

public interface AnaesEventOption {
	String INDUCE = "01" ;//麻醉诱导
	String BEGIN_ANAES = "02";//麻醉开始
	String END_ANAES = "03";//麻醉结束;
	String BEGIN_OPER = "04";//手术开始
	String END_OPER = "05";//手术结束
	String INTUBATION ="06";//气管插管
	String DRAW_PIPE = "07";//气管拔管
	String IN_ROOM = "08";//入室
	String OUT_ROOM = "09";//出室
}
