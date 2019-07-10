import json
from pprint import pprint

with open('Path3.json', encoding='utf-8') as data_file:
    data = json.loads(data_file.read())

print(len(data["Path"]))

# number of paths
idCount = len(data["Path"]);

# number of parameters and their values
paramCount = 4; # len(pathDetails[i])
paramValue = ["id","Segment Number","Distance","Car Details"];

# number of car details parameters and their values
carParamCount = 3;
carParamValue = ["Vehicle Number","pos_x","pos_y"];

pathDetails = data["Path"];
#pprint((pathDetails[0]))

for i in range(idCount):
	print("data for path: "+ str(i+1));
	for j in range(paramCount):
		if(paramValue[j] == "Car Details"):
			carCount = len(pathDetails[i][paramValue[j]]);
			#print(carCount);
			for x in range(carCount):
				for k in range(carParamCount):
					print(carParamValue[k]+" : " + str(pathDetails[i][paramValue[j]][x][carParamValue[k]]));
		else:
			print(paramValue[j]+" : "+str(pathDetails[i][paramValue[j]]));

	#paramCount = len(pathDetails[i])
	#print(paramCount)
	#vehicleDetails[i] = 
#if(data["Path1"][0]["Vehicle Number"] == 18):
	#print("true")


