import java.util.ArrayList;

public class Workspace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataReader reader = new DataReader();
		DataDisplay display = new DataDisplay();

		String path = "romania.txt";
		
		ArrayList<String> dataString = reader.readFile(path);
		ArrayList<City> dataCities = reader.convertRomania(dataString);
		
		display.displayRomaniaData(dataCities);

	}

		

}
