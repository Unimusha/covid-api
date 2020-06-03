package com.covid.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "usuarios", schema = "covid")

public class Usuario {

	@ApiModelProperty(required = false, position = 1)
	@JsonProperty("id_usuario")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long idUsuario;

	@ApiModelProperty(required = true, position = 2)
	@JsonProperty("id_direccion")
	@Column(name = "id_direccion")
	private Long idDireccion;

	@ApiModelProperty(required = true, position = 3)
	@JsonProperty("nombre")
	@Column(name = "nombre", nullable = false, unique = true)
	private String nombre;

	@ApiModelProperty(required = true, position = 4)
	@JsonProperty("apellidos")
	@Column(name = "apellidos", nullable = false)
	private String apellidos;

	@ApiModelProperty(required = true, position = 5)
	@JsonProperty("email")
	@Column(name = "email", nullable = false)
	private String email;

	@ApiModelProperty(required = true, position = 6)
	@JsonProperty("contrasenia")
	@Column(name = "contrasenia", nullable = false)
	private String contrasenia;

	@ApiModelProperty(required = true, position = 7)
	@JsonProperty("genero")
	@Column(name = "genero", nullable = false)
	private String genero;

	@ApiModelProperty(required = true, position = 8, value = "2010-01-01")
	@JsonProperty("fecha_nacimiento")
	@Column(name = "fecha_nacimiento", nullable = false)
	private Date fechaNacimiento;

	@ApiModelProperty(required = true, position = 9)
	@JsonProperty("nacionalidad")
	@Column(name = "nacionalidad", nullable = false)
	private String nacionalidad;

	@ApiModelProperty(required = true, position = 10)
	@JsonProperty("telefono")
	@Column(name = "telefono", nullable = false)
	private String telefono;

	@ApiModelProperty(required = false, position = 11)
	@JsonProperty("covid")
	@JsonManagedReference
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@Builder.Default
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Covid> covid = new HashSet<>();

	@ApiModelProperty(required = false, position = 12)
	@JsonProperty("direccion")
	@JsonBackReference
//	@JsonManagedReference
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_direccion", nullable = false, insertable = false, updatable = false)
	private Direccion direccion;

}