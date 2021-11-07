import java.util.ArrayList;
import java.util.List;

class SpiralMatrix {
    public static void main(String[] args){
        try{
            SpiralMatrix obj = new SpiralMatrix();
            obj.run(args);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void run(String[] args){
        int[][] tallOne = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20}};
        //01,02,03,04
        //05,06,07,08
        //09,10,11,12
        //13,14,15,16
        //17,18,19,20
        int[][] wideOne = new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20}};
        //01,02,03,04,05
        //06,07,08,09,10
        //11,12,13,14,15
        //16,17,18,19,20
        int[][] bigOne = new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        //01,02,03,04,05
        //06,07,08,09,10
        //11,12,13,14,15
        //16,17,18,19,20
        //21,22,23,24,25
        int[][] smallOne = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        //01,02,03
        //04,05,06
        //07,08,09
        int[][] midOne = new int[][]{{1,2,3,4,5,6,7,8,9,10},{11,12,13,14,15,16,17,18,19,20}};
        System.out.println(spiralOrder(bigOne));
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> finalList = new ArrayList<>();
        int matrixSize = matrix[0].length * matrix.length;
        int numOfValuesAdded  = 0;
        boolean keepGoing = true;
        int mostLeftX = 0;
        int mostRightX = matrix[0].length-1;
        int mostUpY = 0;
        int mostDownY = matrix.length-1;
        if(mostRightX <= 0 || mostDownY <= 0){
            for(int y=0;y<mostDownY+1;y++){
                for(int x=0;x<mostRightX+1;x++){
                    finalList.add(matrix[y][x]);
                }
            }
            return finalList;
        }
        while(keepGoing){
            if(mostUpY >= mostDownY && mostLeftX >= mostRightX){
                if(numOfValuesAdded<matrixSize){
                    finalList.add(matrix[mostUpY][mostLeftX]);
                }
                return finalList;
            }
            if(mostUpY >= mostDownY || mostLeftX >= mostRightX){
                keepGoing = false;
                /*if(numOfValuesAdded<matrixSize){
                    finalList.add(matrix[mostUpY][mostLeftX]);
                }*/
                if(matrixSize < numOfValuesAdded){
                    int excessIndex = numOfValuesAdded-1;
                    for(int x=excessIndex;x>matrixSize-1;x--){
                        finalList.remove(x);
                    }
                }
                return finalList;
            }
            for(int x=mostLeftX;x<mostRightX;x++){
                finalList.add(matrix[mostUpY][x]);
                numOfValuesAdded++;
            }
            for(int y=mostUpY;y<mostDownY;y++){
                finalList.add(matrix[y][mostRightX]);
                numOfValuesAdded++;
            }
            for(int x=mostRightX;x>mostLeftX;x--){
                finalList.add(matrix[mostDownY][x]);
                numOfValuesAdded++;
            }
            for(int y=mostDownY;y>mostUpY;y--){
                finalList.add(matrix[y][mostLeftX]);
                numOfValuesAdded++;
            }
            mostRightX--;
            mostLeftX++;
            mostDownY--;
            mostUpY++;
        }
       /* if(matrixSize < numOfValuesAdded){
            int excessIndex = numOfValuesAdded-1;
            for(int x=excessIndex;x>matrixSize-1;x--){
                finalList.remove(x);
            }
        }*/
        return finalList;
    }
}