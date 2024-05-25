
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PROGRAM {

    private USER toUser;
    private EXPERT fromExpert;
    private LocalDateTime date;
    private String[] program = {null, null, null};

    public PROGRAM(USER toUser, EXPERT fromExpert, LocalDateTime date, String first, String second, String third) {
        this.toUser = toUser;
        this.fromExpert = fromExpert;
        this.date = date;
        this.program[0] = first;
        this.program[1] = second;
        this.program[2] = third;
    }

    public PROGRAM(USER toUser, EXPERT fromExpert, LocalDateTime date, String[] program) {
        this.toUser = toUser;
        this.fromExpert = fromExpert;
        this.date = date;
        this.program = program;
    }

    public USER getToUser() {
        return toUser;
    }

    public void setToUser(USER toUser) {
        this.toUser = toUser;
    }

    public EXPERT getFromExpert() {
        return fromExpert;
    }

    public void setFromExpert(EXPERT fromExpert) {
        this.fromExpert = fromExpert;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String[] getProgram() {
        return program;
    }

    public void setProgram(String[] program) {
        this.program = program;
    }

    public String getFirst() {
        return this.program[0];
    }

    public void setFirst(String prog) {
        this.program[0] = prog;
    }

    public String getSecond() {
        return this.program[1];
    }

    public void setSecond(String prog) {
        this.program[1] = prog;
    }

    public String getThird() {
        return this.program[2];
    }

    public void setThird(String prog) {
        this.program[2] = prog;
    }

    public void save(Connection connection) throws SQLException {
        
        String query = "INSERT INTO program VALUES(?, ?, ?, ?, ?, ?)";

        PreparedStatement  preparedstmt = connection.prepareStatement(query);
        preparedstmt.setString(1, this.fromExpert.getEmail());
        preparedstmt.setString(2, this.toUser.getEmail());
        preparedstmt.setString(3, this.date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        preparedstmt.setString(4, this.program[0]);
        preparedstmt.setString(5, this.program[1]);
        preparedstmt.setString(6, this.program[2]);

        preparedstmt.execute();

    }
}
