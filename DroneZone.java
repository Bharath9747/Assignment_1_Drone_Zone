import java.util.*;

public class DroneZone {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the n size for matrix");
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        System.out.println("Enter the n no of Drones");
        int n1 = sc.nextInt();
        DronePoint[] dronePoints = new DronePoint[n1];
        for(int i=0;i<n1;i++)
        {
            System.out.println("Drone : "+(i+1));
            System.out.println("Enter x,y");
            int x = sc.nextInt();
            int y = sc.nextInt();
            dronePoints[i] = new DronePoint(x,y);
            grid[x][y]=1;
        }
        System.out.println("Enter the Target");
        DronePoint target = new DronePoint(sc.nextInt(),sc.nextInt());
        Map<DronePoint, ArrayList<DronePoint>> res = DroneFunctions.findPaths(grid,dronePoints,target);
        for (Map.Entry<DronePoint,ArrayList<DronePoint>> e:res.entrySet())
        {
            System.out.println("Drone : "+e.getKey());
            Collections.reverse(e.getValue());
            for (DronePoint dronePoint : e.getValue())
                System.out.println(dronePoint);
            System.out.println();
        }
    }


}
