import java.util.*;
import java.text.DecimalFormat;
import java.math.BigDecimal;

import org.omg.CORBA.PUBLIC_MEMBER;

import jdk.internal.dynalink.beans.StaticClass;


public class Oral_calculation_exercise {
	
	static int correctNumber = 0;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String Grade;
		int grade = 0, questionNumber, score;
		
		
		
		
		System.out.println("Please enter your grade?");
		Grade = sc.next();
		if(Grade.equals("grade")) {
			grade = sc.nextInt();
		}else {
//			exit(-1);
		}
		grade = Integer.valueOf(grade);
		System.out.println("Please enter the number of questions?");
		questionNumber = sc.nextInt();
		int count_i = questionNumber;
		while(count_i > 0) {
			select(grade);
			count_i--;
		}
		System.out.print("end!");
		score = 100*correctNumber/questionNumber;
		if(score < 100 && score >= 0) {
			System.out.print("There are " + (questionNumber - correctNumber) + " wrong questions, your score is " + score + ".");
		}else if(score == 100) {
			System.out.print("All right, that's great! your score is " + score + ".");
		}
	}
	public static void select(int gradenum) {

		if(gradenum==1 || gradenum==2)
			countgrade(1);
		if(gradenum==3 || gradenum==4)
			if(getRandomNumberInRange(0,9)<3)
				countgrade(1);
			else
				countgrade(2);
		if(gradenum==5 || gradenum==6)
			{
			int temp=getRandomNumberInRange(0,9);
				if(temp==0)
					countgrade(1);
				else if(temp<4)
					countgrade(2);
				else 
					countgrade(3);


			}
	}
	public static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	public static void countgrade(int gradenum) {
		switch (gradenum)
			{
			case 1:
				if(Cal_AS())
					correctNumber++;
				break;
			case 2:
				if(Cal_MD())
					correctNumber++;
				break;
			case 3:
				if(float_calculate())
					correctNumber++;
				break;
			}
	}
	public static boolean Cal_MD(){//输入1是乘法，0是除法
		int i = new java.util.Random().nextBoolean() ? 1 : 0;
		boolean output = false;
		boolean test = true;
		Scanner sc=new Scanner(System.in);
		
		if(i == 1){
			int num1 = (int)(Math.random()*100);//乘数1
			int num2 = (int)(Math.random()*100);//乘数2
			System.out.println(num1 +" * "+ num2 +" = ?");
			int num3 = num1*num2;//乘积
			int c=sc.nextInt();
			if(c == num3){
				output = true;
			} else {
				output = false;
			}
		}
		
		if(i == 0){
			while(test == true){
				int num5 = (int)(Math.random()*99 + 1);//被除数
				int num6 = (int)(Math.random()*99 + 1);//商				
				int num4 = num5*num6;//除数				
				if(num4 < 100){
					System.out.println(num4 +" / "+ num5 +" = ?");
					int c=sc.nextInt();
					if(c == num6){
						output = true;
					} else {
						output = false;
					}
					test = false;
				}
			}
		}
		
		return output;
	}
	public static boolean Cal_AS(){
		int i = new java.util.Random().nextBoolean() ? 1 : 0;
		boolean output = false;
		boolean test = true;
		Scanner sc=new Scanner(System.in);
		
		if(i == 1){
			int num1 = (int)(Math.random()*100);
			int num2 = (int)(Math.random()*100);
			System.out.println(num1 +" + "+ num2 +" = ?");
			int num3 = num1+num2;
			int c=sc.nextInt();
			if(c == num3){
				output = true;
			} else {
				output = false;
			}
		}
		
		if(i == 0)  {
			int num4 = (int)(Math.random()*100);
			int num5 = (int)(Math.random()*100);
			if (num4 < num5){
				int t =num4;
				num4 =num5;
				num5 = t;
			} 
                                  				
            int num6 = num4-num5;			
            System.out.println(num4 +" -"+ num5 +" = ?");
			int c=sc.nextInt();
			if(c == num6){
				output = true;
			} else {
				output = false;
			}

		}
		return output;
	}
	static boolean float_calculate() {
        boolean res = true;
        Random r = new Random();
        int num = r.nextInt(4);
        switch(num) {
            case 0:
                res = float_cal_plus();
                break;
            case 1:
                res = float_cal_sub();
                break;
            case 2:
                res = float_cal_mtu();
                break;
            case 3:
                res = float_cal_div();
                break;
        }
        return res;
    }
    
    static boolean float_cal_plus(){
        Random r = new Random();
        int num1 = r.nextInt(10000);
        int num2 = r.nextInt(10000);
        String numA = String.valueOf(0.01*num1);
        String numB = String.valueOf(0.01*num2);
        BigDecimal BDnumA = new BigDecimal(numA);
        BDnumA = BDnumA.setScale(2,BigDecimal.ROUND_HALF_UP);
        BigDecimal BDnumB = new BigDecimal(numB);
        BDnumB = BDnumB.setScale(2,BigDecimal.ROUND_HALF_UP);
        
//        System.out.println(BDnumA);
//        System.out.println(BDnumB);
//        System.out.println(BDnumA.add(BDnumB));
//        System.out.println(num1+num2);
        
        System.out.println(BDnumA.toString()+"+"+BDnumB.toString()+"=?");
        String resBD= BDnumA.add(BDnumB).toString();
        Scanner sc = new Scanner(System.in);
        String res = sc.nextLine();
        if(res.endsWith(resBD)){
            return true;
        }else{
            return false;
        }
    }
    
    static boolean float_cal_sub(){
        Random r = new Random();
        int num1 = r.nextInt(10000);
        int num2 = r.nextInt(10000);
        String numA = String.valueOf(0.01*num1);
        String numB = String.valueOf(0.01*num2);
        BigDecimal BDnumA = new BigDecimal(numA);
        BDnumA = BDnumA.setScale(2,BigDecimal.ROUND_HALF_UP);
        BigDecimal BDnumB = new BigDecimal(numB);
        BDnumB = BDnumB.setScale(2,BigDecimal.ROUND_HALF_UP);
        
//        System.out.println(BDnumA);
//        System.out.println(BDnumB);
//        System.out.println(BDnumA.add(BDnumB));
        //System.out.println(num1-num2);
        
        System.out.println(BDnumA.toString()+"-"+BDnumB.toString()+"=?");
        String resBD= BDnumA.subtract(BDnumB).toString();
        Scanner sc = new Scanner(System.in);
        String res = sc.nextLine();
        if(res.endsWith(resBD)){
            return true;
        }else{
            return false;
        }
    }

    static boolean float_cal_mtu(){
        Random r = new Random();
        int num1 = r.nextInt(10000);
        int num2 = r.nextInt(10000);
        if(num1 < num2){
            int t = num1;
            num1 = num2;
            num2 = t;
        }
        String numA = String.valueOf(0.01*num1);
        String numB = String.valueOf(0.01*num2);
        BigDecimal BDnumA = new BigDecimal(numA);
        BDnumA = BDnumA.setScale(2,BigDecimal.ROUND_HALF_UP);
        BigDecimal BDnumB = new BigDecimal(numB);
        BDnumB = BDnumB.setScale(2,BigDecimal.ROUND_HALF_UP);
        
//        System.out.println(BDnumA);
//        System.out.println(BDnumB);
//        System.out.println(BDnumA.add(BDnumB));
        //System.out.println(num1*num2);
        
        System.out.println(BDnumA.toString()+"*"+BDnumB.toString()+"=?");
        String resBD= BDnumA.multiply(BDnumB).setScale(2,BigDecimal.ROUND_HALF_UP).toString();
        Scanner sc = new Scanner(System.in);
        String res = sc.nextLine();
        if(res.endsWith(resBD)){
            return true;
        }else{
            return false;
        }
    }

    static boolean float_cal_div(){
        Random r = new Random();
        int num1 = r.nextInt(10000);
        int num2 = r.nextInt(10000);
        String numA = String.valueOf(0.01*num1);
        String numB = String.valueOf(0.01*num2);
        BigDecimal BDnumA = new BigDecimal(numA);
        BDnumA = BDnumA.setScale(2,BigDecimal.ROUND_HALF_UP);
        BigDecimal BDnumB = new BigDecimal(numB);
        BDnumB = BDnumB.setScale(2,BigDecimal.ROUND_HALF_UP);
        
//        System.out.println(BDnumA);
//        System.out.println(BDnumB);
//        System.out.println(BDnumA.divide(BDnumB));
//        System.out.println(1.0*num1/num2);
        
        System.out.println(BDnumA.toString()+"/"+BDnumB.toString()+"=?");
        String resBD= BDnumA.divide(BDnumB,2).toString();
        Scanner sc = new Scanner(System.in);
        String res = sc.nextLine();
        if(res.endsWith(resBD)){
            return true;
        }else{
            return false;
        }
    }
}
© 2021 GitHub, Inc.
Terms
Privacy
Security
Status
Docs
Contact GitHub
Pricing
API
Training
Blog
About
