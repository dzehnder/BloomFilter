package ch.fhnw.dist;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

public class BloomFilter {

    int n, m;
    double p, k;
    int[] bitsArray;
    List<HashFunction> hashes = new ArrayList<>();

    /**
     *
     *
     * @param n Amount of expected elements
     * @param p The desired false positive
     */
    public BloomFilter(int n, double p) {
        this.n = n;
        this.p = p;

        // calculate the number of bits in the array, round up with 1 at the end
        m = (int) -((n * Math.log(p)) / Math.pow(Math.log(2), 2)) + 1;

        // calculate the number of hash functions, round up with 1 at the end
        k = (int) -(Math.log(p) / Math.log(2)) + 1;

        System.out.println("m: " + m);
        System.out.println("k: " + k);


        bitsArray = new int[m];

        // generate bits array and set every position to 0
        for (int i = 0; i < bitsArray.length; i++) {
            bitsArray[i] = 0;
        }

        // generate unique hashes and add them to the list
        for (int i = 0; i < k; i++) {
            hashes.add(Hashing.murmur3_128(i));
        }

    }

    /**
     * Add an element to the hash functions.
     *
     * @param word the word to be added.
     */
    public void add(String word) {
        for (HashFunction hashFunction : hashes) {
            HashCode hashCode = hashFunction.newHasher()
                    .putString(word, Charsets.UTF_8)
                    .hash();
            // set  position in bits array to 1 for this word
            bitsArray[Math.abs(hashCode.asInt() % m)] = 1;
        }
    }

    /**
     * Query an element in the hash functions.
     *
     * @param word the word to be queried.
     * @return true if the word was found, false otherwise.
     */
    public boolean hasWord(String word) {
        for(HashFunction hashFunction : hashes) {
            HashCode hashCode = hashFunction.newHasher()
                    .putString(word, Charsets.UTF_8)
                    .hash();
            if (bitsArray[Math.abs(hashCode.asInt() % m)] == 1) {
                return true;
            }
        }
        return false;
    }






}
