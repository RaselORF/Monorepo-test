package network.thunder.core.etc;

import network.thunder.core.communication.LNConfiguration;
import network.thunder.core.communication.NodeKey;
import network.thunder.core.communication.layer.high.Channel;
import network.thunder.core.communication.layer.high.ChannelStatus;
import network.thunder.core.database.HibernateHandler;

import java.util.ArrayList;
import java.util.List;

public class LNPaymentDBHandlerMock extends HibernateHandler {
    public static final long INITIAL_AMOUNT_CHANNEL = 10000000;

    LNConfiguration configuration = new LNConfiguration();

    @Override
    public Channel getChannel (int id) {
        Channel channel = new Channel();
        channel.id = id;
        channel.channelStatus = new ChannelStatus();
        channel.channelStatus.amountServer = INITIAL_AMOUNT_CHANNEL;
        channel.channelStatus.amountClient = INITIAL_AMOUNT_CHANNEL;
        return channel;
    }

    @Override
    public List<Channel> getChannel (NodeKey nodeKey) {
        List<Channel> list = new ArrayList<>();
        Channel c = getChannel(1);
        c.nodeKeyClient = nodeKey;
        list.add(c);
        return list;
    }

    @Override
    public List<Channel> getOpenChannel (NodeKey nodeKey) {
        return getChannel(nodeKey);
    }
}
