//Duplicate of Exec.java (Randomized ArrayList) rewritten in c++ for a simple array
#include "stdio.h"
#include "stdlib.h"
#include "string.h"
#include "tgmath.h"
#include "sstream"
#include <iostream>

using namespace std;

int main(int argc, char* argv[]){
	int numElements = 10;
	if (argc > 0){
		stringstream(argv[1]) >> numElements;
	}
	printf("%d \n" , numElements);
	int data[numElements];
	for (int i = 0; i < numElements; i++){
		data[i] = i;
	}
	for (int i = 0; i < numElements; i++){
		int buffer = (rand() * 100) % numElements;
		int tmp = data[i];
		data[i] = data[buffer];
		data[buffer] = tmp;
	}
	for (int i = 0; i < numElements; i++){
		cout << data[i] + " ";
	}
	printf("\n");
	return 0;
}
