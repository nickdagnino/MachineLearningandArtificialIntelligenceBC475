import java.util.ArrayList;

public class Workspace {

	public static void main(String[] args) {

//		DataSet set = new DataSet("Restaurant_Data.csv", 10);
//		System.out.println(set.toString());
//		
//		testNodes();
		
//		testTreeBuilder("Assignment04_DecisionTrees(b)\\Restaurant_Data.csv", 10);

	}
	
	public static void testTreeBuilder(String path, int index) {
		
		DataSet data = new DataSet("Restaurant_Data.csv", 10);
		Node treebuilder = new Node();
		
		ArrayList<String> fieldList = data.getAttributeList();
		ArrayList<String> copyFieldList = new ArrayList<String>();
		
		Instance test = data.getInstance(0);
		//System.out.println("Instance: " + test.getAttribute());
		
		for(String s : fieldList) {
			
			copyFieldList.add(s);
			
		}
		
		Node tree = treebuilder.getDecisionTree(data, test.getAttribute(), data);
		
		for(int i = 0; i < data.getData().size(); i++) {
			
			Instance I = data.getInstance(i);
			Attribute attr = I.getAttribute();
			String classification  = tree.classify(attr);
			
			System.out.println("Instance: " + I);
			System.out.println("Tree Decided: " + classification);
			System.out.println("================================");
			
		}
		
		
	}

	public static void testNodes() {

		Node leaf1 = new Node("No");
		Node leaf2 = new Node("Yes");

		Node node1 = new Node("Patron", 4);
		Node node2 = new Node("Hungry", 3);
		Node node3 = new Node("Type", 8);
		Node node4 = new Node("Friday", 2);

		node1.addBranch(leaf1, "None");
		node1.addBranch(leaf2, "Some");
		node1.addBranch(node2, "Full");
		
		node2.addBranch(leaf1, "No");
		node2.addBranch(node3, "Yes");
		
		node3.addBranch(leaf2, "French");
		node3.addBranch(leaf1, "Italian");
		node3.addBranch(leaf2, "Burger");
		node3.addBranch(node4, "Thai");
		
		node4.addBranch(leaf1, "No");
		node4.addBranch(leaf2, "Yes");

		String path = "Restaurant_Data.csv";
		DataSet set = new DataSet(path, 10);
		
		Instance test = set.getInstance(0);
		System.out.println(test.getAttribute());
		System.out.println(test.getClassification());

	}

}