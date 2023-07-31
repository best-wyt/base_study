package com.wang.datestudy;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Test {
public static void main(String[] args) {
	try {
		DayTime("2019-01-26 12:35:26","2019-01-26");
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public static  void DayTime(String armtime,String rq) throws ParseException{
 
SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	long arm0=sim.parse(armtime).getTime();
	for(int i=0;i<24;i++){
		String begin=rq+" ";
		String end =rq+" ";
		String a=Integer.toString(i);
		String b=Integer.toString(i+1);
		if(a.length()==1){
			a="0"+a;
		}
		if(b.length()==1){
			b="0"+b;
		}
		begin=begin+a+":00:00";
		  end=end+b+":00:00";
		  //把开始区间时间和结束区间时间转换为long类型。然后比较
		  long arm1=sim.parse(begin).getTime();
		  long arm2=sim.parse(end).getTime();
		  if(arm0>arm1&&arm0<arm2){
			 System.out.println(armtime+"在区间"+begin+"-"+end+"之间"); 
			 break;
		  }
		  
	}
                                    }
}