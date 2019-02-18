package me.toast.gametime.commands;

import me.toast.gametime.GameTime;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

public class GtPos extends CommandBase
{

	private GameTime mod;
	
	public GtPos(GameTime mod)
	{
		this.mod = mod;
	}
	
	@Override
	public String getCommandName() 
	{
		return "GtPos";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) 
	{
		return "/" + getCommandName() + "<PosX>" + "<PosY>";
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException 
	{
		if(args.length == 0)
		{
			sender.addChatMessage(new ChatComponentText(getCommandUsage(sender)));
		}
		else 
		{
			try
			{
				int newposX = Integer.parseInt(args[0]);
				int newposY = Integer.parseInt(args[1]); 
				//Change the setting
				mod.getPosCfg().setposXST(newposX);
				mod.getPosCfg().setposYST(newposY);
				//Saving the settings
				mod.getPosCfg().saveConfig();
			}
			catch(Exception ex)
			{
				sender.addChatMessage(new ChatComponentText(getCommandUsage(sender)));
			}
		}
	}

	@Override
	public int getRequiredPermissionLevel() 
	{
        return 0;
    }
    
	@Override
    public boolean canCommandSenderUseCommand(final ICommandSender p_71519_1_) 
	{
        return true;
    }
}
