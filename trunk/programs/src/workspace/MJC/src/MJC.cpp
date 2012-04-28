//http://www.mitbbs.com/article_t/JobHunting/32101931.html

#include<iostream>
using namespace std;

class Node{
public:
	Node *next;
	int value;
};

Node* exchangeLinkedList(Node *head){

	Node *p=head;
	while(p->next&&p->next->next){
		Node *one=p->next;
		p->next=one->next;
		one->next=p->next->next;
		p->next->next=one;
		p=one;
	}
	return head;
}

void print(Node *head){
	while(head->next){
		cout<<head->next->value<<' ';
		head=head->next;
	}
	cout<<endl;
}

int main(int argc, char* args[]){
	Node *head=new Node;
	Node *p=head;
	for(int i=0; i<11; i++){
		p->next=new Node;
		p->next->value=i;
		p=p->next;
	}
	p->next=NULL;
	print(head);
	print(exchangeLinkedList(head));
}
