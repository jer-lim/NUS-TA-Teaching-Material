class Main {
    public static void main (String[] args)
    {
        double[][] points;

        Point point = new Point();
        

        points = point.readPoints();
        point.getMovingMidPoint(points);
    }

}
