#include <iostream>
#include <fstream>
#include <string>
#include <json/value.h>
#include <json/json.h>
using namespace std;

int main(){
	Json::Value root;
	
	std::ifstream script;
	script.open("Path2.json");
	//std::ifstream file("Path2.json");
	//cout<<file;
	//file >> root;

//cout<<script;

string programm;
    if (script.is_open()) {
        while (!script.eof()) {
            string line;
            script >> line;
            line += '\n';
            programm += line;
            cout<<line;
        }
    }
    script.close();
}
