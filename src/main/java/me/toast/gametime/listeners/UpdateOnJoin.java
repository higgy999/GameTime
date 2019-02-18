package me.toast.gametime.listeners;

import me.toast.gametime.listeners.utils.UpdateDetection;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

public class UpdateOnJoin 
{
	@SubscribeEvent
	public void onJoin(FMLNetworkEvent.ClientConnectedToServerEvent	event) 
	{
		UpdateDetection.checkIfURLExists();
	}
}
