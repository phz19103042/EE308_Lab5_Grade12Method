package Lab5

import java.util.Scanner;

public class Grade12Method {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = 0;     //题目的数量
		int a, b;
		int sum = 0;
		System.out.println("Please enter the number of questions:");
		n = scanner.nextInt();
		int[] op = new int[n];
		int[] s = new int[n];
		int[] result = new int[n];
		String[] questions = new String[n];
		for (int i = 0; i < n; i++) {
			op[i] = (int) (Math.random() * 4); // 运算符
			a = (int) (Math.random() * 89) + 10; // 数a
			b = (int) (Math.random() * 89) + 10; // 数b
			System.out.println(a + getOp(op[i]) + b + "=?");
			System.out.println("Input the answer:");
			s[i] = scanner.nextInt(); // 输入的答案
			result[i] = jisuan(a, b, op[i]); // 正确答案
			if (s[i] == result[i]) {
				sum++;
			}
			questions[i] = a + getOp(op[i]) + b + "=" + result[i];
		}
		// 最后的输出
		DecimalFormat df = new DecimalFormat("0.00000");
		System.out.println("You're correct" + sum + "and wrong" + (n - sum) 
						   + "，total score is" + (df.format((float)100/b))*sum);
		//答对...题，答错...题，总分为...
	                for (int i = 0; i < n; i++) {
			System.out.print(questions[i]);
			if (s[i] == result[i]) {
				System.out.println(",you answer is" + s[i] + "，correct");
			} else {
				System.out.println(",you answer is" + s[i] + "，wrong");
			}
		}
	}

	// 获取运算符
	private static String getOp(int index) {
		String string = "";
		switch (index) {
		case 0:
			string = "+";
			break;
		case 1:
			string = "-";
			break;
		}
		return string;
	}

	// 计算答案
	private static int jisuan(int a, int b, int index) {
		int sum = 0;
		switch (index) {
		case 0:
			sum = a + b;
			break;
		case 1:
			sum = a - b;
			break;
		}
		return sum;
	}
}


