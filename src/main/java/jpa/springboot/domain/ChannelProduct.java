package jpa.springboot.domain;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * @author omwomw@sk.com
 *         created on 16. 6. 10.
 */
@Entity
@Table(name = "channel_product")
@IdClass(ChannelProductId.class)
public class ChannelProduct {

    @Id
    @NotNull
    @ManyToOne
    @JoinColumn(name = "channel_code")
    private Channel channel;

    @Id
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_code")
    private Product product;

    @Embedded
    @NotNull
    @Valid
    private DisplayPeriod displayPeriod;

    @Column(name = "display_yn")
    @NotNull
    private String displayYn;

    @Column(name = "priority")
    @NotNull
    private Integer priority;

    @Transient
    private final String INCLUDED = "Y";

    @Transient
    private final String NOT_INCLUDED = "N";

    public ChannelProduct() {
    }

    public ChannelProduct(Product product, Channel channel, DisplayPeriod displayPeriod, String displayYn, Integer priority) {
        this.product = product;
        this.channel = channel;
        this.displayPeriod = displayPeriod;
        this.displayYn = displayYn;
        this.priority = priority;
    }

    public boolean isIncluded() {
        return this.displayYn.equals(INCLUDED);
    }

    public boolean isInDisplayPeriod(LocalDate baseDate) {
        return this.displayPeriod.isInDisplayPeriod(baseDate);
    }

    public boolean isDisplayable(LocalDate baseDate) {
        return isIncluded() && isInDisplayPeriod(baseDate);
    }

    public boolean isDisplayable() {
        return isIncluded() && isInDisplayPeriod(LocalDate.now());
    }

    public void setIncluded() {
        this.displayYn = INCLUDED;
    }

    public void setExcluded() {
        this.displayYn = NOT_INCLUDED;
    }

    // getters

    public Product getProduct() {
        return product;
    }

    public Channel getChannel() {
        return channel;
    }

    public DisplayPeriod getDisplayPeriod() {
        return displayPeriod;
    }

    public String getDisplayYn() {
        return displayYn;
    }

    public Integer getPriority() {
        return priority;
    }
}