#include "Read_Data.hpp"
#include <fstream>
#include <iostream>
#include <sstream>
#include <string>
#include <vector>
using namespace std;

std::ostream& operator<<(std::ostream &strm, const VehicleData &vehData) {
  return strm << "Vehicle data: " << vehData.vId << ", " << vehData.control << ", " << vehData.segment << ", "  
  << vehData.posx << ", "  << vehData.posy;
}


void findAllOccurances(std::vector<size_t>& vec, std::string data, std::string toSearch)
{
  // Get the first occurrence
  size_t pos = data.find(toSearch);
 
  // Repeat till end is reached
  while( pos != std::string::npos)
  {
    // Add position to the vector
    vec.push_back(pos);
 
    // Get the next occurrence from the current position
    pos = data.find(toSearch, pos + toSearch.size());
  }
}



int main()
{
  // read each line
  std::string line;

  // key variables from txt file
  std::string strVId ("Vehicle Id");
  std::string strControl ("Controller");
  std::string strSegment ("Segments");
  std::string strposX ("posx");
  std::string strposY ("posy");

  // variables to store data read from txt
  std::string vId;
  std::string control;
  std::string segment;
  std::string posx;
  std::string posy;
  int count;
  std::vector<size_t> vec;

  ifstream myfile("Cars.txt");
    if (myfile)
      {
        while (getline(myfile, line))
          {
            findAllOccurances(vec, line , strVId);
          }
          myfile.close();
      }
    count = vec.size();
    // count of vehicles
    cout<<"size of struct: " << count<<"\n";

    // struct to store data per vehicle
    VehicleData* newVehicleData = new VehicleData[count];

    ifstream myfile2("Cars.txt");

    // lookup file with name Cars.txt
      if (myfile2)
      {
        while (getline(myfile2, line))
        {
            if (line.find(strVId)!=std::string::npos){
            stringstream stream(line);
            getline(stream,vId,':');
            stream>>vId;
            std::cout << "Vehicle id: " << vId+"\n";
          }
          // look for Controller name
          else if (line.find(strControl)!=std::string::npos){
            stringstream stream(line);
            getline(stream,control,':');
            stream>>control;
            std::cout << "Controller: " << control+"\n";
          }
          // look for segment ids
          else if (line.find(strSegment)!=std::string::npos){
            stringstream stream(line);
            getline(stream,segment,':');
            stream>>segment;
            std::cout << "Segments: " << segment+"\n";
          }
          // look for posx
          else if (line.find(strposX)!=std::string::npos){
            stringstream stream(line);
            getline(stream,posx,':');
            stream>>posx;
            std::cout << "posx: " <<  posx+"\n";
          }
          // look for posy and set data in struct variable
          else if (line.find(strposY)!=std::string::npos){
            stringstream stream(line);
            getline(stream,posy,':');
            stream>>posy;
            std::cout << "posy: " << posy+"\n";
            
          }
          
        }
        myfile2.close();
      }
      else cout << "file not found.\n";
      
      return 0;
}