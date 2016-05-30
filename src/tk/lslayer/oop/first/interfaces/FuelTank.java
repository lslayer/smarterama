package tk.lslayer.oop.first.interfaces;

public interface FuelTank {

  public int getFuelLevel();
  public void fill(int quantity);
  public void consumeFuelFor(int distance);
  
}
