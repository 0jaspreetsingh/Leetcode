package Trees;

/**
 * https://leetcode.com/problems/reaching-points/
 */
public class ReachingPoint {

    // time limit exceed
//    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
//        if(sx>tx||sy>ty){
//            return false;
//        }
//        if(sx==tx&&sy==ty){
//            return true;
//        }
//        return reachingPoints(sx,sy+sx,tx,ty)||reachingPoints(sx+sy,sy,tx,ty);
//    }

    // instead travel from back
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx > sx && ty > sy) {
            if (tx > ty) {
                tx = tx % ty;
            } else {
                ty = ty % tx;
            }
        }

        return sx == tx && sy <= ty && (ty - sy) % sx == 0 || sy == ty && sx <= tx && (tx - sx) % ty == 0;
    }

    public static void main(String[] args) {
        ReachingPoint rp = new ReachingPoint();
        int sx = 1, sy = 1, tx = 3, ty = 5;
        System.out.println(rp.reachingPoints(sx, sy, tx, ty));
    }
}
