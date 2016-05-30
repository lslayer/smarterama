package tk.lslayer.oop.first;

import java.util.List;

import tk.lslayer.oop.first.exceptions.CantReachDestinationException;
import tk.lslayer.oop.first.exceptions.NotEnoughFuelException;
import tk.lslayer.oop.first.interfaces.Car;
import tk.lslayer.oop.first.interfaces.Engine;
import tk.lslayer.oop.first.interfaces.Fuel;
import tk.lslayer.oop.first.interfaces.FuelTank;
import tk.lslayer.oop.first.interfaces.Navigator;
import tk.lslayer.oop.first.interfaces.Waypoint;


public abstract class CarImpl implements Car {
  
  private Engine engine;
  private FuelTank fuelTank;
  private Waypoint currentPosition;
  private Navigator navigator;
  
  private void startEngine() {
    if (fuelTank.getFuelLevel() > 0) {
      engine.start();
    }
  }
  
  public void fillFuelTank(Fuel fuel, int quantity) {
    if (engine.compatible(fuel)) {
      fuelTank.fill(quantity);
    }
  }
  
  private void driveTo(Waypoint waypoint) {
    int distance = waypoint.getDistanceTo(currentPosition);
    int requiredFuelQuantity = engine.getFuelConsuption(distance); 
    if (engine.isStarted() && requiredFuelQuantity <= fuelTank.getFuelLevel()) {
      this.currentPosition = waypoint;
      fuelTank.consumeFuelFor(distance);
    } else { 
      throw new NotEnoughFuelException();
    }
  }

  @Override
  public void gotoDestination(Waypoint destination) {
    try {
    startEngine();
    List<Waypoint> route = navigator.route(currentPosition, destination);
    for (Waypoint nextWaypoint : route) {
      driveTo(nextWaypoint);
    }
    stopEngine();
    } catch (RuntimeException e) {
      throw new CantReachDestinationException(e);
    }
  }

  private void stopEngine() {
    engine.stop();
  }

}
