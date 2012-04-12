#include <string>
using namespace std;

int lengthOfSubstring(string s){
	int i=0, j=0;
	int max=0;
	bool table[256]={false};
	for(;j<s.length(); j++){
		if(!table[s[j]]){
			table[s[j]]=true;

		}else{
			while(s[i]!=s[j])
				table[s[i]]=false;
			i++;
		}
		if(max<(j-i+1))
			max=(j-i+1);
		j++;
	}
	return max;
}
