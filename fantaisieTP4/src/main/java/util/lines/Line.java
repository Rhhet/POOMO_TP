package util.lines;


public class Line {
    
    private static final int LENGTH_TITLE = 80;
    private static final int LENGTH_LINE = 95;

    public static void drawHztLine() {
        System.out.println();
        for (int i = 0; i < LENGTH_LINE; i++) 
            System.out.print("-");
        System.out.println();
    }
    
    public static void drawTitleLine(String title) {
        System.out.println();
        for (int i = 0; i < LENGTH_TITLE / 2; i++) 
            System.out.print("-");
        System.out.print("<> " + title + " <>");
        for (int i = 0; i < LENGTH_TITLE / 2; i++) 
            System.out.print("-");
        System.out.println();
    }
}