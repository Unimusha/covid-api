package com.covid.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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

@Table(name = "direcciones", schema = "covid")

public class Direccion {

	@ApiModelProperty(required = false, position = 1)
	@JsonProperty("id_direccion")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_direccion")
	private Long idDireccion;

	@ApiModelProperty(required = true, position = 2)
	@JsonProperty("pais")
	@Column(name = "pais", nullable = false)
	private String pais;

	@ApiModelProperty(required = true, position = 3)
	@JsonProperty("region")
	@Column(name = "region", nullable = false)
	private String region;

	@ApiModelProperty(required = true, position = 4)
	@JsonProperty("provincia")
	@Column(name = "provincia", nullable = false)
	private String provincia;

	@ApiModelProperty(required = true, position = 5)
	@JsonProperty("localidad")
	@Column(name = "localidad", nullable = false)
	private String localidad;

	@ApiModelProperty(required = true, position = 6)
	@JsonProperty("direccion")
	@Column(name = "direccion", nullable = false)
	private String direccion;

	@ApiModelProperty(required = true, position = 7)
	@JsonProperty("codigo_postal")
	@Column(name = "codigo_postal", nullable = false)
	private String codigoPostal;

	@ApiModelProperty(required = false, position = 8)
	@JsonProperty("usuarios")
	@JsonManagedReference
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@Builder.Default
	@OneToMany(mappedBy = "direccion", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Usuario> usuarios = new HashSet<>();

}