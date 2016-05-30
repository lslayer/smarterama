package tk.lslayer.oop.first.interfaces;

public interface Engine {

  public boolean compatible(Fuel fuel);

  public void start();
  public void stop();
  public boolean isStarted();

  public int getFuelConsuption(int getdistanceTo);

}
