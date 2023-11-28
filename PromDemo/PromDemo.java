// A promotion surprise!
class PromDemo {
  public static void main(String[] args) {
    byte b;
    int i;

    b = 10;
    i = b * b; // OK, no cast needed
    
    b = 10;
    b = (byte) (b * b); //bin/
    
    System.out.printf("i and b: %d %b", i, b);
  }
}
