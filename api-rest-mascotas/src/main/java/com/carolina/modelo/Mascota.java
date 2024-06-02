package com.carolina.modelo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Mascota {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	@Size(min=5,message="El nombre debe tener al menos 5 caracteres")
	private String nombre;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name ="fecha_nac")
	private Date fechaNac;
	@Column(nullable = false)
	private String raza;
	@Column(nullable = false)
	private float peso;
	@Column(nullable = false, name = "tiene_chip")
	private String tieneChip;
	@Column(nullable = false, name = "url_foto")
	private String urlFoto;

}
