/*Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

*/

public class Solution {
     public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
            int area = (C-A)*(D-B) + (G-E)*(H-F);
            long coverLen =(long)Math.min(C,G) -(long)Math.max(A,E);
            long coverHei =(long)Math.min(D,H) -(long)Math.max(B,F);
            if(coverLen <=0 || coverHei <= 0)
                return area;
            else
                return (int) (area-coverLen*coverHei);

    }
}

// Discussion
public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H){

        int areaOfSqrA = (C-A) * (D-B);
         int areaOfSqrB = (G-E) * (H-F);

        int left = Math.max(A, E);
        int right = Math.min(G, C);
        int bottom = Math.max(F, B);
        int top = Math.min(D, H);

        //If overlap
        int overlap = 0;
        if(right > left && top > bottom)
             overlap = (right - left) * (top - bottom);

        return areaOfSqrA + areaOfSqrB - overlap;
    }