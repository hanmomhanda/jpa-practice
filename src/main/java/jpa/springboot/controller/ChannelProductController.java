package jpa.springboot.controller;

import jpa.springboot.domain.ChannelProduct;
import jpa.springboot.dto.ChannelProductDto;
import jpa.springboot.service.ChannelProductServiceImpl;
import jpa.springboot.support.EntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author omwomw@sk.com
 *         created on 16. 6. 10.
 */
@RestController
@RequestMapping("/v1")
public class ChannelProductController {

    private ChannelProductServiceImpl channelProductService;
    @Autowired
    public void setChannelProductService(ChannelProductServiceImpl channelProductService) {
        this.channelProductService = channelProductService;
    }

    private EntityConverter entityConverter;
    @Autowired
    public void setEntityConverter(EntityConverter entityConverter) {
        this.entityConverter = entityConverter;
    }




    @RequestMapping(value = "/channel-product", method = RequestMethod.POST)
    public ResponseEntity<ChannelProductDto> save(@Valid ChannelProductDto channelProductDto,
                               BindingResult bindingResult) throws BindException {
        if (bindingResult.hasErrors())
            throw new BindException(bindingResult);

        ChannelProduct channelproduct = entityConverter.convertToEntity(channelProductDto);
        channelProductService.save(channelproduct);

        return ResponseEntity.ok(channelProductDto);
    }
}
