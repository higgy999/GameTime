package me.toast.gametime;

import me.toast.gametime.commands.GtPos;
import me.toast.gametime.commands.GtUpdate;
import me.toast.gametime.configs.PositioningCfg;
import me.toast.gametime.configs.SessionTimeCfg;
import me.toast.gametime.listeners.TextRenderer;
import me.toast.gametime.listeners.TimeCounter;
import me.toast.gametime.listeners.UpdateOnJoin;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = GameTime.MODID, version = GameTime.VERSION)
public class GameTime
{
    public static final String MODID = "GameTime";
    public static final String VERSION = "1.0.0";
    
    private PositioningCfg PosCfg = new PositioningCfg();
    private SessionTimeCfg SessionCfg = new SessionTimeCfg();
    
   //Get System Time Working
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	ClientCommandHandler.instance.registerCommand(new GtPos(this));
    	ClientCommandHandler.instance.registerCommand(new GtUpdate());
    	FMLCommonHandler.instance().bus().register(new TimeCounter(this));
    	FMLCommonHandler.instance().bus().register(new TextRenderer(this));
    	FMLCommonHandler.instance().bus().register(new UpdateOnJoin());
    	PosCfg.loadConfig();
    	SessionCfg.loadConfig();
    }
    
    public PositioningCfg getPosCfg() 
    {
    	return PosCfg;
    }
    
    public SessionTimeCfg getSessionCfg() 
    {
    	return SessionCfg;
    }

}
