package com.poornima.commons.model.order;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;



@Entity
@Table(name = "`Order`")
@Data

public class Order  {

@Id
@GeneratedValue
private int id;
private LocalDateTime date;
}
