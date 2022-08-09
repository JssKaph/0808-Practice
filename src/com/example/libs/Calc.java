package com.example.libs;

public class Calc {
	private Employee [] array;
	private int count;
	
	public Calc(Employee[] array, int count) { // 생성자
		this.array = array;
		this.count = count;
	}
	
	public void calc() {
		for (int i=0; i<count; i++) {
			//영업부
			Employee emp = this.array[i]; 
			String empno = emp.getEmpno(); // A522
			String dname = this.getDname(empno.charAt(0)); // A가 넘어감
			emp.setDname(dname); // 영업부 셋팅
			
			//호급수당
			//String code = ""+empno.charAt(1); // '5' -> "5" 캐릭터를 스트링으로, +연산이 한쪽만 스트링이면 스트링으로 변함
			char code = empno.charAt(1); //'5'
			String codeStr = String.valueOf(code); //"5"
			int codeInt = Integer.parseInt(codeStr); // 5
			int hopay = this.getHopay(codeInt); // 호급수당
			emp.setHopay(hopay); // 호급수당 세팅
			
			//야간수당
			int nightpay = this.getNightpay(emp.getNight()); // 야근수당
			emp.setNightpay(nightpay); // 야근수당 세팅
			
			//기본급
			int base = emp.getBase();
			int basePay = this.getBase(base); // 기본급
			
			//가족수당 계산
			int family = emp.getFamily(); // 가족수
			int famPay = 700*family;
			emp.setFampay(famPay); // 가족수당 세팅
			
			//총급여 계산
			int total = hopay + basePay + nightpay + famPay; // 총금액
			emp.setTotal(total); // 총 금액 세팅
			
			//세금 계산, 실 수령액
			int tax = (int)(hopay*0.1);
			int salary = total - tax; //실 수령액
			emp.setSalary(salary); // 실 수령액 세팅
		}
	}

	private int getHopay(int code) { // 호급수당을 얻기 위한 메소드, 배열 사용
		int[] hopays = { 900000, 400000, 600000, 800000, 300000, 80000, 800000 };
		return hopays[code - 1]; // 배열 첫번째 방이 0이기 때문에 1이 들어오면 0번째 방을 호출
	}

	private int getBase(int base) { // 기본수당을 얻기 위한 메소드, 배열 사용
		int[] bases = { 15000, 25000, 35000, 45000 };
		return bases[base - 1];
	}
 
	private String getDname(char code) { // 부서코드로 부서명을 얻기 위한 메소드
		String[] dnames = { "영업부", "업무부", "홍보부", "인사부", "경리부", "판촉부", "총무부" };
		return dnames[code-65]; // 아스키코드
	}
	
	private int getNightpay(int night) { // 
		return (night == 1) ? 1500 :
						(night == 2) ? 2500 :
							(night == 3) ? 3500 : 4500;
	}
}
