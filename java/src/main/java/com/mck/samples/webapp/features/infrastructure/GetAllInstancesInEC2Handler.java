package com.mck.samples.webapp.features.infrastructure;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.Reservation;
import com.mck.samples.webapp.WebappApplication;
import com.mck.samples.webapp.mediator.BaseResponse;
import com.mck.samples.webapp.mediator.IAmCommandHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;


public class GetAllInstancesInEC2Handler implements IAmCommandHandler<GetAllInstancesInEC2, BaseResponse<List<String>>> {
    @Override
    public BaseResponse<List<String>> handle(GetAllInstancesInEC2 command) {
        Optional<BasicAWSCredentials> bawsc = getBasicAWSCredentials();

        if (bawsc.isPresent()) return new BaseResponse<>(new ArrayList<>();
        //Launch an EC2 Client
        AmazonEC2Client amazonEC2Client = new AmazonEC2Client(bawsc);
        //Obtain a list of Reservations
        List<Reservation> reservations = amazonEC2Client.describeInstances().getReservations();
        int reservationCount = reservations.size();
        for (int i = 0; i < reservationCount; i++) {
            List<Instance> instances = reservations.get(i).getInstances();
            int instanceCount = instances.size();
            //Print the instance IDs of every instance in the reservation.
            for (int j = 0; j < instanceCount; j++) {
                Instance instance = instances.get(j);
                if (instance.getState().getName().equals("running")) {
                    System.out.println(instance.getInstanceId());
                }
            }
        }
    }

    private Optional<BasicAWSCredentials> getBasicAWSCredentials() {
        try {
            Properties properties = new Properties();
            properties.load(WebappApplication.class.getResourceAsStream("/AwsCredentials.properties"));
            return new Optional<>( new BasicAWSCredentials(properties.getProperty("accessKey"),
                    properties.getProperty("secretKey")));
        } catch (IOException e) {
            return new Optional<>();
        }
    }
}
