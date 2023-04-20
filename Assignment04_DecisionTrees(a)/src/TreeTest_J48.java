import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instance;
import weka.core.Instances;
import weka.gui.treevisualizer.PlaceNode2;
import weka.gui.treevisualizer.TreeVisualizer;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import weka.core.converters.ConverterUtils.DataSource;
import weka.core.Instances;

public class TreeTest_J48 {

	public void testTreeJ48(String trainingPath, String testingPath, int classIndex) {

		Instances data;
		Instances dataTest;

		try {

			System.out.println("Building J48 Tree");

			// Training Set
			DataSource source = new DataSource(trainingPath);
			data = source.getDataSet();
			data.setClassIndex(classIndex);

			// Testing Set
			DataSource sourceTest = new DataSource(testingPath);
			dataTest = sourceTest.getDataSet();
			dataTest.setClassIndex(classIndex);

			// Build the J48 Tree and Train with Training Data
			J48 cls = new J48();
			cls.buildClassifier(data);
			
			J48 cls1 = new J48();
			cls1.buildClassifier(dataTest);

			showTree(cls);
			showTree(cls1);

			// Evaluate Tree - Training Set
			System.out.println("Evaluating Tree for Training Set:");
			Evaluation eval = new Evaluation(data);
			eval.evaluateModel(cls, data);
			System.out.println("Error rate Training Set: " + eval.errorRate());
			System.out.println(eval.toSummaryString());
			double[][] confusionMatrix = eval.confusionMatrix();
			String out = getMatrixString(confusionMatrix);
			System.out.println("Confusion Matrix Training Set:");
			System.out.println(out);
			System.out.println("Tree Size: " + cls.measureTreeSize());
			System.out.println("Number of Leaves: " + cls.measureNumLeaves());

			// Evaluate Tree - Testing Set
			System.out.println("Evaluating Tree for Testing Set:");
			Evaluation eval1 = new Evaluation(dataTest);
			eval1.evaluateModel(cls, dataTest);
			System.out.println("Error rate Testing Set: " + eval1.errorRate());
			System.out.println(eval1.toSummaryString());
			confusionMatrix = eval1.confusionMatrix();
			System.out.println("Confusion Matrix Testing Set:");
			out = getMatrixString(confusionMatrix);
			System.out.println(out);
			System.out.println("Tree Size: " + cls1.measureTreeSize());
			System.out.println("Number of leaves: " + cls1.measureNumLeaves());

		}

		catch (Exception e) {

			e.printStackTrace();

		}

	}

	public Instances getData(String dataPath, int classIndex) {

		Instances data = null;

		try {

			System.out.println("Getting Data Instances");

			// Build Instances from dataPath
			DataSource source = new DataSource(dataPath);
			data = source.getDataSet();
			data.setClassIndex(classIndex);

		}

		catch (Exception e) {

			e.printStackTrace();

		}

		return data;

	}

	public J48 getJ48Tree(String dataPath, int classIndex) {

		Instances data;
		J48 cls = null;

		try {

			System.out.println("Building J48 Tree");
			// Get Data Set from Path
			DataSource source = new DataSource(dataPath);
			data = source.getDataSet();
			data.setClassIndex(classIndex);

			cls = new J48();
			cls.buildClassifier(data);

		}

		catch (Exception e) {

			e.printStackTrace();

		}

		return cls;

	}

	public void showTree(J48 cls) {

		try {
			String graphDescriptor = cls.graph();

			final javax.swing.JFrame jf = new javax.swing.JFrame("Weka Classifier Tree Visualizer: J48");

			jf.setSize(1800, 1000);
			jf.getContentPane().setLayout(new BorderLayout());

			TreeVisualizer tv = new TreeVisualizer(null, graphDescriptor, new PlaceNode2());

			jf.getContentPane().add(tv, BorderLayout.CENTER);

			jf.addWindowListener(new java.awt.event.WindowAdapter() {
				public void windowClosing(java.awt.event.WindowEvent e) {
					jf.dispose();
				}
			});

			jf.setVisible(true);
			tv.fitToScreen();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private String getMatrixString(double[][] m) {
		String out = "";

		for (int r = 0; r < m.length; r++) {
			String line = "";
			for (int c = 0; c < m[0].length; c++) {
				line += (int) m[r][c] + " ";
			}
			line += "\n";
			out += line;
		}

		return out;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create Instance and Test
		TreeTest_J48 decisionTree = new TreeTest_J48();

//		// Define Paths for Training and Testing Data for Iris Data
//		String trainingPath = "IrisData/iris_train.csv";
//		String testingPath = "IrisData/iris_test.csv";
//		int classIndex = 4;

//		// Define Paths for Training and Testing Data for Diabetes Data
//		String trainingPath = "DiabetesData/diabetes_data_train.csv";
//		String testingPath = "DiabetesData/diabetes_data_test.csv";
//		int classIndex = 16;

		// Define Paths for Training and Testing Data for Pay Data
		String trainingPath = "PayData/pay_data_training.csv";
		String testingPath = "PayData/pay_data_test.csv";
		int classIndex = 8;

//		// Define Paths for Training and Testing Data for TTT Data
//		String trainingPath = "Tic-Tac-ToeData/ttt_train_data.csv";
//		String testingPath = "Tic-Tac-ToeData/ttt_test_data.csv";
//		int classIndex = 9;

		// Run Tree Build and Test
		decisionTree.testTreeJ48(trainingPath, testingPath, classIndex);
		// decisionTree.testTreeJ48(testingPath, trainingPath, classIndex);

//		//Get Instances for Data
//		Instances data = decisionTree.getData(testingPath, classIndex);
//		
//		//Get J48 Tree
//		J48 treeClassifier = decisionTree.getJ48Tree(trainingPath, classIndex);
//		
//		//Test Classification for one instance
//		//Instance 0
//		Instance sample = data.instance(1);
//		
//		try {
//			
//			double type = treeClassifier.classifyInstance(sample);
//			System.out.println(type);
//			
//		}
//		
//		catch (Exception e) {
//			
//			e.printStackTrace();
//			
//		}
//
	}

}
