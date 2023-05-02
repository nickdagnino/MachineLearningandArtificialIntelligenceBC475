import java.util.ArrayList;

public class Attribute {

	private ArrayList<String> fields = new ArrayList<String>();
	private ArrayList<String> fieldNames = new ArrayList<String>();

	public Attribute(ArrayList<String> input) {

		fields = input;

	}

	public Attribute(Attribute a) {

		for (String s : a.getFields()) {

			fields.add(s);

		}
	}

	public ArrayList<String> getFields() {

		return fields;

	}

	public ArrayList<String> getCopyFields() {

		ArrayList<String> copy = new ArrayList<String>();

		for (String s : fields) {

			copy.add(s);

		}

		return copy;

	}

	public ArrayList<String> getFieldNames() {

		return fieldNames;

	}
	
	public String getValueAt(String attr) {
		
		int index = fieldNames.indexOf(attr);
		return fields.get(index);
		
	}
	
	public int getIndex(String str) {
		
		return fieldNames.indexOf(str);
		
	}

	public String toString() {

		return fields + "";

	}

}