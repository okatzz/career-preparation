char *removeSpace(char *str){
	char *p1=str, *p2=str;
	while(*p2){
		while(*p2==' ')
			p2++;
		*p1=*p2;
		p1++;
		p2++;
	}
	*p1='\0';
	return str;
}
