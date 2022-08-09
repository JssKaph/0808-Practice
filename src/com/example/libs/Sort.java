package com.example.libs;

public class Sort {
	private Employee [] array;
	private int count;
	
	public Sort(Employee[] array, int count) {
		this.array = array;
		this.count = count;
	}
	
	public void selectionSort() {
		for(int i = 0 ; i < this.count - 1 ; i++) {
			for(int j = i + 1 ; j < this.count ; j++) {
				String front = this.array[i].getEmpno();
				String back = this.array[j].getEmpno();
				if(front.compareTo(back) > 0) {  //front가 back보다 크다면
					swap(i, j);
				}
			}
		}
	}
	
	private void swap(int front, int back) {
		Employee temp = this.array[front];
		this.array[front] = this.array[back];
		this.array[back] = temp;
	}
}
