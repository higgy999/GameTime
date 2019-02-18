package me.toast.gametime.configs;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class SessionTimeCfg 
{
	private File saveFile = new File(Minecraft.getMinecraft().mcDataDir, "config/GameTime/SessionTime.cfg");
	private int Hours = 0;
	private int Minutes = 0;
	private int Seconds = 0;
	
		//Hours
		public int getHours()
		{
			return Hours;
		}
		public void setHours(int newHours)
		{
			Hours = newHours;
		}
		public void addHours(int newHours)
		{
			Hours = Hours + newHours;
		}
		
		//Minutes
		public int getMinutes()
		{
			return Minutes;
		}
		public void setMinutes(int newMinutes)
		{
			Minutes = newMinutes;
		}
		public void addMinutes(int newMinutes)
		{
			Minutes = Minutes + newMinutes;
		}
		
		//Seconds
		public int getSeconds()
		{
			return Seconds;
		}
		public void setSeconds(int newSeconds) 
		{
			Seconds = newSeconds;
		}
		public void addSeconds(int newSeconds)
		{
			Seconds = Seconds + newSeconds;
		}
		
		
		public void saveConfig() 
		{
			if (Seconds == 60) 
			{
				Minutes++;
				Seconds = Seconds - 60;
			}
			
			if (Minutes == 60) 
			{
				Hours++;
				Minutes = Minutes - 60;;
			}
			
			Configuration config = new Configuration(saveFile);
			this.updateConfig(config, false);
			config.save();
		}
		
		public void loadConfig() 
		{
			if (Seconds == 60) 
			{
				Minutes++;
				Seconds = Seconds - 60;
			}
			
			if (Minutes == 60) 
			{
				Hours++;
				Minutes = Minutes - 60;;
			}
			Configuration config = new Configuration(saveFile);
			config.load();
			this.updateConfig(config, true);
		}
		
		private void updateConfig(Configuration config, boolean load) 
		{
			Property prop = config.get("Position", "Hours", 0);
			if(load)
			{
				this.Hours = prop.getInt();
			} 
			else 
			{
				prop.setValue(this.Hours);
			}
			
			
			
			Property prop1 = config.get("Position", "Minutes", 0);
			if(load)
			{
				this.Minutes = prop1.getInt();
			} 
			else 
			{
				prop1.setValue(this.Minutes);
			}
			
			Property prop2 = config.get("Position", "Seconds", 0);
			if(load)
			{
				this.Seconds = prop2.getInt();
			} 
			else 
			{
				prop2.setValue(this.Seconds);
			}
			
		}
}