package jpa.springboot.service;

import jpa.springboot.domain.Channel;
import jpa.springboot.domain.ChannelProduct;
import jpa.springboot.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author omwomw@sk.com
 *         created on 16. 6. 10.
 */
@Component
public class ChannelProductServiceImpl {

    private ChannelRepository channelRepository;
    @Autowired
    public void setChannelRepository(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    public void save(ChannelProduct channelProduct) {
        Channel channel = channelProduct.getChannel();
        channel.addChannelProduct(channelProduct);
        channelRepository.save(channel);
    }
}
