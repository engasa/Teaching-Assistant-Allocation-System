#include <fstream>
#include <iostream>
#include <sstream>
#include <string>

#include <vector>
using namespace std;


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
    pos =data.find(toSearch, pos + toSearch.size());
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
  std::vector<size_t> vec;



  

  // lookup file with name Cars.txt
  ifstream myfile("Cars.txt");

    if (myfile)
      {
        while (getline(myfile, line))
        {
          findAllOccurances(vec, line , strVId);
          
        }
        myfile.close();
      }
      cout<<vec.size();
     //   for(size_t pos : vec)
     //     std::cout<<pos<<std::endl;

  
 
  // Get All occurrences of the 'is' in the vector 'vec'
  
 
  std::cout<<"All Index Position of 'is' in given string are,"<<std::endl;


return 0;
}