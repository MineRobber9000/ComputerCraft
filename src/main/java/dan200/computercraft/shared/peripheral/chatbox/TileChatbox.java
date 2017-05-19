/*
 * This file is part of ComputerCraft - http://www.computercraft.info
 * Copyright Daniel Ratcliffe, 2011-2016. Do not distribute without permission.
 * Send enquiries to dratcliffe@gmail.com
 */

package dan200.computercraft.shared.peripheral.chatbox;

import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.shared.peripheral.common.TilePeripheralBase;
import net.minecraft.util.EnumFacing;

public class TileChatbox extends TilePeripheralBase
{
    // Statics
    static final int MIN_TICKS_BETWEEN_SOUNDS = 1;

    // Members
    private ChatboxPeripheral m_peripheral;

    public TileChatbox()
    {
        super();
        m_peripheral = new ChatboxPeripheral(this);
    }

    @Override
    public synchronized void update() {
        m_peripheral.update();
    }

    // IPeripheralTile implementation

    public IPeripheral getPeripheral(EnumFacing side)
    {
        return m_peripheral;
    }

}
