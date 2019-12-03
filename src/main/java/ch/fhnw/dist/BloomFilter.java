package ch.fhnw.dist;

public class BloomFilter {

    int n;
    double p, m, k;

    /**
     *
     *
     * @param n Amount of expected elements
     * @param p The desired false positive
     */
    public BloomFilter(int n, double p) {
        this.n = n;
        this.p = p;

        m = -((n * Math.log(p)) / Math.pow(Math.log(2), 2));
        k = -(Math.log(p) / Math.log(2));

        System.out.println("m: " + m);
        System.out.println("k: " + k);
    }



}
