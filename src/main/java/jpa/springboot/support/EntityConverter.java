package jpa.springboot.support;

import jpa.springboot.domain.*;
import jpa.springboot.dto.ChannelProductDto;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @author omwomw@sk.com
 *         created on 16. 6. 8.
 */
@Component
public class EntityConverter {

    public ChannelProduct convertToEntity(ChannelProductDto channelProductDto) throws ParseException {
        Product product = new Product(
                channelProductDto.getProductCode(),
                channelProductDto.getProductName()
        );
        Channel channel = new Channel(
                channelProductDto.getChannelCode(),
                channelProductDto.getChannelName()
        );
        DisplayPeriod displayPeriod = new DisplayPeriod(
                channelProductDto.getDisplayStartDate(),
                channelProductDto.getDisplayEndDate()
        );
        return new ChannelProduct(
                product,
                channel,
                displayPeriod,
                channelProductDto.getDisplayYn(),
                channelProductDto.getPriority()
        );
    }

    public ChannelProductDto convertToDto(ChannelProduct channelProduct) {
        
        Channel channel = channelProduct.getChannel();
        Product product = channelProduct.getProduct();
        DisplayPeriod displayPeriod = channelProduct.getDisplayPeriod();
        
        ChannelProductDto channelProductDto = new ChannelProductDto();
        channelProductDto.setChannelCode(channel.getChannelCode());
        channelProductDto.setChannelName(channel.getChannelName());
        channelProductDto.setProductCode(product.getProductCode());
        channelProductDto.setProductName(product.getProductName());
        channelProductDto.setDisplayStartDate(displayPeriod.getStartDate());
        channelProductDto.setDisplayEndDate(displayPeriod.getEndDate());
        channelProductDto.setDisplayYn(channelProduct.getDisplayYn());
        channelProductDto.setPriority(channelProduct.getPriority());

        return channelProductDto;
    }

}
