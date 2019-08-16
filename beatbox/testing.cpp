#include<iostream>
using namespace std;
int main(){
	int i;
	int x;
	int tempo=0;
	int overlapping = -5;
	int interval = 7;
	for(i=0;i<16;i++){
		if(i==0){
			x = 0;
		}else{
			x = overlapping;
		}
		tempo = tempo + 1 + x;
		cout<<tempo<<endl;
		tempo = tempo + interval;
		cout<<tempo<<endl;
	}
}
