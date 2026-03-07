package workshop.person.control;

import workshop.person.entity.PersonEntity;

public class PersonEntityTest {
	public static void main(String[] args) {
		PersonEntityTest test = new PersonEntityTest(); //static 아닌 메서드를 위한 객체 생성 
		
		PersonEntity[] persons = new PersonEntity[2]; //배열 선언 
		
		test.fillPersons(persons); 
		
		test.printPersons(persons);
		
	}

	public void printPersons(PersonEntity[] persons) { //person 출력하는 메서드
		//Enhanced for Loop
		for (PersonEntity person : persons) {
			System.out.println(person.getName() + " " + person.getGender());
			//결과: 이성호 남 / 김하늘 여 
		}
	}

	//static 아닌 메서드에서 위의 static 메서드 바로 호출 불가, 별도의 메서드 추출
	public void fillPersons(PersonEntity[] persons) { //person에 채워넣는 메서드 
		persons[0] = new PersonEntity("이성호","7212121028102", "인천 계양구", "032-392-2932");
		persons[1] = new PersonEntity("김하늘","7302132363217", "서울 강동구", "02-362-1932");
	}
}
