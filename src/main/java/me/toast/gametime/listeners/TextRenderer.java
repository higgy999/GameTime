package me.toast.gametime.listeners;

import me.toast.gametime.GameTime;
import me.toast.gametime.listeners.utils.RainbowUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class TextRenderer 
{
	private Minecraft mc = Minecraft.getMinecraft();
	FontRenderer fr = mc.fontRendererObj;
	
	private GameTime mod;
	
	public TextRenderer(GameTime mod)
	{
		this.mod = mod;
	}
	
	@SubscribeEvent
	public void onRenderTick(TickEvent.RenderTickEvent event) 
	{
		//Needed for Rainbow text
		drawStringRW("TestString", 2, 150, 0.75F);
	}
	
	private void drawStringRW(String string, int x, int y, float brightness) 
	{
		for (int i = 0; i < "TestString".length(); i++) 
		{
			if (mc.theWorld != null) 
			{
				/* Session Text */
				fr.drawStringWithShadow("Game Session Time: " + TimeCounter.Hours + ":" + TimeCounter.Minutes + ":" + TimeCounter.Seconds, mod.getPosCfg().getposXST(), mod.getPosCfg().getposYST(), RainbowUtil.effect(i * 3500000L, brightness, 250).getRGB());
			}
		}
	}
}
