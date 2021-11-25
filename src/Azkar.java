
import java.time.*; // import the LocalDate class

public class Azkar {
    public static void main(String[] args) {
        LocalDateTime myDateObj = LocalDateTime.now();
        // DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm");
        
        
        
        boolean flag1 = true, flag2 = true;
        // System.out.println(myDateObj.format(myFormatObj) + " :الساعة");
        while(flag1 || flag2) {
            System.out.println("######################");
            myDateObj = myDateObj.plusHours(1);
            // System.out.println(myDateObj.format(myFormatObj) + " :الساعة");
            if (myDateObj.getHour() == 7) {
                System.out.println("وقت أذكار الصباح");
                System.out.println("((أصبحنا وأصبح الملك لله، والحمد لله، لا إله إلا الله وحده لا شريك له، له الملك وله الحمد وهو على كل شيء قدير، رب أسألك خير ما في هذا اليوم وخير ما بعده، وأعوذ بك من شر ما في هذا اليوم وشر ما بعده، رب أعوذ بك من الكسل وسوء الكبر، رب أعوذ بك من عذاب في النار وعذاب في القبر))");
                System.out.println("وقت أذكار الصباح");
                System.out.println("وقت أذكار الصباح");
                System.out.println("وقت أذكار الصباح");
                System.out.println("وقت أذكار الصباح");
                flag1 = false;
                
            }
            
            else if (myDateObj.getHour() == 18) {
                System.out.println("وقت أذكار المساء");
                flag2 = false;
            }
            
            
        }

  }
}
