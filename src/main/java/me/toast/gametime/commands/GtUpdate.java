package me.toast.gametime.commands;

import me.toast.gametime.listeners.utils.UpdateDetection;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

public class GtUpdate extends CommandBase
{

	@Override
	public String getCommandName() 
	{
		return "GtUpdate";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) 
	{
		return "/" + getCommandName();
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException 
	{
		UpdateDetection.checkIfURLExists();
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
