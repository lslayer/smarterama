package tk.lslayer.oop.first.interfaces;

import java.util.List;

public interface Navigator {

  List<Waypoint> route(Waypoint from, Waypoint to);

}
