package com.tree.www.test;

public enum EnumTest {
	PLUS {
		public double eval(double x, double y){
			return x + y;
		}
	},
	MINUS {
		public double eval(double x, double y) {
			return x - y;
		}
	},
	TIMES {
		public double eval(double x, double y) {
			return x * y;
		}
	},
	DIVIDE {
		public double eval(double x, double y) {
			return x / y;
		}
	};

	public abstract double eval(double x, double y);

	public static void main(String[] args) {
		System.out.println(EnumTest.PLUS.eval(3, 5));
		System.out.println(EnumTest.MINUS.eval(3, 5));
		System.out.println(EnumTest.TIMES.eval(3, 5));
		System.out.println(EnumTest.DIVIDE.eval(-3, 0));
	}
}

