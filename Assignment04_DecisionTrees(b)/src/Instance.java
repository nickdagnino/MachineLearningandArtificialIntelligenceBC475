import java.util.ArrayList;

public class Instance {

	private Attribute attribute;
	private String classification;

	public Instance(Attribute a, String c) {

		attribute = a;
		classification = c;

	}

	public Instance(ArrayList<String> a, String c) {

		Attribute att = new Attribute(a);
		attribute = att;
		classification = c;

	}

	public Attribute getAttribute() {

		return attribute;

	}

	public String getClassification() {

		return classification;

	}

	public String getAttributeAtIndex(int index) {

		return attribute.getFields().get(index);

	}
	
	public ArrayList<String> getAttrFieldsNames() {
		
		return attribute.getFieldNames();
				
	}

	public String toString() {
		
		String attributeString = attribute.getFields().toString();
	    return attributeString;

	}

}