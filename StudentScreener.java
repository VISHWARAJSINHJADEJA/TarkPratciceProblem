public class StudentScreener {
  public static void main(String[] args) throws Exception {
    int totalStudents = 7;
    int totalMarks = 1000;
    float requiredPercentile = 50f;

    int[] marks = {800, 300, 750, 760, 680, 790, 640};
    String[] students = { "Kartik", "Devang", "Pari", "Ketan", "Sheetal", "Darshana", "Mohan" };
    String[] examResults = {"Passed", "Failed", "Passed", "Failed", "Passed", "Passed", "Passed"};

    String eligibleStudents = getEligibleStudents(totalStudents, students, marks, examResults, totalMarks, requiredPercentile);
    System.out.println(eligibleStudents);
  }

  public static String getEligibleStudents(int totalStudents, String[] students, int[] marks, String[] examResults, int totalMarks, float requiredPercentile) throws Exception {
    StringBuilder sb = new StringBuilder();
    int[] percentile = new int[totalStudents];
    
    for (int i = 0; i < totalStudents; i++) {
      int count = 0;
      for (int j = 0; j < totalStudents; j++) {
        if (marks[i] > marks[j]) {
          count++;
        }
      }
      percentile[i] = (int) (((float) count / totalStudents) * 100);
    }

    for (int i = 0; i < totalStudents; i++) {
      if (percentile[i] >= requiredPercentile && examResults[i].equals("Passed")) {
        sb.append(students[i]).append("\n");
      }
    }

    return sb.toString().trim();
  }
}
