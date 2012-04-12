#include<iostream>
#include<string>
using namespace std;

long stringToInt(const string& str){
	
	if(str.empty()){
		cerr<<"Invalid input"<<endl;
		return -1;
	}

	int sign=1;
	if(str[0]=='-')
		sign=-1;
	else if(str[0]=='+')
		sign=1;

	int num=0, num1;
	for(int i=0; i<str.length(); i++){
		char c=str[i];
		if(c>='0' && c<='9'){
			num1=num;
			num=num1*10+c-'0';
			if(num<num1){
				cerr<<"Overflow! Too long string."<<endl;
				return num1;
			}
		}else if((c!='-' && c!='+') ||(i!=0)){
			cerr<<"Invalid input"<<endl;
			return -1;
		}
	}
	num*=sign;
	return num;

}

int main(){
	string s;
	cin>>s;
	cout<<stringToInt(s)<<endl;
}