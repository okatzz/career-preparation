#include<string>
using namespace std;

string integerToString(int num){

	bool negative=false;
	if(num<0){
		negative=true;
		num=-num;
	}
	string temp;

	do{
		temp+='0'+num%10;
		num/=10;
	}while(num!=0);

	string result;
	if(negative)
		result+='-';
	for(int i=temp.length()-1; i>=0; i--){
		result+=temp[i];
	}

	return result;
}
