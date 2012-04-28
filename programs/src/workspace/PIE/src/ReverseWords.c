/*
 * ReverseWords.c
 * Write a function that reverses the order of the words in a string. For example, your function should transform the string “Do or do not, there is no try.” to “try. no is there not, do or Do”. Assume that all words are space delimited and treat punctuation the same as letters.
 *  Created on: Jan 29, 2012
 *      Author: ggGrace
 */


void reverseString(char str[], int start, int end){

	char temp;

	while(start<end){
		temp=str[start];
		str[start]=str[end];
		str[end]=temp;
		start++;
		end--;
	}
}

void reverseWords(char str[]){

	int length;
	int start=0, end=0;

	length=strlen(str);

	reverseString(str, 0, length-1);

	while(end<length){
		if(end!=' '){
			start=end;
			while(str[end]!=' '&&str[end]!='\0')
				end++;
			end--;
			reverseString(str, start, end);
		}
		end++;
	}

}
