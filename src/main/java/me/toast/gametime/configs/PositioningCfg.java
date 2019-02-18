package me.toast.gametime.configs;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class PositioningCfg 
{
	private File saveFile = new File(Minecraft.getMinecraft().mcDataDir, "config/GameTime/Positioning.cfg");
	private int posXST = 0;
	private int posYST = 0;
	private int posXCT = 0;
	private int posYCT = 10;
	
		//posX Session Text
		public int getposXST()
		{
			return posXST;
		}
		public void setposXST(int newposXST)
		{
			posXST = newposXST;
		}
		
		//posY Session Text
		public int getposYST()
		{
			return posYST;
		}
		public void setposYST(int newposYST)
		{
			posYST = newposYST;
		}
		
		//posX Computer Text
		public int getposXCT()
		{
			return posXCT;
		}
		
		public void setposXCT(int newposXCT) 
		{
			posXCT = newposXCT;
		}
		
		//posY Computer Text
		public int getposYCT()
		{
			return posYCT;
		}
		
		public void setposYCT(int newposYCT) 
		{
			posYCT = newposYCT;
		}
		
		
		public void saveConfig() 
		{
			Configuration config = new Configuration(saveFile);
			this.updateConfig(config, false);
			config.save();
		}
		
		public void loadConfig() 
		{
			Configuration config = new Configuration(saveFile);
			config.load();
			this.updateConfig(config, true);
		}
		
		private void updateConfig(Configuration config, boolean load) 
		{
			Property prop = config.get("Position", "posXST", 0);
			if(load)
			{
				this.posXST = prop.getInt();
			} 
			else 
			{
				prop.setValue(this.posXST);
			}
			
			
			
			Property prop1 = config.get("Position", "posYST", 0);
			if(load)
			{
				this.posYST = prop1.getInt();
			} 
			else 
			{
				prop1.setValue(this.posYST);
			}
			
			Property prop2 = config.get("Position", "posXCT", 0);
			if(load)
			{
				this.posXCT = prop2.getInt();
			} 
			else 
			{
				prop2.setValue(this.posXCT);
			}
			
			
			
			Property prop3 = config.get("Position", "posYCT", 10);
			if(load)
			{
				this.posYCT = prop3.getInt();
			} 
			else 
			{
				prop3.setValue(this.posYCT);
			}
			
		}
}