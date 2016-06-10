package jpa.springboot.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * @author omwomw@sk.com
 *         created on 16. 6. 10.
 */
@Getter
@Setter
@ToString
public class ChannelProductDto {

    @NotNull
    private String channelCode;

    @NotNull
    private String channelName;

    @NotNull
    private String productCode;

    @NotNull
    private String productName;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate displayStartDate;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate displayEndDate;

    @NotNull
    private String displayYn;

    @NotNull
    private Integer priority;
}
