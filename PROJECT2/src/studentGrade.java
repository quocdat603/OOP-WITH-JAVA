import java.util.Scanner;

public class studentGrade {

    public static void main(String[] args) {

        double midTerm = midTerm();
        double finalTerm = finalTerm() ;
        double homeWork = homeWork();

        double overall = midTerm + finalTerm + homeWork;
        System.out.println("");
        System.out.println("Your overall score = " + overall);
        double gpa = 0.0;
        if (overall >= 85) {
            gpa = 3.0;
        } else if (overall >= 75 && overall < 85) {
            gpa = 2.0;
        } else  if (overall >= 60 && overall < 75) {
            gpa = 1.0;
        } else {
            gpa = 0.0;
        }
        System.out.println("Your grade at GPA = " + gpa);
    }
    // hàm begin()
    public static String begin() {
        String welcome = "This program reads exam/homework scores and reports your overall course grade.";
        return welcome;
    }
    // hàm midterm()
    public static double midTerm() {
        String welcome =  begin();
        System.out.println(welcome);
        System.out.println("");
        Scanner input = new Scanner(System.in);
        System.out.println("Mid-term: ");
        System.out.println("Weight (0-100)? ");
        int weight1 = input.nextInt();

        System.out.println("Score earned: ");
        int scoreEarn1 = input.nextInt();

        int total1 = 0;
        System.out.println("Were scores shifted (1 = yes, 2 = no): " );
        String ans = input.next();
        if(ans.equals("1")) {
            System.out.println("Shift amount: ");
            int shift1 = input.nextInt();
            total1 =  scoreEarn1 + shift1;
            if (total1 >= 100 ) {
                total1 = 100;
            }
            System.out.println("Total points: " + total1 + " / 100") ;
        } else if (ans.equals("2")) {
            total1 =  scoreEarn1;
            System.out.println("Total points: " + total1 + " / 100") ;
        }
        double midTerm = (total1 *  1.0 * weight1) / 100.0 ;
        System.out.println("Weighted score: " + midTerm + " / " + weight1);

        return midTerm;
    }
    // hàm final()
    public static double finalTerm() {
        System.out.println("");
        Scanner input = new Scanner(System.in);
        System.out.println("Final-term: ");
        System.out.println("Weight (0-100)? ");
        int weight2 = input.nextInt();

        System.out.println("Score earned: ");
        int scoreEarn2 = input.nextInt();

        int total2 = 0;
        System.out.println("Were scores shifted (1 = yes, 2 = no): ");
        String ans = input.next();
        if(ans.equals("1")) {
            System.out.println("Shift amount: ");
            int shift2 = input.nextInt();
            total2 =  scoreEarn2 + shift2;
            if (total2 >= 100 ) {
                total2 = 100;
            }
            System.out.println("Total points: " + total2 + " / 100") ;
        } else if (ans.equals("2")) {
            total2 =  scoreEarn2;
            System.out.println("Total points: " + total2 + " / 100") ;
        }
        double finalTerm = (total2 * 1.0 * weight2) / 100.0;
        System.out.println("Weighted score: " + finalTerm + " / " + weight2);

        return finalTerm;
    }
    //hàm homework()
    public static double homeWork() {
        System.out.println("");
        Scanner input = new Scanner(System.in);
        System.out.println("Weight Midterm: ");
        int weight1 = input.nextInt();
        System.out.println("Weight Final: ");
        int weight2 = input.nextInt();
        int weight3 = 100 - weight1 - weight2;
        System.out.println("Weight (0-100)? " + weight3);

        System.out.println("Number of assignments: ");
        int numAs = input.nextInt();
        int totalAs = 0;
        int totalMax = 0;
        for (int i = 1; i <= numAs; i++) {
            System.out.println("Assignment " + i + " score and max: ");
            int asScore = input.nextInt();
            int scoreMax = input.nextInt();
            totalAs += asScore;
            totalMax += scoreMax;

        }
        if (totalAs >= 150) {
            totalAs = 150;
            totalMax = 150;
        }

        System.out.println("How many sections did you attend? ");
        int section = input.nextInt();
        int sectionPoint = 0;
        if ( section <= 6) {
            sectionPoint = section * 5;
            System.out.println("Section points: " + sectionPoint + " / 30");
        } else {
            sectionPoint = 30;
            System.out.println("Section points: " + sectionPoint + " / 30");
        }
        int totalPoint = totalAs + sectionPoint;
        int maxScore = totalMax + 30;
        System.out.println("Total points: " + totalPoint + " / " + maxScore );

        double homeWork = (totalPoint * weight3 * 1.0) / (maxScore);
        System.out.println("Weighted score: " + Math.round(homeWork * 10.0) / 10.0 + " / " + weight3);

        return homeWork;
    }
}

