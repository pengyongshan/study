package com.tree.www.pattern.chains;

/**
 * 级别表
 * 
 * @author pys
 *
 * @date 2016年4月20日 下午6:26:25
 */
public enum TypeEnum {

	FATHER("father", 1), HUSBAND("husband", 2), SON("son", 3), DEFAULT("default", 0);

	private TypeEnum(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public static int getVlaueByName(String name) {
		for (TypeEnum typeEnum : TypeEnum.values()) {
			if (typeEnum.getName().equals(name)) {
				return typeEnum.value;
			}
		}
		return DEFAULT.value;
	}

	public static String getNameByValue(int value) {
		for (TypeEnum typeEnum : TypeEnum.values()) {
			if (typeEnum.getValue() == value) {
				return typeEnum.name;
			}
		}
		return DEFAULT.name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	private String name;

	private int value;
}

