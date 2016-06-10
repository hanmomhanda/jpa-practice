package jpa.springboot.domain;

import java.io.Serializable;

/**
 * @author omwomw@sk.com
 *         created on 16. 6. 10.
 */
public class ChannelProductId implements Serializable {

    private String channel;

    private String product;

    public ChannelProductId() {
    }

    public ChannelProductId(String channel, String product) {
        this.channel = channel;
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChannelProductId that = (ChannelProductId) o;

        if (!channel.equals(that.channel)) return false;
        return product.equals(that.product);

    }

    @Override
    public int hashCode() {
        int result = channel.hashCode();
        result = 31 * result + product.hashCode();
        return result;
    }
}
