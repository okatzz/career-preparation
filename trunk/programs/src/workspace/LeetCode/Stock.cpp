/*
 * Stock.cpp
 *
 *  Created on: May 11, 2012
 *      Author: ggGrace
 */
#include<iostream>
#include<vector>
using namespace std;

void bestBuySellTime(const vector<int>& price, int& buy, int& sell){

	buy=sell=0;
	int maxPayoff=0;
	int minIdx=0;

	for(int i=0; i<price.size(); i++){
		if(price[i]<price[minIdx])
			minIdx=i;
		if(price[i]-price[minIdx]>maxPayoff){
			buy=minIdx;
			sell=i;
			maxPayoff=price[i]-price[minIdx];
		}
	}

}

int main(int argc, char* args[]){

	vector<int> prices(10);
	for(int i=0; i<prices.size(); i++){
		prices[i]=i;
	}
	int buy, sell;
	bestBuySellTime(prices, buy, sell);
	cout<<buy<<" "<<sell<<endl;
}


