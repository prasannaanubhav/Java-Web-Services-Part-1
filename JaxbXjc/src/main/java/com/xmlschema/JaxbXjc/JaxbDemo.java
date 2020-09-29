package com.xmlschema.JaxbXjc;

import java.io.BufferedInputStream;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.bharatthippireddy.patient.Patient;

public class JaxbDemo {
	public static void main(String[] args) {

		try {
			//Marshalling 
			JAXBContext context = JAXBContext.newInstance(Patient.class);

			Marshaller marshaller = context.createMarshaller();

			Patient patient = new Patient();
			patient.setName("Anubhav");
			patient.setPhone("8969950778");

			StringWriter writer = new StringWriter();

			marshaller.marshal(patient, writer);
			
			System.out.println(writer);
			
			//UnMarshalling
			
			Unmarshaller unmarshaller = context.createUnmarshaller();
			
			Patient patientResult = (Patient) unmarshaller.unmarshal(new StringBufferInputStream(writer.toString()));
			System.out.println(patientResult.getName());
			System.out.println(patientResult.getPhone());
			

		} catch (JAXBException e) {

			e.printStackTrace();
		}
	}
}
