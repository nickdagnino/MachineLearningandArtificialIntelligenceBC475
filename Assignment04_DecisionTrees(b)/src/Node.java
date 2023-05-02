import java.util.ArrayList;

public class Node {

	private String attribute = "";
	private int attributeIndex = -1;
	private ArrayList<Node> branches = new ArrayList<Node>();
	private ArrayList<String> values = new ArrayList<String>();
	private String output = "";
	
	public Node() {}
	
	public Node(String attr, int index) {
		
		attribute = attr;
		attributeIndex = -1;
		
	}
	
	public Node(String out) {
		
		output = out;
		
	}
	
	public void addBranch(Node n, String v) {
		
		branches.add(n);
		values.add(v);
		
	}
	
	public String classify(Attribute instance) {
		
		if(branches.size() < 1)
			return output;
		
		else {
			
			String value = instance.getValueAt(attribute);
			int branchIndex = values.indexOf(value);
			return branches.get(branchIndex).classify(instance);
			
		}
	}
	
	public Node getDecisionTree(DataSet data, Attribute attributes, DataSet parentData) {
		
		Util util = new Util();
		
		if(data.getData().isEmpty())
			return new Node(util.getPluralityValue(parentData));
		
		else if(util.isSame(data))
			return new Node(data.getInstance(0).getClassification());
		
		else if(attributes.getFieldNames().isEmpty())
			return new Node(util.getPluralityValue(data));
		
		else {
			
			String A = util.getImportance(attributes, data);
			Node root = new Node(A, attributes.getIndex(A));
			ArrayList<String> choices = util.getAttributeChoices(data, attributes.getIndex(A));
			
			for(String choice : choices) {
				
				ArrayList<String> names = new ArrayList<String>();
				ArrayList<Instance> instances = new ArrayList<Instance>();
				
				for(Instance instance : data.getData()) {
					if(instance.getAttributeAtIndex(attributes.getIndex(A)).equals(choice)) {
						instances.add(instance);
					}
				}
				for(String field : attributes.getFieldNames()) {
					if(!field.equals(A)) {
						names.add(field);
					}
				}
				
				DataSet exs = new DataSet(names, instances);
				
				Attribute newAttributes = new Attribute(names);
				
				Node subTree = getDecisionTree(exs, newAttributes, data);
				root.addBranch(subTree, choice);
			}
			
			return root;
			
		}
		
	}
	
}