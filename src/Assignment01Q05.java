public class Assignment01Q05 {
    public static int findShortestPath(int[][] m, int i, int j) {
        if (i==j) return 0;
        int[] dis=new int[m.length];
        boolean[] vis=new boolean[m.length];
        int[] queue=new int[m.length];
        int head=0,tail=0;
        tail++;
        queue[tail-1]=i;
        vis[i]=true;
        while(head<tail){
            int cur=queue[head];
            head++;
            for(int k=0;k<m.length;k++){
                if(m[cur][k]==1&&!vis[k]){
                    vis[k]=true;
                    dis[k]=dis[cur]+1;
                    queue[tail++]=k;
                }
            }
        }
        if (dis[j] == 0) {
            return -1;
        }
        return dis[j];
    }

    public static void main(String[] args) {
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 0, 1)); // -1
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 1, 1)); // 0
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}}, 0, 2)); // 2
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}}, 0, 2)); // 2
    }
}