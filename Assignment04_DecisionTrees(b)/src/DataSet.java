import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DataSet {

	private ArrayList<Instance> data;
	private ArrayList<String> attrs;

	public DataSet() {
	}

	public DataSet(String path, int classIndex) {

		ArrayList<String> input = readFile(path);
		attrs = createAttributeList(input);
		data = createInstancesList(input, classIndex);

	}

	public DataSet(ArrayList<String> a, ArrayList<Instance> i) {

		attrs = a;
		data = i;
		
	}
	
	public ArrayList<String> readFile(String path) {
		ArrayList<String> output = new ArrayList<String>();
		try {
			File file = new File(path);
			Scanner input = new Scanner(file);
			while (input.hasNext()) {
				output.add(input.nextLine());
			}
			input.close();
			return output;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<String> createAttributeList(ArrayList<String> input) {

		ArrayList<String> output = new ArrayList<String>();

		String dataLine[] = input.remove(0).split(",");

		for (int j = 0; j < dataLine.length; j++) {

			output.add(dataLine[j]);

		}

		return output;

	}
	
	public ArrayList<Instance> createInstancesList(ArrayList<String> input, int index) {
		
	    ArrayList<Instance> output = new ArrayList<Instance>();
	    ArrayList<ArrayList<String>> attributesList = new ArrayList<ArrayList<String>>();
	    ArrayList<String> classificationList = new ArrayList<String>();

	    for (int m = input.size() - 1; m >= 0; m--) {
	        ArrayList<String> temp = new ArrayList<String>();
	        String dataLine[] = input.get(m).split(",");

	        for(int k = 0; k < dataLine.length; k++) {
	            temp.add(dataLine[k]);
	        }

	        String classificationString = temp.get(index);
	        temp.remove(index);

	        attributesList.add(temp);
	        classificationList.add(classificationString);
	    }

	    Collections.reverse(attributesList);
	    Collections.reverse(classificationList);

	    for (int i = 0; i < attributesList.size(); i++) {
	        Instance instance = new Instance(attributesList.get(i), classificationList.get(i));
	        output.add(instance);
	    }

	    return output;

	}


	public void addInstance(Instance i) {

		data.add(i);

	}

	public DataSet removeAttributeAtIndex(int index) {

		ArrayList<Instance> dataCopy = new ArrayList<Instance>();
		ArrayList<String> attrsCopy = new ArrayList<String>();

		for (int i = 0; i < attrs.size(); i++) {
			if (i == index)
				i++;
			attrsCopy.add(attrs.get(i));
			dataCopy.add(data.get(i));
		}

		DataSet output = new DataSet(attrsCopy, dataCopy);

		return output;

	}

	public DataSet removeAttributeByName(String name) {

		return null;

	}

	public ArrayList<Instance> getData() {

		return data;

	}

	public Instance getInstance(int index) {

		return data.get(index);

	}

	public ArrayList<String> getAttributeList() {

		return attrs;

	}

	public String toString() {

		String output = "";
		output += getAttributeList() + "\n";
		//output += getData();

		for(Instance i : data) {
			
			output += i + " \n";
			
		}

		return output;

	}

}