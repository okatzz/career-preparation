/*
 *  roman.cpp
 *  Roman
 *
 *  Created by Ge Gao on 4/20/12.
 *  Copyright 2012 UVa. All rights reserved.
 *
 */
#include<iostream>
#include<string>
using namespace std;

class RomanNumerals{

	int getValue(char c){
		switch (c) {
			case 'I':
				return 1;
			case 'V':
				return 5;
			case 'X':
				return 10;
			case 'L':
				return 50;
			case 'C':
				return 100;
			case 'D':
				return 500;
			case 'M':
				return 1000;
		}
	}

public:
	
	string Int2Roman(int num){
		
	}
	
	int Roman2Int(string s){
		if (s.length()==0) {
			return 0;
		}
		int num=0;
		int i=0;
		int cur=getValue(s[0]);
		while (i<s.length()-1) {
			int next=getValue(s[i+1]);
			if (cur>=next) {
				num+=cur;
			}else {
				num-=cur;
			}
			i++;
			cur=next;
		}
		num+=cur;
		return num;

	}

};

int main(){
	string s;
	cin>>s;
	RomanNumerals instance;
	cout << instance.Roman2Int(s)<<endl;
}
