package com.javaex.phonebook;

public class Person {
	private String name;
	private String hp;
	private String company;
	private int num = 0;

	public Person() {
	}

	public Person(String name, String hp, String company) {
		this.name = name;
		this.hp = hp;
		this.company = company;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	public int getNum() {
		return num+1;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void showInfo() {
		System.out.println(". " + name + " " + hp + " " + company);
	}
}
