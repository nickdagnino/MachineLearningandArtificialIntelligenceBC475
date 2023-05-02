import java.util.ArrayList;

public class Util {

	public double getB(double q) {

		double b = 0;

		b = -(q * (Math.log(q) / Math.log(2)) + (1 - q) * (Math.log(1 - q) / Math.log(2)));

		return b;

	}

	public double getRemainder(DataSet data, int attrIndex) {

		ArrayList<String> distinctValues = new ArrayList<String>();

		for (Instance instance : data.getData()) {

			String attrValue = instance.getAttribute().getFields().get(attrIndex);

			if (!distinctValues.contains(attrValue)) {

				distinctValues.add(attrValue);

			}

		}

		ArrayList<ArrayList<Instance>> subsets = new ArrayList<ArrayList<Instance>>();

		for (String value : distinctValues) {

			ArrayList<Instance> subset = new ArrayList<Instance>();

			for (Instance instance : data.getData()) {

				String attrValue = instance.getAttribute().getFields().get(attrIndex);

				if (attrValue.equals(value)) {

					subset.add(instance);

				}

			}

			subsets.add(subset);

		}

		double p = 0;
		double n = 0;
		double remainder = 0;

		for (ArrayList<Instance> subset : subsets) {

			p = 0;
			n = 0;

			for (Instance instance : subset) {

				if (instance.getClassification().equals("yes")) {

					p++;

				}

				else {

					n++;

				}

			}

			double q = p / (p + n);
			double subsetEntropy = getB(q);
			double subsetSize = subset.size();
			double totalSize = data.getData().size();
			double subsetWeight = subsetSize / totalSize;

			remainder += subsetWeight * subsetEntropy;
		}

		return remainder;

	}
	
	public double getGain(DataSet data, int attrIndex) {
		
		int p = 0;
		int n = 0;
		
	    for (Instance instance : data.getData()) {
	    	
	        if (instance.getClassification().equals("yes")) {
	        	
	            p++;
	            
	        } 
	        
	        else {
	        	
	            n++;
	            
	        }
	        
	    }
	    
	    double pRatio = (double) p / (p + n);
	    double bValue = getB(pRatio);
	    double remainder = getRemainder(data, attrIndex);
	    
	    return bValue - remainder;
		
	}
	
	public String getImportance(Attribute attributes, DataSet data) {
		
		double maxGain = 0;
		String maxTitle = "";
		
		for(int i = 0; i < attributes.getFieldNames().size(); i++) {
			
			String title = attributes.getFields().get(i);
			int index = data.getAttributeList().indexOf(title);
			double gain = getGain(data, index);
			
			if(gain > maxGain) {
				
				maxGain = gain;
				maxTitle = title;
				
			}
			
		}
		
		return maxTitle;
		
	}
	
	public String getPluralityValue(DataSet data) {
		
	    int yesCount = 0;
	    int noCount = 0;

	    for (Instance instance : data.getData()) {
	    	
	        if (instance.getClassification().equals("yes")) {
	        	
	            yesCount++;
	            
	        } 
	        
	        else {
	        	
	            noCount++;
	            
	        }
	        
	    }

	    if (yesCount > noCount) {
	    	
	        return "yes";
	        
	    }
	    
	    else {
	    	
	        return "no";
	        
	    }
	    
	}
	
	public boolean isSame(DataSet data) {
		
		boolean output = true;
		
		String value = data.getInstance(0).getClassification();
		
		for(int i = 1; i < data.getData().size(); i++) {
			
			if(data.getInstance(i).getClassification().equals(value))
				output = false;
			
		}
		
		return output;
		
	}
	
	public ArrayList<String> getAttributeChoices(DataSet data, int fieldIndex){
		
		ArrayList<String> distinctValues = new ArrayList<String>();

		for (Instance instance : data.getData()) {

			String attrValue = instance.getAttribute().getFields().get(fieldIndex);

			if (!distinctValues.contains(attrValue)) {

				distinctValues.add(attrValue);

			}

		}

		return distinctValues;		
		
	}
	
}