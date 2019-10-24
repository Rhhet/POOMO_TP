package util.lines;


public class Line {
    
    private static final int LENGTH = 80;

    public static void drawHztLine() {
        System.out.println();
        for (int i = 0; i < LENGTH; i++) 
            System.out.print("-");
        System.out.println();
    }
    
}