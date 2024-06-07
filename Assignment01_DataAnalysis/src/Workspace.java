import java.util.ArrayList;

public class Workspace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataReader reader = new DataReader();
		DataDisplay display = new DataDisplay();

/*
// For 1D Data ----------------------------------------------------------		
//		String path = "Assignment01_DataAnalysy\\OneDData_02_short.txt";
		String path = "Assignment01_DataAnalysis\\OneDData_02_long.txt";
		
		ArrayList<String> dataString = reader.readFile(path);
		ArrayList<MyPoint> dataPoints = reader.convertTo1D(dataString);
		
		display.displayOneD(dataPoints);
		double dataDouble [] = new double [dataPoints.size()];
		for(int i= 0; i < dataPoints.size(); i++) {
			dataDouble[i] = dataPoints.get(i).getX();
		}
		StdAudio.play(dataDouble);
*/

/*
// For 2D Data ----------------------------------------------------------		
//		String path = "Assignment01_DataAnalysis\\TwoDData_02_short.txt";
//		String path = "Assignment01_DataAnalysis\\TwoDData_02_long.txt";
		
		ArrayList<String> dataString = reader.readFile(path);
		ArrayList<MyPoint> dataPoints = reader.convertTo2D(dataString);
		
		display.displayTwoD(dataPoints);
*/	

/*
// For 3D Data ----------------------------------------------------------
		String path = "ThreeDData_02.txt";
		
		ArrayList<String> dataString = reader.readFile(path);
		ArrayList<MyPoint> dataPoints = reader.convertTo3D(dataString);
		
		display.displayThreeD(dataPoints);

*/		
/*
// For Mystery Data -----------------------------------------------------
		String path = "MysteryData.txt";
		
		ArrayList<String> dataString = reader.readFile(path);
		ArrayList<City> dataCities = reader.convertMystery(dataString);

		display.displayMysteryData(dataCities);
*/
	}

}
