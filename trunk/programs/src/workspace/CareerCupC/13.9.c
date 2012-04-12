#include"stdlib.h"

void *aligned_malloc(size_t required_size, size_t alignment){

	void *p1, *p2;

	p1 = malloc(required_size+alignment-1+sizeof(void *));
	p2= (void *)(((size_t)p1 + sizeof(void *) + alignment-1)&~(alignment-1));
	*((void **)p2-1)=p1;


	return p2;
}

void free(void *p2){
	void *p1=*((void **)p2-1);
	free(p1);
}
