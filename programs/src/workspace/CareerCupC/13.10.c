/*
 * 13.10.c
 *
 *  Created on: Jan 19, 2012
 *      Author: ggGrace
 */

#include"stdlib.h";

int** my2DAlloc(int nrows, int ncols){

	int i;
	int headerSize = sizeof(int *)*nrows;
	int arraySize = sizeof(int)*nrows*ncols;
	int **arr = (int **)malloc(headerSize+arraySize);
	int *indent = (int *)(arr+nrows);
	for(i=0; i<nrows; i++){
		arr[i]=indent+i*ncols;
	}
	return arr;
}
