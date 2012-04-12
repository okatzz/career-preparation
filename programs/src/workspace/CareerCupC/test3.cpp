/*
 * test3.cpp
 *
 *  Created on: Jan 29, 2012
 *      Author: ggGrace
 */
#include<iostream>
using namespace std;

void printLength(int a[]){
	cout<<sizeof(a)<<endl<<sizeof(*a)<<endl;
}

int main(){
	int b[]={1, 2, 3, 4};
	cout<<sizeof(b)<<endl<<sizeof(*b)<<endl;
	printLength(b);
}

