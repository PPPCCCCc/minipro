package com.javaex.phonebook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		List<Person> personList = new ArrayList<Person>();

		Reader fr = new FileReader("./PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);

		boolean run = true;

		System.out.println("***************************************");
		System.out.println("*          전화번호 관리 프로그램            *");
		System.out.println("***************************************");

		while (true) {
			String str = br.readLine();

			if (str == null) {
				break;
			}
			
			String[] personInfo = str.split(",");

			String name = personInfo[0];
			String hp = personInfo[1];
			String company = personInfo[2];

			Person person = new Person(name, hp, company);

			personList.add(person);
		}

		while (run) {
			System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
			System.out.println("---------------------------------------");
			System.out.print(">메뉴번호 : ");
			int num = sc.nextInt();

			switch (num) {
			case 1:
				System.out.println("<1. 리스트>");
				for (int i = 0; i < personList.size(); i++) {
					System.out.print(i + 1);
					personList.get(i).showInfo();
				}
				break;

			case 2:
				System.out.println("<2. 등록>");
				System.out.print("<이름 : ");
				String name = sc.next();
				System.out.print("<휴대전화 : ");
				String hp = sc.next();
				System.out.print("<회사전화 : ");
				String company = sc.next();

				personList.add(new Person(name, hp, company));

				break;

			case 3:
				System.out.println("<3. 삭제>");

				System.out.println(">번호 : ");
				int numm = sc.nextInt();
				for (int i = 0; i <= personList.size(); i++) {
					if (numm == i) {
						personList.remove(i - 1);
					}
				}

				System.out.println("삭제되었습니다");
				break;

			case 4:
				System.out.println("<4. 검색>");//다시
				System.out.println("<이름 : ");
				String strr = sc.next();
				for (int i = 0; i < personList.size(); i++) {
					Person serchh = (Person) personList.get(i);
					if (serchh.getName().contains(strr)) {
						System.out.println(serchh.toString());
					}
				}
				break;

			case 5:
				run = false;
				System.out.println("종료");
				System.out.println("***************************************");
				System.out.println("*              감사합니다                *");
				System.out.println("***************************************");
				break;

			default:
				System.out.println("다시입력해주세요");
			}

			Writer fw = new FileWriter("./PhoneDB.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			for (Person p : personList) {
				String saveter = p.getName() + "," + p.getHp() + "," + p.getCompany();
				bw.write(saveter);
				bw.newLine();
			}
			bw.close();
		}
		br.close();
		sc.close();

	}

}
