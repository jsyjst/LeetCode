package easy._997;

/**
 * <pre>
 *     author : 残渊
 *     time   : 2019/09/15
 *     desc   : 在一个小镇里，按从 1 到 N 标记了 N 个人。传言称，这些人中有一个是小镇上的秘密法官。
 * 如果小镇的法官真的存在，那么：
 * 小镇的法官不相信任何人。
 * 每个人（除了小镇法官外）都信任小镇的法官。
 * 只有一个人同时满足属性 1 和属性 2 。
 * 给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示标记为 a 的人信任标记为 b 的人。
 * 如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的标记。否则，返回 -1。
 * </pre>
 */
public class Solution {
    /**
     * 输入：N = 2, trust = [[1,2]]
     * 输出：2
     */
    public int findJudge(int N, int[][] trust) {
        boolean[][] graph = new boolean[N+1][N+1];
        int[] t = new int[N+1];
        for(int[] trustRow:trust){
            graph[trustRow[0]][trustRow[1]] = true;
        }
        for (int i = 1; i <= N; i++) {
            if(t[i] == -1) continue;
            for (int j = 1; j <=N ; j++) {
                if(graph[i][j]) {
                    t[i]=-1;
                    t[j]++;
                }
            }
        }
        int res = -1;
        int num = 0;
        for (int i = 1; i <=N ; i++) {
            if(num==2) return -1;
            if(t[i] == N-1) {
                num++;
                res = i;
            }
        }
        return res;
    }

    //二维数组记录出度入度，出度为0，入度为N-1的即为法官
    public int findJudgeBetter(int N, int[][] trust) {
        int[][] people = new int[N][2];
        //记录出度和入度
        for(int[] t:trust){
            int out = t[0];
            int in = t[1];
            people[out-1][0]++;
            people[in-1][1]++;
        }
        for (int i = 0; i < N; i++) {
            if(people[i][0]==0&&people[i][1]==N-1)
                return i+1;
        }
        return -1;
    }

}
