
import java.util.Arrays;
public class PercentileScoreCalculatorSkeleton {
    public static void main(String[] args) throws Exception {
      int totalStudents = 7;
      int[] marks = {800, 300, 950, 760, 680, 490, 640};
      int yourScore = 760;
  
      float percentileScore = PercentileScoreCalculatorSkeleton.calculatePercentileScore(totalStudents, marks, yourScore);
      System.out.printf("Your percentile score is : %.2f", percentileScore);
    }
  
    public static float calculatePercentileScore(int totalStudents, int[] marks, int yourScore) throws Exception {
      //TODO: Implement this function and remove below line, which throws exception
    //   throw new RuntimeException("Not Implemented");
    Arrays.sort(marks);
    int rank = Arrays.binarySearch(marks, yourScore);
 
    float percentile = (rank / (float)totalStudents) * 100;
    return percentile;
    }
    }
  
  