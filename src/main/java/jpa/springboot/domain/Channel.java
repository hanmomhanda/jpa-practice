package jpa.springboot.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * @author omwomw@sk.com
 *         created on 16. 6. 10.
 */
@Entity
@Table(name = "channel")
public class Channel {

    @Id
    @NotNull
    @Column(name = "channel_code")
    private String channelCode;

    @NotNull
    @Column(name = "channel_name")
    private String channelName;

    @OneToMany(mappedBy = "channel", cascade = CascadeType.ALL)
    private Set<ChannelProduct> channelProducts = new HashSet<ChannelProduct>();

    public Channel() {
    }

    public Channel(String channelCode, String channelName) {
        this.channelCode = channelCode;
        this.channelName = channelName;
    }

    public void addChannelProduct(ChannelProduct channelProduct) {
        channelProducts.add(channelProduct);
    }

    public String getChannelCode() {
        return channelCode;
    }

    public String getChannelName() {
        return channelName;
    }
}
