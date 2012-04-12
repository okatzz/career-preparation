#include <cstring>
#include <string>
#include <iostream>
using namespace std;

void reverse1(char str[]){
	int length = strlen(str);
	for (int i=0; i<(length+1)/2; i++){
		char tmp = str[i];
		str[i] = str[length-1-i];
		str[length-1-i] = tmp;
	}
}

void reverse2(char *str){
	char *end = str;
	while (*end)
		end++;
	end--;
	while(str<end){
		char tmp = *str;
		*str++=*end;
		*end--=tmp;
	}
}

