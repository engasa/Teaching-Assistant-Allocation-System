#include <iostream>
#include <fstream>
#include <string>
#include <json/value.h>
#include <json/json.h>
using namespace std;

Json::Value root;
Json::CharReaderBuilder reader;

std::ifstream file("Path4.json");
file >> root;

if(!reader.parse(file, root, true)){
        //for some reason it always fails to parse
    std::cout  << "Failed to parse configuration\n"
               << reader.getFormattedErrorMessages();
}
//set to 30 in file, but constantly returns 0
int width = root["jumper.width"].asInt();
//equivalent code, also returns 0
width = root.get("jumper.width", 30).asInt();