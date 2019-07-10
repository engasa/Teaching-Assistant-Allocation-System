#include<iostream>
#include<string>

struct VehicleData {
	std::string vId;
	std::string control;
	std::string segment;	
	std::string posx;
	std::string posy;
};

std::ostream& operator<<(std::ostream &strm, const VehicleData &vehData);
class ReadData
{
	public:

	void LoadData();

	private:
		
	void findAllOccurances(std::vector<size_t>& vec, std::string data, std::string toSearch);

};

