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

@Table(name = "covid", schema = "covid")
public class Covid {

	@ApiModelProperty(required = false, position = 1)
	@JsonProperty("id_covid")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_covid")
	private Long idMesa;

	@ApiModelProperty(required = true, position = 2)
	@JsonProperty("id_usuario")
	@Column(name = "id_usuario", nullable = false)
	private Long idUsuario;

	@ApiModelProperty(required = false, position = 3, value = "2010-01-01")
	@JsonProperty("fecha_alta_covid")
	@Column(name = "fecha_alta_covid", nullable = true)
	private Date fechaAltaCovid;

	@ApiModelProperty(required = false, position = 4, value = "2010-01-01")
	@JsonProperty("fecha_defuncion")
	@Column(name = "fecha_defuncion", nullable = true)
	private Date fechaDefuncion;

	@ApiModelProperty(required = false, position = 5, value = "2010-01-01")
	@JsonProperty("fecha_confirmado_positivo")
	@Column(name = "fecha_confirmado_positivo", nullable = true)
	private Date fechaConfirmadoPositivo;

	@ApiModelProperty(required = false, position = 6)
	@JsonProperty("usuario")
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false, insertable = false, updatable = false)
	private Usuario usuario;

	@ApiModelProperty(required = false, position = 7)
	@JsonProperty("dias")
	@JsonManagedReference
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@Builder.Default
	@OneToMany(mappedBy = "covid", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Dia> dias = new HashSet<>();

}