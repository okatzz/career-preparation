/*
 * LongestPalindromeSubstring.cpp
 *
 *  Created on: Apr 21, 2012
 *      Author: ggGrace
 */

#include<string>
#include<iostream>
using namespace std;

string palindromeSubstring(string s){
	int l=s.length();
	bool **table=new bool*[l];
	for(int i=0; i<l; i++)
		table[i]=new bool[l];
	int maxLength=1;
	int maxStart=0;
	for(int i=0; i<l; i++){
		table[i][i]=true;
	}
	for(int i=0; i<l-1; i++){
		if(s[i]==s[i+1]){
			table[i][i+1]=true;
			maxLength=2;
			maxStart=i;
		}
	}
	for(int len=3; len<=l; len++){
		for(int i=0; i<=(l-len);i++){
			if(table[i+1][i+len-2]&&(s[i]==s[i+len-1])){
				table[i][i+len-1]=true;
				maxLength=len;
				maxStart=i;
			}
		}
	}
	delete[] table;
	return s.substr(maxStart, maxLength);
}

//int main(int argc, char* args[]){
//	string s;
//	cin>>s;
//	cout<<palindromeSubstring(s)<<endl;
//}


