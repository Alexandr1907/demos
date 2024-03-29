public class Horse {
    private String name;
    private double speed;
    private double distance;
    public Horse (String name, double speed, double distance){
        this.name=name;
        this.speed=speed;
        this.distance=distance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    public void move(){
        distance+=(Math.random()*speed);
    }
    public void print(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.floor(distance); i++) {
            sb.append(".");
        }
        sb.append(getName());
        System.out.println(sb.toString());
    }
}
