package com.eastnets.studentcrud.service.jms;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.eastnets.studentcrud.bean.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StudentProducer {

	public static void produceStudentMessage(Student student) {

		try { // Try to have class for connection, as Connection utill. SRP :)
				// Or try with resource!!!

			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
			Connection connection = connectionFactory.createConnection();
			connection.start();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createQueue("StudentQueue");
			MessageProducer producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

			String text = entityToJson(student);

			TextMessage message = session.createTextMessage(text);
			System.out.println("Sent message: " + message.hashCode());
			producer.send(message);

			session.close();
			connection.close();

		} catch (Exception e) {
			System.out.println("Caught: " + e);
			e.printStackTrace();
		}

	}

	private static String entityToJson(Student student) {
		String jsonStr=null;
		try {

			ObjectMapper objectMapper = new ObjectMapper();
			jsonStr= objectMapper.writeValueAsString(student);
			 System.out.println(jsonStr);
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonStr;
	}

}
