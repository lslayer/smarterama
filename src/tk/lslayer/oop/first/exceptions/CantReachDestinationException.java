package tk.lslayer.oop.first.exceptions;

public class CantReachDestinationException extends RuntimeException {

  public CantReachDestinationException(RuntimeException e) {
    super(e);
  }

}
