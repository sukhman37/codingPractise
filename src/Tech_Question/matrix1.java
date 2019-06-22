package Tech_Question;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;



public class matrix1 {

	private static int $;
static int countSpecialElements(List<List<Integer>> matrix) {
        List<List<Integer>> rowMinMax = new ArrayList<>();
        List<List<Integer>> colMinMax = new ArrayList<>();
        List<Map<Integer,Integer>> countRowMap = new ArrayList<>();
        List<Map<Integer,Integer>> countColMap = new ArrayList<>();
        
        for(int i=0;i<matrix.size();i++) {
            countRowMap.add(new HashMap<>());
            rowMinMax.add(new ArrayList<>());
            for(int j=0;j<matrix.get(0).size();j++) {
                int val = matrix.get(i).get(j);
                if(countRowMap.get(i).containsKey(val))
                    countRowMap.get(i).put(val,countRowMap.get(i).get(val)+1);
                else
                    countRowMap.get(i).put(val,1);
                if(i==0)
                    countColMap.add(new HashMap<>());
                if(countColMap.get(j).containsKey(val))
                    countColMap.get(j).put(val, countColMap.get(j).get(val)+1);
                else
                    countColMap.get(j).put(val,1);
                
                if(j == 0) {
                    rowMinMax.get(i).add(val);
                    rowMinMax.get(i).add(val);
                } else {
                    rowMinMax.get(i).set(0, Math.min(val, rowMinMax.get(i).get(0)));
                    rowMinMax.get(i).set(1, Math.max(val, rowMinMax.get(i).get(1)));
                }
                
                if(i==0) {
                    colMinMax.add(new ArrayList<>());
                }
                if(i == 0 ) {
                    colMinMax.get(j).add(val);
                    colMinMax.get(j).add(val);
                } else {
                    colMinMax.get(j).set(0, Math.min(val, colMinMax.get(j).get(0)));
                    colMinMax.get(j).set(1, Math.max(val, colMinMax.get(j).get(1)));
                }
                
            }
        }
        
        //System.out.println(rowMinMax);
        //System.out.println(colMinMax);
        //System.out.println(countRowMap);
        //System.out.println(countColMap);
        
        Set<String> used = new HashSet<>();
        int ans = 0;
        for(int i=0;i<matrix.size();i++) {
            for(int j=0;j<matrix.get(0).size();j++) {
                String loc = i+"_"+j;
                int val = matrix.get(i).get(j);
                if(!used.contains(loc) && ((val == rowMinMax.get(i).get(0) && countRowMap.get(i).get(val) == 1)
                 || (val == rowMinMax.get(i).get(1) && countRowMap.get(i).get(val) == 1)
                 || (val == colMinMax.get(j).get(0) && countColMap.get(j).get(val) == 1)
                 || (val == colMinMax.get(j).get(1) && countColMap.get(j).get(val) == 1))
                  ) {
                    
                    ans += 1;
                    used.add(loc);
                }
                
                if((val == rowMinMax.get(i).get(0) && countRowMap.get(i).get(val) > 1)
                 || (val == rowMinMax.get(i).get(1) && countRowMap.get(i).get(val) > 1)
                 || (val == colMinMax.get(j).get(0) && countColMap.get(j).get(val) > 1)
                 || (val == colMinMax.get(j).get(1) && countColMap.get(j).get(val) > 1))
                    return -1;
            }
        }

        if(ans == 0)
            return -1;
        return ans;
    }
	
	
	static int count(List<List<Integer>> matrix){

		List<Integer> rowMinMatrix  = new ArrayList<>();
		List<Integer> rowMaxMatrix  = new ArrayList<>();
		List<Integer> colMinMatrix  = new ArrayList<>();
		List<Integer> colMaxMatrix  = new ArrayList<>();


		for(int i = 0 ;i<matrix.size();i++){
			int rowMin = Integer.MAX_VALUE;
			int rowMax = Integer.MIN_VALUE;
			for (int j = 0; j < matrix.get(i).size(); j++) {
				System.out.println("value = "+matrix.get(i).get(j)+" min = "+rowMin+" flag = "+(rowMin < matrix.get(i).get(j)));
				if(rowMin > matrix.get(i).get(j)){
					rowMin = matrix.get(i).get(j);
				}
				if(rowMax < matrix.get(i).get(j)){
					rowMax = matrix.get(i).get(j);
				}
			}
			rowMinMatrix.add(rowMin);
			rowMaxMatrix.add(rowMax);
		}
		
		
		for(int i = 0 ;i<matrix.size();i++){
			int colMin = Integer.MAX_VALUE;
			int colMax = Integer.MIN_VALUE;
			for (int j = 0; j < matrix.get(i).size(); j++) {
				if(colMin > matrix.get(j).get(i)){
					colMin = matrix.get(j).get(i);
				}
				if(colMax < matrix.get(j).get(i)){
					colMax = matrix.get(j).get(i);
				}
				System.out.println("output = "+matrix.get(j).get(i));
			}
			colMinMatrix.add(colMin);
			colMaxMatrix.add(colMax);
		}

		int count = 0;
		HashSet<Integer> set = new HashSet<>();
		for(int i = 0 ;i<matrix.size();i++){
			for (int j = 0; j < matrix.get(i).size(); j++) {
				if(set.contains(matrix.get(i).get(j))){
					return -1;
				}
				System.out.println("val = "+matrix.get(i).get(j)+" rowMin = "+rowMinMatrix.get(i)+" rowMax = "+rowMaxMatrix.get(i)+" colMin = "+colMinMatrix.get(j)+" colMax = "+colMaxMatrix.get(j));
				if(matrix.get(i).get(j) == rowMinMatrix.get(i)){
					count++;
					set.add(matrix.get(i).get(j));
					System.out.println("equal = "+matrix.get(i).get(j));
				}
				else if(matrix.get(i).get(j) == rowMaxMatrix.get(i)){
					count++;
					set.add(matrix.get(i).get(j));
					System.out.println("equal = "+matrix.get(i).get(j));
				}
				else if(matrix.get(i).get(j) == colMinMatrix.get(j)){
					count++;
					set.add(matrix.get(i).get(j));
					System.out.println("equal = "+matrix.get(i).get(j));
				}
				else if(matrix.get(i).get(j) == colMaxMatrix.get(j)){
					count++;
					set.add(matrix.get(i).get(j));
					System.out.println("equal = "+matrix.get(i).get(j));
				}
			}
		}
		return count;
	}



	public static void main(String[] args) {

		List<List<Integer>> matrix = new ArrayList<>();

		List<Integer> list1 = new ArrayList<>();

		list1.add(1);

		list1.add(3);

		list1.add(4);



		List<Integer> list2 = new ArrayList<>();

		list2.add(5);

		list2.add(2);

		list2.add(9);



		List<Integer> list3 = new ArrayList<>();

		list3.add(8);

		list3.add(9);

		list3.add(6);


		matrix.add(list1);
		matrix.add(list2);
		matrix.add(list3);
		System.out.println(countSpecialElements(matrix));
	}
}