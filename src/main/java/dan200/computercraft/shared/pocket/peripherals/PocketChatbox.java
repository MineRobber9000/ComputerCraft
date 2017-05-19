/*
 * This file is part of ComputerCraft - http://www.computercraft.info
 * Copyright Daniel Ratcliffe, 2011-2016. Do not distribute without permission.
 * Send enquiries to dratcliffe@gmail.com
 */

package dan200.computercraft.shared.pocket.peripherals;

import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.api.pocket.IPocketAccess;
import dan200.computercraft.api.pocket.IPocketUpgrade;
import dan200.computercraft.shared.peripheral.PeripheralType;
import dan200.computercraft.shared.peripheral.common.PeripheralItemFactory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class PocketChatbox implements IPocketUpgrade
{
    public PocketChatbox()
    {
    }

    @Nonnull
    @Override
    public ResourceLocation getUpgradeID()
    {
        return new ResourceLocation( "computercraft", "chatbox" );
    }

    @Nonnull
    @Override
    public String getUnlocalisedAdjective()
    {
        return "upgrade.computercraft:chatbox.adjective";
    }

    @Nullable
    @Override
    public ItemStack getCraftingItem()
    {
        return PeripheralItemFactory.create(PeripheralType.Chatbox, null, 1);
    }

    @Nullable
    @Override
    public IPeripheral createPeripheral( @Nonnull IPocketAccess access )
    {
        return new PocketChatboxPeripheral();
    }

    @Override
    public void update( @Nonnull IPocketAccess access, @Nullable IPeripheral peripheral )
    {
        if ( peripheral instanceof PocketChatboxPeripheral )
        {
            Entity entity = access.getEntity();

            PocketChatboxPeripheral chatbox = (PocketChatboxPeripheral) peripheral;

            if ( entity instanceof EntityLivingBase)
            {
                EntityLivingBase player = (EntityLivingBase) entity;
                chatbox.setLocation( entity.getEntityWorld(), player.posX, player.posY + player.getEyeHeight(), player.posZ );
            }

            else if ( entity != null )
            {
                chatbox.setLocation( entity.getEntityWorld(), entity.posX, entity.posY, entity.posZ );
            }
            chatbox.update();
        }
    }

    @Override
    public boolean onRightClick(@Nonnull World world, @Nonnull IPocketAccess access, @Nullable IPeripheral peripheral )
    {
        return false;
    }


}
