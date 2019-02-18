package me.toast.gametime.listeners;

import me.toast.gametime.GameTime;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class TimeCounter 
{
	public static int Ticks = 0;
	public static int Seconds = 0;
	public static int Minutes = 0;
	public static int Hours = 0;
	
	private GameTime mod;
	
	public TimeCounter(GameTime mod)
	{
		this.mod = mod;
	}
	
	@SubscribeEvent
	public void onServerTick(TickEvent.ServerTickEvent event) 
	{
		Ticks++;
		
		if (Ticks == 20) 
		{
			mod.getSessionCfg().addSeconds(1);
			mod.getSessionCfg().saveConfig();
			Ticks = 0;
			Seconds++;
			
		}
		
		if (Seconds == 60) 
		{
			Minutes++;
			Seconds = 0;
		}
		
		if (Minutes == 60) 
		{
			Hours++;
			Minutes = 0;
		}
		
		if (mod.getSessionCfg().getSeconds() == 60) 
		{
			mod.getSessionCfg().addMinutes(1);
			mod.getSessionCfg().setSeconds(0);
			mod.getSessionCfg().saveConfig();
		}
		
		if (mod.getSessionCfg().getMinutes() == 60) 
		{
			mod.getSessionCfg().addHours(1);
			mod.getSessionCfg().setMinutes(0);
			mod.getSessionCfg().saveConfig();		
		}
	}	
}
