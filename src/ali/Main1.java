package ali;

public class Main1 {

    static long min(int[] from,int[] to) {

        int n = from.length;
        long c[][] =new long[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                c[i][j] = 0;
            }
        }


            for(int i=0,j = 2; j < n; j++) {
                c[i][j] = c[i][j-2] + from[j-2] * from[j-1];
            }

        for(int j=0,i = 2; i < n; i++) {
            c[i][j] = c[i-2][j] + to[i-2] * to[i-1];
        }

        c[1][1] = from[0] *to[0];
        for(int i=1,j = 3; j < n; j+=2) {
            c[i][j] = c[i][j-2] + from[j-2] * from[j-1];
            if (c[i][j] > c[i-1][j-1] + from[j-1] * to[i-1]) {
                c[i][j] = c[i-1][j-1] + from[j-1] * to[i-1];
            }
        }

        for(int j=1,i = 3; i < n; i+=2) {
            c[i][j] = c[i-2][j] + to[i-2] * to[i-1];
            if (c[i][j] > c[i-1][j-1] + from[j-1] * to[i-1]) {
                c[i][j] = c[i-1][j-1] + from[j-1] * to[i-1];
            }
        }


        for(int i = 2; i < n; i++) {
            for(int j = 2; j < n; j++) {

                c[i][j] = min(c[i-2][j]+to[i-2]*to[i-1],c[i][j-2]+from[j-2]*from[j-1],c[i-1][j-1]+from[j-1]*to[i-1]);
            }
        }


        return c[n-1][n-1];
    }

    static long min(long a, long b, long c) {
        if (a<b) {
            if(a<c) return a; else return c;

        }
        else {
            if(b<c) return b; else return c;
        }

    }
}
