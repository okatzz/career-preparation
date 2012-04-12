/*
 * test2.cpp
 *
 *  Created on: Jan 28, 2012
 *      Author: ggGrace
 */

#include<iostream>
using namespace std;

class Test{
	int i;
public:
	Test(const Test& t){
		i = t.i;
		cout<<"Test(const Test&)"<<endl;
	}

	void print(){
		cout<<i<<endl;
	}
};

//int main(){
//	Test t1;
//	t1.print();
//	Test t2=t1;
//	t2.print();
//}
