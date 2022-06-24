package com.sist.data;

import java.util.ArrayList;
import java.io.*;
public class FoodSystem {
   private static ArrayList<FoodLocationVO> list=
		          new ArrayList<FoodLocationVO>();
   // 초기화 
   static
   {
	   try
	   {
		   FileInputStream fis=
				   new FileInputStream("c:\\java_data\\food.txt");
		   ObjectInputStream ois=
				   new ObjectInputStream(fis);

		   list=(ArrayList<FoodLocationVO>)ois.readObject();
		   ois.close();
		   fis.close();
	   }catch(Exception ex){}
   }
   
    public static ArrayList<FoodLocationVO> getList() {
	  return list;
    }
	public static ArrayList<FoodLocationVO> FoodLocationVOListData(int cno,int page)
    {
	   ArrayList<FoodLocationVO> cList=
			   new ArrayList<FoodLocationVO>();
	   // 페이지 나누기 
	   int j=0;
	   // 100  115  130
	   // 
	   int pagecnt=(page*15)-15;
	   /*
	    *    list.size ==> 700  (0~699)
	    *    cno  1 => 1
	    *    cno  2 => 100
	    *    cno  3 => 200
	    *    cno  4 => 300...
	    */
	   for(int i=0;i<list.size();i++)
	   {
		     FoodLocationVO m=list.get(i);
		     if(j<15 && i>=pagecnt)
			 {
				   cList.add(m);
				   j++;
			 }
		  
	   }
	   return cList;
   }
   public static int FoodLocationVOToalPage()
   {
	   return (int)(Math.ceil(100/15.0));
   }
   public static void main(String[] args) {
	   ArrayList<FoodLocationVO> list=FoodLocationVOListData(7, 3);
	   for(FoodLocationVO m:list)
	   {
		   System.out.println(m.getNo()+"."+m.getName());
	   }
	   
   }
}