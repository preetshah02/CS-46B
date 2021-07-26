package airlines;

import java.util.HashSet; 

public class FlightNet extends HashSet<Airport>
{
	
	public boolean nameIsAvailable(String name)
	{
		for(Airport airport: this)
		{
			if(airport.getName().equals(name))
			{
				return false;
			}
		}
		return true;
	}
	
	public void connect(Airport a1, Airport a2)
	{
		a1.connectTo(a2);
		a2.connectTo(a1);
	}
	
	public void disconnect(Airport a1, Airport a2)
	{
		a1.disconnectFrom(a2);
		a2.disconnectFrom(a1);
	}
	
	public void removeAndDisconnect(Airport removeMe)
	{
		for(Airport a: this)
		{
			if(a.isConnectedTo(removeMe))
			{
				a.disconnectFrom(removeMe);
			}
		}
		this.remove(removeMe);
	}
	
	public Airport getAirportNearXY(int x, int y, int maximumDistance)
	{
		for(Airport a : this)
		{
			double distance = Math.hypot(x - a.getX(), y - a.getY());
			if(distance <= maximumDistance)
			{
				return a;
				
			}
		}
		return null;
	}
	
	
}
