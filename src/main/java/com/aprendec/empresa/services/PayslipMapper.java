package com.aprendec.empresa.services;

import com.aprendec.empresa.entities.Nominas;
import com.aprendec.empresa.entities.PayslipDTO;

public class PayslipMapper {
	public static PayslipDTO toDTO(Nominas nominas) {
		if (nominas == null) {
			return null;
		}
		PayslipDTO payslipDTO = new PayslipDTO();
		payslipDTO.setDni(nominas.getDni());
		payslipDTO.setSueldo(nominas.getSueldo());
		return payslipDTO;
	}

	public static Nominas toEntity(PayslipDTO payslipDTO) {
		if (payslipDTO == null) {
			return null;
		}
		Nominas nomina = new Nominas();
		nomina.setDni(payslipDTO.getDni());
		nomina.setSueldo(payslipDTO.getSueldo());
		return nomina;
	}
}
