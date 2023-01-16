package com.example.meraki.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@MappedSuperclass
public class BaseEntity  implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", nullable = false, insertable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
}
