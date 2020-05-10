package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/** https://leetcode.com/problems/find-the-town-judge/ */
public class FindTheTownJudge {

    public static void main(String[] args) {
        System.out.println(findJudge(4, new int[][]{{1,3},{1,4},{2,3},{2,4},{4,3}}));
        System.out.println(findJudge(3, new int[][]{{1,3},{2,3},{3,1}}));
        System.out.println(findJudge(3, new int[][]{{1,2},{2,3}}));
    }

    /** Approach - 1 : Use the Map to store votes against each person. Use another Map to store trust.
     * If a person trust someone else, he/she can't be a Judge. Therefore iterate through the data, If he/she has N-1 votes, They are the Judge.
     *
     * LeetCode stats:
     * Runtime: 22 ms, faster than 11.31% of Java online submissions.
     * Memory Usage: 47.6 MB, less than 100.00% of Java online submissions.
     * */
    public static int findJudge(int N, int[][] trust) {
        if(N == 1)
            return 1;
        HashMap<Integer, Integer> trustData = new HashMap<>();
        HashMap<Integer, List<Integer>> data = new HashMap<>();
        for(int[] vote: trust) {
            trustData.put(vote[0], vote[1]);
            List<Integer> currentTrustees = data.getOrDefault(vote[1], new ArrayList<>());
            currentTrustees.add(vote[0]);
            data.put(vote[1], currentTrustees);
        }

        int[] result = new int[1];
        result[0] = -1;
        data.forEach((key, valueList) -> {
            if(valueList.size() == N - 1) {
                result[0] = key;
            }
        });

        if(result[0] != -1) {
            return trustData.containsKey(result[0]) ? -1 : result[0];
        }
        return -1;
    }

    /** Approach - 2 : We can count the trusts for each person.
     * If he vote anyone i.e, Decrease the vote for person. A person is Judge if and only if he/she has N-1 votes.
     *
     * LeetCode stats:
     * Runtime: 2 ms, faster than 100.00% of Java online submissions.
     * Memory Usage: 46.7 MB, less than 100.00% of Java online submissions.
     * */
    public int findJudgeUsingArray(int N, int[][] trust) {
        int[] data = new int[N + 1];
        for(int[] vote: trust) {
            data[vote[0]]--;
            data[vote[1]]++;
        }

        for(int i = 1; i <= N; i++) {
            if(data[i] == N - 1)
                return i;
        }
        return -1;
    }
}
