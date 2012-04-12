#include<string>
using namespace std;

int stringToInteger(string s){

	int sign=1;
	int i=0;

	if(s[0]=='-'){
		sign=-1;
		i=1;
	}

	int num=0;
	for(;i<s.length(); i++){
		num=num*10+s[i]-'0';
	}

	return num*sign;

}
