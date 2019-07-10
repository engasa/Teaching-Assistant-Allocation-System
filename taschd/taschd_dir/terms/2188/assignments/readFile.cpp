// reading a text file
#include <iostream>
#include <fstream>
#include <string>
#include <json/value.h>
#include <nlohmann/json.hpp>

// for convenience
using json = nlohmann::json;
using namespace std;



int main () {
  json::Value people;
  std::ifstream people_file("Path2.json", std::ifstream::binary);
  people_file >> people;

  cout<<people; 
  string line;
  string str1 = "Section";
  string str2 = "Section Number";
  string str3 = "Section Type";
  string str4 = "ID";
  string str5 = "TA Assigned";
  string str6 = "First Name";
  string str7 = "Time Schedule";

  ifstream myfile ("assign_GenAssignSolution");
  if (myfile.is_open())
  {
    while ( getline (myfile,line) )
    {
      size_t found1 = line.find(str1);
      size_t found2 = line.find(str2);
      size_t found3 = line.find(str3);
      size_t found4 = line.find(str4);
      size_t found5 = line.find(str5);
      size_t found6 = line.find(str6);
      size_t found7 = line.find(str7);
      // cout << "found1 " << found2 << " " << string::npos;
      if(found1 != string::npos){
        cout << "case 1" << line << '\n';
        
      }
      else if(found2 != string::npos){
        cout << "case 2" << line << '\n';
        
      }
      else if(found3 != string::npos){
        cout << line << '\n';
        
      }
      else if(found4 != string::npos){
        cout << line << '\n';
        
      }
      else if(found5 != string::npos){
        cout << line << '\n';
        
      }
      else if(found6 != string::npos){
        cout << line << '\n';
        
      }
      else if(found7 != string::npos){
        cout << line << '\n';
        
      }
      else
        cout << "nothing found" << '\n';

      
    }
    myfile.close();
  }

  else cout << "Unable to open file"; 

  return 0;
}