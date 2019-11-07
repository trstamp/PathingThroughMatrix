public class Main {

    public static void main(String[] args){
        Path pa = new Path();
        int[][] test = pa.createMatrix();
        System.out.print(pa.findPath(test,0,0));
    }
}
