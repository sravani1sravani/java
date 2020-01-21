import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int count=0;
        for (Point currPt : s.getPoints()) {
        count=count+1;
        }
        //System.out.print("Points : ");
        return count;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double perimeter=getPerimeter(s);
        int count=getNumPoints(s);
        double average=perimeter/count;
        return average;
    }

    public double getLargestSide(Shape s) {
        // Put code here
         Point prevPt = s.getLastPoint();
         double maximum=0.0;
        for (Point currPt : s.getPoints()) {
          double currDist = prevPt.distance(currPt);
           maximum =(double) Math.max(currDist,maximum);
       
    }
     return maximum;
}
    public double getLargestX(Shape s) {
        // Put code here
        double max=0;
        for (Point line : s.getPoints()) {
         int x=line.getX();
         int y=line.getY();
         if(max<x)
         {
             max=x;
         }
        }
        return max;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double max=0;
        for (File f : dr.selectedFiles()) {
          FileResource fr = new FileResource(f); 
            Shape s=new Shape(fr);
            double larPerimeter=getPerimeter(s);
            max= Math.max(max,larPerimeter);
        }
        return max;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double max=0;
         File temp = null; 
        for (File f : dr.selectedFiles()) {
          FileResource fr = new FileResource(f); 
            Shape s=new Shape(fr);
            double larPerimeter=getPerimeter(s);
            if(max<larPerimeter)
            {
                max=larPerimeter;
                temp=f;
            }
        }
        
          // replace this code
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int y=getNumPoints(s);
        double average=getAverageLength(s);
        double largestside=getLargestSide(s);
        double largestX=getLargestX(s);
        System.out.println("perimeter = " + length);
         System.out.println("Points = " + y);
         System.out.println("Average = " +average);
         System.out.println("LargestSide = " +largestside);
         System.out.println("LargestX = " +largestX);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double larPerimeter=getLargestPerimeterMultipleFiles();
        System.out.println("larPerimeter = "+larPerimeter);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String fileName=getFileWithLargestPerimeter();
        System.out.println("FileName = "+fileName);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
      // System.out.println( pr.getNumPoints());
    }
}
