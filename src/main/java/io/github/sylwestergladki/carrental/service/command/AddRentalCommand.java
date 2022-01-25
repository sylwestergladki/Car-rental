package io.github.sylwestergladki.carrental.service.command;
import lombok.Data;



@Data
public class AddRentalCommand {
    private int userId;
    private int carId;

    public AddRentalCommand(int userId,int carId){
        this.userId = userId;
        this.carId = carId;
    }

}
