class DronePoint {
    int x,y;
    DronePoint parent;

    @Override
    public String toString() {
        return "DronePoint{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public DronePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
