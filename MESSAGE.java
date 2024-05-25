
import java.time.LocalDateTime;

public class MESSAGE {

    private String message;
    private PERSON sender;
    private LocalDateTime time;
    private String chat_id;

    public MESSAGE(String message, PERSON sender, LocalDateTime time, String chat_id) {
        this.message = message;
        this.sender = sender;
        this.time = time;
        this.chat_id = chat_id;
    }

    public String getMessage() {
        return this.message;
    }

    public PERSON getSender() {
        return this.sender;
    }

    public LocalDateTime getTime() {
        return this.time;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSender(PERSON sender) {
        this.sender = sender;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

}
