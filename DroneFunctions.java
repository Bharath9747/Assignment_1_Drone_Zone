import java.util.*;

class DroneFunctions {
    static Map<DronePoint, ArrayList<DronePoint>> findPaths(int[][] grid, DronePoint[] dronePoints, DronePoint target) {
        Map<DronePoint,ArrayList<DronePoint>> path = new HashMap<>();
        int n = grid.length;
        for(DronePoint dronePoint:dronePoints)
        {
            boolean[][] visited = new boolean[n][n];
            Queue<DronePoint> dronePointQueue = new LinkedList<>();
            dronePointQueue.offer(dronePoint);
            visited[dronePoint.x][dronePoint.y] = true;
            int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
            while(!dronePointQueue.isEmpty()){
                DronePoint cur = dronePointQueue.poll();
                if(cur.x==target.x && cur.y==target.y) {
                    path.put(dronePoint, addPath(cur));
                    break;
                }
                for(int[] dr:dir){
                    int x = cur.x+dr[0],y= cur.y+dr[1];
                    if(x>=0 && x<n && y>=0 && y<n && !visited[x][y] && grid[x][y]==0)
                    {
                        DronePoint dronePoint1 = new DronePoint(x,y);
                        dronePoint1.parent = cur;
                        dronePointQueue.offer(dronePoint1);
                        visited[x][y]=true;
                    }
                }
            }
        }
        return path;
    }

    static ArrayList<DronePoint> addPath(DronePoint cur) {
        ArrayList<DronePoint> paths = new ArrayList<>();
        while(cur!=null)
        {
            paths.add(cur);
            cur = cur.parent;
        }
        return paths;
    }
}
