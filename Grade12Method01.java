package Lab5

import java.util.Scanner;

public class Lab5_cal_ AS{
	
	public static boolean Cal_MD(int i){//输入1是加法，0是减法		
		boolean output = false;
		boolean test = true;
		Scanner sc=new Scanner(System.in);
		
		if(i == 1){
			int num1 = (int)(Math.random()*100);//数1
			int num2 = (int)(Math.random()*100);//数2
			System.out.println(num1 +" + "+ num2 +" = ?");
			int num3 = num1+num2;//和
			int c=sc.nextInt();
			if(c == num3){
				output = true;
			} else {
				output = false;
			}
		}
		
		if(i == 0)  {
                                                int num4 = (int)(Math.random()*100);//被减数
			int num5 = (int)(Math.random()*100);//减数
                                                if (num4 < num5){
                                                              int t =num4;
                                                              num4 =num5;
                                                              num5 = t;
                                                 } 
                                  				
			 int num6 = num4-num5;//余数				
                                                 System.out.println(num4 +" -"+ num5 +" = ?");
				int c=sc.nextInt();
				if(c == num6){
					output = true;
				} else {
					output = false;
				}

			}
		}
		
		return output;
	}
		
	public static void main(String[] args) {		
		int i = new java.util.Random().nextBoolean() ? 1 : 0;
		System.out.println(Cal_AS(i));
		
	}	
}


