package rw.iTrack.Application.v1.models;


import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long event_id;
    @NotNull
    @ApiModelProperty("the reason why marks were removed")
    private String reason;
    @NotNull
    @ApiModelProperty("The marks removed")
    private int marks;

    @NotNull
    @ApiModelProperty("The time on which the marks were removed")
    private LocalDate timeRemoved;
    @NotNull
    @ApiModelProperty("The educator who removed the marks")
    @ManyToOne
    @JoinColumn(name = "educator")
    private Educator educator;

    public Event(String reason, int marks, LocalDate timeRemoved, Educator educator) {
        this.reason = reason;
        this.marks = marks;
        this.timeRemoved = timeRemoved;
        this.educator = educator;
    }
}
