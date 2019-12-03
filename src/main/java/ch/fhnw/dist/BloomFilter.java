package ch.fhnw.dist;

public class BloomFilter {

    int n;
    double p;

    /**
     *
     *
     * @param n Amount of expected elements
     * @param p The desired false positive
     */
    public BloomFilter(int n, double p) {
        this.n = n;
        this.p = p;

        System.out.println(n + p);
    }



}
