package com.example.libs;

public class Output {
	private Employee [] array;
	private int count;

	public Output(Employee[] array, int count) {
		this.array = array;
		this.count = count;
	}
	public void output() {
		this.printLabel();
		for(int i=0; i<count; i++) {
			System.out.println(this.array[i]); // this.array[i].toString()
		}
	}
	private void printLabel() {
		System.out.println("                                            <<<<<부산전산산업진흥원 직원 월급 정보>>>>>");
		System.out.println("사원번호\t사원이름\t부서명\t기본급\t호급수당\t가족수당\t야근수당\t총금액\t실수령액");
		System.out.println("-------------------------------------------------------------");
	}
}
