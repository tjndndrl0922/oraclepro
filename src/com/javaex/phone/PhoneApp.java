package com.javaex.phone;

import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num, personId;
		String name, hp, company, like;
		boolean bool = true;
		PhoneDao phoneDao = new PhoneDao();
		List<PersonVo> phoneList;
		List<PersonVo> phonesearchList;

		System.out.println("**********************************************");
		System.out.println("* 		                     전화번호 관리 프로그램                    	  *");
		System.out.println("**********************************************");
		while (bool) {
			System.out.println("1.리스트 \t 2.등록 \t 3.수정 \t 4.삭제 \t 5.검색 \t 6.종료");
			System.out.println("-----------------------------------------------");
			System.out.print(">메뉴번호: ");
			num = sc.nextInt();
			switch (num) {

			case 1: // select
				System.out.println("<1. 리스트>");

				phoneList = phoneDao.getPersonList();
				for (int i = 0; i < phoneList.size(); i++) {
					PersonVo vo = phoneList.get(i);
					System.out.println(
							vo.getPerson_id() + ", " + vo.getName() + ", " + vo.getHp() + ", " + vo.getCompany());
				}
				break;

			case 2: // insert
				System.out.println("<2. 등록>");
				
				System.out.println("이름 > ");
				name = sc.nextLine();

				System.out.println("휴대전화 > ");
				hp = sc.nextLine();

				System.out.println("회사번호 > ");
				company = sc.nextLine();

				PersonVo personVo = new PersonVo(name, hp, company);
				phoneDao.personInsert(personVo);

				System.out.println("[1건 등록되었습니다.]");
				break;

			case 3: // update
				System.out.println("<3. 수정>");
				
				System.out.println("번호 > ");
				personId = sc.nextInt();

				System.out.println("이름 > ");
				name = sc.nextLine();

				System.out.println("휴대전화 > ");
				hp = sc.nextLine();

				System.out.println("회사번호 > ");
				company = sc.nextLine();

				PersonVo personVo1 = new PersonVo(personId, name, hp, company);
				phoneDao.personUpdate(personVo1);

				System.out.println("[1건 수정되었습니다.]");
				break;

			case 4:
				System.out.println("<4. 삭제>");
				
				System.out.println(">번호 :");
				personId = sc.nextInt();

				phoneDao.personDelete(personId);
				System.out.println("[1건 삭제 되었습니다.]");
				break;

			case 5:
				System.out.println("<5. 검색>");
				
				System.out.println("검색어 >");

				like = sc.nextLine();
				phonesearchList = phoneDao.phonesearchList(like);
				for (int i = 0; i < phonesearchList.size(); i++) {
					PersonVo vo = phonesearchList.get(i);
					System.out.println(
							vo.getPerson_id() + ", " + vo.getName() + ", " + vo.getHp() + ", " + vo.getCompany());
				}
				break;

			case 6:
				System.out.println(">메뉴번호: ");
				System.out.println("**********************************************");
				System.out.println("* 		                    감사합니다                    	  *");
				System.out.println("**********************************************");
				bool = false;
				break;

			default:
				System.out.println("[다시 입력해주세요.]");
				break;
			}

		}

		sc.close();

	}

}
