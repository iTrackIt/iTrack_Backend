package rw.iTrack.Application.v1.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListApiResponse {
    private boolean success;
    private String message;
    private List<?> objects;

    public ListApiResponse(boolean success , String message ){
        this.success = success;
        this.message = message;
    }

}
