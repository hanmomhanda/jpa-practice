package jpa.springboot.repository;

import jpa.springboot.domain.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author omwomw@sk.com
 *         created on 16. 6. 10.
 */
@Repository
public interface ChannelRepository extends JpaRepository<Channel, String> {
}
