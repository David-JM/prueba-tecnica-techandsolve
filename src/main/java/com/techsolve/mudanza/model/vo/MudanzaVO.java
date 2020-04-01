package com.techsolve.mudanza.model.vo;

/**
 * Value Object to get data (like json) about moves from an client application
 * 
 * @author David Martinez
 *
 */
public class MudanzaVO {

	private String identification;
	private String inputFile;

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getInputFile() {
		return inputFile;
	}

	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}

}
