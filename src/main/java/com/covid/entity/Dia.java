package com.covid.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Table(name = "dias", schema = "covid")
public class Dia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5897214457488274951L;

	@ApiModelProperty(required = false, position = 1)
	@JsonProperty("id_dia")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_dia")
	private Long idDia;

	@ApiModelProperty(required = true, position = 2)
	@JsonProperty("id_covid")
	@Column(name = "id_covid")
	private Long idCovid;

	@ApiModelProperty(required = false, position = 3)
	@JsonProperty("sintoma1")
	@Column(name = "sintoma1")
	private String sintoma1;

	@ApiModelProperty(required = false, position = 4)
	@JsonProperty("sintoma2")
	@Column(name = "sintoma2")
	private String sintoma2;

	@ApiModelProperty(required = false, position = 5)
	@JsonProperty("tratamiento")
	@Column(name = "tratamiento")
	private String tratamiento;

	@ApiModelProperty(required = false, position = 6)
	@JsonProperty("confinamiento_roto")
	@Column(name = "confinamiento_roto")
	private Boolean confinamientoRoto;

	@ApiModelProperty(required = false, position = 7)
	@JsonProperty("estado_animo")
	@Column(name = "estado_animo")
	private String estadoAnimo;

	@ApiModelProperty(required = false, position = 8)
	@JsonProperty("nota")
	@Column(name = "nota")
	private String nota;

	@ApiModelProperty(required = false, position = 9)
	@JsonProperty("covid")
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_covid", nullable = false, insertable = false, updatable = false)
	private Covid covid;

}