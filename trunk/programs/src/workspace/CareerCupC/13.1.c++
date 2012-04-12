/*
 * 13.1.c++
 *
 *  Created on: Jan 23, 2012
 *      Author: ggGrace
 */


#include<string>
#include<iostream>
#include<fstream>
using namespace std;

void printLastKLines(int K, char *filename){

	int count=0;
	ifstream inputFile(filename);
	string *Kbuffer = new string[K];

	while(getline(inputFile, Kbuffer[count%K])){
		count++;
	}

	int start, size;
	if(count<=K){
		start=0;
		size=count;
	}else{
		start=K;
		size=K;
	}
	for(int i=0; i<size; i++)
		cout<<Kbuffer[(start+i)%K]<<endl;
}

