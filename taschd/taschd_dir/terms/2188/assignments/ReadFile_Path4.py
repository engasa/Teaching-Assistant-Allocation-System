import json
#from pprint import pprint
# uncomment above line to pretty print raw json on your console

# uncomment below for python 3.5
#with open('Path4.json', encoding='utf-8') as data_file:
#    data = json.loads(data_file.read())

# open() for python 2.7
with open('Path4.json') as f:
    data = json.load(f)

# number of paths
idCount = len(data["Path"]);

# number of parameters in every path and their values
paramCount = 4;
paramValue = ["id","Segment Details","name","Car Details"];

# number of Car Details parameters and their values
carParamCount = 1;
carParamValue = ["Vehicle Number"];

# number of car details parameters and their values
segmentParamCount = 1;
segmentParamValue = ["Segment Number"];

# count of cars and their car numbers
totalCars = 0;
carNumbers = [];

controllerDetails = data["Controller"];
pathDetails = data["Path"];
#pprint(pathDetails[0]);
print(controllerDetails)

for i in range(idCount):
	print;
	#print("data for path"+ str(i+1) + ":");
	for j in range(paramCount):
		if(paramValue[j] == "Car Details"):
			carCount = len(pathDetails[i][paramValue[j]]);
			for x in range(carCount):
				for k in range(carParamCount):
					# print vehicle numbers
					print(carParamValue[k]+" : " + str(pathDetails[i][paramValue[j]][x][carParamValue[k]]));
					carNumbers.append(pathDetails[i][paramValue[j]][x][carParamValue[k]]);
			totalCars += carCount;
		elif(paramValue[j] == "Segment Details"):
			segmentCount = len(pathDetails[i][paramValue[j]]);
			for y in range(segmentCount):
				for m in range(segmentParamCount):
					# print segment numbers
					print(segmentParamValue[m]+" : " + str(pathDetails[i][paramValue[j]][y][segmentParamValue[m]]));
		else:
			# print parameters like id and name
			print(paramValue[j]+" : "+str(pathDetails[i][paramValue[j]]));

# count of cars and their values for creating threads
print;
print("total number of cars in all paths: " + str(totalCars));
print("car numbers: "+str(carNumbers));