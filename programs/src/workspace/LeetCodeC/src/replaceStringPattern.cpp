void replacePattern(char *str, const char *pattern){
	if(!str||!pattern)
		return;
	char *pslow=str, *pfast=str;
	int l=strlen(pattern);
	while(*pfast){
		bool matched=false;
		while(isMatch(pfast, pattern)){
			matched=true;
			pfast+=l;
		}
		if(matched){
			matched=false;
			*pslow++='X';
		}
		if(*pfast){
			*pslow++=*pfast++;
		}
	}
	*pslow='\0';

}


bool isMatch(const char *str1, const char *str2){
	while(*str2){
		if((!*str1)||(*str1!=*str2))
			return false;
		str1++;
		str2++;
	}
	return true;
}
