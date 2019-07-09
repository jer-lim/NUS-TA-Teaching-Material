import java.util.Scanner;

public class Point {
    public static void main(String[] args) { 
    
        double [][] points;
        
        points = readPoints();
        getMovingMidPoint(points);
    }

    static double [][] readPoints ()
    {
        Scanner scanner = new Scanner(System.in);
        double[][] points = new double[scanner.nextInt()][2];

        for (double[] point : points) {
            point[0] = scanner.nextDouble();
            point[1] = scanner.nextDouble();
        }
        
        return points;
    }

    
    static void printPoints(double[][] points)
    {
        for (double[] point : points)
        {
            System.out.format("(%.3f, %.3f)\n", point[0], point[1]);
        }
    }

    static void getMidPoint(double[][] points)
    { 
        int size = points.length - 1;
        for (int i = 0; i < size; i++)
        {
             int a = i;
             int b = i + 1;
             double x = (points[a][0] + points[b][0])/2;
             double y = (points[a][1] + points[b][1])/2;
             double angle = Math.atan2((points[b][1]-points[a][1]),(points[b][0]-points[a][0]));
             System.out.format("(%.3f, %.3f) and (%.3f, %.3f) has mid-point (%.3f, %.3f) and angle %.3f\n", points[a][0], points[a][1], points[b][0],points[b][1], x, y, angle);
        }
    }

    static void getMovingMidPoint(double[][] points)
    {
        int size = points.length -1;
        for (int i = 0; i < size; i++)
        {
            int a = i;
            int b = i + 1;
            
            double x = (points[a][0] + points[b][0])/2; //midpoint x corr
            double y = (points[a][1] + points[b][1])/2; //midpoint y corr
            
            double Ydiff = y - points[a][1];
            double Xdiff = x - points[a][0];
		
            //if(x*2 <= 2 && y*2 <=2 && x*2 >= -2 && y*2  >= -2){ 
				double angle = Math.atan2(Ydiff, Xdiff); //midpoint angle
				
				angle += (3.141592653) / 2;
				
				if( angle > (3.141592653) ){
					angle -= (3.141592653) * 2;
				}

			    double distance = Math.sqrt(Math.pow(Xdiff,2) + Math.pow(Ydiff,2)); //pythagoras' theorem
			    
			   if(distance <= 1) {
				double MDistance = Math.sqrt(1 - Math.pow(distance,2));
				double newXCoor = x + (MDistance * Math.cos(angle));
				double newYCoor = y + (MDistance * Math.sin(angle));
				
				System.out.format("(%.3f, %.3f) and (%.3f, %.3f) coincides with circle of centre (%.3f, %.3f)\n", points[a][0], points[a][1], points[b][0], points[b][1], newXCoor, newYCoor);
				}
			//}
		}
    }
}
